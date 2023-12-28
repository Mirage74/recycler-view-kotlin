package com.example.apl_rv.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apl_rv.domain.ShopItem
import com.example.apl_rv.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private val TAG = "ShopListRepositoryImpl"
    private var autoIncrementId = 0

    init {
        for (i in 0 until 20) {
            val item = ShopItem("Name $i", i * 2, true, i)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        shopList.remove(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }

    override fun toString(): String {
        var s = "{object ShopListRepositoryImpl: ["
        //Log.d(TAG, "shopList.size: ${shopList.size}")
        val iterator = shopList.iterator()

        while (iterator.hasNext()) {
            s += iterator.next().toString()
        }
        s = s + "]}"
        return s
    }
}