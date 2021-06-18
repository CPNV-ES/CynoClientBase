package ch.leytto.cynoclient

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ch.leytto.cynoclient.db.entities.Breed

class BreedListAdapter : ListAdapter<Breed, BreedListAdapter.BreedViewHolder>(BreedsComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedViewHolder {
        return BreedViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: BreedViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameItemView: TextView = itemView.findViewById(R.id.name)

        /*
        * Bind noun to view list (RecyclerView)
        * @param Breed object
        * */
        fun bind(breed: Breed?) {
            nameItemView.text = breed?.noun
        }

        companion object {
            fun create(parent: ViewGroup): BreedViewHolder {
                val view: View = LayoutInflater.from(parent.context).inflate(R.layout.dog_adapter, parent, false)
                return BreedViewHolder(view)
            }
        }
    }

    class BreedsComparator : DiffUtil.ItemCallback<Breed>() {
        override fun areItemsTheSame(oldItem: Breed, newItem: Breed): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Breed, newItem: Breed): Boolean {
            return oldItem.id == newItem.id
        }
    }
}