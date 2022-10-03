package com.desarrolloswesquel.todocomida.Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Categoria")
data class Categoria(

    val NombreCategoria: String,
    @PrimaryKey(autoGenerate = true)
    val IDCategoria: Int = 0,
    val ImagenCategoria: Int
)
