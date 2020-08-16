package com.example.foodlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.food_ticket.*

class foodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)
        val bundle=intent.extras
        val name=bundle!!.getString("name")
        val des = bundle!!.getString("des")
        val image=bundle!!.getInt("merna")
        tex1.text=name
        tex2.text=des
        Merna.setImageResource(image)

    }
}