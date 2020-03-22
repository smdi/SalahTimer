package aidev.com.salahtimer.view;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.R;


import aidev.com.salahtimer.viewmodel.RouterViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;


public class Location extends Fragment {


    private EditText city;
    private EditText country;
    private Button search;
    private LinearLayout tasbeeh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_location,container ,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initialisers(view);

    }

    private void initialisers(View view) {
        tasbeeh = (LinearLayout) view.findViewById(R.id.tasbeehlayout);
        tasbeeh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragmentWithNoInternet(new TasbeehFragment());
            }
        });

        city = view.findViewById(R.id.city);
        country = view.findViewById(R.id.country);
        search = view.findViewById(R.id.get_The_Results);
    }


    @Override
    public void onStart() {
        super.onStart();

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startplayer();

                String cityText = city.getText().toString();
                String countryText = country.getText().toString();

                if(cityText.length() > 0  && countryText.length() > 0){
                    setCityCountry(cityText,countryText);
                }
                else {
                    TastyToast.makeText(getActivity(),"enter valid details",TastyToast.LENGTH_SHORT,TastyToast.CONFUSING).show();
                }
            }
        });

    }




    private void setCityCountry(String cityText, String countryText) {

        if(checkConnection()){
            Bundle bundle = new Bundle();
            bundle.putString("city",cityText);
            bundle.putString("country",countryText);
            Fragment fragment = new TimingsFragment();
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.location,fragment).addToBackStack("tag");
            fragmentTransaction.commit();
        }
        else { displayNoInternet("No Internet"); }

    }
    public boolean loadFragment(Fragment fragment)
    {
        final boolean check = checkConnection();
        if(check){if(fragment!=null)
        {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack("tag");
            ft.commitAllowingStateLoss();
            return  true;
        }}
        else { displayNoInternet("No Internet"); }

        return false;
    }

    public boolean loadFragmentWithNoInternet(Fragment fragment)
    {
        final boolean check = checkConnection();
        if(check){if(fragment!=null)
        {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack("tag");
            ft.commitAllowingStateLoss();
            return  true;
        }}
        else { displayNoInternet("No Internet"); }

        return false;
    }

    private void displayNoInternet(String msg) {
        TastyToast.makeText(getActivity(),msg,TastyToast.ERROR,TastyToast.LENGTH_SHORT).show();
    }

    private void startplayer() {

        final MediaPlayer mp = MediaPlayer.create(getActivity() ,R.raw.knock);
        mp.start();
    }

    private boolean checkConnection() {


        ConnectivityManager connectivityManager = (ConnectivityManager)  getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }
}
