package com.example.guru

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guru.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {


    lateinit var auth: FirebaseAuth
    private val TAG = "MainActivity"
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnnext.setOnClickListener {

            startActivity(Intent(this, Login_Activity::class.java))
        }





        auth = FirebaseAuth.getInstance()
        binding.btnregister.setOnClickListener {

            var email = binding.txtemail.text.toString()
            var password = binding.txtpassword.text.toString()


            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        Toast.makeText(this, "REGISTER HO GAYA", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, Login_Activity::class.java))
                    }

                }.addOnFailureListener { error ->

                    Log.e(TAG, "onCreate:-------- " + error.message)
                }


        }


    }
}