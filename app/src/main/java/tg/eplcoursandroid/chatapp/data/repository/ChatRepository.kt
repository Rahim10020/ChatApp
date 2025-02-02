package tg.eplcoursandroid.chatapp.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase


// classe qui va contenir les methodes pour interagir avec
// la base de donnees pour les chats

class ChatRepository {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance() // on recupere l'instance de firebase
    private val database: FirebaseDatabase = FirebaseDatabase.getInstance() // on recupere l'instance de la BD

    // methode pour ajouter un chat a la base de donnees

}