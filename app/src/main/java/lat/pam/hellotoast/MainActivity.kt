package lat.pam.hellotoast

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var mCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mShowCount = findViewById<TextView>(R.id.show_count)
        val buttonCountUp = findViewById<Button>(R.id.button_count)
        val buttonToast = findViewById<Button>(R.id.button_toast)
        val buttonSwitchPage = findViewById<Button>(R.id.button_switchpage)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)
        val buttonContacts = findViewById<Button>(R.id.button_contacts)
        val buttonMap = findViewById<Button>(R.id.button_map)

        buttonCountUp.setOnClickListener {
            mCount++
            mShowCount.text = mCount.toString()
        }

        buttonToast.setOnClickListener {
            val tulisan = mShowCount?.text.toString()
            val toast = Toast.makeText(this, "Angka yang dimunculkan $tulisan", Toast.LENGTH_LONG)
            toast.show()
        }

        buttonSwitchPage.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        buttonBrowser.setOnClickListener {
            val intentBrowse = Intent(Intent.ACTION_VIEW)
            intentBrowse.data = Uri.parse("https://www.google.com/")
            startActivity(intentBrowse)
        }

        buttonContacts.setOnClickListener {
            val intentContacts = Intent(Intent.ACTION_VIEW)
            intentContacts.data = Uri.parse("content://contacts/people/")
            startActivity(intentContacts)
        }

        buttonMap.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:0,0?q=UIN+Bandung")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps") // buka dengan Google Maps
            startActivity(mapIntent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
