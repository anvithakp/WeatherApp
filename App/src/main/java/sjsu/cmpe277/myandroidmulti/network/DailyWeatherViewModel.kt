package sjsu.cmpe277.myandroidmulti.network

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


private const val WeatherAPPID = "2b492c001d57cd5499947bd3d3f9c47b"

class DailyWeatherViewModel : ViewModel() {


    val _response = MutableLiveData<String>()

    var _finallist = MutableLiveData<List<DailyWeatherData>>()



     fun getDailyWeatherProperties(city : String) {


        DailyWeatherApi.retrofitService.getProperties(city, "Imperial", WeatherAPPID).enqueue(
            object : Callback<DailyWeatherProperty> {
                override fun onFailure(call: Call<DailyWeatherProperty>, t: Throwable) {
                    println("TAG :onFailure");
                    _response.value = "Failure: " + t.message
                    var dailyWeatherData = DailyWeatherData("Failure", "Failure","Failure","Failure", "")
                   _finallist = MutableLiveData(listOf(dailyWeatherData))

                }

                override fun onResponse(
                    call: Call<DailyWeatherProperty>,
                    response: Response<DailyWeatherProperty>
                ) {

                    var index1Output: String = ""
                    var index2Output: String = ""
                    var index3Output: String = ""
                    var index4Output: String = ""
                    var index5Output: String = ""

                   //  var final: List<DailyWeatherProperty>
                    var parts = response.body()?.listpart
                    var city : String? = response.body()?.citypart?.name

                    if (parts != null && parts.size >= 5) {

                        // Day1 weather retrieval
                        var main1 = ""
                        var date1 = parts?.get(8)?.dt_txt
                        var temp1 = parts?.get(8)?.mainpart?.temp
                        var icon1 = parts?.get(8)?.weatherpart?.get(0)?.icon
                        index1Output = index1Output.plus("Temperature").plus(temp1).plus(", ")
                        var weatherList1 = parts?.get(8)?.weatherpart
                        if (weatherList1 != null && weatherList1.isNotEmpty()) {
                            main1 = weatherList1.get(0).main
                           // index1Output = index1Output.plus("Forecast").plus(main)
                        }
                        var dailyWeatherData1 = DailyWeatherData(" Temparature : ".plus(temp1)," Forecast : ".plus(main1),"Date : ".plus(date1),"City : ".plus(city), icon1)

                        // Day2 weather retrieval
                        var main2 = ""
                        var date2 = parts?.get(15)?.dt_txt
                        var temp2 = parts?.get(15)?.mainpart?.temp
                        var icon2 = parts?.get(15)?.weatherpart?.get(0).icon

                        index2Output = index2Output.plus("Temperature").plus(temp2).plus(", ")
                        var weatherList2 = parts?.get(15)?.weatherpart
                        if (weatherList2 != null && weatherList2.isNotEmpty()) {
                            main2 = weatherList2.get(0).main
                           // index2Output = index2Output.plus("Forecast").plus(main2)
                        }
                        var dailyWeatherData2 = DailyWeatherData(" Temparature : ".plus(temp2)," Forecast : ".plus(main2),"Date : ".plus(date2),"City : ".plus(city),icon2)

                        // Day3 weather retrieval
                        var main3 = ""
                        var date3 = parts?.get(24)?.dt_txt
                        var temp3 = parts?.get(24)?.mainpart?.temp
                        var icon3 = parts?.get(24)?.weatherpart?.get(0).icon
                        index3Output = index3Output.plus("Temperature").plus(temp3).plus(", ")
                        var weatherList3 = parts?.get(24)?.weatherpart
                        if (weatherList3 != null && weatherList3.isNotEmpty()) {
                            main3 = weatherList3.get(0).main
                        //    index3Output = index3Output.plus("Forecast").plus(main)
                        }
                        var dailyWeatherData3 = DailyWeatherData(" Temparature : ".plus(temp3)," Forecast : ".plus(main3),"Date : ".plus(date3),"City : ".plus(city),icon3)

                        // Day4 weather retrieval
                        var main4 = ""
                        var date4 = parts?.get(31)?.dt_txt
                        var temp4 = parts?.get(31)?.mainpart?.temp
                        var icon4 = parts?.get(31)?.weatherpart?.get(0).icon
                        index4Output = index4Output.plus("Temperature").plus(temp4).plus(", ")
                        var weatherList4 = parts?.get(31)?.weatherpart
                        if (weatherList4 != null && weatherList4.isNotEmpty()) {
                            main4 = weatherList4.get(0).main
                           // index4Output = index4Output.plus("Forecast").plus(main)
                        }
                        var dailyWeatherData4 = DailyWeatherData(" Temparature : ".plus(temp4)," Forecast : ".plus(main4),"Date : ".plus(date4),"City : ".plus(city), icon4)

                        // Day5 weather retrieval
                        var main5 = ""
                        var date5 = parts?.get(39)?.dt_txt
                        var temp5 = parts?.get(39)?.mainpart?.temp
                        var icon5 = parts?.get(39)?.weatherpart?.get(0).icon
                        index5Output = index5Output.plus("Temperature").plus(temp5).plus(", ")
                        var weatherList5 = parts?.get(39)?.weatherpart
                        if (weatherList5 != null && weatherList5.isNotEmpty()) {
                            main5 = weatherList5.get(0).main
                            index5Output = index5Output.plus("Forecast").plus(main5)
                        }

                        var dailyWeatherData5 = DailyWeatherData(" Temparature : ".plus(temp5)," Forecast : ".plus(main5),"Date : ".plus(date5),"City : ".plus(city), icon5)

                        // List of all the 5 day weather
                       _finallist.value = listOf(dailyWeatherData1,dailyWeatherData2,dailyWeatherData3,dailyWeatherData4,dailyWeatherData5)


                    }

                }
            }
        )
    }
}

