package aidev.com.salahtimer.viewmodel;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.view.Router;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;

public class CompassViewModel extends ViewModel {

    private Context activity;
    private String url;
    private static int val = 0;
    private View view;
    private WebView webView;
    private ProgressBar progressBar;

    public CompassViewModel(Context activity,View view ,String url){
        this.activity = activity;
        this.url = url;
        this.view = view;
    }

    private void displayNoInternet(String msg) {
        TastyToast.makeText(activity,msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
    }

    private ProgressBar getProgressBar(){

        if(progressBar == null){
            progressBar = view.findViewById(R.id.qiblaprog);
            return progressBar;
        }
        else
            return progressBar;
    }

    private WebView getWebView(){
        if(webView == null){

            webView  =  view.findViewById(R.id.webViewinActivity);
            return webView;
        }
        else return webView;
    }

    public void getDisplayData(){

           WebView webView = getWebView();
           webView.setWebViewClient(new MyClient());
           webView.getSettings().setJavaScriptEnabled(true);
           webView.getSettings().getLoadsImagesAutomatically();
           webView.setWebChromeClient(new WebChromeClient(){

               @Override
               public void onProgressChanged(WebView view, int newProgress) {
                   super.onProgressChanged(view, newProgress);

                   getProgressBar().setProgress(newProgress);

                   if (newProgress == 100) {

                       getProgressBar().setVisibility(View.GONE);
                       webView.setVisibility(View.VISIBLE);
                   }
               }
           });

           if(checkConnection()){
               webView.loadUrl(url);
           }
           else {
               displayNoInternet("No Internet");
               Router router = new Router();
               FragmentManager fragmentManager = router.getSupportFragmentManager();
               fragmentManager.popBackStack ("qibla", FragmentManager.POP_BACK_STACK_INCLUSIVE);
           }


    }


    private boolean checkConnection() {

        ConnectivityManager connectivityManager = (ConnectivityManager)  activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }

    private class MyClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return true;
        }
    }


}
