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
            val client = OkHttpClient();

            try {
                val request = Request.Builder()
                    .url("https://valid-isrgrootx1.letsencrypt.org/robots.txt")
                    .build();
                val response = client.newCall(request).execute()
//                assertTrue(response.code() == 200 || response.code() == 404);
//                assertEquals(Protocol.HTTP_2, response.protocol());
            } catch (sslhe: SSLHandshakeException) {
                sslhe.printStackTrace()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        t.start()
    }
}
