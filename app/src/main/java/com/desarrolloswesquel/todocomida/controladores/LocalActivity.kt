package com.desarrolloswesquel.todocomida.controladores

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.desarrolloswesquel.todocomida.Controlador.ControladorCategoria
import com.desarrolloswesquel.todocomida.Modelo.Categoria
import com.desarrolloswesquel.todocomida.R
import com.desarrolloswesquel.todocomida.controladores.adapters.ProductoAdapter
import com.desarrolloswesquel.todocomida.databinding.ActivityLocalBinding
import com.desarrolloswesquel.todocomida.Modelo.Producto
import com.desarrolloswesquel.todocomida.Modelo.carga.CargarProducto

class LocalActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLocalBinding
    private var productoMutableList: MutableList<Producto> =
        CargarProducto().listaProducto().toMutableList()
    private lateinit var adapter: ProductoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_local)

        binding = ActivityLocalBinding.inflate(layoutInflater)
        setContentView(binding.root)
        cargarpantalla()
        adapter = ProductoAdapter(productoMutableList)
        val recyclerView = binding.ListadoProducto
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        val CCategoria = ControladorCategoria(this)
        var listaCategorias:List<Categoria> = CCategoria.buscarCategorias()
        if (listaCategorias.isEmpty()) {
            CCategoria.agregarCategoria(
                Categoria(
                    "Pizzas",
                    0,
                    R.drawable.pizza
                )
            )
            Log.i("info","Agregado")
        }else{
            Log.i("info",listaCategorias[0].NombreCategoria)
            Log.i("info","ya existe")
        }

    }

    private fun cargarpantalla() {
        binding.ItemLocalNombre.text = intent.getStringExtra("nombrelocal")
        binding.ItemLocalRubro.text = intent.getStringExtra("rubrolocal")
        binding.ItemLocalDireccion.text = intent.getStringExtra("direccionlocal")
        binding.ItemLocalImagen.setImageResource(intent.extras?.get("imagenlocal") as Int)
    }


}