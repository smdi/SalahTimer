package aidev.com.salahtimer.view;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.Toast;

import aidev.com.salahtimer.R;

import com.aidev.generictoast.GenericToast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import aidev.com.salahtimer.model.pojo.HadithBookmarkDBTable;
import aidev.com.salahtimer.model.pojo.HadithBookmarkRepository;
import aidev.com.salahtimer.viewmodel.RouterViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;



public class Router extends AppCompatActivity {


    private RouterViewModel rvm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router);



        String menuFragment = getIntent().getStringExtra("menuFragment");


        if(menuFragment!= null && menuFragment.equals("hadith")){
            Bundle bundle = new Bundle();
            bundle.putString("data","Notif");
            Fragment fragment = new Hadith();
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame,fragment);
            fragmentTransaction.commit();
        }
        else if(menuFragment!= null && menuFragment.equals("notif")){
            if(checkConnection()){
                Bundle bundle = new Bundle();
                bundle.putString("head",getIntent().getStringExtra("head"));
                bundle.putString("body",getIntent().getStringExtra("body"));
                bundle.putString("image",getIntent().getStringExtra("image"));
                Fragment fragment = new Notify();
                fragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame,fragment);
                fragmentTransaction.commit();
            }
            else {
                displayNoInternet("No Internet connection");
            }
        }
        else{

            rvm = new ViewModelProvider(this,
                    new RouterFactory(getApplicationContext(),getFragementManagerObject(),Router.this)).get(RouterViewModel.class);


            BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
            navigation.setOnItemSelectedListener(rvm.getBottomNavbarObject());
            navigation.setSelectedItemId(R.id.salahtimings);

            SharedPreferences sh = getSharedPreferences("DB", Context.MODE_PRIVATE);
            int exe = sh.getInt("dbval", 0);

//        Toast.makeText(getApplicationContext(),""+exe,Toast.LENGTH_SHORT).show();

            if(exe == 0){
                DataStore dataStore = new DataStore();
                dataStore.execute();
            }

        }
    }




    public  FragmentManager getFragementManagerObject(){
        return  getSupportFragmentManager();
    }

    private String category(int i) {

        String message = "";

        if(i >=1&& i <=65)
        {
            message =Reference.InnerReference.hadeesCategory1;
        }
        else  if(i >=66&& i <=130)
        {
            message =Reference.InnerReference.hadeesCategory2;
        }
        else  if(i >=131&& i <=195)
        {
            message =Reference.InnerReference.hadeesCategory3;
        } else if (i >=196&& i <=260) {
            message =Reference.InnerReference.hadeesCategory4;
        }
        else if(i >=261&& i <=293)
        {
            message =Reference.InnerReference.hadeesCategory5;
        }
        else if(i >=294&& i <=358){
            message =Reference.InnerReference.hadeesCategory6;
        }
        return message;
    }

    private boolean loadFirstFragment(Fragment fragment){

        if(fragment!=null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment);
            ft.commitAllowingStateLoss();
            return  true;
        }
        return false;
    }


    private class DataStore extends AsyncTask<String, String, String> {

        private HadithBookmarkRepository mRepository;

        @Override
        protected String doInBackground(String... strings) {

            mRepository = new HadithBookmarkRepository(getApplication());

            for (int i = 1; i <= 354; i++) {
                mRepository.insert(new HadithBookmarkDBTable(i,category(i),Reference.InnerReference.get(i),0));
            }

            SharedPreferences.Editor editor = getSharedPreferences("DB", Context.MODE_PRIVATE).edit();
            editor.putInt("dbval", 1);
            editor.apply();

            return "";
        }
    }

    public boolean loadFragmentWithNoInternet(Fragment fragment, String tag) {

        if(fragment!=null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack(tag);
            ft.commitAllowingStateLoss();
            return  true;
        }
        return false;
    }

    private boolean checkConnection() {

        ConnectivityManager connectivityManager = (ConnectivityManager)  getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }

    private void displayNoInternet(String msg) {
//        TastyToast.makeText(ctx,msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
        GenericToast.showToast(getApplicationContext(),
                msg,
                GenericToast.LENGTH_SHORT,
                GenericToast.ERROR,
                GenericToast.LITE,
                GenericToast.DEFAULT_FONT,
                GenericToast.DEFAULT_FONT);
    }

}
