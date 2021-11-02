package dma.pwr.lab3.ui.middle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MiddleViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hello! It's left fragment"
    }
    val text: LiveData<String> = _text
}