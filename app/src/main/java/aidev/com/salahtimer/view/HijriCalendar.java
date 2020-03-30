package aidev.com.salahtimer.view;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;

import aidev.com.salahtimer.R;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HijriCalendar extends Fragment {
    private ProgressBar progressBar;
    private WebView webView;
    private static  String url = "" ;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        url = preferences.getString("hijriurl","https://calendar.google.com/calendar/r?cid=chicagohilal.org_dd3vb8e40l4kij6iptp04qo3r4@group.calendar.google.com&cid=ht3jlfaac5lfd6263ulfh4tql8@group.calendar.google.com&cid=chicagohilal.org_csh9v4an33q1ltti3r9b5ottbo@group.calendar.google.com");

        return inflater.inflate(R.layout.fragment_compass,container,false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        try {
            if (Build.VERSION.SDK_INT < 16) {
                getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        progressBar = (ProgressBar) view.findViewById(R.id.qiblaprog);



        webView = (WebView) view.findViewById(R.id.webViewinActivity);
        webView.setWebViewClient(new MyClient(){


        });
        webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setVerticalScrollBarEnabled(true);
        webView.setHorizontalScrollBarEnabled(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
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
            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin,true,false);
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
        @Override
        public void onPageFinished(final WebView view, final String url) {
            super.onPageFinished(view, url);
            webView.requestLayout();
        }
    }

}
