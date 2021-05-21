package ch.leytto.cynoclient.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ch.leytto.cynoclient.model.AbstractRepository
import ch.leytto.cynoclient.model.DogRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: DogRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DogViewModel(repository as DogRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}