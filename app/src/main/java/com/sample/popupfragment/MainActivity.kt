package com.sample.popupfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), HelloWorldPopupFragment.HelloWorldPopupCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { HelloWorldPopupFragment.show(this) }
    }

    override fun onHelloClicked() {
        Snackbar.make(fab, "Hello world!!!", Snackbar.LENGTH_LONG).show()
    }

    override fun onGoodbyeClicked() {
        Snackbar.make(fab, "Goodbye world!!!", Snackbar.LENGTH_LONG).show()
    }
}
