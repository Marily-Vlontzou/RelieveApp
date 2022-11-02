package ntua.hci.relieveapp.ui.tips

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ntua.hci.relieveapp.R
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast

class TipsFragment : Fragment() {

    var batteries: RadioButton? = null
    var electronic: RadioButton? = null
    var clothes: RadioButton? = null
    //var selectedSuperStar: String? = null
    var tell_me: Button? = null

    private lateinit var tipsViewModel: TipsViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        tipsViewModel =
                ViewModelProvider(this).get(TipsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_tips, container, false)
        val textView1: TextView = root.findViewById(R.id.text_battery_tips)
        val textView2: TextView = root.findViewById(R.id.text_elec_tips)
        val textView3: TextView = root.findViewById(R.id.text_clothes_tips)
        val textView4: TextView = root.findViewById(R.id.text_howtobat)
        val imageView1: ImageView = root.findViewById(R.id.imageView_bat)
        val textView5: TextView = root.findViewById(R.id.text_howtoelec)
        val textView6: TextView = root.findViewById(R.id.text_howtoclothes)
        val imageView2: ImageView = root.findViewById(R.id.imageView_elec)
        val imageView3: ImageView = root.findViewById(R.id.imageView_clothes)

        batteries = root.findViewById<View>(R.id.radioButton_bat) as RadioButton
        electronic = root.findViewById<View>(R.id.radioButton_elec) as RadioButton
        clothes = root.findViewById<View>(R.id.radioButton_clothes) as RadioButton
        tell_me = root.findViewById<View>(R.id.button_tellme) as Button

        textView4.visibility = View.GONE
        textView5.visibility = View.GONE
        textView6.visibility = View.GONE
        imageView1.visibility = View.GONE
        imageView2.visibility = View.GONE
        imageView3.visibility = View.GONE

        tell_me!!.setOnClickListener {

            if (batteries!!.isChecked) {
                textView1.visibility = View.VISIBLE
                textView4.visibility = View.VISIBLE
                imageView1.visibility = View.VISIBLE
                imageView2.visibility = View.GONE
                imageView3.visibility = View.GONE
                textView2.visibility = View.GONE
                textView3.visibility = View.GONE
                textView5.visibility = View.GONE
                textView6.visibility = View.GONE
                tipsViewModel.text.observe(viewLifecycleOwner, Observer {
                    textView1.text = it
                })

                //selectedSuperStar = batteries!!.text.toString()
            } else if (electronic!!.isChecked) {
                textView1.visibility = View.GONE
                textView2.visibility = View.VISIBLE
                textView3.visibility = View.GONE
                textView4.visibility = View.GONE
                imageView1.visibility = View.GONE
                imageView2.visibility = View.VISIBLE
                imageView3.visibility = View.GONE
                textView5.visibility = View.VISIBLE
                textView6.visibility = View.GONE
                tipsViewModel.text2.observe(viewLifecycleOwner, Observer {
                    textView2.text = it
                })
                //selectedSuperStar = electronic!!.text.toString()
            } else if (clothes!!.isChecked) {
                textView1.visibility = View.GONE
                textView2.visibility = View.GONE
                textView3.visibility = View.VISIBLE
                textView4.visibility = View.GONE
                imageView1.visibility = View.GONE
                imageView2.visibility = View.GONE
                imageView3.visibility = View.VISIBLE
                textView5.visibility = View.GONE
                textView6.visibility = View.VISIBLE
                tipsViewModel.text3.observe(viewLifecycleOwner, Observer {
                    textView3.text = it
                })
                //selectedSuperStar = clothes!!.text.toString()
            }
            //Toast.makeText(context, selectedSuperStar, Toast.LENGTH_LONG).show() // print the value of selected super star
        }

       /* val radioGroup: RadioGroup = root.findViewById(R.id.radio_group)
        val button: Button = root.findViewById(R.id.button_tellme)*/
        /*button.setOnClickListener{
            val intSelectedButton: Int = radioGroup!!.checkedRadioButtonId
            val radioButton: RadioButton = root.findViewById(intSelectedButton)
            Toast.makeText(context, radioButton.text, Toast.LENGTH_SHORT).show()
        }*/


       /*tipsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView1.text = it
        })
        tipsViewModel.text2.observe(viewLifecycleOwner, Observer {
            textView2.text = it
        }) */
        return root
    }


}



