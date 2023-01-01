package com.ardayildiz.courselist

    import android.content.Intent
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    import androidx.recyclerview.widget.LinearLayoutManager
    import androidx.recyclerview.widget.RecyclerView

    class MainActivity : AppCompatActivity() {


        private lateinit var recyclerView: RecyclerView
        private lateinit var courseList: ArrayList<Course>
        private lateinit var courseAdaptor: CourseAdaptor
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            recyclerView = findViewById(R.id.recyclerView)
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = LinearLayoutManager(this)

            courseList = ArrayList()

            courseList.add(Course(R.drawable.course1, "Doç. Dr. Aşkın Demirağ",))
            courseList.add(Course(R.drawable.course2, "Doç. Dr. Uğur T. Kaplancalı" ))
            courseList.add(Course(R.drawable.course3, "Dr. Öğr. Üyesi Manu Dube" ))
            courseList.add(Course(R.drawable.course4, "Dr. Öğr. Üyesi Tufan Ekin" ))
            courseList.add(Course(R.drawable.course5, "Dr. Öğr. Üyesi Engin Kandıran" ))
            courseList.add(Course(R.drawable.course6, "Dr. Öğr. Üyesi Aziz Tüter" ))

            courseAdaptor = CourseAdaptor(courseList)
            recyclerView.adapter = courseAdaptor

            courseAdaptor.onItemClick = {
                val intent = Intent(this,DetailedActivity::class.java)
                intent.putExtra("course", it)
                startActivity(intent)
            }

        }
}