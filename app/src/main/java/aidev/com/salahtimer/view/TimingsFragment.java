package aidev.com.salahtimer.view;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.RetrofitResponseListener;
import aidev.com.salahtimer.model.pojo.TimingsData;
import aidev.com.salahtimer.viewmodel.TimingsViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

public class TimingsFragment extends Fragment {

    private String cityText, countryText;

    private TimingsViewModel tvmhanafi, tvmshafii;
    private TimingsData.Datum data;
    private int i = 0;

    private TextView citycountry, timezone, sunrise, sunset, date, imsak, fajr, dhuhr, asrs, asrh, maghrib, isha, midnight;

    private TextView viewgridlist;

    private LinearLayout layout1, layout2, layout3, layout4, layout5, imsaklayout, fajrlayout, sunriselayout, dhuhrlayout, asrshafilayout,
    asrhanafilayout, sunsetlayout, maghriblayout, ishalayout, midnightlayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test,container ,false);
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

        layout1 = view.findViewById(R.id.layout1);
        layout2 = view.findViewById(R.id.layout2);
        layout3 = view.findViewById(R.id.layout3);
        layout4 = view.findViewById(R.id.layout4);
        layout5 = view.findViewById(R.id.layout5);

        imsaklayout = view.findViewById(R.id.imsaklayout);
        fajrlayout = view.findViewById(R.id.fajrlayout);
        sunriselayout = view.findViewById(R.id.sunriselayout);
        dhuhrlayout = view.findViewById(R.id.dhuhrlayout);
        asrshafilayout = view.findViewById(R.id.asrslayout);
        asrhanafilayout = view.findViewById(R.id.asrhlayout);
        sunsetlayout = view.findViewById(R.id.sunsetlayout);
        maghriblayout = view.findViewById(R.id.maghriblayout);
        ishalayout = view.findViewById(R.id.ishalayout);
        midnightlayout = view.findViewById(R.id.midnightlayout);


        viewgridlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(i == 0){
                    viewgridlist.setText("Grid view");
                    i = 1;
                    layout1.setOrientation(LinearLayout.VERTICAL);
                    layout2.setOrientation(LinearLayout.VERTICAL);
                    layout3.setOrientation(LinearLayout.VERTICAL);
                    layout4.setOrientation(LinearLayout.VERTICAL);
                    layout5.setOrientation(LinearLayout.VERTICAL);

                    LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);

                    imsaklayout.setOrientation(LinearLayout.HORIZONTAL);
                    imsaklayout.setLayoutParams(parms);
                    fajrlayout.setOrientation(LinearLayout.HORIZONTAL);
                    fajrlayout.setLayoutParams(parms);
                    sunriselayout.setOrientation(LinearLayout.HORIZONTAL);
                    sunriselayout.setLayoutParams(parms);
                    dhuhrlayout.setOrientation(LinearLayout.HORIZONTAL);
                    dhuhrlayout.setLayoutParams(parms);
                    asrshafilayout.setOrientation(LinearLayout.HORIZONTAL);
                    asrshafilayout.setLayoutParams(parms);
                    asrhanafilayout.setOrientation(LinearLayout.HORIZONTAL);
                    asrhanafilayout.setLayoutParams(parms);
                    sunsetlayout.setOrientation(LinearLayout.HORIZONTAL);
                    sunsetlayout.setLayoutParams(parms);
                    maghriblayout.setOrientation(LinearLayout.HORIZONTAL);
                    maghriblayout.setLayoutParams(parms);
                    ishalayout.setOrientation(LinearLayout.HORIZONTAL);
                    ishalayout.setLayoutParams(parms);
                    midnightlayout.setOrientation(LinearLayout.HORIZONTAL);
                    midnightlayout.setLayoutParams(parms);

                }
                else{
                    viewgridlist.setText("List view");
                    i = 0;

                    layout1.setOrientation(LinearLayout.HORIZONTAL);
                    layout2.setOrientation(LinearLayout.HORIZONTAL);
                    layout3.setOrientation(LinearLayout.HORIZONTAL);
                    layout4.setOrientation(LinearLayout.HORIZONTAL);
                    layout5.setOrientation(LinearLayout.HORIZONTAL);


                    LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(R.dimen.size_of_card,R.dimen.size_of_card);

                    imsaklayout.setOrientation(LinearLayout.VERTICAL);
                    imsaklayout.setLayoutParams(parms);
                    fajrlayout.setOrientation(LinearLayout.VERTICAL);
                    fajrlayout.setLayoutParams(parms);
                    sunriselayout.setOrientation(LinearLayout.VERTICAL);
                    sunriselayout.setLayoutParams(parms);
                    dhuhrlayout.setOrientation(LinearLayout.VERTICAL);
                    dhuhrlayout.setLayoutParams(parms);
                    asrshafilayout.setOrientation(LinearLayout.VERTICAL);
                    asrshafilayout.setLayoutParams(parms);
                    asrhanafilayout.setOrientation(LinearLayout.VERTICAL);
                    asrhanafilayout.setLayoutParams(parms);
                    sunsetlayout.setOrientation(LinearLayout.VERTICAL);
                    sunsetlayout.setLayoutParams(parms);
                    maghriblayout.setOrientation(LinearLayout.VERTICAL);
                    maghriblayout.setLayoutParams(parms);
                    ishalayout.setOrientation(LinearLayout.VERTICAL);
                    ishalayout.setLayoutParams(parms);
                    midnightlayout.setOrientation(LinearLayout.VERTICAL);
                    midnightlayout.setLayoutParams(parms);

                }



            }
        });

    }



}
