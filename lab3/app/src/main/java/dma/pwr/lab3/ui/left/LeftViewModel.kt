package dma.pwr.lab3.ui.left

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LeftViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hello! It's middle fragment"
    }
    val text: LiveData<String> = _text
}