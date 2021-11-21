package com.example.fakenews.presentation.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.RadioButton
import androidx.core.view.isVisible
import com.example.fakenews.R
import com.example.fakenews.databinding.FragmentChooseFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChooseFilter : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentChooseFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_choose_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBinding(view)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("message", binding.groupRadio.checkedRadioButtonId)
    }

    private fun initBinding(view: View) {
        binding = FragmentChooseFilterBinding.bind(view).apply {
            groupRadio.setOnCheckedChangeListener { _, i ->
                when (i) {

                    R.id.radioButtonDefault -> {
                        itemClickListener?.invoke(
                            radioButtonDefault.text.toString(),
                            "Не имеет значения"
                        )
                        dismiss()
                    }

                    R.id.radioDate -> {
                        date.isVisible = true
                        selectFilter(radioDate, date)
                    }

                    R.id.radioAuthor -> {
                        author.isVisible = true
                        selectFilter(radioAuthor, author)
                    }

                    R.id.radioTopic -> {
                        topic.isVisible = true
                        selectFilter(radioTopic, topic)
                    }
                }
            }
        }
    }

    private fun selectFilter(checkedButton: RadioButton, filterConfig: EditText?) {
        filterConfig?.setOnEditorActionListener { _, i, _ ->
            if (i == EditorInfo.IME_ACTION_DONE) {
                itemClickListener?.invoke(
                    checkedButton.text.toString(),
                    filterConfig.text.toString()
                )
                filterConfig.visibility = View.GONE
                dismiss()
            }
            return@setOnEditorActionListener false
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            setOnShowListener {
                val bottomSheet =
                    findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout
                bottomSheet.setBackgroundResource(android.R.color.transparent)
            }
        }
    }

    companion object {
        const val TAG = "ChooseFilter"

        @JvmStatic
        fun newInstance() = ChooseFilter()
    }

    private var itemClickListener: ((String, String) -> Unit)? = null

    fun setItemClickListener(listener: ((String, String) -> Unit)) {
        itemClickListener = listener
    }
}