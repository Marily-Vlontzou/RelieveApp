package ntua.hci.relieveapp.ui.addpoint

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AddpointViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is add point Fragment"
    }
    val text: LiveData<String> = _text
}