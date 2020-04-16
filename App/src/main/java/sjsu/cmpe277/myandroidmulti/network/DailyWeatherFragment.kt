package sjsu.cmpe277.myandroidmulti.network

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import sjsu.cmpe277.myandroidmulti.network.WeatherFragment.Companion.TAG
import sjsu.cmpe277.myandroidmulti.R
import sjsu.cmpe277.myandroidmulti.databinding.DailyWeatherRecyclerBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//private const val ARG_PARAM1 = "param1"
//private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [DailyWeatherFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [DailyWeatherFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DailyWeatherFragment : Fragment() {

    private lateinit var viewModel: DailyWeatherViewModel
    private lateinit var binding: DailyWeatherRecyclerBinding
    private lateinit var city: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("$TAG - onCreate")
        arguments?.let {
            city = DailyWeatherFragmentArgs.fromBundle(arguments!!).cityName
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        println("$TAG - onCreateView")

        binding =
            DataBindingUtil.inflate(inflater, R.layout.daily_weather_recycler, container, false)

        val application = requireNotNull(this.activity).application

        viewModel = ViewModelProviders.of(this).get(DailyWeatherViewModel::class.java)
        if (city != null)
            viewModel.getDailyWeatherProperties(city)

        val adapter = DailyWeatherAdapter()
        binding.recyclerView.adapter = adapter



        viewModel._finallist.observe(viewLifecycleOwner, Observer { response ->
            adapter.submitList(response)

        })

        return binding.root
//        viewModel._finallist.forEach(Iterable<MutableIterator>(viewLifecycleOwner, Observer { newresponse ->
//            adapter.submitList(newresponse) //display the raw json data
//        })

    }
}







//private fun <E> List<E>.forEach(action: (E) -> Unit) {
//
//}

//        viewModel._finallist.forEach.(viewLifecycleOwner,  Observer { newresponse ->  {
//
//        adapter.submitList(newresponse)
//        }
//        //adapter.submitList(newresponse.toString()) //display the raw json data
//
//
//    }
//
//    }
      //viewModel._response.observe(viewLifecycleOwner, Observer { newresponse ->
                //            binding.weathertextView.text = newresponse.toString() //display the raw json data
                //        })

                //it?.let {
                //            adapter.submitList(it)
//        private fun setupRecyclerView() {
//                var recycler_view = binding.recyclerView
//                var layoutManager = LinearLayoutManager(context)
//
//            recycler_view.setLayoutManager(layoutManager)
//            recycler_view.layoutManager = layoutManager
//
//            var adapter = DailyWeatherAdapter()
//            recycler_view.adapter = adapter
//
//
//            }









            //  viewModel = ViewModelProviders.of(this).get(DailyWeatherViewModel::class.java)

//        viewModel._response.observe(viewLifecycleOwner,  Observer { newresponse ->
//            binding.sjweathertext.text = newresponse.toString() //display the raw json data
//
//        }
//
//
//        )

//        viewModel._index1Response.observe(viewLifecycleOwner,  Observer { newresponse ->
//            binding.index01.text = newresponse.toString() //display the raw json data
//        }
//        )
//        viewModel._index2Response.observe(viewLifecycleOwner,  Observer { newresponse ->
//            binding.index02.text = newresponse.toString() //display the raw json data
//        }
//        )
//        viewModel._index3Response.observe(viewLifecycleOwner,  Observer { newresponse ->
//            binding.index03.text = newresponse.toString() //display the raw json data
//        }
//        )
//        viewModel._index4Response.observe(viewLifecycleOwner,  Observer { newresponse ->
//            binding.index04.text = newresponse.toString() //display the raw json data
//        }
//        )
//        viewModel._index5Response.observe(viewLifecycleOwner,  Observer { newresponse ->
//            binding.index05.text = newresponse.toString() //display the raw json data
//        }
//        )
//
//
//
//        return binding.root

//    }





    // TODO: Rename method, update argument and hook method into UI event
//    fun onButtonPressed(uri: Uri) {
//        println("$TAG - onButtonPressed")
//
//        listener?.onFragmentInteraction(uri)
//    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        if (context is OnFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
//        }
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//        listener = null
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
//    interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onFragmentInteraction(uri: Uri)
//    }

//    companion object {
//
//        const val TAG = "DailyWeatherFragment"
//
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @param param1 Parameter 1.
//         * @param param2 Parameter 2.
//         * @return A new instance of fragment dailyWeatherFragment.
//         */
//        // TODO: Rename and change types and number of parameters
////        @JvmStatic
////        fun newInstance(param1: String, param2: String) =
////            DailyWeatherFragment().apply {
////                arguments = Bundle().apply {
////                    putString(ARG_PARAM1, param1)
////                    putString(ARG_PARAM2, param2)
////                }
////            }
//    }
//}


