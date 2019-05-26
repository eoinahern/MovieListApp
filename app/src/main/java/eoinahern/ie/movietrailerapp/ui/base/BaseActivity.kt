package eoinahern.ie.movietrailerapp.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import eoinahern.ie.movietrailerapp.util.ViewModelFactory
import javax.inject.Inject


abstract class BaseActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    override fun onCreate(siState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(siState)
        setContentView(getLayout())
    }

    inline fun <reified T : ViewModel> getViewModel(clazz: Class<T>): T {
        return ViewModelProviders.of(this, factory)[clazz]
    }


    abstract fun getLayout(): Int
}