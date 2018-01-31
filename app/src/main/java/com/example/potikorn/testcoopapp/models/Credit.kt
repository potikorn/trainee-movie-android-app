package com.example.potikorn.testcoopapp.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import org.parceler.Parcel

@Parcel
data class CreditActor(@SerializedName("cast_id") val cast_id: String
                       , @SerializedName("character") val cast_nik_name: String
                       , @SerializedName("id") val id: String
                       , @SerializedName("name") val cast_full_name: String
                       , @SerializedName("profile_path") val cast_pic: String) : Parcelable {
    constructor(parcel: android.os.Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.apply {
            writeString(cast_id)
            writeString(cast_nik_name)
            writeString(id)
            writeString(cast_full_name)
            writeString(cast_pic)
        }
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CreditActor> {
        override fun createFromParcel(parcel: android.os.Parcel): CreditActor = CreditActor(parcel)

        override fun newArray(size: Int): Array<CreditActor?> = arrayOfNulls(size)
    }
}

@Parcel
data class Crew(@SerializedName("job") val job: String, @SerializedName("name") val name: String
                , @SerializedName("profile_path") val profile_path: String) : Parcelable {
    constructor(parcel: android.os.Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: android.os.Parcel, flags: Int) {
        parcel.writeString(job)
        parcel.writeString(name)
        parcel.writeString(profile_path)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Crew> {
        override fun createFromParcel(parcel: android.os.Parcel): Crew {
            return Crew(parcel)
        }

        override fun newArray(size: Int): Array<Crew?> {
            return arrayOfNulls(size)
        }
    }
}

@Parcel
data class CreditList(@SerializedName("cast") val cast_data: List<CreditActor>
                    ,@SerializedName("crew") val crew_data: List<Crew>)