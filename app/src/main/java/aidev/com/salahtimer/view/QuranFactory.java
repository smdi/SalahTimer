package aidev.com.salahtimer.view;

import android.content.Context;

import aidev.com.salahtimer.viewmodel.QuranViewModel;
import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class QuranFactory  implements ViewModelProvider.Factory {

    private Context application;

    public QuranFactory(Context application) {
        this.application = application;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new QuranViewModel(application);
    }
}
