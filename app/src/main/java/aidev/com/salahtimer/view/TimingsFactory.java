package aidev.com.salahtimer.view;

import android.app.Application;

import aidev.com.salahtimer.viewmodel.TimingsViewModel;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class TimingsFactory implements ViewModelProvider.Factory {

    private String city, country;
    private FragmentActivity application;

    public TimingsFactory(FragmentActivity application, String city, String country){
        this.application =  application;
        this.city  = city;
        this.country = country;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new TimingsViewModel(application,city, country);
    }
}
