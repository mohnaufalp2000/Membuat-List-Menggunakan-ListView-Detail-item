package com.example.rakuzangakuen.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Player(
    var name : String = "",
    var number : String = "",
    var detail : String = "",
    var img : Int = 0
) : Parcelable