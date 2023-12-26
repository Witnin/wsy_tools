package com.wsy.tools

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnticipateOvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.wsy.tools.databinding.LayoutSecondBinding
import com.wsy.viewspread.helper.BaseViewHelper
import com.wsy.viewspread.helper.BaseViewHelper.OnAnimationListener


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: LayoutSecondBinding

    var helper: BaseViewHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = LayoutSecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "第二页"

        when (intent.getIntExtra("id", -1)) {
            R.id.btn_translation1 -> startTranslation1()
            R.id.btn_translation2 -> startTranslationNoFullWindow()
            R.id.btn_translation3 -> startTranslationNoShowTranslation()
            R.id.btn_translation4 -> startTranslationShowTranslationY()
            R.id.fab -> startTranslation1()
            R.id.ib_customImage -> startTranslation(findViewById(R.id.iv_second))
        }
    }

    private fun startTranslationShowTranslationY() {
        helper = BaseViewHelper.Builder(this@SecondActivity)
            .isFullWindow(true) //是否全屏显示
            .isShowTransition(true) //是否显示过渡动画
            .setDimColor(Color.WHITE) //遮罩颜色
            .setDimAlpha(200) //遮罩透明度
            .setTranslationY(-600f)
            .setInterpolator(AnticipateOvershootInterpolator())
            .create() //开始动画
    }

    private fun startTranslationNoShowTranslation() {
        helper = BaseViewHelper.Builder(this@SecondActivity)
            .isFullWindow(true) //是否全屏显示
            .isShowTransition(false) //是否显示过渡动画
            .setDimColor(Color.WHITE) //遮罩颜色
            .setDimAlpha(200) //遮罩透明度
            .create() //开始动画
    }

    fun startTranslation(v: View?) {
        helper =
            BaseViewHelper.Builder(this@SecondActivity) //.setEndView()//如果是两个切换的视图  这里设定最终显示的视图
                .setTranslationView(v) //设置过渡视图
                .isFullWindow(true) //是否全屏显示
                .isShowTransition(true) //是否显示过渡动画
                .setDimColor(Color.WHITE) //遮罩颜色
                .setDimAlpha(200) //遮罩透明度
                //.setTranslationX(0)//x轴平移
                //.setRotation(360)//旋转
                //.setScaleX(0)//x轴缩放
                //.setScaleY(0)//y轴缩放
                //.setTranslationY(0)//y轴平移
                //.setDuration(800)//过渡时长
                //.setInterpolator(new AccelerateDecelerateInterpolator())//设置插值器
                //设置监听
                //                .setOnAnimationListener(new BaseViewHelper.OnAnimationListener() {
                //                    @Override
                //                    public void onAnimationStartIn() {
                //                        Log.e("TAG","onAnimationStartIn");
                //                    }
                //
                //                    @Override
                //                    public void onAnimationEndIn() {
                //                        Log.e("TAG","onAnimationEndIn");
                //                    }
                //
                //                    @Override
                //                    public void onAnimationStartOut() {
                //                        Log.e("TAG","onAnimationStartOut");
                //                    }
                //
                //                    @Override
                //                    public void onAnimationEndOut() {
                //                        Log.e("TAG","onAnimationEndOut");
                //                    }
                //                })
                .create() //开始动画
    }


    fun startTranslation1() {
        helper =
            BaseViewHelper.Builder(this@SecondActivity) //.setEndView()//如果是两个切换的视图  这里设定最终显示的视图
                //.setTranslationView(viewById)//设置过渡视图
                .isFullWindow(true) //是否全屏显示
                .isShowTransition(true) //是否显示过渡动画
                .setDimColor(Color.WHITE) //遮罩颜色
                .setDimAlpha(200) //遮罩透明度
                .setTranslationX(0f) //x轴平移
                .setRotation(360f) //旋转
                .setScaleX(0f) //x轴缩放
                .setScaleY(0f) //y轴缩放
                .setTranslationY(0f) //y轴平移
                .setDuration(800) //过渡时长
                .setInterpolator(AccelerateDecelerateInterpolator()) //设置插值器
                //设置监听
                .setOnAnimationListener(object : OnAnimationListener {
                    override fun onAnimationStartIn() {
                        Log.e("TAG", "onAnimationStartIn")
                    }

                    override fun onAnimationEndIn() {
                        Log.e("TAG", "onAnimationEndIn")
                    }

                    override fun onAnimationStartOut() {
                        Log.e("TAG", "onAnimationStartOut")
                    }

                    override fun onAnimationEndOut() {
                        Log.e("TAG", "onAnimationEndOut")
                    }
                })
                .create() //开始动画
    }

    private fun startTranslationNoFullWindow() {
        helper = BaseViewHelper.Builder(this@SecondActivity)
            .isFullWindow(false) //是否全屏显示
            .isShowTransition(true) //是否显示过渡动画
            .setDimColor(Color.WHITE) //遮罩颜色
            .setDimAlpha(200) //遮罩透明度
            .create() //开始动画
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        if (helper != null && helper!!.isShowing()) {
            helper!!.backActivity(this)
        } else {
            super.onBackPressed()
        }
    }
}

