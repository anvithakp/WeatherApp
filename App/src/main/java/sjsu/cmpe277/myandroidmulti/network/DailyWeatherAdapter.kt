package sjsu.cmpe277.myandroidmulti.network

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import sjsu.cmpe277.myandroidmulti.databinding.FragmentDailyWeatherBinding



class DailyWeatherAdapter :
    ListAdapter<DailyWeatherData, DailyWeatherAdapter.DailyWeatherHolder>(
        DailyWeatherDiffCallback()
    ) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyWeatherHolder {
        return DailyWeatherHolder.from(parent)
    }

    override fun onBindViewHolder(holder: DailyWeatherHolder, position: Int) {

        var dailyWeatherData= getItem(position)

        holder.bind(dailyWeatherData)

    }

    class DailyWeatherHolder private constructor(val binding: FragmentDailyWeatherBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dailyWeatherData: DailyWeatherData?) {
            binding.dailyweather = dailyWeatherData
            binding.textView1.text = dailyWeatherData?.city
            binding.textView2.text = dailyWeatherData?.date?.substring(0,17)
            binding.textView3.text = dailyWeatherData?.main
            binding.textView4.text = dailyWeatherData?.temparature + " F"
            binding.executePendingBindings()

        }

        companion object {
            fun from(parent: ViewGroup): DailyWeatherHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FragmentDailyWeatherBinding.inflate(layoutInflater, parent, false)
               // binding.textView.text =
                return DailyWeatherHolder(binding)
            }
        }

    }


}

class DailyWeatherDiffCallback : DiffUtil.ItemCallback<DailyWeatherData>() {
    override fun areItemsTheSame(
        oldItem: DailyWeatherData,
        newItem: DailyWeatherData
    ): Boolean {
        return oldItem.main == newItem.main && oldItem.temparature == newItem.temparature
    }

    override fun areContentsTheSame(
        oldItem: DailyWeatherData,
        newItem: DailyWeatherData
    ): Boolean {
        return oldItem == newItem
    }
}


