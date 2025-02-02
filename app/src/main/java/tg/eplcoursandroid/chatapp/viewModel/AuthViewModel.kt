package tg.eplcoursandroid.chatapp.viewModel

import android.util.Log
import tg.eplcoursandroid.chatapp.data.repository.AuthRepository

// classe qui va servir d'intermediaire entre l'ecran de connexion ou de creation de compte
// et le repository ou se trouve les methodes d'authentification (AuthRepository)

class AuthViewModel {
    private val authRepository = AuthRepository()

    // fonction de connexion qui va etre appele dans le UI de connexion
    fun connecter(email: String, password: String) {
        authRepository.connecter(email,password,
            onSuccess = {
                // connexion reussie
                Log.d("AuthViewModel", "Connexion réussie")
            },
            onFailure = {
                // connexion echouee
                Log.d("AuthViewModel", "Connexion échouée: ${it.message}")
            }
        )
    }

    // fonction de creation de compte qui va etre appele dans le UI de creation de compte
    fun creerCompte(email: String, password: String) {
        authRepository.creerCompte(email,password,
            onSuccess = {
                // creation de compte reussie
                Log.d("AuthViewModel", "Creation de compte réussie")
            },
            onFailure = {
                // creation de compte echouee
                Log.d("AuthViewModel", "Creation de compte échouée: ${it.message}")
            }
        )
    }

    // fonction de deconnexion qui va etre appele dans le UI de deconnexion
    fun deconnecter() {
        authRepository.deconnecter(
            onSuccess = {
                // deconnexion reussie
                Log.d("AuthViewModel", "Deconnexion réussie")
            },
            onFailure = {
                // deconnexion echouee
                Log.d("AuthViewModel", "Deconnexion échouée: ${it.message}")
            }
        )
    }
}