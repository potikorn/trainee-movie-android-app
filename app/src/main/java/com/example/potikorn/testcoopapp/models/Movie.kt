package com.example.potikorn.testcoopapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
data class Movie(@SerializedName("vote_average") val vote_average: String? = null
                 , @SerializedName("title") val title: String? = null
                 , @SerializedName("poster_path") val poster: String? = null
                 , @SerializedName("backdrop_path") val backdrop: String? = null
                 , @SerializedName("overview") val overview: String? = null
                 , @SerializedName("release_date") val release_date: String? = null) : Parcelable {
    constructor(parcel: android.os.Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeString(vote_average)
        parcel.writeString(title)
        parcel.writeString(poster)
        parcel.writeString(backdrop)
        parcel.writeString(overview)
        parcel.writeString(release_date)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: android.os.Parcel): Movie {
            return Movie(parcel)
        }

        override fun newArray(size: Int): Array<Movie?> {
            return arrayOfNulls(size)
        }
    }
}

@Parcel
data class MovieList(@SerializedName("results") var results: ArrayList<Movie>? = null)