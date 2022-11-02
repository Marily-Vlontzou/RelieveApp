package ntua.hci.relieveapp.ui.recycling

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ntua.hci.relieveapp.R

class RecyclingFragment : Fragment() {

    private lateinit var recyclingViewModel: RecyclingViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        recyclingViewModel =
                ViewModelProvider(this).get(RecyclingViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_recycling, container, false)

        return root
    }
}