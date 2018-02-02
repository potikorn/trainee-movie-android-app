package com.example.potikorn.testcoopapp.television.holder

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.potikorn.testcoopapp.load
import com.example.potikorn.testcoopapp.models.CreditActor
import com.example.potikorn.testcoopapp.models.television.TelevisionType
import com.example.potikorn.testcoopapp.network.BaseUrl
import com.example.potikorn.testcoopapp.television.GenresTelevisionDetailActivity
import kotlinx.android.synthetic.main.credit_item.view.*
import kotlinx.android.synthetic.main.genres_item.view.*

class TelevisionViewHolderDetailActor(view: View) : RecyclerView.ViewHolder(view) {
companion object {
    const val KEY_GENRES = "GEN"
}

    fun onBind(actor: CreditActor) {
        itemView.apply {
//            genresName.text = television.type_name
//            setOnClickListener {
//                context.startActivity(Intent(context,GenresTelevisionDetailActivity::class.java).putExtra(KEY_GENRES,television.type_id))
//            }
            tvCreditName.text = actor.cast_nik_name
            ivCredit.load(BaseUrl.baseUrlImageMovie+actor.cast_pic)
        }
    }
}