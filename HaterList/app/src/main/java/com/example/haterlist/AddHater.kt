package com.example.haterlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.view.isVisible
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddHater : AppCompatActivity() {

    //db as firebase realtime database
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_hater)

        //path for firebase reference
        var path: String = ""

        //to notify user which category it's about to add
        intent?.extras?.let {
            findViewById<TextView>(R.id.category_to_add).text = "Add new one to " + it.get("category").toString()
            path = it.get("category").toString()
        }

        //page back button
        findViewById<ImageButton>(R.id.page_back).setOnClickListener {
            finish()
        }

        //input sections
        val hater_name = findViewById<EditText>(R.id.hater_name)
        val hater_phone = findViewById<EditText>(R.id.hater_phone)
        val comment = findViewById<EditText>(R.id.comment)
        val input_sections = arrayListOf(hater_name, hater_phone, comment)

        //stars
        val star1 = findViewById<ImageView>(R.id.star1)
        val star2 = findViewById<ImageView>(R.id.star2)
        val star3 = findViewById<ImageView>(R.id.star3)
        val star4 = findViewById<ImageView>(R.id.star4)
        val star5 = findViewById<ImageView>(R.id.star5)
        val stars = arrayListOf(star1, star2, star3, star4, star5)

        //score buttons
        val score1 = findViewById<Button>(R.id.b1)
        val score2 = findViewById<Button>(R.id.b2)
        val score3 = findViewById<Button>(R.id.b3)
        val score4 = findViewById<Button>(R.id.b4)
        val score5 = findViewById<Button>(R.id.b5)
        val score_buttons = arrayListOf(score1, score2, score3, score4, score5)

        //when score button clicked, a variable store the score, and turn on/off the stars
        var score: Int = 0
        score1.setOnClickListener {
            score = 1
            stars[0].isVisible = true
            for(i in 1..4)
                stars[i].isVisible = false
        }

        score2.setOnClickListener {
            score = 2
            for(i in 0..1)
                stars[i].isVisible = true
            for(i in 2..4)
                stars[i].isVisible = false
        }

        score3.setOnClickListener {
            score = 3
            for(i in 0..2)
                stars[i].isVisible = true
            for(i in 3..4)
                stars[i].isVisible = false
        }

        score4.setOnClickListener {
            score = 4
            for(i in 0..3)
                stars[i].isVisible = true
            stars[4].isVisible = false
        }

        score5.setOnClickListener {
            score = 5
            for(i in 0..4)
                stars[i].isVisible = true
        }

        //report button
        findViewById<ImageButton>(R.id.report_button).setOnClickListener {
            when {
                //show message,
                //if name < 2 or phone < 10, show error message, else show success message
                hater_name.length() < 2 -> showToast("Name form invalid.")
                hater_phone.length() != 10 -> showToast("Phone form invalid.")
                else -> {
                    //upload data to firebase
                    db = FirebaseDatabase.getInstance().getReference(path)
                    val hater = Hater(hater_name.text.toString(), hater_phone.text.toString(), score, comment.text.toString())
                    db.child("all").push().setValue(hater)
                    db.child(hater_name.text.toString()).child(hater_phone.text.toString()).push().setValue(hater)
                    showToast("Congratulations, you shoot a hater.")

                    //clear all input sections
                    for(i in input_sections) {
                        i.text.clear()
                    }

                    //turn off all stars
                    for(i in 0..4) {
                        stars[i].isVisible = false
                    }
                }
            }
        }
    }

    //Toast function to show "you got a hater"
    private fun showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}