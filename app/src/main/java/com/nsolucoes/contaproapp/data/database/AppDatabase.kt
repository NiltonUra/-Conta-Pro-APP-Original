package com.nsolucoes.contaproapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nsolucoes.contaproapp.data.database.entities.Despesa
import com.nsolucoes.contaproapp.data.database.entities.Receita
import com.nsolucoes.contaproapp.data.database.entities.Usuario

@Database(
    entities = [Usuario::class, Despesa::class, Receita::class],
    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): MainDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        //verificar se existe ou não instância
        fun getDatabase(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}