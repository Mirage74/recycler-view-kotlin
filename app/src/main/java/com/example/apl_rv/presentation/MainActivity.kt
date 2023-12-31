package com.example.apl_rv.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.apl_rv.R
import com.example.apl_rv.databinding.ActivityMainBinding
import com.example.apl_rv.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var shopListAdapter = ShopListAdapter()
    private val TAG = "MainActivity"
    //var shopListAct = MutableList<ShopItem>
    //var shopListAct: List<ShopItem> =Collections.emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        binding.rvShopList.adapter = shopListAdapter
        viewModel.shopList.observe(this) {
            shopListAdapter.shopList = it
        }
    }


}