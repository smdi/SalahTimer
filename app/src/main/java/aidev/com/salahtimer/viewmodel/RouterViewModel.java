package aidev.com.salahtimer.viewmodel;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import com.aidev.generictoast.GenericToast;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.view.Compass;
import aidev.com.salahtimer.view.HadithNotifier;
import aidev.com.salahtimer.view.HijriCalendar;
import aidev.com.salahtimer.view.Location;
import aidev.com.salahtimer.view.Router;

import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class RouterViewModel extends ViewModel {

    private Context activity;
    private FragmentManager fragmentManager;
    private Router router;

    public RouterViewModel(Context activity, FragmentManager fragementManager, Router router){
        this.activity = activity;
        this.fragmentManager = fragementManager;
        this.router = router;
    }
    public NavigationBarView.OnItemSelectedListener getBottomNavbarObject(){

//        int once = getCompassValue(activity,0);

           NavigationBarView.OnItemSelectedListener mOnNavigationItemSelectedListener
                  = item -> {

                        loadFirstFragment(new Location());
//                      switch (item.getItemId()) {
//                          case R.id.salahtimings:
//                              loadFirstFragment(new Location());
//                              break;
//                          case R.id.qibla:
//                              loadFragment(new Compass(), "qibla");
//                              break;
//                          case R.id.hijricalendar:
//                              loadFragment(new HijriCalendar(), "hijricalendar");
//                              break;
//                          case R.id.hadithnotifier:
//                              loadFragmentWithNoInternet(new HadithNotifier(),"HadithNotifier");
//                              break;
//                          case R.id.masjidfinder:
//                              if(checkConnection()){
//                                  getMasjidFinder();
//                              }
//                              else {
//                                  displayNoInternet("No Internet connection");
//                              }
//                              break;
//                      }
                      return true;
                  };

          return mOnNavigationItemSelectedListener;
      }

    private void getMasjidFinder() {

        AlertDialog.Builder builder = new AlertDialog.Builder(router);
        builder.setMessage("Find masjid near you ?")
                .setCancelable(false)
                .setPositiveButton("Yes", (dialogInterface, i) -> {

                    Uri str = Uri.parse("http://maps.google.com/maps?daddr=Masjid");

                    Intent intent = new Intent(Intent.ACTION_VIEW,str);
                    intent.setPackage("com.google.android.apps.maps");
                    if(intent.resolveActivity(activity.getPackageManager())!=null)
                    {
                        router.startActivity(intent);
                    }
                    else {
//                        TastyToast.makeText(activity, "Unable to process", Toast.LENGTH_LONG,TastyToast.CONFUSING).show();
                        GenericToast.showToast(activity, "Unable to process your request!",
                                GenericToast.LENGTH_SHORT, GenericToast.ERROR, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
                    }
                })
                .setNegativeButton("No", (dialogInterface, i) -> dialogInterface.cancel());

        AlertDialog alert =builder.create();
        alert.setTitle("Masjid Finder");
        alert.show();

    }


    public boolean loadFragmentWithNoInternet(Fragment fragment,String tag)
    {

        if(fragment!=null)
        {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack(tag);
            ft.commitAllowingStateLoss();
            return  true;
        }
        return false;
    }

    private boolean loadFirstFragment(Fragment fragment){

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
//        TastyToast.makeText(activity,msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
        GenericToast.showToast(activity,
                msg,
                GenericToast.LENGTH_SHORT,
                GenericToast.ERROR,
                GenericToast.LITE,
                GenericToast.DEFAULT_FONT,
                GenericToast.DEFAULT_FONT);
    }

    private boolean loadFragment(Fragment fragment, String tag) {
            final boolean check = checkConnection();
            if(check){if(fragment!=null)
            {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.frame, fragment).addToBackStack(tag);
                ft.commitAllowingStateLoss();
                return  true;
            }}
            else { displayNoInternet("No Internet connection"); }

        return false;
        }

    @SuppressLint("MissingPermission")
    private boolean checkConnection() {


        ConnectivityManager connectivityManager = (ConnectivityManager)  activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }


}
