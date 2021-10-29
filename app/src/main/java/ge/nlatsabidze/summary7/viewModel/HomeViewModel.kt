package ge.nlatsabidze.summary7.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ge.nlatsabidze.summary7.model.User
import ge.nlatsabidze.summary7.network.ApiInstance
import kotlinx.coroutines.launch
import retrofit2.Response


class HomeViewModel() : ViewModel() {

    private val _loginResponseData: MutableLiveData<Response<User>> = MutableLiveData()
    val loginResponseData: LiveData<Response<User>> = _loginResponseData

    private val _registerResponseData: MutableLiveData<Response<User>> = MutableLiveData()
    val registerResponseData: LiveData<Response<User>> = _registerResponseData

    fun register(email: String, password: String) {
        viewModelScope.launch {
            val registerResponse = ApiInstance.ApiClient.register(email, password)
            _registerResponseData.value = registerResponse
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            val loginResponse = ApiInstance.ApiClient.login(email, password)
            _loginResponseData.value = loginResponse
        }
    }
}