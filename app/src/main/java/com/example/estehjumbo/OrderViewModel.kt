package com.example.estehjumbo

import androidx.lifecycle.ViewModel
import com.example.estehjumbo.data.OrderUIState
//import com.example.estehjumbo.data.harga
//import com.example.estehjumbo.data.rasa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.text.NumberFormat

private const val HARGA_PER_CUP = 3000
class OrderViewModel : ViewModel(){
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI:StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setJumlah(jmlESTEHJUMBO:Int){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                jumlah = jmlESTEHJUMBO,
                harga = hitungHarga(jumlah = jmlESTEHJUMBO)
            )
        }
    }
    fun setRasa(rasaPilihan: String){
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(rasa = rasaPilihan)
        }
    }
    fun  resetOrder(){
        _stateUI.value = OrderUIState()
    }
    private fun hitungHarga(
        jumlah : Int =_stateUI.value.jumlah,
    ): String{
        val kalkulasiHarga = jumlah * HARGA_PER_CUP

        return NumberFormat.getNumberInstance().format(kalkulasiHarga)
    }

}