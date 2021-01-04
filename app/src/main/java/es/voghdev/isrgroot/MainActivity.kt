package es.voghdev.isrgroot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.Request
import javax.net.ssl.SSLHandshakeException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            doNetworkRequest()
        }
    }

    private fun doNetworkRequest() {
        val t = Thread {
            try {
                val client = OkHttpClient();
                val request = Request.Builder()
                    .url("https://valid-isrgrootx1.letsencrypt.org/robots.txt")
                    .build();
                val response = client.newCall(request).execute()
                textView.post {
                    textView.text =
                        "Response code: ${response.code()} protocol: ${response.protocol()}"
                }
            } catch (sslhe: SSLHandshakeException) {
                sslhe.printStackTrace()
                textView.post {
                    textView.text = "SSLHandshakeException: ${sslhe.message}"
                }
            } catch (e: Exception) {
                e.printStackTrace()
                textView.post {
                    textView.text = "Exception: ${e.message}"
                }
            }
        }
        t.start()
    }
}
