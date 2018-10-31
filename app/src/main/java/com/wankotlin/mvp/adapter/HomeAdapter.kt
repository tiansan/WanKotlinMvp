package com.wankotlin.mvp.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.wankotlin.mvp.R
import com.wankotlin.mvp.data.network.model.Articles
import kotlinx.android.synthetic.main.item_home_article.view.*
import java.util.*

/**
 * 类名：HomeAdapter
 * 作者：Yun.ei
 * 功能：
 * 创建日期：2018-10-19 11:11
 * 修改人：
 * 修改时间：
 * 修改备注：
 */
class HomeAdapter : BaseQuickAdapter<Articles, BaseViewHolder>(R.layout.item_home_article) {

    private val colorRess = mutableListOf(
            R.drawable.shape_head_red,
            R.drawable.shape_head_blue,
            R.drawable.shape_head_orange,
            R.drawable.shape_head_green)

    override fun convert(helper: BaseViewHolder?, item: Articles?) {
        val itemView = helper?.itemView
        itemView?.apply {
            item?.let {
                nameHeadTV.text = getStrFirstChat(it.author)
                nameHeadTV.setBackgroundResource(getRandomColor())
                nameTv.text = it.author
                titleTv.text = it.title
                descTv.text = if (it.desc.isNullOrBlank()) {
                    it.link
                } else {
                    it.desc
                }
                timeTv.text = it.niceDate
                typeTv.text = getType(it)
                heartIV.setColorFilter(context.resources.getColor(if (it.collect) {
                    R.color.red
                } else {
                    R.color.gray_1
                }))
            }
        }
    }

    private fun getType(item: Articles): String {
        return if (item.superChapterName.isNullOrBlank()) {
            item.chapterName
        } else {
            "${item.chapterName} / ${item.superChapterName}"
        }
    }

    private fun getRandomColor(): Int {
        val index = Random().nextInt(4)
        return colorRess[index]
    }

    private fun getStrFirstChat(str: String): String {
        return str.substring(0, 1)
    }
}