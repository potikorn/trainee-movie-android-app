package com.example.potikorn.testcoopapp.models

import com.google.gson.annotations.SerializedName

data class YouVidData(@SerializedName("snippet") val listData: Snippet
                      , @SerializedName("id") val id: EyeDee)

data class Snippet(@SerializedName("title") val title: String?)

data class EyeDee(@SerializedName("videoId") val videoId: String?)

data class VidListFOF(@SerializedName("items") val results: ArrayList<YouVidData>)