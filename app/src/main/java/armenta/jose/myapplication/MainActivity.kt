package armenta.jose.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    var series = ArrayList<Pelicula>()
    var peliculas = ArrayList<Pelicula>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridViewSeries: GridView = findViewById(R.id.gridViewSeries)
        val gridViewMovies: GridView = findViewById(R.id.gridViewMovies)

        cargarPeliculas()

        val adaptadorSeries = PeliculaAdapter(this, series)
        gridViewSeries.adapter = adaptadorSeries
        setGridViewHeight(gridViewSeries);


        val adaptadorMovies = PeliculaAdapter(this, peliculas)
        gridViewMovies.adapter = adaptadorMovies
        setGridViewHeight(gridViewMovies);

    }

    fun cargarPeliculas(){

        peliculas.add(Pelicula(titulo = "Big Hero 6", R.drawable.bighero6, R.drawable.headerbighero6, sinopsis = "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called 'Big Hero 6.'"))
        peliculas.add(Pelicula(titulo = "Leap Year", R.drawable.leapyear, R.drawable.leapyearheader, sinopsis = "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        peliculas.add(Pelicula(titulo = "Inception", R.drawable.inception, R.drawable.inceptionheader, sinopsis = "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))
        peliculas.add(Pelicula(titulo = "Men in Black", R.drawable.mib, R.drawable.mibheader, sinopsis = "Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency finest men only going by the name K (Tommy Lee Jones) , is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the Bug race. He takes the body of a farmer (Vincent D'Onofrio) and heads to New York. He is searching for a super energy source called The Galaxy. Now, Agents J and K must stop the bug before it can escape with the galaxy."))
        peliculas.add(Pelicula(titulo = "Toy Story", R.drawable.toystory, R.drawable.toystoryheader, sinopsis = "Toy Story is about the secret life of toys when people are not around. When Buzz Lightyear, a space-ranger, takes Woodys place as Ands favorite toy, Woody doesnt like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home."))
        peliculas.add(Pelicula(titulo = "1917", R.drawable.the1917, R.drawable.the1917header, sinopsis = "British trenches somewhere in France. World war has been going on for the third year, heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly, sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two young soldiers, Blake and Schofield, are summoned to the general, who instructs them to send an important message to Colonel MacKenzie in the Second Devonshire Battalion, whose telephone connection was cut off by the enemy."))

        series.add(Pelicula(titulo = "Suits", R.drawable.suits, R.drawable.suitsheader, sinopsis = "While running from a drug deal gone bad, brilliant young college dropout Mike Ross slips into a job interview with one of New York City's best legal closers, Harvey Specter. Tired of cookie-cutter law- school grads, Harvey takes a gamble by hiring Mike on the spot after recognizing his raw talent and photographic memory. Mike and Harvey are a winning team. Although Mike is a genius, he still has a lot to learn about law and while Harvey might seem like an emotionless, cold-blooded shark, Mike's sympathy and concern for their cases and clients will help remind Harvey why he went into law in the first place. Mike's other allies in the office include the firm's best paralegal Rachel and Harvey's no-nonsense assistant Donna. Proving to be an irrepressible duo and invaluable to the practice, Mike and Harvey must keep their secret from everyone including managing partner Jessica and Harvey's archnemesis Louis, who seems intent on making Mike's life as difficult as possible."))
        series.add(Pelicula(titulo = "Dr. Who", R.drawable.drwho, R.drawable.drwhoheader, sinopsis = "Traveling across time and space, the immortal time-lord known as 'The Doctor' travels across the universe with his many companions and his loyal shape-shifting space-ship: The TARDIS. The Doctor faces many threats across many generations: from The Daleks, The Cybermen and his time-lord adversary The Master to the sinister Davros, creator of The Daleks."))
        series.add(Pelicula(titulo = "Friends", R.drawable.friends, R.drawable.friendsheader, sinopsis = "Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing and Phoebe Buffay are six 20 something year-olds, living off of one another in the heart of New York City. Over the course of ten years, this average group of buddies goes through massive mayhem, family trouble, past and future romances, fights, laughs, tears and surprises as they learn what it really means to be a friend."))
        series.add(Pelicula(titulo = "Bones", R.drawable.bones, R.drawable.bonesheader, sinopsis = "Dr. Temperance Brennan is a brilliant, but lonely, anthropologist whom is approached by an ambitious FBI agent, named Seely Booth, to help the bureau solve a series of unsolved crimes by identifying the long-dead bodies of missing persons by their bone structure. But both Agent Booth and Dr. Brennan and her team come up against a variety of interference from red tape, corruption, and local noncooperation."))
        series.add(Pelicula(titulo = "Dr. House", R.drawable.drhouse, R.drawable.househeader, sinopsis = "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try to cure complex and rare diseases from very ill ordinary people in the United States of America."))
        series.add(Pelicula(titulo = "Smallville", R.drawable.smallville, R.drawable.smallvilleheader, sinopsis = "The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions amongst colonials of Smallville. Interestingly, the boy has managed to downplay his acts of various heroic egresses in the past. They say he's either too fast or has a penchant for finding trouble. He was found by Martha and Jonathan Kent on the day of the Meteor Shower, and subsequently adopted. Clark's friend Lex Luthor, the only heir of Luthorcorp, has been secretly investigating grounds for Clark's outlandish valor. However, on the face of it, Clark just seems a normal boy who's slightly more secretive than usual."))

    }

    fun setGridViewHeight(gridView: GridView) {
        val adapter = gridView.adapter ?: return

        var totalHeight = 0
        val items = adapter.count
        val rows = ceil(items / 3.0).toInt()

        for (i in 0 until rows) {
            val listItem = adapter.getView(i, null, gridView)
            listItem.measure(0, 0)
            totalHeight += listItem.measuredHeight
        }

        val params = gridView.layoutParams
        params.height = totalHeight + (gridView.verticalSpacing * (rows - 1))
        gridView.layoutParams = params
        gridView.requestLayout()
    }


    private class PeliculaAdapter(context: Context, peliculas: ArrayList<Pelicula>) : BaseAdapter() {
        var peliculas: ArrayList<Pelicula> = peliculas
        var context: Context = context

        override fun getCount(): Int {
            return peliculas.size
        }

        override fun getItem(position: Int): Any {
            return peliculas[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val pelicula = peliculas[position]
            val inflater = LayoutInflater.from(context)
            val vista = convertView ?: inflater.inflate(R.layout.pelicula, parent, false)

            val ivPelicula: ImageView = vista.findViewById(R.id.iv_pelicula)
            val tvTitulo: TextView = vista.findViewById(R.id.tv_titulo)

            ivPelicula.setImageResource(pelicula.image)
            tvTitulo.text = pelicula.titulo

            vista.setOnClickListener {
                val intent = Intent(context, DetallePelicula::class.java)
                intent.putExtra("titulo", pelicula.titulo)
                intent.putExtra("imagen", pelicula.image)
                intent.putExtra("header", pelicula.header)
                intent.putExtra("sinopsis", pelicula.sinopsis)
                context.startActivity(intent)
            }

            return vista
        }
    }

}

