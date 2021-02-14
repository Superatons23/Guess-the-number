package mx.edu.itson.guessthenumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var valorMInimo =0
    var valorMaximo =100
    var num:Int=0
    var won= false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val guessings: TextView = findViewById(R.id.guessings)
        val down: Button= findViewById(R.id.down)
        val up:Button=findViewById(R.id.up)
        val generate: Button=findViewById(R.id.generate)
        val guessed:Button =findViewById(R.id.guessed)

        generate.setOnClickListener {
            num = Random.nextInt(valorMInimo,valorMaximo)
            guessings.setText(num.toString())
            generate.visibility= View.INVISIBLE
            guessed.visibility=View.VISIBLE

        }
        up.setOnClickListener {
            valorMInimo=num
            if (checkingLimits()) {
                num = Random.nextInt(valorMInimo, valorMaximo)
                guessings.setText(num.toString())
            }else{
                guessings.setText("damn")
            }
        }

        down.setOnClickListener {
            valorMaximo=num
            if (checkingLimits()){
                num=Random.nextInt(valorMInimo,valorMaximo)
                guessings.setText(num.toString())
            }else{
                guessings.setText("damn")
            }
        }

        guessed.setOnClickListener {
            if(!won){
                guessings.setText("Tu numero es "+num)
                guessed.setText("jugar de nuevo")
                won=true
            }else{
                generate.visibility=View.VISIBLE
                generate.setText("toque 'generar' para empezar")
                guessed.setText("Adivinado")
                guessed.visibility=View.GONE
                valorMInimo=0
                valorMaximo=100
                num=0
                won=false
            }

        }
    }

    fun checkingLimits():Boolean{
        return valorMInimo!=valorMaximo
    }
}

