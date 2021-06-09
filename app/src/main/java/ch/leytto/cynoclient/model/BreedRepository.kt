package ch.leytto.cynoclient.model

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import ch.leytto.cynoclient.db.dao.BreedDao
import ch.leytto.cynoclient.db.entities.Breed
import kotlinx.coroutines.flow.Flow

class BreedRepository(private val dogDao: BreedDao) : AbstractRepository() {

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allDogs: Flow<List<Breed>> = dogDao.getBreeds()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(breed: Breed) {
        dogDao.insert(breed)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(breed: Breed)
    {
        dogDao.deleteBreed(breed);
    }
}