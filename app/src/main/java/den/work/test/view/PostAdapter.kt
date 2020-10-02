package den.work.test.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import den.work.test.R
import den.work.test.model.Post
import kotlinx.android.synthetic.main.item_post.view.*

class PostAdapter(private val items           : ArrayList<Post>) :
    RecyclerView.Adapter<PostAdapter.AdapterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : AdapterViewHolder =
        AdapterViewHolder(LayoutInflater.from(parent.context),parent)

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.bind(items[position], position == 0)
    }

    override fun getItemCount(): Int = items.size

    fun onScreenChange(){
        notifyDataSetChanged()
    }

    class AdapterViewHolder(inflater : LayoutInflater, parent : ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_post, parent, false)) {

        fun bind(item : Post, hideLine : Boolean) {
            itemView.tvPostTitle.text = item.getTitle()
            itemView.tvPostText.text = item.getBody()
            itemView.llPostLine.visibility = if (hideLine) View.GONE else View.VISIBLE
        }
    }

}