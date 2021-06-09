package ch.leytto.cynoclient.viewmodels
import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Breed
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.model.BreedRepository
import ch.leytto.cynoclient.model.DogRepository
import kotlinx.coroutines.launch

class BreedViewModel(private val repository: BreedRepository) : ViewModel() {

    val AllDogs: LiveData<List<Breed>> = repository.allDogs.asLiveData()

    fun insert(breed: Breed) = viewModelScope.launch {
        repository.insert(breed)
    }

}

