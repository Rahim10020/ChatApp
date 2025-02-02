package tg.eplcoursandroid.chatapp.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import tg.eplcoursandroid.chatapp.data.models.Utilisateur

// classe qui va contenir les methodes pour interagir
// avec la base de donnees concernant les utilisateurs

class UtilisateurRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance() // on recupere l'instance de firebase
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance() // on recupere l'instance de la BD

    // methode pour ajouter un utilisateur a la base de donnees
    fun ajouterUtilisateur(utilisateur: Utilisateur, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        // recuperation d'une reference a la table "utilisateurs"
        val userRef = database.getReference("utilisateurs").child(utilisateur.id)
        userRef.setValue(utilisateur)
            .addOnSuccessListener {
                Log.d("UtilisateurRepository", "Utilisateur ajouté avec succès")
                onSuccess()
            }
            .addOnFailureListener{
                Log.d("UtilisateurRepository", "Erreur lors de l'ajout de l'utilisateur: ${it.message}")
                onFailure(it)
            }
    }

    // methode pour recuperer un utilisateur de la base de donnees
    fun getUtilisateur(utilisateurId: String, onSuccess: (Utilisateur) -> Unit, onFailure: (Exception) -> Unit){
        val userRef = database.getReference("utilisateurs").child(utilisateurId)
        userRef.get()
            .addOnSuccessListener { snapshot ->
                val utilisateur = snapshot.getValue(Utilisateur::class.java)
                if (utilisateur != null) onSuccess(utilisateur)
                else onFailure(Exception("User not found"))
                Log.d("UtilisateurRepository", "Utilisateur récupéré avec succès")
            }
            .addOnFailureListener{
                Log.d("UtilisateurRepository", "Erreur lors de la récupération de l'utilisateur: ${it.message}")
                onFailure(it)
            }
    }
}

