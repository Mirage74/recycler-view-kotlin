package com.example.apl_rv.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel


import com.example.apl_rv.data.ShopListRepositoryImpl
import com.example.apl_rv.domain.DeleteShopItemUseCase
import com.example.apl_rv.domain.EditShopItemUseCase
import com.example.apl_rv.domain.GetShopListUseCase
import com.example.apl_rv.domain.ShopItem


class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    //val shopList = MutableLiveData<List<ShopItem>>()
    val shopList = getShopListUseCase.getShopList()

//    fun getShopList() {
//        val list = getShopListUseCase.getShopList()
//        shopList.value = list
//    }

    fun deleteShopItem(item: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(item)
        //getShopList()
    }

    fun changeEnabledState(item: ShopItem) {
        val newItem = item.copy(enabled = !item.enabled)
        editShopItemUseCase.editShopItem(newItem)
        //getShopList()
    }
}