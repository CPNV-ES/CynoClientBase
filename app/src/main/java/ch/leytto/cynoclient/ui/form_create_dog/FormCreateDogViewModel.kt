package ch.leytto.cynoclient.ui.form_create_dog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormCreateDogViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is New Dog"
    }
    val text: LiveData<String> = _text
}