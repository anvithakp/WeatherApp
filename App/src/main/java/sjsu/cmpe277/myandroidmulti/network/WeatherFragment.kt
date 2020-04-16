package sjsu.cmpe277.myandroidmulti.network

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.google.android.gms.location.*
import sjsu.cmpe277.myandroidmulti.R
import sjsu.cmpe277.myandroidmulti.databinding.WeatherFragmentBinding
import java.lang.Exception

class WeatherFragment : Fragment() {

    companion object {
//        fun newInstance() = WeatherFragment()
        const val TAG = "WeatherFragment"

    }

    private lateinit var viewModel: WeatherViewModel

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("${TAG} - onButtonPressed")

        val binding = DataBindingUtil.inflate<WeatherFragmentBinding>(inflater, R.layout.weather_fragment,container,false)

        binding.buttonDaily.setOnClickListener { view: View ->
            var city = viewModel.cityName.value ?: "San Jose"
            val actionWeatherFragmentToDailyWeatherFragment =
                WeatherFragmentDirections.actionWeatherFragmentToDailyWeatherFragment(city)
            Navigation.findNavController(view).navigate(actionWeatherFragmentToDailyWeatherFragment)

        }


        //viewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)
        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        binding.button3.setOnClickListener { view ->
            var city = binding.editText.text
            Log.d(TAG, "Button Clicked ${city}")
            viewModel.getCityLocation(city.toString().trim())
        }


        viewModel.cityName.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.cityName.text = newresponse?.toString() //display the raw json data
        })

        viewModel.temperature.observe(viewLifecycleOwner, Observer { newresponse ->
            binding.temperature.text = newresponse
        })

        viewModel.icon.observe(viewLifecycleOwner, Observer { newresponse ->
            bindImage(binding.imageView, newresponse)
        })




        return binding.root//inflater.inflate(R.layout.weather_fragment, container, true)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        println("${TAG} - onActivityCreated")

        viewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        if (activity != null) {
            fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity!!.applicationContext)



            fusedLocationProviderClient.lastLocation
                .addOnSuccessListener { location : Location? ->
                    Log.d(TAG, "Location obtained lat ${location?.latitude}")
                    Log.d(TAG, "Location obtained lng ${location?.longitude}")

                    location?.let { viewModel.getCurrentLocation(it) }
                }
                .addOnFailureListener { e : Exception -> Log.e(TAG , "exception ${e.message}") }
        }

        // TODO: Use the ViewModel
    }

}
