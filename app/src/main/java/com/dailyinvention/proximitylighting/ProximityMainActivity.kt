package com.dailyinvention.proximitylighting

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.NavHostFragment
import com.dailyinvention.proximitylighting.fragments.CreateFragment
import com.dailyinvention.proximitylighting.fragments.TimePickerFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class ProximityMainActivity : AppCompatActivity(), TimePickerFragment.SetDateValuesListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        addContextAction.setOnClickListener {
            NavHostFragment.findNavController(nav_host_fragment).navigate(R.id.action_Hide_Show_Create)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSetDateValues(viewID: Int, dateString: String) {

        val createFragment: CreateFragment? =
            supportFragmentManager.findFragmentById(R.id.create_fragment) as CreateFragment?
        // Call a method in the ArticleFragment to update its content

        if (createFragment != null) {
            // If article frag is available, we're in two-pane layout...

            // Call a method in the ArticleFragment to update its content
            createFragment.updateDateString(viewID, dateString)
        } else {
            // If the frag is not available, we're in the one-pane layout and must swap frags...

            // Create fragment and give it an argument for the selected article
            val newFragment = CreateFragment()
            val args = Bundle()
            args.putInt("viewID", viewID)
            args.putString("dateString", dateString)
            newFragment.setArguments(args)
            val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()

            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.create_fragment, newFragment)
            transaction.addToBackStack(null)

            // Commit the transaction
            transaction.commit()
        }
    }
}
