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
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fakenews.R
import com.example.fakenews.databinding.FragmentChooseFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ChooseFilter : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "ChooseFilter"

        @JvmStatic
        fun newInstance() = ChooseFilter()
    }

    private  val binding by viewBinding(FragmentChooseFilterBinding::bind)
    private var itemClickListener: ((String, String) -> Unit)? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_choose_filter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFilter()
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


    fun setItemClickListener(listener: ((String, String) -> Unit)) {
        itemClickListener = listener
    }

    private fun initFilter() {
        binding.apply {
            groupRadio.setOnCheckedChangeListener { _, checkedButtonId ->
                when (checkedButtonId) {

                    R.id.radioButtonDefault -> {
                        itemClickListener?.invoke(
                            radioButtonDefault.text.toString(),
                            "Не имеет значения"
                        )
                        dismiss()
                    }

                    R.id.radioDate -> selectFilter(radioDate, date)

                    R.id.radioAuthor -> selectFilter(radioAuthor, author)

                    R.id.radioTopic -> selectFilter(radioTopic, topic)
                }
            }
        }
    }

    private fun selectFilter(checkedButton: RadioButton, filterConfig: EditText ) {
        filterConfig.isVisible = true
        filterConfig.setOnEditorActionListener { _, pressedButton, _ ->
            if (pressedButton == EditorInfo.IME_ACTION_DONE) {
                itemClickListener?.invoke(
                    checkedButton.text.toString(),
                    filterConfig.text.toString()
                )
                filterConfig.isVisible = false
                dismiss()
            }
            return@setOnEditorActionListener false
        }
    }
}