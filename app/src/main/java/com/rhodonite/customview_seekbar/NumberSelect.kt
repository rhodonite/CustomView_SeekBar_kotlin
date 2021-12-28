package com.rhodonite.customview_seekbar

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.Button

class NumberSelect : LinearLayout {
    var addButton: Button? = null
    var minusButton: Button? = null
    var valueTextView: TextView? = null
    private var minValue = 0
    private var maxValue = 0
    private var defaultValue = 0
    private var textValue = 0

    interface NumberSelectListener {
        fun onValueChange(value: Int)
    }

    private var listener: NumberSelectListener? = null

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
        inflate(context, R.layout.numberselect, this)
        descendantFocusability = FOCUS_BLOCK_DESCENDANTS
        addButton = findViewById<View>(R.id.addButton) as Button
        minusButton = findViewById<View>(R.id.minusButton) as Button
        valueTextView = findViewById<View>(R.id.valueTextView) as TextView
        textValue = 0
        maxValue = Int.MAX_VALUE
        minValue = 0
        if (attrs != null) {
            val attributes = context.theme.obtainStyledAttributes(
                    attrs,
                    R.styleable.NumberSelect,
                    0, 0)
            maxValue = attributes.getInt(R.styleable.NumberSelect_max_value, maxValue)
            minValue = attributes.getInt(R.styleable.NumberSelect_min_value, minValue)
            defaultValue = attributes.getInt(R.styleable.NumberSelect_default_value, 0)
            valueTextView!!.text = defaultValue.toString()
        }
        addButton!!.setOnClickListener {
            addTextValue()
            if (listener != null) {
                listener!!.onValueChange(textValue)
            }
        }
        minusButton!!.setOnClickListener {
            minusTextValue()
            if (listener != null) {
                listener!!.onValueChange(textValue)
            }
        }
    }

    fun setMaxValue(value: Int) {
        maxValue = value
    }

    fun setMinValue(value: Int) {
        minValue = value
    }

    fun setDefaultValue(value: Int) {
        defaultValue = value
        valueTextView!!.text = defaultValue.toString()
        textValue = valueTextView!!.text.toString().toInt()
    }

    private fun addTextValue() {
        textValue = valueTextView!!.text.toString().toInt()
        if (textValue < maxValue) {
            textValue++
            valueTextView!!.text = textValue.toString()
        }
    }

    private fun minusTextValue() {
        textValue = valueTextView!!.text.toString().toInt()
        if (textValue > minValue) {
            textValue--
            valueTextView!!.text = textValue.toString()
        }
    }

    fun setListener(listener: NumberSelectListener?) {
        this.listener = listener
    }
}