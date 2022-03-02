package com.example.per

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var count = 0;
    fun Login( view: View) {
        val username = findViewById<TextView>(R.id.edit_user)
        val password = findViewById<TextView>(R.id.edit_password)
        if (username.getText().toString().equals("admin") && password.getText().toString()
                .equals("admin")
        ) {
            Toast.makeText(applicationContext, "Вход выполнен!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, Second::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(
                getApplicationContext(),
                "Неправильные данные! Осталось попыток:" + (3 - count).toString(),
                Toast.LENGTH_SHORT
            ).show();
            count++;
        }

        if (count == 3) {
            Toast.makeText(getApplicationContext(), "Попытки закончились", Toast.LENGTH_SHORT)
                .show();
            username.isEnabled = false;
            password.isEnabled = false;
        }
    }


}