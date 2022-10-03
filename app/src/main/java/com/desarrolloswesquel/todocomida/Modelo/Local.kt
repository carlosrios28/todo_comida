package com.desarrolloswesquel.todocomida.Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Local")
data class Local(
    @PrimaryKey(autoGenerate = true)
    val IdLocal: Int = 0,
    val NombreLocal: String,
    val Rubro: String,
    val DireccionLocal: String,
    val ImagenLocal: Int,
    val Latitud: Double,
    val Longitud: Double,
)


