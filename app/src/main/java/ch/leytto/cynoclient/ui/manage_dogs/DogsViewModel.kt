package ch.leytto.cynoclient.ui.manage_dogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import ch.leytto.cynoclient.viewmodels.DogViewModel
import ch.leytto.cynoclient.viewmodels.ViewModelFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class DogsViewModel : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "This is Dogs Fragment"
    }
    val text: LiveData<String> = _text


}

