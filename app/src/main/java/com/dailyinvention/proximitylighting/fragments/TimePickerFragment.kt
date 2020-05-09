package com.dailyinvention.proximitylighting.fragments

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.TextView
import android.widget.TimePicker
import androidx.fragment.app.DialogFragment
import java.util.*

class TimePickerFragment : DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // get the current date
        val currentDate = Calendar.getInstance()
        val hour = currentDate.get(Calendar.HOUR_OF_DAY)
        val minute = currentDate.get(Calendar.MINUTE)

        // generate time picker set to the current time
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
        //val viewObj:TextView = activity.findViewById()
    }
}