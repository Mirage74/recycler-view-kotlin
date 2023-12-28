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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        Log.d(TAG, ShopListRepositoryImpl.toString())
        val item = ShopItem("test Replace", 111, true, -3)
        //ShopListRepositoryImpl.editShopItem(item)
        ShopListRepositoryImpl.addShopItem(item)
        Log.d(TAG, ShopListRepositoryImpl.toString())


    }


}