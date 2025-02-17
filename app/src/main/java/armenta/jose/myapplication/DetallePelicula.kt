package armenta.jose.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val bundle = intent.extras
        val ivPelicula: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tvTitulo: TextView = findViewById(R.id.tv_nombre_pelicula)
        val tvDescripcion: TextView = findViewById(R.id.tv_pelicula_desc)
        val seatsLeft: TextView = findViewById(R.id.seatsLeft)
        val buyTickets: Button = findViewById(R.id.buyTickets)

        var movieSeats = 0
        var id = -1
        var title = ""

        if (bundle != null) {
            movieSeats = bundle.getInt("numberSeats")
            title = bundle.getString("titulo") ?: ""
            ivPelicula.setImageResource(bundle.getInt("header"))
            tvTitulo.text = title
            tvDescripcion.text = bundle.getString("sinopsis") ?: ""
            seatsLeft.text = "$movieSeats seats available"
            id = bundle.getInt("pos")
        }

        if (movieSeats == 0) {
            buyTickets.isEnabled = false
        } else {
            buyTickets.setOnClickListener {
                val intent = Intent(this, SeatSelection::class.java).apply {
                    putExtra("id", id)
                    putExtra("name", title)
                }
                startActivity(intent)
            }
        }
    }
}
