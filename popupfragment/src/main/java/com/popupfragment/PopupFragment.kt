package com.sample.commonui.base.popup

import android.os.Bundle
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * [OWNER_CALLBACK] has to be either [FragmentActivity] or [Fragment] as
 * they are used to rebind callbacks when [DialogFragment] is destroyed by AndroidOS.
 *
 * If you want to show multiple [PopupFragment]s of the same implementaion, you need to
 * override [isUniqueInFragmentManager] and return false.
 */
abstract class PopupFragment<OWNER_CALLBACK : Any> : DialogFragment() {
    private val REQUEST_CODE = 0
    protected lateinit var callback : OWNER_CALLBACK

    open val fragmentTag = "PopupFragment.${javaClass.name}"
    open val isUniqueInFragmentManager = true

    abstract val popupTheme : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupCallback()

        setStyle(STYLE_NO_FRAME, popupTheme)
    }

    private fun setupCallback() {
        callback = if(targetFragment != null) {
            targetFragment as OWNER_CALLBACK
        } else {
            requireActivity() as OWNER_CALLBACK
        }
    }

    fun showPopup(popupOwner: Fragment) {
        if (popupOwner.fragmentManager?.findFragmentByTag(fragmentTag) != null && isUniqueInFragmentManager) {
            return
        }

        setTargetFragment(popupOwner, REQUEST_CODE)

        popupOwner.fragmentManager?.let {
            show(it, fragmentTag)
        }
    }

    fun showPopup(popupOwner : FragmentActivity) {
        if (popupOwner.supportFragmentManager.findFragmentByTag(fragmentTag) != null && isUniqueInFragmentManager) {
            return
        }

        show(popupOwner.supportFragmentManager, fragmentTag)
    }
}