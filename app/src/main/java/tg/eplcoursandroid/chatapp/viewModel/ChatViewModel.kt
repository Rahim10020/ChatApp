package tg.eplcoursandroid.chatapp.viewModel

import android.util.Log
import tg.eplcoursandroid.chatapp.data.repository.ChatRepository

class ChatViewModel {
    private val chatRepository = ChatRepository()

    // methode pour creer un chat
    fun creerChat(senderId: String, receiverId: String) {
        chatRepository.creerChat(senderId, receiverId,
            onSuccess = {
                Log.d("ChatViewModel", "Chat cree avec succes")
                // chat cree avec succes
            },
            onFailure = {
                Log.d("ChatViewModel", "Erreur lors de la creation du chat: ${it.message}")
                // erreur lors de la creation du chat
            }
        )
    }

    // methode pour recuperer un chat
    fun getChat(chatId: String) {
        chatRepository.getChat(chatId,
            onSuccess = {
                Log.d("ChatViewModel", "Chat recupere")
            },
            onFailure = {
                Log.d("ChatViewModel", "Erreur lors de la recuperation du chat: ${it.message}")
            }
        )
    }
}