package com.sample.popupfragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.sample.popupfragment.databinding.PopupFragmentHelloWorldBinding

class HelloWorldPopupFragment : PopupBindingFragment<HelloWorldPopupFragment.HelloWorldPopupCallback, PopupFragmentHelloWorldBinding>() {

    override val layoutId = R.layout.popup_fragment_hello_world

    override fun onBindingCreated(binding: PopupFragmentHelloWorldBinding) {
        binding.clWindow.setOnClickListener {
            dismiss()
        }

        binding.bYes.setOnClickListener {
            callback.onHelloClicked()
            dismiss()
        }
        binding.bNo.setOnClickListener {
            callback.onGoodbyeClicked()
            dismiss()
        }
    }

    interface HelloWorldPopupCallback {
        fun onHelloClicked()
        fun onGoodbyeClicked()
    }

    companion object {
        fun show(popupOwner: Fragment) {
            HelloWorldPopupFragment().showPopup(popupOwner)
        }

        fun show(popupOwner: FragmentActivity) {
            HelloWorldPopupFragment().showPopup(popupOwner)
        }
    }
}