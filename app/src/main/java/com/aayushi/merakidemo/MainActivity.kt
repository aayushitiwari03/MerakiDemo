package com.aayushi.merakidemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var adapter: PathwayAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.users_list_view)
        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


        val call = RetrofitInstance.api.getPathways()
        call.enqueue(object : Callback<PathwayContainer> {
            override fun onResponse(
                call: Call<PathwayContainer>,
                response: Response<PathwayContainer>
            ) {
                if (response.isSuccessful) {
                    val pathways = response.body()?.pathways
                    if (pathways != null) {
                        adapter = PathwayAdapter(this@MainActivity, pathways)
                        recyclerView.adapter = adapter
                    }
                }
            }

            override fun onFailure(call: Call<PathwayContainer>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
                Log.d("MainActivity", "onFailure: ${t.message}")
            }
        })

//        recyclerView.adapter = adapter

    }
}
