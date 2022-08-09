package com.example.haterlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class ViewComments : AppCompatActivity() {
    //store name & phone & category
    private var name: String = ""
    private var phone: String = ""
    private var category: String = ""

    //a variable to count the average stars
    public var sum: Int = 0
    public var times = 0

    //recycler view
    private lateinit var adapter: CommentAdapter
    private var layoutManager: RecyclerView.LayoutManager? = null

    //arraylist to store comment data
    var commentsList = ArrayList<Hater>()

    //average to store the average stars
    var average = 0

    //firebase
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_comments)

        intent?.extras?.let {
            name = it.get("name").toString()
            phone = it.get("phone").toString()
            category = it.get("category").toString()
        }
        findViewById<TextView>(R.id.comments_name).text = name
        findViewById<TextView>(R.id.comments_phone).text = phone



        //get comments data
        db = FirebaseDatabase.getInstance().getReference()
        db.child(category).child(name).child(phone).addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                commentsList.clear()
                for(postSnapshot in snapshot.children) {
                    val c = postSnapshot.getValue(Hater::class.java)
                    commentsList.add(c!!)
                }
                adapter.notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {

            }
        })

        //count average result
        //for(i in 0..commentsList.size - 1)
          //
        //  sum += commentsList[i].star!!
        //sum /= commentsList.size - 1
        //findViewById<TextView>(R.id.comments_star).text = sum.toString()

        //recycler view settings
        layoutManager = LinearLayoutManager(this)
        findViewById<RecyclerView>(R.id.comments).layoutManager = layoutManager
        adapter = CommentAdapter(this, commentsList)
        findViewById<RecyclerView>(R.id.comments).adapter = adapter
    }

    public fun add(sum: Int) {
        this.sum += sum
    }
}