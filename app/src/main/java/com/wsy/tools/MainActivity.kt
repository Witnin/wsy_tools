package com.wsy.tools


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.wsy.tools.databinding.ActivityMainBinding
import com.wsy.viewspread.helper.BaseViewHelper



class MainActivity : AppCompatActivity() {

    private lateinit var _binding: ActivityMainBinding

    var helper: BaseViewHelper? = null

    private val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
    }

    fun click(view: View) {
        if (view.id == binding.contentMain.btnTranslation5.id) {
            //显示在当前页面跳转
            helper = BaseViewHelper.Builder(this, view)
                .setTranslationView(R.id.iv_second)
                .setEndView(inflate(this, R.layout.layout_second, null))
                .create()
            return
        }
        if (view.id == binding.contentMain.btnTranslation6.id) {
            val v = inflate(this, R.layout.layout_second, null)
            //显示在当前页面跳转
            helper = BaseViewHelper.Builder(this, view)
                .setEndView(v)
                .create()
            (v.findViewById<View>(R.id.tv_message) as TextView).text = "我还在第一个页面"
            return
        }
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra("id", view.id)
        BaseViewHelper.Builder(this@MainActivity, view)
            .startActivity(intent)



    }

}