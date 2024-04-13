package com.example.randomuserapp.core.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.randomuserapp.core.base.hilt.HiltActivityEntryPoint

abstract class BaseActivity<VB : ViewBinding>(
    private val setupViewBinding: (LayoutInflater) -> VB
) : HiltActivityEntryPoint() {

    lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = setupViewBinding(layoutInflater)
        setContentView(binding.root)

        setupView()
        observeState()
        setupListener()
    }

    open fun setupView(){}

    open fun setupListener() {}
    open fun observeState() {}

}