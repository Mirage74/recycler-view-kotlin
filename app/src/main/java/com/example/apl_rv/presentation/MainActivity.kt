package com.example.apl_rv.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.apl_rv.R
import com.example.apl_rv.data.ShopListRepositoryImpl
import com.example.apl_rv.databinding.ActivityMainBinding
import com.example.apl_rv.domain.EditShopItemUseCase
import com.example.apl_rv.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val TAG = "MainActivity"
    private var item = ShopItem("444", 3, true, 111)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            Log.d(TAG, it.toString())
                //viewModel.deleteShopItem(it[0])

        }

        //val shopItem = viewModel.shopList.value?.get(0)
        viewModel.getShopList()
       //viewModel.deleteShopItem(item)


        //Log.d(TAG, viewModel.shopList.value.toString())
    }

}