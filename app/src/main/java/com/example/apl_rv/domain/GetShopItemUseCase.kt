package com.example.apl_rv.shoplist

import com.example.apl_rv.domain.ShopItem
import com.example.apl_rv.domain.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopItemId: Int): ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}