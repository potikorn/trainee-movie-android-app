package com.example.potikorn.testcoopapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
data class Television(@SerializedName("id") val id: String, @SerializedName("name") val name: String
                      , @SerializedName("backdrop_path") val backdrop_path: String, @SerializedName("poster_path") val poster_path: String
                      , @SerializedName("overview") val overview: String
                      , @SerializedName("vote_average") val vote_average: String) : Parcelable {
    constructor(parcel: android.os.Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.apply {
            writeString(id)
            writeString(name)
            writeString(backdrop_path)
            writeString(poster_path)
            writeString(overview)
            writeString(vote_average)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Television> {
        override fun createFromParcel(parcel: android.os.Parcel): Television = Television(parcel)
        override fun newArray(size: Int): Array<Television?> = arrayOfNulls(size)
    }
}

@Parcel
data class TelevisionList(@SerializedName("results") var results: List<Television>? = null)