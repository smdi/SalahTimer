package aidev.com.salahtimer.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aidev.generictoast.GenericToast;
import java.util.ArrayList;
import java.util.List;
import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.InternetChecker;
import aidev.com.salahtimer.model.pojo.CountryCityDBTable;
import aidev.com.salahtimer.model.pojo.CountryCityRepository;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;



public class Location extends Fragment {



    private Button search;
    private AutoCompleteTextView cityac, conac;
    private TextView share;
    private LinearLayout tasbeeh, unlawfulgazes, hadith, hadithBookmark, quran, bookmark, names99, namazkdua;
    private TextView cityerr, conerr;

    private CountryCityRepository mRepository;

    private LiveData<List<CountryCityDBTable>> allCC;
    private InternetChecker internetChecker;
    private boolean isConnectionAvailable = false;

    List<CountryCityDBTable> list;
    ArrayList<String> arrayList;
    ArrayAdapter<String> arrayAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_location,container ,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cityac = (AutoCompleteTextView) view.findViewById(R.id.cityac);
        conac = (AutoCompleteTextView) view.findViewById(R.id.conac);

        internetChecker = new InternetChecker(view.getContext());
        internetChecker.setNetworkStateListener(new InternetChecker.NetworkStateListener() {
            @Override
            public void onNetworkAvailable() {
                isConnectionAvailable = true;
            }

            @Override
            public void onNetworkLost() {
                isConnectionAvailable = false;
            }

            @Override
            public void onInternetCapabilityChanged(boolean hasInternet) {
            }
        });
        internetChecker.startMonitoring();


        initialisers(view);
    }

    private void initialisers(View view) {


        conerr = (TextView) view.findViewById(R.id.conerr);
        cityerr = (TextView) view.findViewById(R.id.cityerr);

        share = (TextView) view.findViewById(R.id.share);
        share.setOnClickListener(view13 -> {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_SUBJECT, "Islami Duniya");
            String sAux = "\nAssalamualaikum wa rahamatullahi wa barakaatuhu\n" +
                    "\nKnow salah timings,\nQuran in english transliteration,\nHadith,\nTasbeeh counter,\n" +
                    "Names of Allah s.w.t,\nDuaen with Islami Duniya application";

            sAux = sAux + "\n\nPlay store link for the application\n\n"  + AppLInks.getPlaystore() + "\n\n\n";

            i.putExtra(Intent.EXTRA_TEXT, sAux);
            startActivity(Intent.createChooser(i, "share application"));

        });


        namazkdua = (LinearLayout) view.findViewById(R.id.namazkdua);
        namazkdua.setOnClickListener(view1 -> {

            loadFragmentWithNoInternet(new Namaz_me_dua(),"namaz ke dua");
        });

        quran = (LinearLayout) view.findViewById(R.id.quran);
        quran.setOnClickListener(view1 -> {

            loadFragmentWithNoInternet(new QuranIndexDisplay(),"index");

        });


        bookmark = (LinearLayout) view.findViewById(R.id.quranbookmark);
        bookmark.setOnClickListener(view1 -> {

            loadFragmentWithNoInternet(new QuranBookmark(),"quranbookmark");
        });


        names99 = (LinearLayout) view.findViewById(R.id.names99);
        names99.setOnClickListener(view1 -> {

            loadFragmentWithNoInternet(new AllahNames(),"AllahNames");
        });


        hadith = (LinearLayout) view.findViewById(R.id.hadith);
        hadith.setOnClickListener(view1 -> {

            Bundle bundle = new Bundle();
            bundle.putString("data","read");
            Fragment fragment = new Hadith();
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame,fragment).addToBackStack("hadith");
            fragmentTransaction.commit();
        });

        tasbeeh = (LinearLayout) view.findViewById(R.id.tasbeehlayout);
        tasbeeh.setOnClickListener(view1 -> {

            loadFragmentWithNoInternet(new TasbeehFragment(),"tasbeeh");
        });


        hadithBookmark = (LinearLayout) view.findViewById(R.id.hadithbookmark);
        hadithBookmark.setOnClickListener(view1 -> {

            loadFragmentWithNoInternet(new HadithBookmark(),"HadithBookmark");
        });


        search = view.findViewById(R.id.get_The_Results);
    }


    @Override
    public void onStart() {
        super.onStart();


        SharedPreferences sh = getActivity().getSharedPreferences("DB", Context.MODE_PRIVATE);
        String ct = sh.getString("city", "no");
        String con = sh.getString("country", "India");

        if(!ct.equals("no")){
            cityac.setText(ct);
        }
        conac.setText(con);


        arrayList = new ArrayList<>();


        mRepository = new CountryCityRepository(getActivity().getApplication());
        mRepository.getAllCC().observe(this, countryCityDBTables -> {

            for(CountryCityDBTable countryCityDBTable:countryCityDBTables){
                arrayList.add(countryCityDBTable.getNames());
            }

            arrayAdapter = new ArrayAdapter<>(getActivity(),R.layout.support_simple_spinner_dropdown_item,arrayList);

            cityac.setThreshold(1);
            conac.setThreshold(1);
            cityac.setAdapter(arrayAdapter);
            conac.setAdapter(arrayAdapter);

        });



        search.setOnClickListener(view -> {


            String cityText = cityac.getText().toString();
            String countryText = conac.getText().toString();

            boolean cityb = false, countryb = false;

            if(cityText.length() > 0){
                cityb = true;
            }
            else {
                cityerr.setVisibility(View.VISIBLE);
            }
            if(countryText.length() > 0){
                countryb = true;
            }
            else {
                conerr.setVisibility(View.VISIBLE);
            }
            if(cityb & countryb){
                cityerr.setVisibility(View.GONE);
                conerr.setVisibility(View.GONE);
                setCityCountry(cityText,countryText);
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
            fragmentTransaction.replace(R.id.location,fragment).addToBackStack("timings");
            fragmentTransaction.commit();
        }
        else { displayNoInternet("No Internet connection"); }

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
        else { displayNoInternet("No Internet connection"); }

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

        GenericToast.showToast(getActivity(),
                msg,
                GenericToast.LENGTH_SHORT,
                GenericToast.ERROR,
                GenericToast.LITE,
                GenericToast.DEFAULT_FONT,
                GenericToast.DEFAULT_FONT);
    }


    @SuppressLint("MissingPermission")
    private boolean checkConnection() {

        if (!isConnectionAvailable) {
            return false;
        }
        return true;

    }
}
