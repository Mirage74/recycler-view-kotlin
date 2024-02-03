package com.example.apl_rv.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.apl_rv.data.ShopListRepositoryImpl
import com.example.apl_rv.domain.DeleteShopItemUseCase
import com.example.apl_rv.domain.EditShopItemUseCase
import com.example.apl_rv.domain.GetShopListUseCase
import com.example.apl_rv.domain.ShopItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ShopListRepositoryImpl(application)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    private val scope = CoroutineScope(Dispatchers.IO)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(item: ShopItem) {
        scope.launch {
            deleteShopItemUseCase.deleteShopItem(item)
        }
    }

    fun changeEnableState(item: ShopItem) {
        scope.launch {
            val newItem = item.copy(enabled = !item.enabled)
            editShopItemUseCase.editShopItem(newItem)
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }
}