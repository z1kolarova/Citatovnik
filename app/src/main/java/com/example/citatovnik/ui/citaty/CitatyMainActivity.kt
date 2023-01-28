package com.example.citatovnik.ui.citaty

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.citatovnik.data.Citat
import com.example.citatovnik.databinding.ActivityMainCitatyBinding
import com.example.citatovnik.utilities.InjectorUtils

class CitatyMainActivity : AppCompatActivity() {

    /*private lateinit var binding: ActivityMainBinding*/

    // pridano
    private lateinit var viewModel: CitatyViewModel
    // konec pridano

    private lateinit var binding: ActivityMainCitatyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCitatyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        inicializujUI()

        /*binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)*/
    }

    private fun inicializujUI(){
        val factory = InjectorUtils.dejCitatyViewModelFactory()

        //val factory = ViewModelProvider.AndroidViewModelFactory(application)
        viewModel = ViewModelProvider(this, factory).get(CitatyViewModel::class.java)

        viewModel.vratCitaty().observe(this, Observer { citaty ->
            val stringBuilder = StringBuilder()
            for (citat in citaty) {
                stringBuilder.append("$citat\n\n")
            }
            binding.textViewCitaty.text = stringBuilder.toString()
        })

        binding.btnPridatCitat.setOnClickListener{
            val citat = Citat(binding.editTextCitat.text.toString(), binding.editTextAutor.text.toString())
            viewModel.pridejCitat(citat)
            binding.editTextCitat.setText("")
            binding.editTextAutor.setText("")
        }
    }
}