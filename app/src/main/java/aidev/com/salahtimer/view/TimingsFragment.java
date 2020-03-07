package aidev.com.salahtimer.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.model.ConfigurationFile;
import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.RetrofitResponseListener;
import aidev.com.salahtimer.model.pojo.TimingsData;
import aidev.com.salahtimer.viewmodel.TimingsViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

public class TimingsFragment extends Fragment {

    private String cityText, countryText;

    private TimingsViewModel tvmhanafi, tvmshafii;
    private TimingsData.Datum data;
    private int i;

    private TextView citycountry, timezone, sunrise, sunset, date, imsak, fajr, dhuhr, asrs, asrh, maghrib, isha, midnight;

    private TextView viewgridlist;

    private TextView sunriselv, sunsetlv, imsaklv, fajrlv, dhuhrlv, asrslv, asrhlv, maghriblv, ishalv, midnightlv;

    private CardView listview;
    private LinearLayout gridview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timings_item,container ,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        cityText = getArguments().getString("city");
        countryText = getArguments().getString("country");
        initializer(view);

        tvmhanafi = ViewModelProviders.of(this, new TimingsFactory(getActivity(), cityText, countryText)).get(TimingsViewModel.class);


        tvmhanafi.getHanafiTimingsData(new RetrofitResponseListener() {
            @Override
            public void onFailure() {
                TastyToast.makeText(getActivity(),"No data found",Toast.LENGTH_SHORT,TastyToast.ERROR).show();
                Fragment fragment = new Location();
                FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentstimingsitem,fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }

            @Override
            public void onSuccess(TimingsData body) {
                data = body.data;


                String coni = ""+countryText.toString().charAt(0);
                String citi = ""+cityText.toString().charAt(0);

                citycountry.setText(coni.toUpperCase() + countryText.toString().substring(1,countryText.toString().length())
                                    +" - " + citi.toUpperCase() + cityText.toString().substring(1,cityText.toString().length()));
                timezone.setText(data.meta.timezone);
                sunrise.setText(data.timings.sunrise);
                sunset.setText(data.timings.sunset);
                date.setText(data.date.date);
                imsak.setText(data.timings.imsak);
                fajr.setText(data.timings.fajr);
                dhuhr.setText(data.timings.dhuhr);
                asrh.setText(data.timings.asr);
                maghrib.setText(data.timings.magrib);
                isha.setText(data.timings.isha);
                midnight.setText(data.timings.midnight);



                sunriselv.setText(data.timings.sunrise);
                sunsetlv.setText(data.timings.sunset);
                imsaklv.setText(data.timings.imsak);
                fajrlv.setText(data.timings.fajr);
                dhuhrlv.setText(data.timings.dhuhr);
                asrhlv.setText(data.timings.asr);
                maghriblv.setText(data.timings.magrib);
                ishalv.setText(data.timings.isha);
                midnightlv.setText(data.timings.midnight);

            }
        });

        tvmshafii = ViewModelProviders.of(this, new TimingsFactory(getActivity(), cityText, countryText)).get(TimingsViewModel.class);

        tvmshafii.getShafiTimingsData(new RetrofitResponseListener() {
            @Override
            public void onFailure() {

            }

            @Override
            public void onSuccess(TimingsData body) {

                asrs.setText(body.data.timings.asr.toString());
                asrslv.setText(body.data.timings.asr.toString());
            }
        });
    }



    private void initializer(View view) {

        citycountry = view.findViewById(R.id.citycountry);
        timezone = view.findViewById(R.id.timezone);
        sunrise = view.findViewById(R.id.sunrise);
        sunset = view.findViewById(R.id.sunset);
        date = view.findViewById(R.id.date);
        imsak = view.findViewById(R.id.imsak);
        fajr = view.findViewById(R.id.fajr);
        dhuhr = view.findViewById(R.id.dhuhr);
        imsak = view.findViewById(R.id.imsak);
        fajr =view.findViewById(R.id.fajr);
        dhuhr =view.findViewById(R.id.dhuhr);
        asrh = view.findViewById(R.id.asrh);
        asrs = view.findViewById(R.id.asrs);
        maghrib = view.findViewById(R.id.maghrib);
        isha =view.findViewById(R.id.isha);
        midnight =view.findViewById(R.id.midnight);
        viewgridlist = view.findViewById(R.id.view);

        sunriselv = view.findViewById(R.id.sunriselv);
        sunsetlv = view.findViewById(R.id.sunsetlv);
        imsaklv = view.findViewById(R.id.imsaklv);
        fajrlv = view.findViewById(R.id.fajrlv);
        dhuhrlv = view.findViewById(R.id.dhuhrlv);
        asrhlv = view.findViewById(R.id.asrhlv);
        asrslv = view.findViewById(R.id.asrslv);
        maghriblv = view.findViewById(R.id.maghriblv);
        ishalv =view.findViewById(R.id.ishalv);
        midnightlv =view.findViewById(R.id.midnightlv);


        gridview = view.findViewById(R.id.grid);
        listview = view.findViewById(R.id.listview);

        i = getDataFromSharedPref(view);
        Toast.makeText(getActivity(), ""+i ,Toast.LENGTH_SHORT);

        setVisibilityToViews(i);



        viewgridlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(i == 0){
                    i = 1;
                    setVisibilityToViews(i);
                    setViewDataToSharedPreference(i);
                }
                else{
                    i = 0;
                    setVisibilityToViews(i);
                    setViewDataToSharedPreference(i);
                }



            }
        });

    }

    private void setVisibilityToViews(int i) {

        if(i == 0){
            viewgridlist.setText("Grid view");
            gridview.setVisibility(View.GONE);
            listview.setVisibility(View.VISIBLE);

        }
        else{
            viewgridlist.setText("List view");
            listview.setVisibility(View.GONE);
            gridview.setVisibility(View.VISIBLE);
        }
    }

    private int getDataFromSharedPref(View view) {

        SharedPreferences prefs = getActivity().getSharedPreferences(""+ConfigurationFile.viewDB, Context.MODE_PRIVATE);
        int viewVal = prefs.getInt(""+ConfigurationFile.viewVal, 0);
        return  viewVal;
    }


    public void setViewDataToSharedPreference(int viewDataToSharedPreference) {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences(""+ConfigurationFile.viewDB, Context.MODE_PRIVATE).edit();
        editor.putInt(""+ConfigurationFile.viewVal, viewDataToSharedPreference);
        editor.apply();
    }

   }
