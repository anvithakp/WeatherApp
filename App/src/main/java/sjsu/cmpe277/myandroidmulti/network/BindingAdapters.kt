package sjsu.cmpe277.myandroidmulti.network

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import sjsu.cmpe277.myandroidmulti.R

@BindingAdapter("app:imageUrl")
fun bindImage(imgView: ImageView, icon: String?) {
    icon?.let {
        val imgUrl = "https://openweathermap.org/img/wn/$icon@2x.png"
        val imgUri = imgUrl.toUri()

        Glide.with(imgView.context)
            .load(imgUri)
            .apply(
                RequestOptions()
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_boken_image))
            .into(imgView)
    }
}