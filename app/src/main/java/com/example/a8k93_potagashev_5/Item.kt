package com.example.a8k93_potagashev_5

import android.os.Parcel
import android.os.Parcelable


class Item() : Parcelable {

    // Тип
    var kind: String = ""
    // Название
    var title: String = ""
    // Стоимость
    var price: Double = 0.0
    // Сводная информация
    var weight: Double = 0.0
    // Сводная информация
    val info: String
        get() = "$kind $title ($price ₽) $weight"

    constructor(parcel: Parcel) : this() {
        kind = parcel.readString() ?: ""
        title = parcel.readString() ?: ""
        price = parcel.readDouble()
        weight = parcel.readDouble()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(kind)
        parcel.writeString(title)
        parcel.writeDouble(price)
        parcel.writeDouble(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Item> {
        override fun createFromParcel(parcel: Parcel): Item {
            return Item(parcel)
        }

        override fun newArray(size: Int): Array<Item?> {
            return arrayOfNulls(size)
        }
    }
}
