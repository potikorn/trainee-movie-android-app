package com.example.potikorn.testcoopapp.movies.adapter
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.potikorn.testcoopapp.R

class MyRecyclerViewAdapterButton (context: Context, animals: List<String>) : RecyclerView.Adapter<MyRecyclerViewAdapterButton.ViewHolder>() {
    private var mAnimals = emptyList<String>()
    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mClickListener: ItemClickListener? = null
    init { this.mAnimals = animals }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val animal = mAnimals[position]
        holder.myTextView.text = animal
    }

    override fun getItemCount(): Int = mAnimals.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var myTextView:TextView = itemView.findViewById(R.id.tvAnimalName)

        init { itemView.setOnClickListener(this) }

        override fun onClick(view: View) { if (mClickListener != null) mClickListener?.onItemClick(view, adapterPosition) } }

    fun setClickListener(itemClickListener: ItemClickListener) {
        this.mClickListener = itemClickListener }

    interface ItemClickListener {
        fun onItemClick(view: View, position: Int) }
}