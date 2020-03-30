package aidev.com.salahtimer.view;


import android.content.Context;

import aidev.com.salahtimer.viewmodel.RouterViewModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;


public class RouterFactory implements ViewModelProvider.Factory {

    private Context application;
    private FragmentManager fragementManagerObject;
    private Router router;

    public RouterFactory(Context application, FragmentManager fragementManagerObject, Router router) {
        this.application = application;
        this.fragementManagerObject = fragementManagerObject;
        this.router = router;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new RouterViewModel(application,fragementManagerObject, router);
    }
}