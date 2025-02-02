package tg.eplcoursandroid.chatapp.viewModel

import android.util.Log
import tg.eplcoursandroid.chatapp.data.models.Utilisateur
import tg.eplcoursandroid.chatapp.data.repository.UtilisateurRepository

class UtilisateurViewModel {
    private val utilisateurRepository = UtilisateurRepository()

    // methode pour ajouter un utilisateur
    fun ajouterUtilisateur(utilisateur: Utilisateur) {
        utilisateurRepository.ajouterUtilisateur(utilisateur,
            onSuccess = {
                Log.d("UtilisateurViewModel", "Utilisateur ajouté avec succès")
            },
            onFailure = {
                Log.d("UtilisateurViewModel", "Erreur lors de l'ajout de l'utilisateur: ${it.message}")
            }
        )
    }

    // methode pour recuperer un utilisateur
    fun getUtilisateur(utilisateurId: String){
        utilisateurRepository.getUtilisateur(utilisateurId,
            onSuccess = {
                Log.d("UtilisateurViewModel", "Utilisateur récupéré avec succès")
            },
            onFailure = {
                Log.d("UtilisateurViewModel", "Erreur lors de la récupération de l'utilisateur: ${it.message}")
            }
        )
    }
}