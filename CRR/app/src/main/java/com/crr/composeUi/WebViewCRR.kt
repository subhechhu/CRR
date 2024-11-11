package com.crr.composeUi

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.SslErrorHandler
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowInsetsControllerCompat
import com.crr.databinding.ActivityWebviewBinding

class WebViewCRR : AppCompatActivity() {
    private val TAG = javaClass.simpleName

    private val binding by lazy {
        ActivityWebviewBinding.inflate(layoutInflater)
    }

    @SuppressLint("SetJavaScriptEnabled", "SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true

        try {
            val url = "https://jiogames.akamaized.net/mc/sp/miniapp/preloader%201.json"
            binding.lottieAnimationWebView.setAnimationFromUrl(url)
        } catch (e: Exception) {
            Log.e(TAG, "exception loadLottieAnimationFromUrl: ${e.message}")
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.webView.canGoBack()) {
                    binding.webView.goBack()
                } else {
                    binding.webView.destroy()
                    finish()
                }
            }
        })

        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars = true

        binding.webView.webViewClient = CustomWebViewClient(binding)
        val webSetting = binding.webView.settings
        webSetting.javaScriptEnabled = true
        webSetting.domStorageEnabled = true
        webSetting.cacheMode = WebSettings.LOAD_NO_CACHE
        webSetting.textZoom = 100
        val url = "https://app.lapentor.com/sphere/thame-loss-and-damage-virtual-reality"
        binding.webView.loadUrl(url)
    }


    override fun onSupportNavigateUp(): Boolean {
        binding.webView.destroy()
        finish()
        return true
    }

    class CustomWebViewClient internal constructor(binding: ActivityWebviewBinding) : WebViewClient() {
        private val mBinding = binding

        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            val url: String = request?.url.toString()
            view?.loadUrl(url)
            return false
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            super.onPageFinished(view, url)
            if (view?.progress == 100) {
                mBinding.webView.visibility = View.VISIBLE
                mBinding.lottieAnimationWebView.visibility = View.GONE
            }
        }


        override fun onReceivedError(view: WebView, request: WebResourceRequest, error: WebResourceError) {
            Log.e(javaClass.simpleName, "onReceivedError(): ${error.description}")
        }

        override fun onReceivedSslError(webView: WebView, handler: SslErrorHandler, error: SslError) {
            handler.cancel()

            val description = when (error.primaryError) {
                SslError.SSL_DATE_INVALID -> "The date of the certificate is invalid"
                SslError.SSL_EXPIRED -> "The certificate has expired"
                SslError.SSL_IDMISMATCH -> "Hostname mismatch"
                SslError.SSL_INVALID -> "A generic error occurred"
                SslError.SSL_NOTYETVALID -> "The certificate is not yet valid"
                SslError.SSL_UNTRUSTED -> "The certificate authority is not trusted"
                else -> "Unknown SSL Error"
            }
            Log.e(javaClass.simpleName, "onReceivedSslError: $description")
        }
    }
}