package tg.rahimali.chatapp.feature.auth.signin

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject


@HiltViewModel
class SignInViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow<SignInState>(SignInState.Nothing)
    val state = _state.asStateFlow()
    private val firebaseAuth = FirebaseAuth.getInstance()

    fun signIn(email: String, password: String) {
        _state.value = SignInState.Loading

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                _state.value = if (task.isSuccessful) {
                    SignInState.Success
                } else {
                    SignInState.Error
                }
            }
    }
}


sealed class SignInState {
    data object Nothing : SignInState()
    data object Loading : SignInState()
    data object Success : SignInState()
    data object Error : SignInState()
}