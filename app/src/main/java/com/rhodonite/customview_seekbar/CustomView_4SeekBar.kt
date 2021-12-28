package com.rhodonite.customview_seekbar

import android.content.Context
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.SeekBar
import com.rhodonite.customview_seekbar.CustomView_4SeekBar.CustomView_4SeekBarListener
import com.rhodonite.customview_seekbar.R
import android.view.ViewGroup
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.SeekBar.OnSeekBarChangeListener

class CustomView_4SeekBar : RelativeLayout {
    var titleTextView: TextView? = null
    var leftTopSeekbar: SeekBar? = null
    var rightTopSeekbar: SeekBar? = null
    var leftBottomSeekbar: SeekBar? = null
    var rightBottomSeekbar: SeekBar? = null
    private val isLeftButtonOnOff = true
    private val isRightButtonOnOff = true
    private var defaultValue = 0
    private var maxValue = 0
    private var titleText: String? = null
    private var isSeekBarOnTouch = false

    interface CustomView_4SeekBarListener {
        fun onTopRightSeekValueChange(value: Int)
        fun onTopLeftSeekValueChange(value: Int)
        fun onBottomRightSeekValueChange(value: Int)
        fun onBottomLeftSeekValueChange(value: Int)
    }

    private var listener: CustomView_4SeekBarListener? = null

    constructor(context: Context) : super(context) {
        init(context, null)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        inflate(context, R.layout.customview_4seekbar, this)
        descendantFocusability = FOCUS_BLOCK_DESCENDANTS
        titleTextView = findViewById<View>(R.id.tv_title) as TextView
        leftTopSeekbar = findViewById<View>(R.id.sb_left) as SeekBar
        rightTopSeekbar = findViewById<View>(R.id.sb_right) as SeekBar
        leftBottomSeekbar = findViewById<View>(R.id.sb_left_1) as SeekBar
        rightBottomSeekbar = findViewById<View>(R.id.sb_right_1) as SeekBar
        maxValue = 20
        titleText = "Title"
        defaultValue = 0
        if (attrs != null) {
            val attributes = context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.CustomSelect,
                    0, 0)
            maxValue = attributes.getInt(R.styleable.CustomSelect_max_value_, maxValue)
            defaultValue = attributes.getInt(R.styleable.CustomSelect_default_value_, 0)
            titleText = attributes.getString(R.styleable.CustomSelect_Title)
            leftTopSeekbar!!.max = maxValue
            leftTopSeekbar!!.progress = defaultValue
            rightTopSeekbar!!.max = maxValue
            rightTopSeekbar!!.progress = defaultValue
            rightBottomSeekbar!!.max = maxValue
            rightBottomSeekbar!!.progress = defaultValue
            titleTextView!!.text = titleText
        }
        leftTopSeekbar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (isSeekBarOnTouch) if (listener != null) listener!!.onTopLeftSeekValueChange(i)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                isSeekBarOnTouch = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (isSeekBarOnTouch) {
                    /* if (listener != null)
                        listener.onLeftSeekValueChange(leftSeekbar.getProgress());*/
                    isSeekBarOnTouch = false
                }
            }
        })
        rightTopSeekbar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (isSeekBarOnTouch) if (listener != null) listener!!.onTopRightSeekValueChange(i)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                isSeekBarOnTouch = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (isSeekBarOnTouch) {
                    /*if (listener != null)
                        listener.onRightSeekValueChange(rightSeekbar.getProgress());*/
                    isSeekBarOnTouch = false
                }
            }
        })
        leftBottomSeekbar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (isSeekBarOnTouch) if (listener != null) listener!!.onBottomLeftSeekValueChange(i)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                isSeekBarOnTouch = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (isSeekBarOnTouch) {
                    /* if (listener != null)
                        listener.onLeftSeekValueChange(leftSeekbar.getProgress());*/
                    isSeekBarOnTouch = false
                }
            }
        })
        rightBottomSeekbar!!.setOnSeekBarChangeListener(object : OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (isSeekBarOnTouch) if (listener != null) listener!!.onBottomRightSeekValueChange(i)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                isSeekBarOnTouch = true
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                if (isSeekBarOnTouch) {
                    /*if (listener != null)
                        listener.onRightSeekValueChange(rightSeekbar.getProgress());*/
                    isSeekBarOnTouch = false
                }
            }
        })
    }

    fun setRightTopSeekbar(value: Int) {
        rightTopSeekbar!!.progress = value
    }

    fun setLeftTopSeekbar(value: Int) {
        leftTopSeekbar!!.progress = value
    }

    fun setRightBottomSeekbar(value: Int) {
        rightBottomSeekbar!!.progress = value
    }

    fun setLeftBottomSeekbar(value: Int) {
        leftBottomSeekbar!!.progress = value
    }

    fun setListener(listener: CustomView_4SeekBarListener?) {
        this.listener = listener
    }
}