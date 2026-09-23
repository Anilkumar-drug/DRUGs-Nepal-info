package com.example.data.repository

import com.example.data.local.dao.SavedItemDao
import com.example.data.local.entity.SavedItemEntity
import kotlinx.coroutines.flow.Flow

class SavedItemRepository(private val dao: SavedItemDao) {

    val allSavedItems: Flow<List<SavedItemEntity>> = dao.getAllSavedItems()

    suspend fun saveItem(item: SavedItemEntity) {
        dao.insertSavedItem(item)
    }

    suspend fun removeItem(id: String) {
        dao.deleteSavedItemById(id)
    }

    suspend fun removeByTarget(targetId: String, itemType: String) {
        dao.deleteByTargetIdAndType(targetId, itemType)
    }

    suspend fun toggleSave(
        id: String,
        itemType: String,
        targetId: String,
        title: String,
        subtitle: String,
        category: String,
        extraInfo: String = ""
    ): Boolean {
        val existing = dao.getSavedItem(targetId, itemType)
        return if (existing != null) {
            dao.deleteSavedItemById(existing.id)
            false
        } else {
            dao.insertSavedItem(
                SavedItemEntity(
                    id = id,
                    itemType = itemType,
                    targetId = targetId,
                    title = title,
                    subtitle = subtitle,
                    category = category,
                    extraInfo = extraInfo,
                    timestamp = System.currentTimeMillis()
                )
            )
            true
        }
    }

    suspend fun clearAll() {
        dao.clearAll()
    }
}
