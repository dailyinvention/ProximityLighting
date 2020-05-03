package com.dailyinvention.proximitylighting.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.dailyinvention.proximitylighting.R
import com.dailyinvention.proximitylighting.model.GetHueGroups
/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val url = "https://192.168.1.118/api/aolDVxGXIEo5muHK1t-409nM9b8O-mfP114DU9gX/groups"
        GetHueGroups().execute(url)
    }
}
