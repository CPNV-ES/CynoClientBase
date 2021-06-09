package ch.leytto.cynoclient.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ch.leytto.cynoclient.model.AbstractRepository
import ch.leytto.cynoclient.model.BreedRepository
import ch.leytto.cynoclient.model.DogRepository
import java.lang.IllegalArgumentException

class ViewModelFactory(private val repository: AbstractRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DogViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DogViewModel(repository as DogRepository) as T
        }
        if(modelClass.isAssignableFrom(BreedViewModel::class.java))
        {
            @Suppress("UNCHECKED_CAST")
            return BreedViewModel(repository as BreedRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}