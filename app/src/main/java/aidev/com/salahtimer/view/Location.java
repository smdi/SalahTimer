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
    private LinearLayout tasbeeh, unlawfulgazes, hadith, hadithBookmark, quran, bookmark, names99, namazkdua, ghustkadaab;

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
            i.putExtra(Intent.EXTRA_SUBJECT, "Islami Duniya");
            String sAux = "\nAssalamualaikum wa Rahamatullahi wa Barakaatuhu\n" +
                    "\nKnow Namaz timings, Qibla, Islamic Calendar, Quran - e - pak, Hadith, Tasbeeh counter," +
                    "Unlawful gazes, Masjid finder, Names of Allah s.w.t, Ghust ke adaab, Namaz ke dua with Islami Duniya application";

            sAux = sAux + "\n\nFor Online Quran follow this link\n\n"  + AppLInks.getPlaystore() + "\n\n";

            sAux = sAux + "\n\nFor Offline Quran follow this link\n\n"  + AppLInks.getOfflineAppLink() + "\n\n";

            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "share application"));

        });

        ghustkadaab = (LinearLayout) view.findViewById(R.id.gustkadab);
        ghustkadaab.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new GhustKeAdaab(),"ghust");
        });

        namazkdua = (LinearLayout) view.findViewById(R.id.namazkdua);
        namazkdua.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new Namaz_me_dua(),"namaz ke dua");
        });

        quran = (LinearLayout) view.findViewById(R.id.quran);
        quran.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new QuranIndexDisplay(),"index");

        });


        bookmark = (LinearLayout) view.findViewById(R.id.quranbookmark);
        bookmark.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new QuranBookmark(),"quranbookmark");
        });


        names99 = (LinearLayout) view.findViewById(R.id.names99);
        names99.setOnClickListener(view1 -> {
            startplayer();
            loadFragmentWithNoInternet(new AllahNames(),"AllahNames");
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

        search.setOnClickListener(view -> {
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
    public boolean loadFragment(Fragment fragment, String tag) {
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

    public boolean loadFragmentWithNoInternet(Fragment fragment,String tag) {

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
