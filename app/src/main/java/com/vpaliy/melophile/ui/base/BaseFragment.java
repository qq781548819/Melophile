package com.vpaliy.melophile.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.vpaliy.melophile.ui.base.bus.RxBus;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import android.support.annotation.Nullable;
import javax.inject.Inject;

public abstract class BaseFragment extends Fragment {

    private Unbinder unbinder;

    @Inject
    protected RxBus rxBus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        initializeDependencies();
    }

    public void bind(View root){
        unbinder= ButterKnife.bind(this,root);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(unbinder!=null){
            unbinder.unbind();
        }
    }

    public abstract void initializeDependencies();
}