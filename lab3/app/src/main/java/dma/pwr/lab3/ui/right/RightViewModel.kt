package dma.pwr.lab3.ui.right

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RightViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hello! It's right fragment"
    }
    val text: LiveData<String> = _text
}