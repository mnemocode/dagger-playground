package com.marcosholgado.daggerplayground

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.marcosholgado.core.ExpensiveObject
import com.marcosholgado.core.di.CoreInjectHelper
import com.marcosholgado.daggerplayground.di.DaggerFeature2Component
import com.marcosholgado.mymodule.OtherActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var expensiveObject: ExpensiveObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerFeature2Component
            .builder()
            .coreComponent(CoreInjectHelper.provideCoreComponent(applicationContext))
            .build()
            .inject(this)

        button.setOnClickListener {
            startActivity(Intent(this, OtherActivity::class.java))
        }
    }
}
