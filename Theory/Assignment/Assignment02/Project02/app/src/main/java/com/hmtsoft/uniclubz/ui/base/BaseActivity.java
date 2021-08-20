package com.hmtsoft.uniclubz.ui.base;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.library.baseAdapters.BR;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


@SuppressLint("SetTextI18n")
public abstract class BaseActivity<DATA_BINDING extends ViewDataBinding, VIEW_MODEL extends ViewModel> extends AppCompatActivity {

    protected VIEW_MODEL viewModel;
    protected DATA_BINDING binding;
    protected Intent intent;
    private Class<VIEW_MODEL> viewModelClassType;
    @LayoutRes
    private int layoutId;

    public BaseActivity(Class<VIEW_MODEL> viewModelClassType, int layoutId) {
        this.viewModelClassType = viewModelClassType;
        this.layoutId = layoutId;
    }

    public BaseActivity() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, layoutId);
        viewModel = new ViewModelProvider(this).get(viewModelClassType);
        binding.setVariable(BR.viewModel, viewModel);
        binding.setLifecycleOwner(this);
        binding.executePendingBindings();
        intent = getIntent();

        initViews();
        clickListeners();
        liveEventsObservers();
    }


    protected abstract void initViews();

    protected abstract void liveEventsObservers();

    protected abstract void clickListeners();

}
