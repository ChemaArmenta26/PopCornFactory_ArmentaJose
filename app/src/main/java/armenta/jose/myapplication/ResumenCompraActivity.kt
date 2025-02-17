package armenta.jose.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResumenCompraActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resumen_compra)

        val movieTitle: TextView = findViewById(R.id.movieTitle)
        val seatNumber: TextView = findViewById(R.id.seatNumber)
        val customerName: TextView = findViewById(R.id.customerName)

        val bundle = intent.extras
        if (bundle != null) {
            movieTitle.text = "Movie: " + bundle.getString("movieName")
            seatNumber.text = "Seat: " + bundle.getString("seat")
            customerName.text = "Customer: " + bundle.getString("customer")
        }
    }
}
