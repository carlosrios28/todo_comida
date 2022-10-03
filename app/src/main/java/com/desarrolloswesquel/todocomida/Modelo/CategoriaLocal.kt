package com.desarrolloswesquel.todocomida.Modelo

import androidx.room.Entity

@Entity(tableName = "CategoriaLocal")
data class CategoriaLocal(
    val IdCategoria: Int,
    val IdLocal: Int
)
