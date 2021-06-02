package ch.leytto.cynoclient.ui.manage_dogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DogsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Dogs Fragment"
    }
    val text: LiveData<String> = _text
}