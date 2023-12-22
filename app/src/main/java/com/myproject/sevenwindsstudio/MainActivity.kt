package com.myproject.sevenwindsstudio

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myproject.domain.models.authorization.Authorization
import com.myproject.domain.models.cart.CartDrinkItem
import com.myproject.domain.models.cart.CartItem
import com.myproject.domain.usecase.authorization.LogInUseCase
import com.myproject.domain.usecase.authorization.RegistrationUseCase
import com.myproject.domain.usecase.cart.AddCartItemUseCase
import com.myproject.domain.usecase.cart.DeleteCartItemUseCase
import com.myproject.domain.usecase.cart.FetchCartUseCase
import com.myproject.domain.usecase.cart.UpdateCartItemUseCase
import com.myproject.domain.usecase.coffeeshop.FetchListDrinksUseCase
import com.myproject.domain.usecase.coffeeshop.FetchListEstablishmentsUseCase
import com.myproject.sevenwindsstudio.ui.theme.SevenwindsstudioTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SevenwindsstudioTheme {
                val viewModel: MainViewModel = hiltViewModel()
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        onClick = { viewModel.logIn("nester","nester") }) {
                        Text(text = "LogIn")
                    }
                    Button(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        onClick = { viewModel.putListEstablishments() }) {
                        Text(text = "putListEstablishments")
                    }
                    Button(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        onClick = { viewModel.putListDrinks() }) {
                        Text(text = "putListDrinks")
                    }
                    Button(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        onClick = { viewModel.addCartItem() }) {
                        Text(text = "addCartItem")
                    }
                    Button(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        onClick = { viewModel.deleteCartItem() }) {
                        Text(text = "deleteCartItem")
                    }
                    Button(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        onClick = { viewModel.fetchCart() }) {
                        Text(text = "fetchCart")
                    }
                    Button(
                        modifier = Modifier
                            .padding(top = 50.dp),
                        onClick = { viewModel.updateCartItem() }) {
                        Text(text = "updateCartItem")
                    }
                }
            }
        }
    }
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val logInUseCase: LogInUseCase,
    private val registrationUseCase: RegistrationUseCase,
    private val putListDrinksUseCase: FetchListDrinksUseCase,
    private val putListEstablishmentsUseCase: FetchListEstablishmentsUseCase,
    private val addCartItemUseCase: AddCartItemUseCase,
    private val deleteCartItemUseCase: DeleteCartItemUseCase,
    private val fetchCartUseCase: FetchCartUseCase,
    private val updateCartItemUseCase: UpdateCartItemUseCase,
) : ViewModel() {
    private var token: String = ""

    fun registration(login: String, password: String) {
        viewModelScope.launch {
            try {
                val response = registrationUseCase.execute(Authorization(login, password))
                Log.d("DEBUG_CHECK", "Registration: $response")
            } catch (e: Exception) {
                Log.d("DEBUG_CHECK", "Registration for (login: $login, password: $password): false")
            }

        }
    }

    fun logIn(login: String, password: String) {
        viewModelScope.launch {
            try {
                val response = logInUseCase.execute(Authorization(login, password))
                token = "Bearer ${response.token}"
                Log.d("DEBUG_CHECK", "LogIn: $response")
            } catch (e: Exception) {
                Log.d("DEBUG_CHECK", "LogIn for (login: $login, password: $password): false")
            }
        }
    }

    fun putListEstablishments() {
        viewModelScope.launch {
            try {
                val response = putListEstablishmentsUseCase.execute(token)
                Log.d("DEBUG_CHECK", "putListEstablishments: $response")
            } catch (e: Exception) {
                Log.d("DEBUG_CHECK", "putListEstablishments: $e")
            }
        }
    }

    fun putListDrinks() {
        viewModelScope.launch {
            try {
                val response = putListDrinksUseCase.execute(token, 1)
                Log.d("DEBUG_CHECK", "putListDrinks: $response")
            } catch (e: Exception) {
                Log.d("DEBUG_CHECK", "putListDrinks: $e")
            }
        }
    }

    fun fetchCart() {
        viewModelScope.launch {
            fetchCartUseCase
            try {
                val response = fetchCartUseCase.execute()
                Log.d("DEBUG_CHECK", "fetchCart: ${response}")
            } catch (e: Exception) {
                Log.d("DEBUG_CHECK", "fetchCart: $e")
            }
        }
    }

    fun addCartItem() {
        viewModelScope.launch {
            try {
                val response = addCartItemUseCase.execute(
                    CartItem(
                        establishment = "Арома",
                        drinks = arrayListOf(
                            CartDrinkItem(
                                id = 0,
                                name = "Латте",
                                price = 100,
                                count = 1
                            )
                        )
                    )
                )

                addCartItemUseCase.execute(
                    CartItem(
                        establishment = "Арома 2",
                        drinks = arrayListOf(
                            CartDrinkItem(
                                id = 0,
                                name = "Латте",
                                price = 100,
                                count = 1
                            )
                        )
                    )
                )
                Log.d("DEBUG_CHECK", "addCartItem: $response")
            } catch (e: Exception) {
                Log.d("DEBUG_CHECK", "addCartItem: $e")
            }
        }
    }

    fun deleteCartItem() {
        viewModelScope.launch {
            try {
                val response = deleteCartItemUseCase.execute("Арома")
                deleteCartItemUseCase.execute("Арома 2")
                Log.d("DEBUG_CHECK", "addCartItem: $response")
            } catch (e: Exception) {
                Log.d("DEBUG_CHECK", "addCartItem: $e")
            }
        }
    }

    fun updateCartItem() {
        viewModelScope.launch {
            try {
                val drink = CartDrinkItem(
                    id = 0,
                    name = "Латте",
                    price = 100,
                    count = 1
                )
                val response = updateCartItemUseCase.execute(
                    CartItem(
                        "Арома", arrayListOf(drink, drink, drink)
                    )
                )
                Log.d("DEBUG_CHECK", "addCartItem: $response")
            } catch (e: Exception) {
                Log.d("DEBUG_CHECK", "addCartItem: $e")
            }
        }
    }
}
