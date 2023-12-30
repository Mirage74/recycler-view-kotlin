package com.example.apl_rv.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int): ShopItem

    //fun getShopList(): List<ShopItem>
    fun getShopList(): LiveData<List<ShopItem>>
}