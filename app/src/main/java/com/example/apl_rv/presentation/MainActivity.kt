package com.example.apl_rv.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.apl_rv.R
import com.example.apl_rv.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val TAG = "MainActivity"
    //var shopListAct = MutableList<ShopItem>
    //var shopListAct: List<ShopItem> =Collections.emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        viewModel.shopList.observe(this) {
            Log.d(TAG, "it : $it")
            //Log.d(TAG, "0$shopListAct")
            if (it[0].id == 0) {
                //viewModel.deleteShopItem(it[0])
                val item = it[0]
                viewModel.changeEnabledState(item)
            }

        }


    }

}