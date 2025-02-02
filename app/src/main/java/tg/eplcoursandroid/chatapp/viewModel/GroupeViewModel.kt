package tg.eplcoursandroid.chatapp.viewModel

import android.util.Log
import tg.eplcoursandroid.chatapp.data.repository.GroupeRepository

class GroupeViewModel {
    private val groupeRepository = GroupeRepository()

    // methode pour creer un groupe
    fun creerGroupe(nomGroupe: String, creatorId: String, membres: List<String>) {
        groupeRepository.creerGroupe(nomGroupe, creatorId, membres,
            onSuccess = {
                // groupe cree avec succes
                Log.d("GroupeViewModel", "Groupe cree avec succes")
            },
            onFailure = {
                Log.d("GroupeViewModel", "Erreur lors de la creation du groupe: ${it.message}")
                // erreur lors de la creation du groupe
            }
        )
    }

    // methode pour ajouter un membre a un groupe
    fun ajouterMembre(groupId: String, creatorId: String, newMemberId: String) {
        groupeRepository.ajouterMembre(groupId, creatorId, newMemberId,
            onSuccess = {
                Log.d("GroupeViewModel", "Membre ajoute avec succes")
                // membre ajoute avec succes
            },
            onFailure = {
                Log.d("GroupeViewModel", "Erreur lors de l'ajout du membre: ${it.message}")
                // erreur lors de l'ajout du membre
            }
        )
    }

    // methode pour retirer un membre du groupe
    fun retirerMembre(groupId: String, userId: String){
        groupeRepository.retirerMembre(groupId, userId,
            onSuccess = {
                Log.d("GroupeViewModel", "Membre retire avec succes")
            },
            onFailure = {
                Log.d("GroupeViewModel", "Erreur lors de la retire du membre: ${it.message}")
            }
        )
    }
}