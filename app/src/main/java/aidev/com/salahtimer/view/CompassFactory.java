package aidev.com.salahtimer.view;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import aidev.com.salahtimer.viewmodel.CompassViewModel;
import aidev.com.salahtimer.viewmodel.RouterViewModel;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class CompassFactory implements ViewModelProvider.Factory {

    private Context application;
    private String url;
    private WebView webView;
    private ProgressBar progressBar;
    private View view;

    public CompassFactory(Context application, View view, String url) {
        this.application = application;
        this.url = url;
        this.view = view;

    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CompassViewModel(application, view, url);
    }
}