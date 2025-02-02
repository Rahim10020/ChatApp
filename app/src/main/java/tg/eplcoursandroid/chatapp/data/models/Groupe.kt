package tg.eplcoursandroid.chatapp.data.models

data class Groupe(
    val id: String="",
    val nomGroupe: String="",
    val creatorId: String="",       // id de celui qui a cree le groupe
    val dateCreation: Long= System.currentTimeMillis(),
    val description: String="", // description du groupe
    val photoProfil: String="", // lien vers la photo de profil du groupe
    val membres: List<String> = listOf(), // liste des IDs des membres qui participent au chat
    val chatID: String="", // ID du chat associé au groupe
)
