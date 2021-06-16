package ch.leytto.cynoclient.viewmodels
import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Breed
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.model.BreedRepository
import ch.leytto.cynoclient.model.DogRepository
import kotlinx.coroutines.launch

class BreedViewModel(private val repository: BreedRepository) : ViewModel() {

    //List all breeds in database
    val AllBreeds: LiveData<List<Breed>> = repository.allBreeds.asLiveData()


    /*
    *
    * Insert a new breed in the database
    *
    * @param breed Breed object to add in database
    * */
    fun insert(breed: Breed) = viewModelScope.launch {
        repository.insert(breed)
    }

}

