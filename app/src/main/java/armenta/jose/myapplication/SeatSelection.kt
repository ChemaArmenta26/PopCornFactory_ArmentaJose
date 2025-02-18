package armenta.jose.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class SeatSelection : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_seat_selection)


        val titleSeat : TextView = findViewById(R.id.titleSeats)
        var posMovie = -1

        val bundle = intent.extras
        val row1 : RadioGroup = findViewById(R.id.row1)
        val row2 : RadioGroup = findViewById(R.id.row2)
        val row3 : RadioGroup = findViewById(R.id.row3)
        val row4 : RadioGroup = findViewById(R.id.row4)

        if (bundle!= null) {
            titleSeat.setText(bundle.getString("name"))
            posMovie= bundle.getInt("id")
        }

        val movieTitle = intent.getStringExtra("name") ?: ""
        val sharedPreferences: SharedPreferences = getSharedPreferences("reservas", MODE_PRIVATE)
        val claveAsientos = "asientos_reservados_$movieTitle"

        val reservedSeats = sharedPreferences.getStringSet(claveAsientos, mutableSetOf()) ?: mutableSetOf()

        listOf(row1, row2, row3, row4).forEach { row ->
            for (i in 0 until row.childCount) {
                val seatButton = row.getChildAt(i) as? RadioButton
                seatButton?.let {
                    if (reservedSeats.contains(it.text.toString())) {
                        it.isEnabled = false
                        it.setBackgroundResource(R.drawable.radio_disabled)
                    }
                }
            }
        }



        val confirm : Button = findViewById(R.id.confirm)

        confirm.setOnClickListener {
            val selectedSeatId = listOf(row1, row2, row3, row4)
                .flatMap { it.checkedRadioButtonId.let { id -> if (id != -1) listOf(id) else emptyList() } }
                .firstOrNull()

            if (selectedSeatId != null) {
                val seatButton = findViewById<RadioButton>(selectedSeatId)
                val seatName = seatButton.text.toString()

                val sharedPreferences = getSharedPreferences("reservas", MODE_PRIVATE)
                val editor = sharedPreferences.edit()

                val movieTitle = intent.getStringExtra("name") ?: ""
                val claveAsientos = "asientos_reservados_$movieTitle"
                val reservedSeats = sharedPreferences.getStringSet(claveAsientos, mutableSetOf()) ?: mutableSetOf()
                reservedSeats.add(seatName)

                editor.putStringSet(claveAsientos, reservedSeats)
                editor.apply()

                seatButton.isEnabled = false
                seatButton.setBackgroundResource(R.drawable.radio_disabled)
                Toast.makeText(this, "Enjoy the movie! :D", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ResumenCompraActivity::class.java)
                    intent.putExtra("movieName", movieTitle)
                    intent.putExtra("seat", seatName)
                    intent.putExtra("customer", "Chemita")

                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a seat", Toast.LENGTH_LONG).show()
            }
        }

        row1.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row1.check(checkedId)
        }

        }

        row2.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1){
                row1.clearCheck()
                row3.clearCheck()
                row4.clearCheck()

                row2.check(checkedId)
            }

        }

        row3.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1){
                row2.clearCheck()
                row1.clearCheck()
                row4.clearCheck()

                row3.check(checkedId)
            }

        }

        row4.setOnCheckedChangeListener { group, checkedId ->

            if (checkedId > -1){
                row2.clearCheck()
                row3.clearCheck()
                row1.clearCheck()

                row4.check(checkedId)
            }

        }

    }
}