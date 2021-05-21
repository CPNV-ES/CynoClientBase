package ch.leytto.cynoclient.ui.home

import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Dog
import ch.leytto.cynoclient.model.DogRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel (private val repository: DogRepository) : ViewModel() {

    val AllDogs: LiveData<List<Dog>> = repository.allDogs.asLiveData()
}

class HomeViewModelFactory(private val repository: DogRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}