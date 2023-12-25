package com.myproject.sevenwindsstudio.screens.coffeeShop

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.myproject.domain.models.cart.Cart
import com.myproject.domain.models.cart.CartDrinkItem
import com.myproject.domain.models.cart.CartItem
import com.myproject.domain.models.coffeeshop.DrinkItem
import com.myproject.domain.models.coffeeshop.EstablishmentItem
import com.myproject.domain.models.coffeeshop.mapToCartDrinkItem
import com.myproject.domain.usecase.cart.AddCartItemUseCase
import com.myproject.domain.usecase.cart.DeleteCartItemUseCase
import com.myproject.domain.usecase.cart.FetchCartUseCase
import com.myproject.domain.usecase.cart.UpdateCartItemUseCase
import com.myproject.domain.usecase.coffeeshop.FetchListDrinksUseCase
import com.myproject.domain.usecase.coffeeshop.FetchListEstablishmentsUseCase
import com.myproject.sevenwindsstudio.navigation.MainGraphDestination
import com.myproject.sevenwindsstudio.navigation.destination.CoffeeShopGraphDestination
import com.myproject.sevenwindsstudio.screens.coffeeShop.model.CoffeeShopState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch

class CoffeeShopViewModel @AssistedInject constructor(
    private val fetchListEstablishmentsUseCase: FetchListEstablishmentsUseCase,
    private val fetchListDrinksUseCase: FetchListDrinksUseCase,
    private val fetchCartUseCase: FetchCartUseCase,
    private val addCartItemUseCase: AddCartItemUseCase,
    private val updateCartItemUseCase: UpdateCartItemUseCase,
    @Assisted private val token: String
): ViewModel() {
    private val _listEstablishments: MutableStateFlow<List<EstablishmentItem>> =
        MutableStateFlow(listOf())
    val listEstablishments: StateFlow<List<EstablishmentItem>> = _listEstablishments

    private val _listDrinks: MutableStateFlow<List<DrinkItem>> =
        MutableStateFlow(listOf())
    val listDrinks: StateFlow<List<DrinkItem>> = _listDrinks

    private val _cart: MutableStateFlow<List<CartItem>> =
        MutableStateFlow(listOf())

    private var _currentIdEstablishment: Int? = null

    val state: MutableStateFlow<CoffeeShopState> = MutableStateFlow(CoffeeShopState.LoadEstablishments)

    private val _idAndCountDishesInCart: MutableStateFlow<Map<Int, Int>> =
        MutableStateFlow(mapOf())
    val idAndCountDishesInCart: StateFlow<Map<Int, Int>> = _idAndCountDishesInCart

    @AssistedFactory
    interface Factory {
        fun create(token: String?): CoffeeShopViewModel
    }

    companion object {
        fun provideDetailsViewModelFactory(
            factory: Factory,
            token: String?
        ) : ViewModelProvider.Factory {
            return object: ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(token) as T
                }
            }
        }
    }

    // Нужно обработать исключение
    fun loadListEstablishments() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                _listEstablishments.emit(fetchListEstablishmentsUseCase.execute("Bearer $token"))
            } catch (e: Exception) {

            }
        }
    }

    // Нужно обработать исключение
    fun loadListDrinks(idEstablishment: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            _currentIdEstablishment = idEstablishment
            try {
                _listDrinks.emit(fetchListDrinksUseCase
                    .execute("Bearer $token", idEstablishment))
                updateCart()

            } catch (e: Exception) {

            }
        }
    }

    // Требудет рефакторинга
    fun increase(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            var newItem = true
            _cart.value.forEach { cartItem ->
                if (_currentIdEstablishment != cartItem.establishment) return@forEach
                cartItem.drinks.forEach { drink ->
                    if (drink.id != id) return@forEach
                    drink.count++
                    newItem = false
                    updateCartItemUseCase.execute(cartItem)
                }
                if (!newItem) return@forEach

                _listDrinks.value.forEach {
                    if (id == it.id) {
                        cartItem.drinks.add(it.mapToCartDrinkItem(1))
                    }
                }
                updateCartItemUseCase.execute(cartItem)
            }

            if (!newItem) {
                state.emit(CoffeeShopState.IncreaseCountDrink)
                return@launch
            }

            val cartItem = CartItem(
                _currentIdEstablishment!!,
                arrayListOf()
            )
            _listDrinks.value.forEach {
                if (id == it.id) cartItem.drinks.add(it.mapToCartDrinkItem(1))
            }
            addCartItemUseCase.execute(cartItem)
            state.emit(CoffeeShopState.IncreaseCountDrink)
        }
    }


    // Требудет рефакторинга
    fun decrease(id: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            var removeDrink: CartDrinkItem? = null

            _cart.value.forEach { cartItem ->
                if (_currentIdEstablishment != cartItem.establishment) return@forEach
                cartItem.drinks.forEach { drink ->
                    if (drink.id != id) return@forEach
                    drink.count--
                    if (drink.count <= 0)
                        removeDrink = drink

                }
                if (removeDrink != null) cartItem.drinks.remove(removeDrink)
                updateCartItemUseCase.execute(cartItem)
            }
            state.emit(CoffeeShopState.DecreaseCountDrink)
        }
    }

    // Требудет рефакторинга
    fun updateCart() {
        CoroutineScope(Dispatchers.IO).launch {
            _cart.emit(fetchCartUseCase.execute().items)
            Log.d("DEBUG_CHECK", _idAndCountDishesInCart.value.toString())

            _cart.value.forEach { cartItem ->
                if (_currentIdEstablishment != cartItem.establishment) return@forEach
                _idAndCountDishesInCart.emit(cartItem.drinks.associate {
                    Pair(it.id, it.count)
                })
            }
            Log.d("DEBUG_CHECK", _idAndCountDishesInCart.value.toString())
            state.emit(CoffeeShopState.Default)
        }
    }

    fun navigateToLogIn(navController: NavController) {
        state.value = CoffeeShopState.LoadEstablishments
        navigateTo(navController, MainGraphDestination.Authorization.destination)
    }

    fun navigateToListEstablishments(childNavController: NavController) {
        state.value = CoffeeShopState.LoadEstablishments
        navigateTo(
            childNavController,
            CoffeeShopGraphDestination.ListEstablishments.destination
        )
    }

    fun navigateToListEstablishmentsOnMap(childNavController: NavController) {
        state.value = CoffeeShopState.LoadEstablishmentsOnMap
        navigateTo(
            childNavController,
            CoffeeShopGraphDestination.ListEstablishmentsOnMap.destination
        )
    }

    fun navigateToListDrinks(childNavController: NavController, idEstablishment: Int) {
        state.value = CoffeeShopState.LoadDrinksOfEstablishment(idEstablishment)
        navigateTo(
            childNavController,
            CoffeeShopGraphDestination.ListDrinks.destination
        )
    }

    private fun navigateTo(navController: NavController, root: String) {
        navController.navigate(root) {
            popUpTo(navController.currentDestination?.route.toString()) {
                inclusive = true
            }
        }
    }
}
