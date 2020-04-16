package sjsu.cmpe277.myandroidmulti.network

import android.location.Location
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val WeatherAPPID = "2b492c001d57cd5499947bd3d3f9c47b"

class WeatherViewModel : ViewModel() {

    // The internal MutableLiveData String that stores the most recent response
    var cityName = MutableLiveData<String>()
    var temperature = MutableLiveData<String>()
    var part2 = MutableLiveData<String>()
    var icon = MutableLiveData<String>()

    var city = MutableLiveData<String>()


companion object {
    const val TAG = "WeatherViewModel"
}

    /**
     * Call getWeatherProperties() on init so we can display status immediately.
     */
    init {
//        getWeatherProperties()
    }


    fun onClick(view: View) {
        Log.d(TAG, "on click ${city.value}" )
    }



//    private fun getWeatherProperties() {
//        //_response.value = "Set the Weather API Response here!"
//        //WeatherApi.retrofitService.getProperties()
//        WeatherApi.retrofitService.getProperties("San Jose", WeatherAPPID).enqueue(
//            object: Callback<WeatherProperty> {
//                override fun onFailure(call: Call<WeatherProperty>, t: Throwable) {
//                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    _response.value = "Failure: " + t.message
//                }
//
//                override fun onResponse(call: Call<WeatherProperty>, response: Response<WeatherProperty>) {
//                    //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//                    //_response.value = response.body()
//                    _response.value = "Success: ${response.body()?.name} city retrieved; Temperature: ${response.body()?.mainpart?.temp}; Humidity: ${response.body()?.mainpart?.humidity}"
//                }
//
//            }
//        )
//    }

    fun getCityLocation(city : String) {
        WeatherApi.retrofitService.getProperties(
            city,
            WeatherAPPID
        ).enqueue(
            object : Callback<WeatherProperty> {
                override fun onFailure(call: Call<WeatherProperty>, t: Throwable) {
                    // TODO
                }

                override fun onResponse(
                    call: Call<WeatherProperty>,
                    response: Response<WeatherProperty>
                ) {
                    cityName.value = response.body()?.name
                    temperature.value = convertToFahernheit(response.body()?.mainpart?.temp)
                    part2.value = response.body()?.mainpart?.humidity.toString()
                    icon.value = response.body()?.weatherpart?.get(0)?.icon
                }

            }
        )
    }




    fun getCurrentLocation(location : Location) {
            WeatherApi.retrofitService.getCurrentLocation(
                location.latitude.toString(),
                location.longitude.toString(),
                WeatherAPPID
            ).enqueue(
                object : Callback<WeatherProperty> {
                    override fun onFailure(call: Call<WeatherProperty>, t: Throwable) {
                        Log.e(TAG, "Failed !!!! $t")
                    }

                    override fun onResponse(
                        call: Call<WeatherProperty>,
                        response: Response<WeatherProperty>
                    ) {
                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                        //_response.value = response.body()
                        cityName.value = response.body()?.name
                        temperature.value = convertToFahernheit(response.body()?.mainpart?.temp)
                        part2.value = response.body()?.mainpart?.humidity.toString()
                        icon.value = response.body()?.weatherpart?.get(0)?.icon
                    }

                }
            )
    }

    private fun convertToFahernheit(kelvin : Double?) : String {
        if (kelvin == null)
            return ""
        var result = 9.times(kelvin - 273)
        result /= 5
        result += 32
        return result.toInt().toString() + " F"
    }


}
