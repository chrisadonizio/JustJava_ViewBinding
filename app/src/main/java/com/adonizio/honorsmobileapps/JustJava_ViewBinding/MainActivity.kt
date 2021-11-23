package com.adonizio.honorsmobileapps.JustJava_ViewBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.adonizio.honorsmobileapps.JustJava_ViewBinding.databinding.ActivityMainBinding

var quantity = 0
lateinit var quantity_text: TextView
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val rootView =binding.root
        setContentView(rootView)
        binding.buttonMinus.setOnClickListener { view ->
            updateQuantity(-1)
        }
        binding.buttonPlus.setOnClickListener { view ->
            updateQuantity(1)
        }
        binding.submit.setOnClickListener { view ->
            submitOrder()
        }
    }

    fun updateQuantity(amount: Int) {
        if (quantity + amount < 1) {
            Toast.makeText(this, "Chill!!!You can't buy less than 1", Toast.LENGTH_LONG).show()
        } else if (quantity + amount > 10) {
            Toast.makeText(this, "Slow the roll only 10", Toast.LENGTH_LONG).show()
        } else {
            quantity += amount
        }
        binding.counter.text = quantity.toString()

    }

    fun submitOrder() {
        var message = "Thanks ${binding.Name.text}!\n$quantity coffees"
        var total = quantity*5
        if (binding.checkBox.isChecked()) {
            message += "\n + Whipped Cream"
            total += quantity
        }
        if (binding.checkBox2.isChecked) {
            message += "\n + Chocolate"
            total += (quantity * 2)
        }
        binding.summary.text = message +"\nTotal: $${total}.00"
    }

}
