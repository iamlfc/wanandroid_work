package luyao.mvvm.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import kotlinx.android.synthetic.main.activity_base.view.lay_root_base
import luayo.mvvm.core.R

abstract class BaseVMsActivity<VB : ViewBinding> : AppCompatActivity() {


    /**
     * ViewBinding
     */
    private var _binding: ViewBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB
    @Suppress("UNCHECKED_CAST")
    protected val binding: VB
        get() = _binding as VB

    override fun onCreate(savedInstanceState: Bundle?) {
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        super.setContentView(R.layout.activity_base)
        startObserve()
        initView()
        initData()
    }


    override fun setContentView(view: View) {
//        if (rootLayout == null)
//            return
//        rootLayout.addView(
//            view,
//            ViewGroup.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.MATCH_PARENT
//            )
//        )
        val ivLeftLayoutParams: ConstraintLayout.LayoutParams = ConstraintLayout.LayoutParams(-1, 0)
        ivLeftLayoutParams.topToBottom = R.id.lay_appbar
        ivLeftLayoutParams.leftToLeft = R.id.lay_root_base
        ivLeftLayoutParams.bottomToBottom = R.id.lay_root_base
        view.layoutParams = ivLeftLayoutParams
        _binding?.root?.lay_root_base?.addView(view)


    }

    override fun setContentView(layoutId: Int) {
        setContentView(View.inflate(this, layoutId, null))

    }

    fun setContentView(layoutId: Int, isAddParent: Boolean = true) {
        if (isAddParent)
            setContentView(View.inflate(this, layoutId, null))
        else super.setContentView(layoutId)

    }

    abstract fun initView()
    abstract fun initData()
    abstract fun startObserve()
}