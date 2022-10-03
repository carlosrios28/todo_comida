package com.desarrolloswesquel.todocomida.Modelo

import androidx.room.Entity

@Entity(tableName = "CategoriaProducto")
data class CategoriaProducto (
    val IdCategoria: Int,
    val IdProducto: Int
)