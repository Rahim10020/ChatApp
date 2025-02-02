package tg.eplcoursandroid.chatapp.viewModel

import android.util.Log
import tg.eplcoursandroid.chatapp.data.models.Message
import tg.eplcoursandroid.chatapp.data.repository.MessageRepository

class MessageViewModel {
    private val messageRepository = MessageRepository()

    // methode pour ajouter un message
    fun ajouterMessage(chatId: String, message: Message) {
        messageRepository.ajouterMessage(chatId, message,
            onSuccess = {
                Log.d("MessageViewModel", "Message ajoute avec succes")
            },
            onFailure = {
                Log.d("MessageViewModel", "Erreur lors de l'ajout du message: ${it.message}")
            }
        )
    }

    // methode pour recuperer les messages
    fun getMessages(chatId: String){
        messageRepository.getMessages(chatId,
            onSuccess = {
                Log.d("MessageViewModel", "Messages recuperes avec succes")
            },
            onFailure = {
                Log.d("MessageViewModel", "Erreur lors de la recuperation des messages: ${it.message}")
            }
        )
    }
}