package com.example.easyfood.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.easyfood.pojo.Meal

@Database(entities = [Meal::class], version = 1)
@TypeConverters(MealTypeConvertor::class)
abstract class MealDatabase : RoomDatabase(){
    abstract fun mealDao():MealDao
    companion object{
        @Volatile
        var INSTANCE :MealDatabase? = null

        fun getdatabase(contex:Context):MealDatabase{
            var tempInstace = INSTANCE
            if (tempInstace != null)
            {
                return tempInstace
            }
            synchronized(this)
            {
                var instance  = Room.databaseBuilder(
                    contex.applicationContext,
                    MealDatabase::class.java,
                    "meal.db"
                ).build()

                INSTANCE = instance
                return instance

            }

        }

    }
}
