package br.com.vipnetware.my1stcryptoapp.model

import com.google.gson.annotations.SerializedName

data class BlockInfo(
    @SerializedName("hash") val hash: String,
    @SerializedName("time") val time: Long,
    @SerializedName("height") val blockHeight: Int,
    @SerializedName("txIndexes") val txIndexes: List<Long>
)
