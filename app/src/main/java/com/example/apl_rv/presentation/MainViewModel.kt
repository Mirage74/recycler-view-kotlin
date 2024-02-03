package com.example.apl_rv.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.apl_rv.data.ShopListRepositoryImpl
import com.example.apl_rv.domain.DeleteShopItemUseCase
import com.example.apl_rv.domain.EditShopItemUseCase
import com.example.apl_rv.domain.GetShopListUseCase
import com.example.apl_rv.domain.ShopItem
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ShopListRepositoryImpl(application)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)


    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(item: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(item)
        }
    }

    fun changeEnableState(item: ShopItem) {
        viewModelScope.launch {
            val newItem = item.copy(enabled = !item.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

}