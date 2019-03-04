package com.example.funu.ui.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.example.funu.R
import com.example.funu.common.entity.GankArticle
import com.example.funu.common.type.GankType
import com.example.funu.ui.activity.picture.PictureActivity
import com.example.funu.utils.toast.toast
import kotlinx.android.synthetic.main.fragment_base.*


class WelfareFragment : BaseFragment() {

    private lateinit var adapter: GirlAdapter

    companion object {
        fun newInstance(): WelfareFragment {
            return WelfareFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar.visibility = View.VISIBLE
    }

    override fun initRecyclerView() {
        recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        val simpleAnimator = recyclerView.itemAnimator as SimpleItemAnimator
        simpleAnimator.supportsChangeAnimations = false

        adapter = GirlAdapter(activity!!.applicationContext, R.layout.item_girl)
        adapter.onItemClickListener = BaseQuickAdapter.OnItemClickListener { adapter, view, position ->
            start2PhotoActivity(adapter.getItem(position) as GankArticle)
        }

        recyclerView.adapter = adapter

        adapter.setOnLoadMoreListener({
            pageNumber++
            isRefresh = false
            loadData(pageSize, pageNumber)
        }, recyclerView)
    }

    private fun start2PhotoActivity(article: GankArticle) {
        val intent = Intent(activity, PictureActivity::class.java)
        intent.putExtra("url", article.url)
        activity!!.startActivity(intent)
    }

    override fun loadError() {
        activity?.toast(R.string.load_failed)
    }

    override fun loadSuccess(data: List<GankArticle>) {
        setUp(data)
    }

    private fun setUp(data: List<GankArticle>) {
        if (isRefresh) {
            adapter.setNewData(data)
        } else {
            adapter.addData(data)
        }
    }

    override fun loadFinish() {
        if (swipeLayout.isRefreshing) {
            this.swipeLayout.isRefreshing = false
        }

        adapter.loadMoreComplete()
    }

    override fun getType(): String {
        return GankType.福利.name
    }

    class GirlAdapter(var context: Context,
                      layoutId: Int) : BaseQuickAdapter<GankArticle, BaseViewHolder>(layoutId) {

        override fun convert(viewHolder: BaseViewHolder?, article: GankArticle?) {
            val imageView = viewHolder!!.getView<ImageView>(R.id.image)
            Glide.with(context).load(article!!.url).into(imageView)
        }

    }

}