package br.com.vipnetware.my1stcryptoapp.repository

import br.com.vipnetware.my1stcryptoapp.model.AddressInfo
import br.com.vipnetware.my1stcryptoapp.model.BlockInfo
import br.com.vipnetware.my1stcryptoapp.model.TransactionInfo
import br.com.vipnetware.my1stcryptoapp.network.BitcoinApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class BTCRepository() {

    suspend fun  getLatestBlock(): BlockInfo = Api.getLatestBlock()

    suspend fun getBlockInfo(hash: String): BlockInfo {
        val blockInfo = Api.getBlock(hash)
        return blockInfo
    }

    suspend fun getAddressInfo(address: String): AddressInfo {
        val info = Api.getAddressInfo(address)
        return info
    }

    suspend fun  getTransactionInfo(tx: Long): TransactionInfo = Api.getTransactionInfo(tx)

    companion object {
        const val BASE_URL = "https://blockchain.info/"

        val Api = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BitcoinApiService::class.java)
    }
}