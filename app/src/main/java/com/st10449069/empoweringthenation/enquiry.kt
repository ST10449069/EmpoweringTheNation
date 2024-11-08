package com.st10449069.empoweringthenation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class enquiry : AppCompatActivity() {

    private val servicePrices = mapOf(
        "First Aid" to 1500,
        "Sewing" to 1500,
        "Garden Maintenance" to 750,
        "Life Skills" to 1500,
        "Landscaping" to 1500,
        "Child Minding" to 750,
        "Cooking" to 750
    )

    private lateinit var etName: EditText
    private lateinit var etEmailAddress: EditText
    private lateinit var etPhoneNumber: EditText
    private lateinit var etStreet: EditText
    private lateinit var etSuburb: EditText
    private lateinit var etCity: EditText
    private lateinit var etPostalCode: EditText

    private lateinit var cbCourse1: CheckBox
    private lateinit var cbCourse2: CheckBox
    private lateinit var cbCourse3: CheckBox
    private lateinit var cbCourse4: CheckBox
    private lateinit var cbCourse5: CheckBox
    private lateinit var cbCourse6: CheckBox
    private lateinit var cbCourse7: CheckBox

    private lateinit var btnCalculate: Button
    private lateinit var btnClear: Button
    private lateinit var btnSubmit: Button
    private lateinit var tvQuotation: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etName = findViewById(R.id.etName)
        etEmailAddress = findViewById(R.id.etEmailAddress)
        etPhoneNumber = findViewById(R.id.etPhoneNumber)
        etStreet = findViewById(R.id.etStreet)
        etSuburb = findViewById(R.id.etSuburb)
        etCity = findViewById(R.id.etCity)
        etPostalCode = findViewById(R.id.etPostalCode)

        cbCourse1 = findViewById(R.id.cbCourse1)
        cbCourse2 = findViewById(R.id.cbCourse2)
        cbCourse3 = findViewById(R.id.cbCourse3)
        cbCourse4 = findViewById(R.id.cbCourse4)
        cbCourse5 = findViewById(R.id.cbCourse5)
        cbCourse6 = findViewById(R.id.cbCourse6)
        cbCourse7 = findViewById(R.id.cbCourse7)

        btnCalculate = findViewById(R.id.btnCalculate)
        tvQuotation = findViewById(R.id.tvQuotation)

        btnCalculate.setOnClickListener {
            calculateQuotation()
        }
    }

    private fun calculateQuotation() {
        val name = etName.text.toString()
        val email = etEmailAddress.text.toString()
        val phone = etPhoneNumber.text.toString()

        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill in all your details", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedCourses = mutableListOf<String>()
        var total = 0
        var courseCount = 0

        if (cbCourse1.isChecked) {
            selectedCourses.add("First Aid")
            total += servicePrices["First Aid"] ?: 0
            courseCount++
        }
        if (cbCourse2.isChecked) {
            selectedCourses.add("Sewing")
            total += servicePrices["Sewing"] ?: 0
            courseCount++
        }
        if (cbCourse3.isChecked) {
            selectedCourses.add("Garden Maintenance")
            total += servicePrices["Garden Maintenance"] ?: 0
            courseCount++
        }
        if (cbCourse4.isChecked) {
            selectedCourses.add("Life Skills")
            total += servicePrices["Life Skills"] ?: 0
            courseCount++
        }
        if (cbCourse5.isChecked) {
            selectedCourses.add("Landscaping")
            total += servicePrices["Landscaping"] ?: 0
            courseCount++
        }
        if (cbCourse6.isChecked) {
            selectedCourses.add("Child Minding")
            total += servicePrices["Child Minding"] ?: 0
            courseCount++
        }
        if (cbCourse7.isChecked) {
            selectedCourses.add("Cooking")
            total += servicePrices["Cooking"] ?: 0
            courseCount++
        }

        if (courseCount == 0) {
            Toast.makeText(this, "Please select at least one course", Toast.LENGTH_SHORT).show()
            return
        }

        // Apply discount based on number of courses
        val discountPercentage = when (courseCount) {
            1 -> 0.0
            2 -> 0.05
            3 -> 0.10
            else -> 0.15
        }

        val discount = total * discountPercentage
        val totalAfterDiscount = total - discount

        val vat = 0.15 * totalAfterDiscount
        val totalWithVAT = totalAfterDiscount + vat

        tvQuotation.text = """
            Name: $name
            Email: $email
            Phone: $phone
            Selected Courses: $selectedCourses
            Total before discount: $total
            Discount: ${discountPercentage * 100}%
            Total after discount: $totalAfterDiscount
            VAT (15%): $vat
            Total (incl. VAT): $totalWithVAT
        """.trimIndent()

        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val email = etEmailAddress.text.toString()
            val phone = etPhoneNumber.text.toString()
            val street = etStreet.text.toString()
            val suburb = etSuburb.text.toString()
            val city = etCity.text.toString()
            val postalCode = etPostalCode.text.toString()

            btnClear.setOnClickListener {
                etName.text.clear()
                etEmailAddress.text.clear()
                etPhoneNumber.text.clear()
                etStreet.text.clear()
                etSuburb.text.clear()
                etCity.text.clear()
                etPostalCode.text.clear()
            }
        }
    }
}