package tg.rahimali.chatapp.feature.auth.signin

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel


@HiltViewModel
class SignInViewModel : ViewModel() {
}

sealed class SignInState {
    data object Nothing : SignInState()
    data object Loading : SignInState()
    data object Success : SignInState()
    data object Error : SignInState()
}