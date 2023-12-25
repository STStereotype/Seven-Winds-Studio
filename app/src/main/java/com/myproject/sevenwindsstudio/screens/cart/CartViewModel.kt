package com.myproject.sevenwindsstudio.screens.cart

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.myproject.domain.models.cart.CartDrinkItem
import com.myproject.domain.models.cart.CartItem
import com.myproject.domain.usecase.cart.DeleteCartItemUseCase
import com.myproject.domain.usecase.cart.FetchCartUseCase
import com.myproject.domain.usecase.cart.PlaceAnOrderUseCase
import com.myproject.domain.usecase.cart.UpdateCartItemUseCase
import com.myproject.sevenwindsstudio.navigation.MainGraphDestination
import com.myproject.sevenwindsstudio.navigation.destination.CoffeeShopGraphDestination
import com.myproject.sevenwindsstudio.screens.authorization.models.AuthorizationState
import com.myproject.sevenwindsstudio.screens.cart.model.CartState
import com.myproject.sevenwindsstudio.screens.coffeeShop.model.CoffeeShopState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CartViewModel @AssistedInject constructor(
    private val placeAnOrderUseCase: PlaceAnOrderUseCase,
    private val fetchCartUseCase: FetchCartUseCase,
    private val updateCartItemUseCase: UpdateCartItemUseCase,
    private val deleteCartItemUseCase: DeleteCartItemUseCase,
    @Assisted private val idEstablishment: Int?
): ViewModel() {
    private val _cart: MutableStateFlow<CartItem> =
        MutableStateFlow(CartItem(0, arrayListOf()))
    val cart: StateFlow<CartItem> = _cart

    val state: MutableStateFlow<CartState> = MutableStateFlow(CartState.Default)

    @AssistedFactory
    interface Factory {
        fun create(idEstablishment: Int?): CartViewModel
    }

    init {
        loadCart()
    }

    companion object {
        fun provideCartViewModelFactory(
            factory: Factory,
            idEstablishment: Int?
        ): ViewModelProvider.Factory {
            return object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(idEstablishment) as T
                }
            }
        }
    }

    private fun loadCart() {
        CoroutineScope(Dispatchers.IO).launch {
            val cart = fetchCartUseCase.execute().items

            cart.forEach { cartItem ->
                if (idEstablishment != cartItem.establishment) return@forEach
                _cart.emit(cartItem)
            }
        }
    }

    fun resetState() {
        CoroutineScope(Dispatchers.IO).launch {
            state.emit(CartState.Default)
        }
    }

    fun navigateToCoffeeShop(navController: NavController) {
        CoroutineScope(Dispatchers.IO).launch {
            state.emit(CartState.Default)
        }
        navigateTo(
            navController,
            MainGraphDestination.CoffeeShop.destination,
            true
        )
    }

    private fun navigateTo(navController: NavController, root: String, isInclusive: Boolean) {
        navController.navigate(root) {
            popUpTo(navController.currentDestination?.route.toString()) {
                inclusive = isInclusive
            }
        }
    }

    fun increase(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            _cart.value.drinks.forEach { drink ->
                if (drink.id != id) return@forEach
                drink.count++
                updateCartItemUseCase.execute(_cart.value)
            }
            state.emit(CartState.IncreaseDrink)
        }
    }

    fun decrease(id: Int) {
        if (_cart.value.drinks.isEmpty()) return
        CoroutineScope(Dispatchers.IO).launch {
            var removeDrink: CartDrinkItem? = null

            _cart.value.drinks.forEach { drink ->
                if (drink.id != id) return@forEach
                drink.count--
                if (drink.count <= 0)
                    removeDrink = drink

            }
            if (removeDrink != null) _cart.value.drinks.remove(removeDrink)
            updateCartItemUseCase.execute(_cart.value)
            state.emit(CartState.DecreaseDrink)
        }
    }

    fun placeAnOrder() {
        CoroutineScope(Dispatchers.IO).launch {
            placeAnOrderUseCase.execute(_cart.value)
            deleteCartItemUseCase.execute(idEstablishment!!)
            state.emit(CartState.PlaceAnOrder)
        }
    }

    fun showToast(context: Context, message: String) {
       Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}
