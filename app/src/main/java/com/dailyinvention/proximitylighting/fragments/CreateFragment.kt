package com.dailyinvention.proximitylighting.fragments

import android.app.DatePickerDialog
import android.content.Context
import android.nfc.Tag
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.FragmentActivity
import com.dailyinvention.proximitylighting.R
import com.dailyinvention.proximitylighting.model.GetHueGroups
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.create_fragment.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CreateFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.create_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startTime.setOnFocusChangeListener { v, hasFocus -> onFocus(v, hasFocus) }
        endTime.setOnFocusChangeListener { v, hasFocus -> onFocus(v, hasFocus) }
    }

    fun onFocus(v: View, hasFocus: Boolean) {
        // if field is in focus, generate time picker
        if (hasFocus) {
            val viewID = resources.getResourceName(v.id)
            val viewText = resources.getText(v.id).toString()
            val timePickerObj = TimePickerFragment()
            val bundleObj = Bundle()

            // send viewID key to time picker fragment as an argument
            bundleObj.putString("viewID", viewID)
            timePickerObj.arguments = bundleObj

            timePickerObj.show(parentFragmentManager, viewText)
        }
    }

}
