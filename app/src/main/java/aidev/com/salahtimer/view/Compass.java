package aidev.com.salahtimer.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;


import aidev.com.salahtimer.R;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;


public class Compass extends Fragment {


    private ProgressBar progressBar;
    private WebView webView;
    private static  String url = "" ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_compass,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        url =  "https://qiblafinder.withgoogle.com/intl/en/finder/ar";

        progressBar = (ProgressBar) view.findViewById(R.id.qiblaprog);

        webView = (WebView) view.findViewById(R.id.webViewinActivity);

        webView.setWebViewClient(new MyClient());
        webView.getSettings().setJavaScriptEnabled(true);

        webView.getSettings().getLoadsImagesAutomatically();
        webView.setWebChromeClient(new WebChromeClient(){

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);

                progressBar.setProgress(newProgress);

                if (newProgress == 100) {

                    progressBar.setVisibility(View.GONE);
                    webView.setVisibility(View.VISIBLE);
                }

            }
        });

        webView.loadUrl(url);

    }

    private class MyClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
    }


}
