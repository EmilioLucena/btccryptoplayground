package br.com.vipnetware.my1stcryptoapp.model

import com.google.gson.annotations.SerializedName

data class AddressInfo(
    @SerializedName("address") val address: String,
    @SerializedName("total_received") val totalReceived: Long,
    @SerializedName("total_sent") val totalSent: Long,
    @SerializedName("final_balance") val finalBalance: Long,
)
