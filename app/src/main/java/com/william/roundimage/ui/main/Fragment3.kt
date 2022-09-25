/*
 * Copyright WeiLianYang
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.william.roundimage.ui.main

import android.content.res.Resources
import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.william.roundimage.R
import com.william.roundimage.databinding.Fragment3Binding

/**
 * A placeholder fragment containing a simple view.
 */
class Fragment3 : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: Fragment3Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this)[PageViewModel::class.java].apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = Fragment3Binding.inflate(inflater, container, false)
        val root = binding.root

        binding.riv1.setRadiusAndBorder(75f.dp, 10f.dp, Color.parseColor("#60ff0000"), true)

        binding.riv2.setRadiusAndBorder(
            20f.dp, 20f.dp, 0f, 0f,
            10f.dp, Color.parseColor("#800000ff")
        )

        binding.riv3.setRadiusAndBorder(30f.dp, 10f.dp, Color.parseColor("#ff00ff"))

        binding.riv4.setRadiusAndBorder(
            0f, 30f.dp, 30f.dp, 0f,
            10f.dp, Color.parseColor("#00ff00")
        )

        binding.riv5.setRadiusAndBorder(0f, 10f.dp, Color.parseColor("#ff0000"), true)

        binding.riv6.setRadiusAndBorder(
            14f.dp, 20f.dp, 32f.dp, 25f.dp,
            10f.dp, Color.parseColor("#ffaa00")
        )

        val url =
            "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.oappt.com%2Fd%2Ffile%2Fcj%2F114%2F0713_2014111566305657.jpg&refer=http%3A%2F%2Fimg.oappt.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1666102585&t=bc26e0684d9c3f0ef22cc9bbaf5a1b99"
        Glide.with(this).load(url).into(binding.riv5)
        Glide.with(this).load(R.drawable.test2).into(binding.riv6)

        return root
    }

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(sectionNumber: Int): Fragment3 {
            return Fragment3().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    val Int.dp
        get() = this.toFloat().dp.toInt()

    val Float.dp
        get() = getTypedValue(TypedValue.COMPLEX_UNIT_DIP, this)

    val Float.sp
        get() = getTypedValue(TypedValue.COMPLEX_UNIT_SP, this)

    private fun getTypedValue(unit: Int, value: Float): Float {
        return TypedValue.applyDimension(unit, value, Resources.getSystem().displayMetrics)
    }
}