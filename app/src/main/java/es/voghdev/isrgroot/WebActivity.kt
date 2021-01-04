package es.voghdev.isrgroot

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_web.*

class WebActivity : AppCompatActivity() {
    private val url = "https://valid-isrgrootx1.letsencrypt.org/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_web)

        webView.webViewClient = WebViewClient()
        webView.loadUrl(url)
    }
}