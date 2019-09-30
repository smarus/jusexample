package ownvk.ruslan.android.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(CardViewModel::class.java)
        val text = findViewById<TextView>(R.id.json_result)

        viewModel.shufleDec.observe(this, Observer {
            text.text = it.success.toString()
        })

    }
}
