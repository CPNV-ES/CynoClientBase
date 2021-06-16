package ch.leytto.cynoclient.viewmodels
import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.model.DogRepository
import kotlinx.coroutines.launch

class DogViewModel(private val repository: DogRepository) : ViewModel() {

    //Lists all dogs in the database
    val AllDogs: LiveData<List<Dog>> = repository.allDogs.asLiveData()


    /*
    *
    * Insert a new dog in the database
    *
    * @param dog Dog object to add in database
    * */
    fun insert(dog: Dog) = viewModelScope.launch {
        repository.insert(dog)
    }

}

