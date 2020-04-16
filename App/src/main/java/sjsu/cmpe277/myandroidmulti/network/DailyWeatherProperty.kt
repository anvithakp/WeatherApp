package sjsu.cmpe277.myandroidmulti.network

import com.squareup.moshi.Json

data class DailyWeatherProperty(

    // used to map main from the JSON to mainpart in our class
    @Json(name = "list") val listpart: List<TheListPart>,
    @Json(name = "city") val  citypart: TheCityPart,
    val message: String,
    val cod: Double
)

data class TheListPart(

    @Json(name= "main") val mainpart : TheMainPart,
    @Json(name= "weather") val weatherpart : List<TheWeatherPart>,
    val dt_txt : String

)

data class TheMainPart (
    val temp: Double,
    @Json(name= "temp_min") val min: Double,
    @Json(name= "temp_max") val max: Double
)

data class TheWeatherPart (
    @Json(name= "main") val main: String,
    @Json(name= "icon") val icon: String
)

data class TheCityPart (
    val name: String
)

