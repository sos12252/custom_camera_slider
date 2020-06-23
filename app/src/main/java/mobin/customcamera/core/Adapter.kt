package mobin.customcamera.core

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import mobin.ui.R


class Adapter(customCameraUI: CustomCameraUI) : PagerAdapter() {
    private val images = intArrayOf(R.drawable.guide1, R.drawable.guide2, R.drawable.guide3)
    private var inflater: LayoutInflater? = null
    private var context: Context? = null
    fun Adapter(context: Context?) {
        this.context = context
    }

    override fun getCount(): Int {
        return images.size
    }

    override fun isViewFromObject(view: View,`object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
       // val v: View = inflater!!.inflate(R.layout.slider, container, false)
        val v: View = inflater!!.inflate(R.layout.slider, null)
        val imageView = v.findViewById<View>(R.id.imageView) as ImageView

        imageView.setImageResource(images[position])
        val vp = container as ViewPager
        vp.addView(v, 0)

        return v
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.invalidate()
    }
}
