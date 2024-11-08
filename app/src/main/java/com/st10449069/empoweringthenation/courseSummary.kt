package com.st10449069.empoweringthenation

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class courseSummary : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val courseDetailsTextView = findViewById<TextView>(R.id.tvCourseDetails)

        val spannableString = SpannableString(
            "Empowering the Nation offers the following six-month courses:\n• First Aid\n• Sewing\n• Landscaping\n• Life Skills\n\nThe six-week short courses are:\n• Child minding\n• Cooking\n• Garden maintenance"
        )

        val firstAidClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {

                val intent = Intent(this@courseSummary, MainActivity2::class.java)
                startActivity(intent)
            }
        }

        val sewingClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@courseSummary, MainActivity3::class.java)
                startActivity(intent)
            }
        }

        val landscapingClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@courseSummary, MainActivity4::class.java)
                startActivity(intent)
            }
        }

        val lifeSkillsClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@courseSummary, MainActivity5::class.java)
                startActivity(intent)
            }
        }

        val childMindingClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@courseSummary, MainActivity6::class.java)
                startActivity(intent)
            }
        }

        val cookingClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@courseSummary, MainActivity7::class.java)
                startActivity(intent)
            }
        }

        val gardenMaintenanceClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                val intent = Intent(this@courseSummary, MainActivity8::class.java)
                startActivity(intent)
            }
        }

        spannableString.setSpan(firstAidClickableSpan, 55, 65, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(sewingClickableSpan, 67, 73, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(landscapingClickableSpan, 75, 86, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(lifeSkillsClickableSpan, 88, 98, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(childMindingClickableSpan, 138, 151, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(cookingClickableSpan, 153, 160, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(gardenMaintenanceClickableSpan, 162, 180, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        courseDetailsTextView.text = spannableString
        courseDetailsTextView.movementMethod = LinkMovementMethod.getInstance()
    }
}