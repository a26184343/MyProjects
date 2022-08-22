package com.example.haterlist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class CategoryView : AppCompatActivity() {
    //recycler view adapter
    private lateinit var adapter: HaterAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null

    //arraylist to store hater data
    var haterArray = ArrayList<Hater>()

    //restore category name for adding new hater
    private lateinit var category: String

    //firebase
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category_view)

        //set title category name
        intent?.extras?.let {
            findViewById<TextView>(R.id.category_name).text = it.get("category").toString()
            category = it.get("category").toString()
        }

        //page back button
        findViewById<ImageButton>(R.id.page_back).setOnClickListener {
            finish()
        }

        //get haters data
        db = FirebaseDatabase.getInstance().getReference()
        db.child(category).child("all").addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                haterArray.clear()
                for(postSnapshot in snapshot.children) {
                    val h = postSnapshot.getValue(Hater::class.java)
                    haterArray.add(h!!)
                }
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        //recycler view settings
        layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.hater_page).layoutManager = layoutManager
        adapter = HaterAdapter(this, haterArray, category)
        findViewById<RecyclerView>(R.id.hater_page).adapter = adapter

        //go report page
        findViewById<ImageButton>(R.id.report).setOnClickListener {
            var i = Intent(this, AddHater::class.java)
            i.putExtra("category", category)
            startActivity(i)
        }
    }
}