package com.dailyinvention.proximitylighting.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.dailyinvention.proximitylighting.R
import com.dailyinvention.proximitylighting.lib.timeFunctions
import kotlinx.android.synthetic.main.create_fragment.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.logging.SimpleFormatter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CreateFragment : Fragment() {
    //var createView: View = View(null, null)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.create_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewID: Int? = arguments?.getInt("viewID")
        val dateString: String? = arguments?.getString("dateString")

        if (viewID !== null && dateString !== null) {
            updateDateString(viewID, dateString)
        }

        start_time.setOnFocusChangeListener { v, hasFocus -> onFocus(v, hasFocus) }
        end_time.setOnFocusChangeListener { v, hasFocus -> onFocus(v, hasFocus) }
    }

    fun onFocus(v: View, hasFocus: Boolean) {
        // if field is in focus, generate time picker
        if (hasFocus) {
            val viewText = resources.getText(v.id).toString()
            val timePickerObj = TimePickerFragment()
            val bundleObj = Bundle()

            // send viewID key to time picker fragment as an argument
            bundleObj.putInt("viewID", v.id)
            timePickerObj.arguments = bundleObj

            timePickerObj.show(parentFragmentManager, viewText)
        }
    }

    fun updateDateString(viewID: Int, dateString: String) {
        val view: View? = view
        val dateField = view?.findViewById<EditText>(viewID)
        val formattedDateString: String =
            timeFunctions.convertMilitaryAndStandard(dateString, false)
        dateField?.hint = null
        dateField?.setText(formattedDateString)
    }

}
