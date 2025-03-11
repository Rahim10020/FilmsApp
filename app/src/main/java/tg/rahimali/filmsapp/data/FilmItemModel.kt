package tg.rahimali.filmsapp.data

import java.io.Serializable

data class FilmItemModel(
    var Title : String = "",
    var Descriptipon : String = "",
    var Poster : String = "",
    var Time : String = "",
    var Trailer : String = "",
    var Imdb : Int = 0,
    var Year : Int = 0,
    var price : Double = 0.0,
    var Genre : ArrayList<String> = ArrayList(),
    var Casts : ArrayList<CastModel> = ArrayList(),
):Serializable
