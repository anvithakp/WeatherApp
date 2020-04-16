package sjsu.cmpe277.myandroidmulti.network

import com.squareup.moshi.Json

data class WeatherProperty(
    val id: String,
    // used to map main from the JSON to mainpart in our class
    @Json(name = "main") val mainpart: MainWeatherPart,
    @Json(name = "weather") val weatherpart: List<WeatherPart>,
    val name: String,
    val cod: Double
)

data class MainWeatherPart(
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double
)

data class WeatherPart(
    val icon : String
)