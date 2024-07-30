package br.com.vipnetware.my1stcryptoapp.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.vipnetware.my1stcryptoapp.model.AddressInfo
import br.com.vipnetware.my1stcryptoapp.model.BlockInfo
import br.com.vipnetware.my1stcryptoapp.model.TransactionInfo
import br.com.vipnetware.my1stcryptoapp.repository.BTCRepository
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class MainScreenViewModel : ViewModel() {
    private val repository = BTCRepository()

    private val _blockInfo = MutableLiveData<BlockInfo>()
    val blockInfo: LiveData<BlockInfo>
        get() = _blockInfo

    private val _addressInfo = MutableLiveData<AddressInfo>()
    val addressInfo: LiveData<AddressInfo>
        get() = _addressInfo

    private val _lastHash = MutableLiveData<String>()
    val lastHash: LiveData<String>
        get() = _lastHash

    private val _txInfo = MutableLiveData<TransactionInfo>()
    val txInfo: LiveData<TransactionInfo>
        get() = _txInfo

    val error = MutableLiveData<String>()

    fun getLastBlock() {
        viewModelScope.launch {
            try {
                val block = repository.getLatestBlock()
                _blockInfo.value = block
                val time = block.time * 1000
                val date = Date(time)
                val sdf = SimpleDateFormat("dd/MM/yyyy hh:mm")
                sdf.format(date)
                getTxInfo(block.txIndexes.get(0))
                val size = _txInfo.value?.size
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }

    fun getTxInfo(tx: Long) {
        viewModelScope.launch {
            try {
                val info = repository.getTransactionInfo(tx)
                _txInfo.value = info
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }

//    fun getLastBlock() {
//        viewModelScope.launch {
//            val hash = repository.getLatestBlockHash()
//            _blockInfo.value = repository.getBlockInfo(hash)
//        }
//    }

    fun getAddrInfo(addr: String) {
        viewModelScope.launch {
            try {
                val response = repository.getAddressInfo(addr)
                _addressInfo.postValue(response)
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }
}