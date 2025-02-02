package tg.eplcoursandroid.chatapp.data.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import tg.eplcoursandroid.chatapp.data.models.Message

// classe qui va contenir les methodes pour interagir
// avec la base de donnees concernant les messages

class MessageRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance() // on recupere l'instance de firebase
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance() // on recupere l'instance de la BD

    // methode pour ajouter un message a la base de donnees (le message dois etre associe a un chat)
    fun ajouterMessage(chatId: String, message: Message, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val chatRef = database.getReference("chats").child(chatId).child("messages").push()
        chatRef.setValue(message)
            .addOnSuccessListener {
                Log.d("MessageRepository", "Message ajouté avec succès")
                onSuccess()
            }
            .addOnFailureListener{
                Log.d("MessageRepository", "Erreur lors de l'ajout du message: ${it.message}")
                onFailure(it)
            }

    }

    // methode pour recuperer les messages dans la base de donnees
    // on ne va pas recuperer un seul message mais tous les messages d'un chat
    fun getMessages(chatId: String, onSuccess: (List<Message>) -> Unit, onFailure: (Exception) -> Unit){
        val messagesRef = database.getReference("chats").child(chatId).child("messages")
        messagesRef.get()
            .addOnSuccessListener { snapshot ->
                val messages = snapshot.children.mapNotNull { it.getValue(Message::class.java) }
                onSuccess(messages)
                Log.d("MessageRepository", "Messages récupérés avec succès")
            }
            .addOnFailureListener{
                Log.d("MessageRepository", "Erreur lors de la récupération des messages: ${it.message}")
                onFailure(it)
            }
    }
}