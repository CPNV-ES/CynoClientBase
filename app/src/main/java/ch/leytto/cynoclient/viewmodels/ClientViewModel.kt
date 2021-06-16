package ch.leytto.cynoclient.viewmodels

import androidx.lifecycle.*
import ch.leytto.cynoclient.db.entities.Client
import ch.leytto.cynoclient.model.ClientRepository
import kotlinx.coroutines.launch

class ClientViewModel(private val repository: ClientRepository) : ViewModel() {

    //lists all clients in database
    val AllClients: LiveData<List<Client>> = repository.allClients.asLiveData()

    /*
    *
    * Insert a new client in the database
    *
    * @param client Client object to add in database
    * */
    fun insert(client: Client) = viewModelScope.launch {
        repository.insert(client)
    }

}