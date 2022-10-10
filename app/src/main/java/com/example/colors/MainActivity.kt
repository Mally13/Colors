package com.example.colors

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.color_creator_button)?.setOnClickListener{
            val redChannelText=
                findViewById<TextInputEditText>(R.id.red_channel)?.text.toString()
            val greenChanelText=
                findViewById<TextInputEditText>(R.id.green_channel)?.text.toString()
            val blueChannelText=
                findViewById<TextInputEditText>(R.id.blue_channel)?.text.toString()

            //check that all  fields are filled in
            if(redChannelText.isEmpty() or
                greenChanelText.isEmpty() or
                blueChannelText.isEmpty()){
                Toast.makeText(this,"All values are required", Toast.LENGTH_LONG).show()
            }else{
                //Check that 2 hexadecimal characters have been entered and if not add the same
                if(redChannelText.length == 1)
                    redChannelText.plus(redChannelText)

                if(greenChanelText.length ==1)
                    greenChanelText.plus(greenChanelText)

                if(blueChannelText.length == 1)
                    blueChannelText.plus(blueChannelText)


                val  colorToDisplay= redChannelText.plus(greenChanelText).plus(blueChannelText)
                val colorAsInt= Color.parseColor("#".plus(colorToDisplay))

                findViewById<TextView>(R.id.color_creator_display)?.setBackgroundColor(colorAsInt)
            }
        }
    }
}