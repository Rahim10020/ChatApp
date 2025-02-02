package tg.eplcoursandroid.chatapp.data.repository

import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import tg.eplcoursandroid.chatapp.data.models.Chat


// classe qui va contenir les methodes pour interagir avec
// la base de donnees pour les chats

class ChatRepository {
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance() // on recupere l'instance de la BD

    // methode pour ajouter un chat a la base de donnees
    fun creerChat(senderId: String, receiverId: String, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val chat = Chat(
            id = FirebaseDatabase.getInstance().reference.child("chats").push().key ?: "",
            senderID = senderId,
            receiverID = receiverId
        )

        val creerChatRef = database.reference.child("chats").child(chat.id)
        creerChatRef.setValue(chat)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it)
            }

    }

    // fonction pour recuperer un chat de la base de donnees
    fun getChat(chatId: String, onSuccess: (Chat) -> Unit, onFailure: (Exception) -> Unit) {
        val chatRef = database.reference.child("chats").child(chatId)
        chatRef.addListenerForSingleValueEvent(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val chat = snapshot.getValue(Chat::class.java)
                    if (chat != null) {
                        onSuccess(chat)
                    } else {
                        Log.d("ChatRepository", "Chat not found")
                        onFailure(Exception("Chat not found"))
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("ChatRepository", "Erreur lors de la récupération du chat: ${error.message}")
                    onFailure(error.toException())
                }
            }
        )

    }

}