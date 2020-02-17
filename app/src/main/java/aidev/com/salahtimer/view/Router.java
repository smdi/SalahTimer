package aidev.com.salahtimer.view;


import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import android.os.Vibrator;
import android.view.MenuItem;
import android.widget.Toast;

import aidev.com.salahtimer.R;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class Router extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {



            final boolean check = checkConnection();

            switch (item.getItemId()) {
                case R.id.salahtimings:
                     loadFirstFragment(new Location());
                    break;
                case R.id.qibla:
                    Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.library:
                    Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.hadithnotifier:
                    Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.masjidfinder:
                    Toast.makeText(getApplicationContext(),"test",Toast.LENGTH_SHORT).show();
                    break;
            }
           return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.salahtimings);
    }

    public boolean loadFirstFragment(Fragment fragment){

        if(fragment!=null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment);
            ft.commit();
            return  true;
        }
        return false;
    }

    public boolean loadFragment(Fragment fragment)
    {
        if(fragment!=null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack("tag");
            ft.commit();
            return  true;
        }
        return false;

    }
    private boolean checkConnection() {


        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {

            return true;

        } else {
            return false;
        }


    }
    private void setVibrator() {
        Vibrator v =(Vibrator)getSystemService(VIBRATOR_SERVICE);
        v.vibrate(1000);
    }

}
