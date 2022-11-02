package ntua.hci.relieveapp.ui.addpoint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ntua.hci.relieveapp.R

class AddpointFragment : Fragment() {

    private lateinit var addpointViewModel: AddpointViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        addpointViewModel =
                ViewModelProvider(this).get(AddpointViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_addpoint, container, false)

        return root
    }
}