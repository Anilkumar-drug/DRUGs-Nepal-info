package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.local.entity.SavedItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SavedItemDao {
    @Query("SELECT * FROM saved_items ORDER BY timestamp DESC")
    fun getAllSavedItems(): Flow<List<SavedItemEntity>>

    @Query("SELECT * FROM saved_items WHERE itemType = :type ORDER BY timestamp DESC")
    fun getSavedItemsByType(type: String): Flow<List<SavedItemEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSavedItem(item: SavedItemEntity)

    @Query("DELETE FROM saved_items WHERE id = :id")
    suspend fun deleteSavedItemById(id: String)

    @Query("DELETE FROM saved_items WHERE targetId = :targetId AND itemType = :type")
    suspend fun deleteByTargetIdAndType(targetId: String, type: String)

    @Query("SELECT EXISTS(SELECT 1 FROM saved_items WHERE id = :id)")
    fun isItemSaved(id: String): Flow<Boolean>

    @Query("SELECT * FROM saved_items WHERE targetId = :targetId AND itemType = :type LIMIT 1")
    suspend fun getSavedItem(targetId: String, type: String): SavedItemEntity?

    @Query("DELETE FROM saved_items")
    suspend fun clearAll()
}
