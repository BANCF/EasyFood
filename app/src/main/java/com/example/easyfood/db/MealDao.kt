package com.example.easyfood.db

import androidx.lifecycle.LiveData
import com.example.easyfood.pojo.Meal
import androidx.room.*
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MealDao {
        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun upsert(meal:Meal)

        @Delete
        suspend fun delete(meal: Meal)

        @Query("SELECT  * FROM mealInformation" )
        fun getAllMeals() : LiveData<List<Meal>>



}