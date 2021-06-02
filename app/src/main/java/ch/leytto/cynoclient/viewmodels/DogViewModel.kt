package ch.leytto.cynoclient.viewmodels
import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.model.DogRepository
import kotlinx.coroutines.launch

class DogViewModel(private val repository: DogRepository) : ViewModel() {

    val AllDogs: List<Dog> = repository.allDogs

   /* fun insert(dog: Dog) = viewModelScope.launch {
        repository.insert(dog)
    }*/

}

