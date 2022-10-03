package com.desarrolloswesquel.todocomida.controladores

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.desarrolloswesquel.todocomida.Controlador.ControladorCategoria
import com.desarrolloswesquel.todocomida.Modelo.Categoria
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarCategoria
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.databinding.LoginActivityBinding


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        findViewById<Button>(R.id.IngresarEmail).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        val CCategoria = ControladorCategoria(this)
        var listaCategorias:List<Categoria> = CCategoria.buscarCategorias()
    }
}

