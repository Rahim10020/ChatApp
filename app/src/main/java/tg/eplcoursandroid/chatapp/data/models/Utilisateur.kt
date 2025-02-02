package tg.eplcoursandroid.chatapp.data.models

data class Utilisateur(
    val id: String="",
    val nom: String="",
    val email: String="",
    val profil: String="",
    val lastLogin: Long= System.currentTimeMillis(),
)
