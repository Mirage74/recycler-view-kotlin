package com.example.apl_rv.presentation

//import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import com.example.apl_rv.R
import com.example.apl_rv.databinding.ItemShopDisabledBinding
import com.example.apl_rv.databinding.ItemShopEnabledBinding
import com.example.apl_rv.domain.ShopItem

//private const val TAG = "ShopListAdapter"
//private var holderCount = 0

//class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

//    var shopList = listOf<ShopItem>()
//        set(value) {
//            val callback = ShopListDiffCallback(shopList, value)
//            val diffResult = DiffUtil.calculateDiff(callback)
//            diffResult.dispatchUpdatesTo(this)
//            field = value
//            //notifyDataSetChanged()
//        }

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        //Log.d(TAG, "onCreateViewHolder: ${++holderCount}")
        val layout = when (viewType) {
            VIEW_TYPE_ENABLED -> R.layout.item_shop_enabled
            VIEW_TYPE_DISABLED -> R.layout.item_shop_disabled
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        //val binding = ItemShopDisabledBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context), layout, parent, false)



        return ShopItemViewHolder(binding)
    }


    override fun onBindViewHolder(viewHolder: ShopItemViewHolder, position: Int) {
        //Log.d(TAG, "onBindViewHolder: ${++holderCount}")
        val shopItem = getItem(position)
        val binding = viewHolder.binding
        binding.root.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(shopItem)
            true
        }
        binding.root.setOnClickListener {
            onShopItemClickListener?.invoke(shopItem)
        }

        when (binding) {
            is ItemShopDisabledBinding -> {
                binding.shopItem = shopItem
            }
            is ItemShopEnabledBinding -> {
                binding.shopItem = shopItem
            }
        }


    }

//    override fun onViewRecycled(viewHolder: ShopItemViewHolder) {
//        super.onViewRecycled(viewHolder)
//        viewHolder.tvName.text = ""
//        viewHolder.tvCount.text = ""
//        viewHolder.tvName.setTextColor(ContextCompat.getColor(viewHolder.view.context, android.R.color.white))
//    }

//    override fun getItemCount(): Int {
//        return shopList.size
//    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).enabled) {
            VIEW_TYPE_ENABLED
        } else {
            VIEW_TYPE_DISABLED
        }
    }



    companion object {
        const val VIEW_TYPE_ENABLED = 0
        const val VIEW_TYPE_DISABLED = 1

        const val MAX_POOL_SIZE = 15
    }
}