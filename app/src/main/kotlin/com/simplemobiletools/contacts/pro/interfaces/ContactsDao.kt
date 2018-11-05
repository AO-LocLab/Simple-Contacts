package com.simplemobiletools.contacts.pro.interfaces

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.simplemobiletools.contacts.pro.models.LocalContact

@Dao
interface ContactsDao {
    @Query("SELECT * FROM contacts")
    fun getContacts(): List<LocalContact>

    @Query("SELECT * FROM contacts WHERE id = :id")
    fun getContactWithId(id: Int): LocalContact

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdate(contact: LocalContact): Long

    @Query("DELETE FROM contacts WHERE id IN (:ids)")
    fun deleteContactIds(ids: String)
}
