package com.example.guru

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guru.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login_Activity : AppCompatActivity() {

    lateinit var auth: FirebaseAuth
    lateinit var binding: ActivityLoginBinding
    private  val TAG = "Login_Activity"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        binding.btnregister.setOnClickListener {

            var email = binding.txtemail.text.toString()
            var password = binding.txtpassword.text.toString()


            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener{task ->

                    if (task.isSuccessful){
                        Toast.makeText(this, "REGISTER HO GAYA", Toast.LENGTH_SHORT).show()
                    }

                }.addOnFailureListener { error->

                    Log.e(TAG, "onCreate:-------- "+error.message )
                }


        }


    }
    }
