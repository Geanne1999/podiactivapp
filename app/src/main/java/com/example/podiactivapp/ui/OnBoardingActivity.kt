package com.example.podiactivapp.ui

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.podiactivapp.R
import com.example.podiactivapp.databinding.ActivityOnBoardingBinding

class OnBoardingActivity : AppCompatActivity() {

    lateinit var viewPager:ViewPager
    lateinit var linearLayout: LinearLayout
    lateinit var backButton: Button
    lateinit var nextButton: Button
    lateinit var skipButton: Button

    lateinit var dots: Array<TextView?>
    var array = IntArray(5)
    lateinit var viewPagerOnBoardingAdapter: ViewPagerOnBoardingAdapter

    private lateinit var binding: ActivityOnBoardingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnBoardingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        backButton = findViewById(R.id.backButtonOnBoarding)
        nextButton = findViewById(R.id.nextButtonOnBoarding)
        skipButton = findViewById(R.id.skipButtonOnBoarding)

        binding.backButtonOnBoarding.setOnClickListener {
            if(getItem(0) > 0){
                viewPager.currentItem = getItem(-1)
            }
        }

        binding.nextButtonOnBoarding.setOnClickListener {
            if(getItem(0) < 3){
                viewPager.currentItem = getItem(1)
            }else{
                val i = Intent(this, InitialPageActivity::class.java )
                startActivity(i)
                finish()
            }
        }

        binding.skipButtonOnBoarding.setOnClickListener {
            val i = Intent(this, InitialPageActivity::class.java )
            startActivity(i)
            finish()
        }

        viewPager = findViewById(R.id.slideViewPagerOnBoarding)
        linearLayout = findViewById(R.id.indicatorLayoutOnBoarding)
        viewPagerOnBoardingAdapter = ViewPagerOnBoardingAdapter(this)

        viewPager.adapter = viewPagerOnBoardingAdapter

        setUpIndicator(0)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                setUpIndicator(position)

                if(position > 0){
                    binding.backButtonOnBoarding.visibility = android.view.View.VISIBLE
                }
                else{
                    binding.backButtonOnBoarding.visibility = android.view.View.INVISIBLE
                }
            }

        })
    }

    private fun getItem(i: Int): Int {
        return viewPager.currentItem + i
    }

    private fun setUpIndicator(position: Int){
        dots = arrayOfNulls(4)
        linearLayout.removeAllViews()

        for (i in dots.indices){
            dots[i] = TextView(this)
            dots[i]?.text = Html.fromHtml("&#8226")
            dots[i]?.textSize = 35F
            dots[i]?.setTextColor(resources.getColor(R.color.inactive))
            linearLayout.addView(dots[i])
        }
        dots[position]?.setTextColor(resources.getColor(R.color.active))
    }
}