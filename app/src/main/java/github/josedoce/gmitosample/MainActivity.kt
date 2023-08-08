package github.josedoce.gmitosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import github.josedoce.gmito.Fakegem
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMensagem = findViewById<TextView>(R.id.mensagem)
        Fakegem().euVi(tvMensagem)
    }
}
