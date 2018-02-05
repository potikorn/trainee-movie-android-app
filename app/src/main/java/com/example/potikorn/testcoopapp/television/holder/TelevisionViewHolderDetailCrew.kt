package com.example.potikorn.testcoopapp.television.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.Crew
import com.example.potikorn.testcoopapp.network.BaseUrl
import kotlinx.android.synthetic.main.credit_item.view.*

class TelevisionViewHolderDetailCrew(view: View) : RecyclerView.ViewHolder(view) {
    companion object {
        const val KEY_GENRES = "GEN"
    }

    fun onBind(crew: Crew) {
        itemView.apply {
            //            genresName.text = television.type_name
//            setOnClickListener {
//                context.startActivity(Intent(context,GenresTelevisionDetailActivity::class.java).putExtra(KEY_GENRES,television.type_id))
//            }
            tvCreditName.text = crew.name
            ivCredit.load(BaseUrl.baseUrlImageMovie + crew.profile_path)
        }
    }
}