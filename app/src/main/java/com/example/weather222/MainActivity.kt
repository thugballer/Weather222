package com.example.weather222

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.weather222.databinding.ActivityMainBinding
import org.json.JSONObject

const val API_KEY = "488f532777b1a8e3e30fba36a239fb61"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bGet.setOnClickListener {
            getResult("London")
        }
    }
    private fun getResult(name: String){
        val url = "https://api.openweathermap.org/data/2.5/weather?q=voronezh&appid=$API_KEY"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(
            Request.Method.GET,
            url,
            {
                    response->
                val obj = JSONObject(response)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog","Response: ${temp.getString("temp_c")}")
            },
            {
                Log.d("MyLog","Volley error: $it")
            }
        )
        queue.add(stringRequest)
    }
}