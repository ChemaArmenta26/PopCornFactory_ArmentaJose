package armenta.jose.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_pelicula)

        val titulo = intent.getStringExtra("titulo")
        val imagen = intent.getIntExtra("header", 1)
        val sinopsis = intent.getStringExtra("sinopsis")

        val ivPelicula: ImageView = findViewById(R.id.iv_pelicula_imagen)
        val tvTitulo: TextView = findViewById(R.id.tv_nombre_pelicula)
        val tvDescripcion: TextView = findViewById(R.id.tv_pelicula_desc)

        ivPelicula.setImageResource(imagen)
        tvTitulo.text = titulo
        tvDescripcion.text = sinopsis
    }
}
