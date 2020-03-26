package aidev.com.salahtimer.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.view.Compass;
import aidev.com.salahtimer.view.Location;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class RouterViewModel extends ViewModel {

    private Context activity;
    private FragmentManager fragmentManager;

    public RouterViewModel(Context activity, FragmentManager fragementManager){
        this.activity = activity;
        this.fragmentManager = fragementManager;
    }

    public BottomNavigationView.OnNavigationItemSelectedListener getBottomNavbarObject(){

          BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
                  = new BottomNavigationView.OnNavigationItemSelectedListener() {

              @Override
              public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                  switch (item.getItemId()) {
                      case R.id.salahtimings:
                          loadFirstFragment(new Location());
                          break;
                      case R.id.qibla:
                          loadFragment(new Compass(), "qibla");
                          break;
                      case R.id.library:
                          Toast.makeText(activity,"test",Toast.LENGTH_SHORT).show();
                          break;
                      case R.id.hadithnotifier:
                          Toast.makeText(activity,"test",Toast.LENGTH_SHORT).show();
                          break;
                      case R.id.masjidfinder:
                          Toast.makeText(activity,"test",Toast.LENGTH_SHORT).show();
                          break;
                  }
                  return true;
              }
          };

          return mOnNavigationItemSelectedListener;
      }



    public boolean loadFirstFragment(Fragment fragment){

            if(fragment!=null)
            {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.frame, fragment);
                ft.commitAllowingStateLoss();
                return  true;
            }
        return false;
        }

    private void displayNoInternet(String msg) {
        TastyToast.makeText(activity,msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
    }

    public boolean loadFragment(Fragment fragment,String tag)
        {
            final boolean check = checkConnection();
            if(check){if(fragment!=null)
            {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.frame, fragment).addToBackStack(tag);
                ft.commitAllowingStateLoss();
                return  true;
            }}
            else { displayNoInternet("No Internet"); }

        return false;
        }

    private boolean checkConnection() {


        ConnectivityManager connectivityManager = (ConnectivityManager)  activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }


}
