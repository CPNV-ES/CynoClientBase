package ch.leytto.cynoclient.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import ch.leytto.cynoclient.db.entities.Breed
import kotlinx.coroutines.flow.Flow

@Dao
interface BreedDao {

    @Query("SELECT * FROM breeds")
    fun getBreeds(): Flow<List<Breed>>

    @Query("SELECT * FROM dogs WHERE id = :id")
    suspend fun getBreed(id: Int): Breed

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(dog: Breed)

    @Update
    suspend fun updateBreed(vararg breeds: Breed)

    @Delete
    suspend fun deleteBreed(vararg breeds: Breed)
}