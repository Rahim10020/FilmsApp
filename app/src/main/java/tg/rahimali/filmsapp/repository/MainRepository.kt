package tg.rahimali.filmsapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import tg.rahimali.filmsapp.data.FilmItemModel

class MainRepository {
    // recuperer une instance de firebase
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadUpComings(): LiveData<MutableList<FilmItemModel>> {
        val liste = MutableLiveData<MutableList<FilmItemModel>>()
        val reference = firebaseDatabase.getReference("Upcomming")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val films = mutableListOf<FilmItemModel>()
                for (snpshot in snapshot.children) {
                    // conversion en objet FilmItemModel
                    val item = snpshot.getValue(FilmItemModel::class.java)
                    item?.let { films.add(it) }
                }
                liste.value = films
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        return liste
    }


    fun loadItems(): LiveData<MutableList<FilmItemModel>> {
        val liste = MutableLiveData<MutableList<FilmItemModel>>()
        val reference = firebaseDatabase.getReference("Items")
        reference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val films = mutableListOf<FilmItemModel>()
                for (snpshot in snapshot.children) {
                    // conversion en objet FilmItemModel
                    val item = snpshot.getValue(FilmItemModel::class.java)
                    item?.let { films.add(it) }
                }
                liste.value = films
            }

            override fun onCancelled(error: DatabaseError) {

            }
        })
        return liste
    }
}