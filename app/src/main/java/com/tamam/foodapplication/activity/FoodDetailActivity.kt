package com.tamam.foodapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.tamam.foodapplication.R
import com.tamam.foodapplication.model.FoodsDetailResponse
import com.tamam.foodapplication.services.NetworkConfig
import kotlinx.android.synthetic.main.activity_food_detail.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FoodDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_detail)

        val id = intent.getStringExtra("id")
        getDetailFood(id)
    }

    private fun getDetailFood(id: String?) {
        if (id != null) {
            NetworkConfig.getServiceDetailFood()
                .getDetailFood(id)
                .enqueue(object : Callback<FoodsDetailResponse> {
                    override fun onResponse(
                        call: Call<FoodsDetailResponse>,
                        response: Response<FoodsDetailResponse>
                    ) {
                        if (response.isSuccessful){
                            tv_name.text = response.body()?.foods?.name
                            tv_instruction.text = response.body()?.foods?.instruction
                            showDetail(response.body())
                        }
                    }

                    override fun onFailure(call: Call<FoodsDetailResponse>, t: Throwable) {
                        Toast.makeText(this@FoodDetailActivity, "Response : $t", Toast.LENGTH_LONG).show()
                    }
                })
        }
    }

    fun showDetail(body: FoodsDetailResponse?) {
        tv_name.text = body?.foods?.name
        tv_instruction.text = body?.foods?.instruction
//                val poster = intent.getIntExtra(EXTRA_POSTER, 1)
//                poster_path_foods.setImageResource(poster)
    }
}