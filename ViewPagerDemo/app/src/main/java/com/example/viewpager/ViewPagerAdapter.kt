package com.example.viewpager

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class ViewPagerAdapter(context: Context) : PagerAdapter() {

    private var mContext: Context? = context

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == obj
    }

    override fun getCount(): Int {
        return CustomPageEnum.values().size
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val page = CustomPageEnum.values()[position]
        val layoutInflater = LayoutInflater.from(mContext)
        val view = layoutInflater.inflate(page.layoutRes, container, false)
        container.addView(view)

        return view
    }

}