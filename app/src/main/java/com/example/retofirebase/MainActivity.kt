package com.example.retofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.retofirebase.databinding.ActivityMainBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = Firebase.database
        val myRef  = database.reference

        myRef.child("peliculas")

        binding.btnSave.setOnClickListener{

            val title: String = binding.etTitle.text.toString()
            val year: Int = binding.etYear.text.toString().toInt()
            val id: String = binding.etId.text.toString()
            val type: String = binding.etType.text.toString()
            val country: String = binding.etCountry.text.toString()
            val genre: String = binding.etGenre.text.toString()



            myRef.child("peliculas").child(id).setValue(Movie(title, year, type, country, genre))


            Toast.makeText(this, "Guardado", Toast.LENGTH_LONG).show()

            binding.etTitle.setText("")
            binding.etYear.setText("")
            binding.etId.setText("")
            binding.etType.setText("")
            binding.etCountry.setText("")
            binding.etGenre.setText("")


        }
    }
}