package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var myData: PremiumMoel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myData= ViewModelProviders.of(this).get(PremiumMoel::class.java)
        display()
        calculate.setOnClickListener(){
            myData.premium=getPremium()
           // premiumOut.text ="%.2f".format(premium)
            display()
        }

        reset.setOnClickListener(){
            myData.premium=0.0
            spinner.setSelection(0)
            radioGroup.clearCheck()
            chkSmoker.setChecked(false)
            display()
        }

    }

    fun getPremium():Double{
        return when (spinner.selectedItemPosition){
            0-> 60.00
            1-> 70.00 +
                    (if(male.isChecked) 50.00 else 0.0)+
                    (if(chkSmoker.isChecked)100.00 else 0.0)
            2-> 90.00+
                    (if(male.isChecked) 100.00 else 0.0)+
                    (if(chkSmoker.isChecked)150.00 else 0.0)
            3->120.00+
                    (if(male.isChecked) 150.00 else 0.0)+
                    (if(chkSmoker.isChecked)250.00 else 0.0)
            4->150.00+
                    (if(male.isChecked)200.00 else 0.0)+
                    (if(chkSmoker.isChecked)250.00 else 0.0)
            else->150.00+
                    (if(male.isChecked)200.00 else 0.0)+
                    (if(chkSmoker.isChecked) 300.00 else 0.0)

        }
    }
    fun display(){
        if(myData.premium!=0.0)
        premiumOut.text="RM" + myData.premium.toString()

    }

}
