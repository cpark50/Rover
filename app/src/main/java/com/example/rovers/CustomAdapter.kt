import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rovers.Photos
import com.example.rovers.R
import com.example.rovers.databinding.CardItemBinding


val URL = "http://mars.jpl.nasa.gov/msl-raw-images/msss/01000/mcam/1000ML0044631200305217E01_DXXX.jpg"

class CustomAdapter() :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    private val photoList = mutableListOf<Photos.MarsPhoto>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // to inflate the layout for each item of recycler view.
        val layoutInflater = LayoutInflater.from(parent.context)

        return ViewHolder(CardItemBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // to set data to textview and imageview of each card layout
        holder.bind(photoList[position])
    }



    override fun getItemCount(): Int {
        // this method is used for showing number of card items in recycler view.
        return photoList.size
    }

    // View holder class for initializing of your views such as TextView and Imageview.
    class ViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root) {
       fun bind(item: Photos.MarsPhoto) {
           binding.item = item
       }
    }

    fun setData(data: List<Photos.MarsPhoto>?) {
        this.photoList.clear()
        data?.let{ this.photoList.addAll(it) }
        notifyDataSetChanged()
    }



}