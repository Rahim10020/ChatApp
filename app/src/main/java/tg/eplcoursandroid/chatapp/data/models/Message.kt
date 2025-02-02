package tg.eplcoursandroid.chatapp.data.models

data class Message(
    val id: String="",
    val celuiQuiEnvoiId: String="",
    val celuiQuiRecoitId: String="",
    val contenu: String="",
    val timestamp: Long= System.currentTimeMillis(),
)
