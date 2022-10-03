package com.desarrolloswesquel.todocomida.Modelo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacto")
data class Contacto(
    @PrimaryKey(autoGenerate = true)
    val IdContacto: Int = 0,
    val IDLocal: Int,
    val Telefono: String,
    val linkWhatsapp: String,
    val linkFacebook: String,
    val linkInstagram: String
)
