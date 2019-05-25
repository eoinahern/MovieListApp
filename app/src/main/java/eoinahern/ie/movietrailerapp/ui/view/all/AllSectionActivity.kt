package eoinahern.ie.movietrailerapp.ui.view.all

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.android.AndroidInjection
import eoinahern.ie.movietrailerapp.R
import eoinahern.ie.movietrailerapp.util.ViewModelFactory
import javax.inject.Inject

class AllSectionActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
         AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_section)
    }
}
