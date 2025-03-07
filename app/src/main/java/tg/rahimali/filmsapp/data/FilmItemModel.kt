package tg.rahimali.filmsapp.data

import java.io.Serializable

data class FilmItemModel(
    var title : String = "",
    var descriptipon : String = "",
    var poster : String = "",
    var time : String = "",
    var trailer : String = "",
    var imdb : String = "",
    var year : String = "",
    var price : Double = 0.0,
    var genre : ArrayList<String> = ArrayList(),
    var casts : ArrayList<CastModel> = ArrayList(),
):Serializable
