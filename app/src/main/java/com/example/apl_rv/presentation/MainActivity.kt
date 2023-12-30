package com.example.apl_rv.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.apl_rv.R
import com.example.apl_rv.data.ShopListRepositoryImpl
import com.example.apl_rv.databinding.ActivityMainBinding
import com.example.apl_rv.domain.EditShopItemUseCase
import com.example.apl_rv.domain.ShopItem
import java.util.Collections

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val TAG = "MainActivity"
//    private var item = ShopItem("444", 3, true, 111)
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
      //  Log.d(TAG, "2$shopListAct")
//        shopListAct = viewModel.shopList.value!!
//        Log.d(TAG, shopListAct.toString())
//        val item = shopListAct[0]
//        Log.d(TAG, shopListAct[0].toString())
//        item.count = 5
//        var b = item == shopListAct[0]
//
//        Log.d(TAG, b.toString())
//        Log.d(TAG, shopListAct[0].toString())
//        viewModel.deleteShopItem(item)
//
//        shopListAct = viewModel.shopList.value!!
//        Log.d(TAG, "222 $shopListAct")

    }

}