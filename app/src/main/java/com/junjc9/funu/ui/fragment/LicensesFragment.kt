package com.junjc9.funu.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.junjc9.funu.R
import com.junjc9.funu.ui.activity.license.LicenseContract
import kotlinx.android.synthetic.main.fragment_license.*

class LicensesFragment : Fragment(), LicenseContract.View {

    private lateinit var mPresenter: LicenseContract.Presenter

    companion object {
        @JvmStatic
        fun newInstance(): LicensesFragment {
            return LicensesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_license, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        mPresenter.subscribe()

        license_web_view.loadUrl("file:///android_asset/licenses.html")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.unsubscribe()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            activity?.onBackPressed()
        }
        return true
    }

    override fun setPresenter(presenter: LicenseContract.Presenter) {
        mPresenter = presenter
    }

    private fun initViews() {
        val settings = license_web_view.settings
        settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.SINGLE_COLUMN
        settings.defaultTextEncodingName = "UTF-8"
        settings.blockNetworkImage = false
        settings.domStorageEnabled = true
        settings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW

        license_web_view.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(webView: WebView?, request: WebResourceRequest?): Boolean {
                webView?.loadUrl(request?.url.toString())
                return true
            }
        }

    }

}