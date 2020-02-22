package com.sample.popupfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.sample.commonui.base.popup.PopupFragment

abstract class PopupBindingFragment <OWNER_CALLBACK : Any, LAYOUT_BINDING : ViewDataBinding> : PopupFragment<OWNER_CALLBACK>() {

    abstract val layoutId : Int

    override val popupTheme = R.style.DialogTheme

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<LAYOUT_BINDING>(layoutInflater, layoutId, container, false)

        onBindingCreated(binding)

        return binding.root
    }

    abstract fun onBindingCreated(binding: LAYOUT_BINDING)
}