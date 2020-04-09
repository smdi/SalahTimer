package aidev.com.salahtimer.view;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.google.android.material.textfield.TextInputLayout;
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


    private TextInputLayout city;
    private TextInputLayout country;
    private Button search;
    private TextView share;
    private LinearLayout tasbeeh, unlawfulgazes, hadith, hadithBookmark, quran;

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

        share = (TextView) view.findViewById(R.id.share);
        share.setOnClickListener(view13 -> {

            startplayer();

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Salah Timer");
            String sAux = "\nSalah Timer App link (Know salah timings, Qibla, Islamic Calendar,Quran - e - pak, Hadith, Tasbeeh counter," +
                    "Unlawful gazes, Masjid finder Accurately)\n\n";
            sAux = sAux + "app link\n\n";
            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "share application"));
        });


        quran = (LinearLayout) view.findViewById(R.id.quran);
        quran.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new QuranChapter(),"index");
        });

        hadith = (LinearLayout) view.findViewById(R.id.hadith);
        hadith.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new Hadith(),"hadith");
        });

        tasbeeh = (LinearLayout) view.findViewById(R.id.tasbeehlayout);
        tasbeeh.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new TasbeehFragment(),"tasbeeh");
        });


        unlawfulgazes = (LinearLayout) view.findViewById(R.id.unlawfulgazes);
        unlawfulgazes.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new UnlawfulGazes(),"unlawfulgazes");

        });

        hadithBookmark = (LinearLayout) view.findViewById(R.id.hadithbookmark);
        hadithBookmark.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new HadithBookmark(),"HadithBookmark");
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

                String cityText = city.getEditText().getText().toString();
                String countryText = country.getEditText().getText().toString();

                boolean cityb = false, countryb = false;

                if(cityText.length() > 0){
                    cityb = true;
                }
                else {
                    city.setError("City name required");
                }
                if(countryText.length() > 0){
                    countryb = true;
                }
                else {
                    country.setError("Country name required");
                }
                if(cityb & countryb){

                    disableError(city);
                    disableError(country);
                    setCityCountry(cityText,countryText);
                }

            }
        });

    }


    private void disableError(TextInputLayout Wrapper) {
        if(Wrapper.isErrorEnabled()){
            Wrapper.setErrorEnabled(false);
        }
    }

    private void setCityCountry(String cityText, String countryText) {

        if(checkConnection()){
            Bundle bundle = new Bundle();
            bundle.putString("city",cityText);
            bundle.putString("country",countryText);
            Fragment fragment = new TimingsFragment();
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.location,fragment).addToBackStack("timings");
            fragmentTransaction.commit();
        }
        else { displayNoInternet("No Internet"); }

    }
    public boolean loadFragment(Fragment fragment, String tag)
    {
        final boolean check = checkConnection();
        if(check){if(fragment!=null)
        {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack(tag);
            ft.commitAllowingStateLoss();
            return  true;
        }}
        else { displayNoInternet("No Internet"); }

        return false;
    }

    public boolean loadFragmentWithNoInternet(Fragment fragment,String tag)
    {

        if(fragment!=null)
        {
            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame, fragment).addToBackStack(tag);
            ft.commitAllowingStateLoss();
            return  true;
        }
        return false;
    }

    private void displayNoInternet(String msg) {
        TastyToast.makeText(getActivity(),msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
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
