package br.com.vipnetware.my1stcryptoapp.model

import com.google.gson.annotations.SerializedName

data class TransactionInfo(
    @SerializedName("hash") val hash: String,
    @SerializedName("size") val size: Int,
    @SerializedName("block_height") val blockHeight: Int
    )
