package com.example.potikorn.testcoopapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
data class Image(@SerializedName("file_path") val file_path: String) : Parcelable {
    constructor(parcel: android.os.Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeString(file_path)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Image> {
        override fun createFromParcel(parcel: android.os.Parcel): Image = Image(parcel)

        override fun newArray(size: Int): Array<Image?> = arrayOfNulls(size)
    }
}

@Parcel
data class Poster(@SerializedName("file_path") val file_path: String) : Parcelable {
    constructor(parcel: android.os.Parcel) : this(parcel.readString()) {
    }

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeString(file_path)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Poster> {
        override fun createFromParcel(parcel: android.os.Parcel): Poster {
            return Poster(parcel)
        }

        override fun newArray(size: Int): Array<Poster?> {
            return arrayOfNulls(size)
        }
    }
}

@Parcel
data class MovieImageList(@SerializedName("backdrops") val backdrops: List<Image>
                          , @SerializedName("posters") val poster: List<Poster>)