package edu.nmhu.bssd5250.sb_bssd5250_hw21


import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.widget.LinearLayoutCompat

import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var linearLayout: LinearLayoutCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Instantiate an ImageView and define its properties
        val r = makeButton("red")

        // Instantiate an ImageView and define its properties
        val b = makeButton("blue")

        // Create a ConstraintLayout in which to add the ImageView
        val redlinearLayout = LinearLayoutCompat(this).apply {
            setBackgroundColor(Color.GRAY)
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            // Add the ImageView to the layout.
            addView(r)  //add the red image
        }

        // Create a ConstraintLayout in which to add the ImageView
        val bluelinearLayout = LinearLayoutCompat(this).apply {
            setBackgroundColor(Color.GREEN)
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            // Add the ImageView to the layout.
            addView(b)  //add the blue image
        }


        // Create a ConstraintLayout in which to add the ImageView
        linearLayout = LinearLayoutCompat(this).apply {
            setBackgroundColor(Color.BLUE)
            orientation = LinearLayoutCompat.VERTICAL
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
            // Add the ImageView to the layout.
            addView(redlinearLayout)
            addView(bluelinearLayout)
        }

        // Set the layout as the content view.
        setContentView(linearLayout)
    }

    fun makeButton(color:String):ImageButton {
        lateinit var button:ImageButton
        if(color == "red") {
            button = ImageButton(this).apply {
                setImageResource(R.drawable.red)
                background = null
                contentDescription = "Red Dot Image" //resources.getString(R.string.my_image_desc
                setOnClickListener {
                        //view -> (view.parent as LinearLayoutCompat).removeView(view)
                        view -> (view.parent as LinearLayoutCompat).addView(makeButton("blue"))
                }
                // set the ImageView bounds to match the Drawable's dimensions
                adjustViewBounds = true
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        } else { //must be blue
            button = ImageButton(this).apply {
                setImageResource(R.drawable.blue)
                background = null
                contentDescription = "Blue Dot Image" //resources.getString(R.string.my_image_desc)
                setOnClickListener {
                    (it.parent as LinearLayoutCompat).removeView(it) }

                // set the ImageView bounds to match the Drawable's dimensions
                adjustViewBounds = true
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                )
            }
        }
        return button
    }// end fun makeButton(color:String):ImageButton
}

