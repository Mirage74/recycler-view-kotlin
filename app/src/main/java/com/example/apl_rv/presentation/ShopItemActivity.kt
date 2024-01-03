package com.example.apl_rv.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.apl_rv.databinding.ActivityShopItemBinding
import com.example.apl_rv.R

class ShopItemActivity : AppCompatActivity() {
    private lateinit var binding: ActivityShopItemBinding
    private val TAG = "ShopItemActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_shop_item)
    }
}