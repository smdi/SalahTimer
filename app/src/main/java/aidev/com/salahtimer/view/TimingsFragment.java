package aidev.com.salahtimer.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import aidev.com.salahtimer.model.ConfigurationFile;
import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.RetrofitResponseListener;
import aidev.com.salahtimer.model.pojo.CountryCityDBTable;
import aidev.com.salahtimer.model.pojo.CountryCityRepository;
import aidev.com.salahtimer.model.pojo.HadithBookmarkRepository;
import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.model.pojo.Quran_Transliteration;
import aidev.com.salahtimer.model.pojo.TimingsData;
import aidev.com.salahtimer.viewmodel.TimingsViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.aidev.generictoast.GenericToast;

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

    private ProgressDialog dialog;

    private CountryCityRepository mRepository;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timings_item,container ,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRepository = new CountryCityRepository(getActivity().getApplication());

        cityText = getArguments().getString("city");
        countryText = getArguments().getString("country");

        initializer(view);

        tvmhanafi = new ViewModelProvider(this, new TimingsFactory(getActivity(), cityText, countryText)).get(TimingsViewModel.class);

        tvmhanafi.getHanafiTimingsData(new RetrofitResponseListener() {
            @Override
            public void onFailure() {
//                TastyToast.makeText(getActivity(),"No data found",TastyToast.LENGTH_SHORT,TastyToast.ERROR).show();
                GenericToast.showToast(getActivity(),
                        "No data found!",
                        GenericToast.LENGTH_SHORT,
                        GenericToast.ERROR,
                        GenericToast.LITE,
                        GenericToast.DEFAULT_FONT,
                        GenericToast.DEFAULT_FONT);
                dialog.dismiss();
                FragmentManager fm = getActivity()
                        .getSupportFragmentManager();
                fm.popBackStack ("timings", FragmentManager.POP_BACK_STACK_INCLUSIVE);
            }

            @Override
            public void onSuccess(TimingsData body) {

                data = body.data;


                String coni = ""+countryText.toString().charAt(0);
                String citi = ""+cityText.toString().charAt(0);

                String conName  = coni.toUpperCase() + countryText.toString().substring(1,countryText.toString().length()).toLowerCase();
                String cityName = citi.toUpperCase() + cityText.toString().substring(1,cityText.toString().length()).toLowerCase();

                citycountry.setText(conName +" - " + cityName);

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

                try{

                    mRepository.insert(new CountryCityDBTable(conName));
                    mRepository.insert(new CountryCityDBTable(cityName));

                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("DB", Context.MODE_PRIVATE).edit();
                    editor.putString("city", cityName);
                    editor.putString("country", conName);
                    editor.apply();

                }
                catch (Exception e){
                    Log.e("TimingsFragment","error in storing data",e);
                }

                sunriselv.setText(data.timings.sunrise);
                sunsetlv.setText(data.timings.sunset);
                imsaklv.setText(data.timings.imsak);
                fajrlv.setText(data.timings.fajr);
                dhuhrlv.setText(data.timings.dhuhr);
                asrhlv.setText(data.timings.asr);
                maghriblv.setText(data.timings.magrib);
                ishalv.setText(data.timings.isha);
                midnightlv.setText(data.timings.midnight);


                try{

                }catch (Exception e) {
                    Log.e("TimingsFragment","error in timings fragment",e);
                }

            }

            @Override
            public void onSuccess(Quran_Ar_En body) {

            }

            @Override
            public void onSuccess(Quran_Transliteration body) {

            }
        });

        tvmshafii = new ViewModelProvider(this, new TimingsFactory(getActivity(), cityText, countryText)).get(TimingsViewModel.class);

        tvmshafii.getShafiTimingsData(new RetrofitResponseListener() {
            @Override
            public void onFailure() {

            }

            @Override
            public void onSuccess(TimingsData body) {

                asrs.setText(body.data.timings.asr.toString());
                asrslv.setText(body.data.timings.asr.toString());

                dialog.dismiss();
            }
            @Override
            public void onSuccess(Quran_Ar_En body) {

            }

            @Override
            public void onSuccess(Quran_Transliteration body) {

            }
        });
    }



    private void initializer(View view) {

        dialog = new ProgressDialog(getActivity(), R.style.CustomProgressDialog);
        dialog.setMessage("processing data!");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();

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
//        Toast.makeText(getActivity(), ""+i ,Toast.LENGTH_SHORT);

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
