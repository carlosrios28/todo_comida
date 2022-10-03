package com.desarrolloswesquel.todocomida.controladores

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.desarrolloswesquel.todocomida.Controlador.ControladorCategoria
import com.desarrolloswesquel.todocomida.Controlador.ControladorDB
import com.desarrolloswesquel.todocomida.Modelo.Categoria
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarCategoria
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarLocal
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarProducto
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.snackbar.Snackbar
import java.io.Console

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)


        navView.setupWithNavController(navController)

    }

}

