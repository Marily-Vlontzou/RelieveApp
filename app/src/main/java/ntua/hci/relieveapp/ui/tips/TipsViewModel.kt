package ntua.hci.relieveapp.ui.tips

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TipsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Recycling processes today recover approximately 25% to 96% of the materials of a lithium-ion battery cell, depending on the separation technology.\n" +
                "\n" +
                "These steps you need to take are:\n" +
                "\n" +
                "•Deactivation or discharging of the battery (especially in case of batteries from electric vehicles)\n" +  "\n" +
                "•Disassembly of battery systems (especially in case of batteries from electric vehicles)\n" + "\n" +
                "•Mechanical processes (including crushing, sorting, and sieving processes)\n" + "\n" +
                "•Electrolyte recovery\n" + "\n" +
                "•Hydrometallurgical processes\n" + "\n" +
                "•Pyrometallurgical processes\n"}
    val text: LiveData<String> = _text

    private val _text2 = MutableLiveData<String>().apply {
        value = "Electronic waste (sometimes called e-waste) is a term used to describe electronics that are nearing the end of their useful life and are discarded, donated, or recycled. \n\n" +
                "•Cellphones: Restore your phone to factory settings to remove all your personal information. \n\n" +
                "•Computers: First, remove all data from your desktop or laptop computer. Unplug your keyboard, speakers, camera or any other accessories. \n\n" +
                "•Small appliances: Unplug the appliance and tie or tape the cord so you don’t trip while carrying the item."}
    val text2: LiveData<String> = _text2

    private val _text3 = MutableLiveData<String>().apply {
        value = "•Every clothing item or piece of linen should be inspected for rips or tears missing buttons, broken zippers, and stains.\n" + "\n"+
                "•Dry clean or wash everything and treat any stains before donating.\n" + "\n"+
                "•Check all the pockets, especially in purses and wallets.\n" + "\n"+
                "•Shoes should be in good condition, clean, and given in pairs.\n" + "\n"+
                "•Donate clothing that can be distributed during that season."}
    val text3: LiveData<String> = _text3
    }

