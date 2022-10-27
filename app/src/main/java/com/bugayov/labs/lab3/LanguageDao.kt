package com.bugayov.labs.lab3

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface LanguageDao {
    @Insert
    fun insert(language: Language)

    @Query("DELETE FROM languages")
    fun clearTable()

    @Query("SELECT * FROM languages")
    fun getAllLanguages() : Flow<List<Language>>

    @Query("SELECT count(*) FROM languages")
    fun getCount() : Int
}