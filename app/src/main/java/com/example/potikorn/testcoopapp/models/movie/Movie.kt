package com.example.potikorn.testcoopapp.models.movie

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel //TODO upcoming , now play data , pop data ,top rate
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
        parcel.apply {
            writeString(vote_average)
            writeString(title)
            writeString(poster)
            writeString(backdrop)
            writeString(overview)
            writeString(release_date)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Movie> {
        override fun createFromParcel(parcel: android.os.Parcel): Movie = Movie(parcel)
        override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
    }
}

@Parcel
data class MovieList(@SerializedName("results") var results: List<Movie>? = null
                     , @SerializedName("page") val page: String? = null
                     , @SerializedName("total_pages") var total_pages: String? = null)

@Parcel
data class MovieType(@SerializedName("id") val type_id: String, @SerializedName("name") val type_name: String)

@Parcel
data class MovieTypeList(@SerializedName("genres") var type: List<MovieType>)

@Parcel
data class MovieVideoPath(@SerializedName("key") val key: String, @SerializedName("name") val name: String)

@Parcel
data class MovieVideoPathList(@SerializedName("results") val results: List<MovieVideoPath>)