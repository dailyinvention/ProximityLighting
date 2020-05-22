package com.dailyinvention.proximitylighting.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Context
import android.os.Bundle
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    // used to pass back to original field
    var viewID: Int = 0
    var listener: SetDateValuesListener? = object : SetDateValuesListener {
        override fun onSetDateValues(viewID: Int, dateString: String) { /*...*/
        }
    }

    interface SetDateValuesListener {
        fun onSetDateValues(viewID: Int, dateString: String)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // get the current date
        val currentDate = Calendar.getInstance()
        val hour = currentDate.get(Calendar.HOUR_OF_DAY)
        val minute = currentDate.get(Calendar.MINUTE)

        // set view id from arguments
        viewID = requireArguments().getInt("viewID")

        // generate time picker set to the current time in fields
        return TimePickerDialog(
            activity,
            android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth,
            this,
            hour,
            minute,
            false
        )
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        val timeString = "$hourOfDay:$minute"
        listener?.onSetDateValues(viewID, timeString)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? SetDateValuesListener
        if (listener == null) {
            throw ClassCastException("$context must implement SetDateValuesListener")
        }
    }
}