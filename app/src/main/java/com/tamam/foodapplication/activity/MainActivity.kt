package com.tamam.foodapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.tamam.foodapplication.R
import com.tamam.foodapplication.adapter.FoodsAdapter
import com.tamam.foodapplication.model.FoodResponse
import com.tamam.foodapplication.model.Foods
import com.tamam.foodapplication.services.NetworkConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val listfoodAdapter = FoodsAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Food List"

        rv_foods.layoutManager = LinearLayoutManager(this@MainActivity)
        rv_foods.adapter = listfoodAdapter

        getDataListFood()
    }

    private fun getDataListFood() {
        // List Foods
        NetworkConfig.getServiceFoodList()
            .getFoodsList()
            .enqueue(object : Callback<FoodResponse> {

                // Jika API listfood dapat diterima
                override fun onResponse(
                    call: Call<FoodResponse>,
                    response: Response<FoodResponse>
                ) {
                    if (response.isSuccessful) {
                        viewListFood(response.body()!!)
                        val food = response.body()!!.foods
                        for (item in food) {
                            detailFood(item.id)
                        }
                    } else {
                        Toast.makeText(this@MainActivity, "Response Gagal", Toast.LENGTH_LONG).show()
                    }
                }

                // Jika API listfood gagal diterima
                override fun onFailure(call: Call<FoodResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Reponse Gagal : $t", Toast.LENGTH_LONG).show()
                }
            })
    }

    fun viewListFood(data: FoodResponse) {
        val food = data.foods
        listfoodAdapter.setData(food as List<Foods>)
    }

    fun detailFood(id: String?){
        NetworkConfig
    }
}