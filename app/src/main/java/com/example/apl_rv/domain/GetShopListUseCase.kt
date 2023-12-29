package com.example.apl_rv.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    //fun getShopList(): LiveData<List<ShopItem>> {
    fun getShopList(): List<ShopItem> {
        return shopListRepository.getShopList()
    }
}