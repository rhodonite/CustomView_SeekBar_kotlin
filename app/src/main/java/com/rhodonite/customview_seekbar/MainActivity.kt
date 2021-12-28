package com.rhodonite.customview_seekbar

import androidx.appcompat.app.AppCompatActivity
import com.rhodonite.customview_seekbar.NumberSelect
import com.rhodonite.customview_seekbar.CustomView_4SeekBar
import android.os.Bundle
import android.util.Log
import android.view.View
import com.rhodonite.customview_seekbar.R
import com.rhodonite.customview_seekbar.NumberSelect.NumberSelectListener
import com.rhodonite.customview_seekbar.CustomView_4SeekBar.CustomView_4SeekBarListener

class MainActivity : AppCompatActivity() {
    private var numberSelect: NumberSelect? = null
    private var customView4SeekBar: CustomView_4SeekBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numberSelect = findViewById<View>(R.id.number_select) as NumberSelect
        customView4SeekBar = findViewById<View>(R.id.customView_4SeekBar) as CustomView_4SeekBar
        numberSelect!!.setListener(object :NumberSelectListener{
            override fun onValueChange(value: Int) {
                Log.d("onTopRightSeekValueChange", value.toString())
            }
        })

        customView4SeekBar!!.setListener(object : CustomView_4SeekBarListener {
            override fun onTopRightSeekValueChange(value: Int) {
                Log.d("onTopRightSeekValueChange", value.toString())
            }

            override fun onTopLeftSeekValueChange(value: Int) {
                Log.d("onTopLeftSeekValueChange", value.toString())
            }

            override fun onBottomRightSeekValueChange(value: Int) {
                Log.d("onBottomRightSeekValueChange", value.toString())
            }

            override fun onBottomLeftSeekValueChange(value: Int) {
                Log.d("onBottomLeftSeekValueChange", value.toString())
            }
        })
    }
}