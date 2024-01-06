package com.kenanhaciyev.mylessonproject.fetures.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Notes(
    val id : Int,
    val title:String,
    val description:String):Parcelable{
}
