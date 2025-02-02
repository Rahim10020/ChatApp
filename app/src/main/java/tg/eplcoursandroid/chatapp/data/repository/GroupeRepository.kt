package tg.eplcoursandroid.chatapp.data.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import tg.eplcoursandroid.chatapp.data.models.Chat
import tg.eplcoursandroid.chatapp.data.models.Groupe


// classe qui contenir les methodes pour
// interagir avec la base de donnees concernant les groupes

class GroupeRepository {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance() // on recupere l'instance de la BD

    // methode pour ajouter un groupe a la base de donnees
    fun creerGroupe(nomGroupe: String, creatorId: String, membres: List<String>, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val groupeChatID = database.reference.child("chats").push().key ?: ""
        // creation d'un chat pour le groupe
        val groupeChat = Chat(
            id = groupeChatID,
        )
        val groupeChatRef = database.reference.child("chats").child(groupeChat.id)
        groupeChatRef.setValue(groupeChat)
            .addOnSuccessListener {
                // creation du groupe
                val groupe = Groupe(
                    id = database.reference.child("groupes").push().key ?: "",
                    nomGroupe = nomGroupe,
                    creatorId = creatorId,
                    membres = membres,
                    chatID = groupeChat.id // permet de lier le groupe a son chat
                )

                // sauvegarde du groupe dans la base de donnees
                val groupeRef = database.reference.child("groupes").child(groupe.id)
                groupeRef.setValue(groupe)
                    .addOnSuccessListener {
                        onSuccess()
                    }.addOnFailureListener {
                        Log.d("GroupeRepository", "Erreur lors de la creation du groupe: ${it.message}")
                    onFailure(it)
                    }
            .addOnFailureListener {
                Log.d("GroupeRepository", "Erreur lors de la creation du chat du groupe: ${it.message}")
                onFailure(it)
            }
        }

    }

    // methode pour a ajouter un membre au groupe
    fun ajouterMembre(groupId: String, creatorId: String, newMemberId: String, onSuccess: (Groupe) -> Unit, onFailure: (Exception) -> Unit) {
        // Récupérer les informations du groupe
        val groupeRef = database.reference.child("groupes").child(groupId)

            groupeRef.addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val groupe = snapshot.getValue(Groupe::class.java)
                    if (groupe != null) {
                        // Vérifier si l'utilisateur est le créateur du groupe
                        if (groupe.creatorId == creatorId) {
                            // Ajouter le nouveau membre à la liste des utilisateurs de ce groupe
                            val updatedUsers = groupe.membres.toMutableList()

                            if (updatedUsers.size >= 1) {
                                updatedUsers.add(newMemberId)

                                // Mettre à jour la liste des utilisateurs dans la base de données
                                val updatedGroup = groupe.copy(membres = updatedUsers)

                                // Enregistrer les modifications dans Firebase
                                val updatedGroupeRef = database.reference.child("groupes").child(groupId)

                                    updatedGroupeRef.setValue(updatedGroup)
                                    .addOnSuccessListener {
                                        // Récupérer le chat associé au groupe pour une mise à jour (si nécessaire)
                                        FirebaseDatabase.getInstance().reference.child("chats").child(groupe.id)
                                            .addListenerForSingleValueEvent(object : ValueEventListener {
                                                override fun onDataChange(snapshot: DataSnapshot) {
                                                    val chat = snapshot.getValue(Chat::class.java)
                                                    if (chat != null) {
                                                        onSuccess(updatedGroup) // Retourner le groupe mis à jour
                                                        Log.d("GroupeRepository", "Membre ajouté avec succès")
                                                    } else {
                                                        Log.d("GroupeRepository", "Chat not found")
                                                        onFailure(Exception("Chat not found"))
                                                    }
                                                }

                                                override fun onCancelled(error: DatabaseError) {
                                                    Log.d("GroupeRepository", "Erreur lors de la récupération du chat: ${error.message}")
                                                    onFailure(error.toException())
                                                }
                                            })
                                    }
                                    .addOnFailureListener { exception ->
                                        Log.d("GroupeRepository", "Erreur lors de la mise à jour du groupe: ${exception.message}")
                                        onFailure(exception)
                                    }
                            } else {
                                Log.d("GroupeRepository", "un group doit contenir au moins un utilisateur")
                                onFailure(Exception("un groupe doit contenir au moins un utilisateur"))
                            }
                        } else {
                            Log.d("GroupeRepository", "Vous n'êtes pas le créateur du groupe")
                            onFailure(Exception("Vous n'êtes pas le créateur du groupe"))
                        }
                    } else {
                        Log.d("GroupeRepository", "Groupe non trouve")
                        onFailure(Exception("Groupe non trouve"))
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("GroupeRepository", "Erreur lors de la récupération du groupe: ${error.message}")
                    onFailure(error.toException())
                }
            })
    }

    // methode pour retirer un membre d'un groupe
    fun retirerMembre(groupId: String, userId: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val groupRef = database.reference.child("groupes").child(groupId).child("utilisateurs")

        groupRef.get().addOnSuccessListener { snapshot ->
            val membersList = snapshot.children.mapNotNull { it.getValue(String::class.java) }.toMutableList()

            if (membersList.contains(userId)) {
                membersList.remove(userId)

                // Mise à jour de la liste des membres dans Firebase
                groupRef.setValue(membersList)
                    .addOnSuccessListener {
                        onSuccess()
                        Log.d("GroupeRepository", "Membre supprimé avec succès")
                    }
                    .addOnFailureListener {
                        exception -> onFailure(exception)
                        Log.d("GroupeRepository", "Erreur lors de la mise à jour de la liste des membres: ${exception.message}")
                    }
            } else {
                Log.d("GroupeRepository", "L'utilisateur n'est pas dans ce groupe")
                onFailure(Exception("L'utilisateur n'est pas dans ce groupe"))
            }
        }.addOnFailureListener { exception ->
            onFailure(exception)
            Log.d("GroupeRepository", "Erreur lors de la récupération de la liste des membres: ${exception.message}")
        }
    }

}