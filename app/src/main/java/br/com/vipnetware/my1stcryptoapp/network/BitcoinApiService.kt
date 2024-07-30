package br.com.vipnetware.my1stcryptoapp.network

import br.com.vipnetware.my1stcryptoapp.model.AddressInfo
import br.com.vipnetware.my1stcryptoapp.model.BlockInfo
import br.com.vipnetware.my1stcryptoapp.model.TransactionInfo
import retrofit2.http.GET
import retrofit2.http.Path

interface BitcoinApiService {
//    @GET("rawaddr/{address}")
//    suspend fun getAddressInfo(@Path("address") address: String): AddressInfo

    @GET("latestblock")
    suspend fun getLatestBlock(): BlockInfo

    @GET("rawblock/{block_Hash}")
    suspend fun getBlock(@Path("block_hash") blockHash: String): BlockInfo

    @GET("rawtx/{tx_info}")
    suspend fun getTransactionInfo(@Path("tx_info") txInfo: Long): TransactionInfo

    @GET("rawaddr/{address}")
    suspend fun getAddressInfo(@Path("address") address: String): AddressInfo
}