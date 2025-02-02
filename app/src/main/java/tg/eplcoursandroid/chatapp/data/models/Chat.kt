package tg.eplcoursandroid.chatapp.data.models


data class Chat(
    val id: String="",
    val senderID: String="",
    val receiverID: String="",
    val messages: List<Message> = listOf(), // les messages qu'ils echangent entre eux.
    val dernierMessage: Message? = null, // le dernier message envoyé dans le chat.
)
