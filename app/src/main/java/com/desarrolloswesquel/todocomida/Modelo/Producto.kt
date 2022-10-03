package com.desarrolloswesquel.todocomida.Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Producto")
data class Producto(
    @PrimaryKey(autoGenerate = true)
    val IdProducto: Int = 0,
    val Categoria: String,
    val Descripcion: String,
    val NombreProducto: String,
    val Precio: Int,
    val ImagenProducto: Int
)
