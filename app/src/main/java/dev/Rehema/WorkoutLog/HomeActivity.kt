package dev.Rehema.WorkoutLog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dev.Rehema.WorkoutLog.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleclicks()
        setupBottomNav()
    }
    fun handleclicks(){
//        bnvHome=findViewById(R.id.bottom_navigation)
//        fcvHome=findViewById(R.id.fcvHome)
    }
    fun setupBottomNav(){
        binding.bottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.plan->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, PlanFragment()).commit()
                    true
                }
                R.id.track->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, TrackFragment()).commit()
                    true
                }
                R.id.profile->{
                    supportFragmentManager.beginTransaction().replace(R.id.fcvHome, ProfileFragment()).commit()
                    true
                }
                else-> false
            }
        }

    }
}