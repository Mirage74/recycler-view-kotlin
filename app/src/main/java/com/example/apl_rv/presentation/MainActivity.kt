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
import com.example.apl_rv.databinding.ItemShopEnabledBinding
import com.example.apl_rv.databinding.ItemShopDisabledBinding
import com.example.apl_rv.domain.ShopItem

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var llShopList: LinearLayout
    private val TAG = "MainActivity"
    //var shopListAct = MutableList<ShopItem>
    //var shopListAct: List<ShopItem> =Collections.emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel =
            ViewModelProvider(this, MainViewModelFactory(application))[MainViewModel::class.java]
        llShopList = binding.llShopList
        viewModel.shopList.observe(this) {
            showList(it)
        }
    }

    private fun showList(list: List<ShopItem>) {
        val bindingEnableView = DataBindingUtil.setContentView<ItemShopEnabledBinding>(this, R.layout.item_shop_enabled)
        val bindingDisableView = DataBindingUtil.setContentView<ItemShopDisabledBinding>(this, R.layout.item_shop_disabled)
        var tvName: TextView
        var tvCount: TextView
        for (shopItem in list) {
            val layoutID = if (shopItem.enabled) {
//                tvName = bindingEnableView.tvName
//                tvCount = bindingEnableView.tvCount
                R.layout.item_shop_enabled
            } else {
//                tvName = bindingDisableView.tvName
//                tvCount = bindingDisableView.tvCount
                R.layout.item_shop_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutID, llShopList, false)
//            tvName.text = shopItem.name
//            tvCount.text = shopItem.count.toString()
            llShopList.addView(view)
        }
    }


}