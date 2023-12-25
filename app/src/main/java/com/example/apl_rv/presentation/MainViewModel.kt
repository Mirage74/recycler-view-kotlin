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
    private val forTest = 68

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}