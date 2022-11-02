package ntua.hci.relieveapp.ui.newsfeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ntua.hci.relieveapp.R

class NewsfeedFragment : Fragment() {

    private lateinit var newsfeedViewModel: NewsfeedViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        newsfeedViewModel =
                ViewModelProvider(this).get(NewsfeedViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_newsfeed, container, false)

        return root
    }
}