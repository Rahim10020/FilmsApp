package tg.rahimali.filmsapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import tg.rahimali.filmsapp.data.FilmItemModel
import tg.rahimali.filmsapp.repository.MainRepository

class MainViewModel : ViewModel(){
    private val repository = MainRepository()

    fun loadUpCommings() : LiveData<MutableList<FilmItemModel>> {
        return repository.loadUpComings()
    }


    fun loadItems() : LiveData<MutableList<FilmItemModel>> {
        return repository.loadItems()
    }
}