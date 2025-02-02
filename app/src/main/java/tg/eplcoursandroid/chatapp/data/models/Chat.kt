package tg.eplcoursandroid.chatapp.data.models

// je veux distinguer deux types de chats :
// les chats de groupe et les chats individuels
// les chats de groupe auront un nom, une date de creation et une photo de profil ce qui serait null pour
// les chats individuels

data class Chat(
    val id: String="",
    val participantsIds: List<String> = listOf(), // liste des IDs des utilisateurs qui participent au chat
    val messages: List<Message> = listOf(), // les messages qu'ils echangent entre eux.
    val dernierMessage: Message? = null, // le dernier message envoyé dans le chat.
    val isGroup: Boolean    // true si c'est un chat de groupe, false sinon.
)
