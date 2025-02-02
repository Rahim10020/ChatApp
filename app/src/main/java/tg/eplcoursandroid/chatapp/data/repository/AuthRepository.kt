package tg.eplcoursandroid.chatapp.data.repository

import com.google.firebase.auth.FirebaseAuth

// classe qui va interagir directement avec firebase
// pour la connexion et la creation de compte

class AuthRepository {
    private val auth = FirebaseAuth.getInstance() // on recupere l'instance de firebase

    // methode pour s'inscrire avec l'email et le mot de passe
    fun creerCompte(email: String, password: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                task -> if (task.isSuccessful) {
                // succes de l'inscription de l'utilisateur
                onSuccess()
            } else {
                // echec de l'inscription de l'utilisateur
                onFailure(task.exception?: Exception("inscription echouee"))
            }
        }
    }

    // methode pour se connecter via email et mot de passe
    fun connecter(email:String, password: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit){
        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener {
                task -> if (task.isSuccessful) {
                    // succes de la connexion de l'utilisateur
                    onSuccess()
                } else {
                    // echec de la connexion de l'utilisateur
                    onFailure(task.exception?: Exception("connexion echouee"))
                }
            }
    }

    // methode pour se deconnecter
    fun deconnecter(onSuccess: () -> Unit, onFailure: (Exception) -> Unit){
        try {
            auth.signOut()
            onSuccess() // appel du callback en cas de succes
        }catch (e: Exception){
            onFailure(e) // appel du callback en cas d'echec
        }
    }

}