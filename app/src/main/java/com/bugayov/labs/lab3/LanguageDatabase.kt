package com.bugayov.labs.lab3

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Language::class], version = 1)
abstract class LanguageDatabase : RoomDatabase() {

    abstract fun languageDao() : LanguageDao

    companion object {
        @Volatile
        private var INSTANCE: LanguageDatabase? = null

        fun getDatabase(context: Context): LanguageDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }
            return INSTANCE!!
        }

        private fun buildDatabase(context: Context): LanguageDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                LanguageDatabase::class.java,
                "languages_database"
            ).build()
        }
    }
}