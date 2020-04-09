package aidev.com.salahtimer.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.List;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.RetrofitResponseListener;
import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.model.pojo.Quran_Transliteration;
import aidev.com.salahtimer.model.pojo.TimingsData;
import aidev.com.salahtimer.viewmodel.QuranViewModel;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class QuranChapter extends Fragment {

    private QuranViewModel quranViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TextView chapterName, arabic, translitertion, translation;
    private ImageView playpause, stop;
    private int num;
    private List<Quran_Ar_En.Datum> data1;
    private List<String> data2;
    private List<String > faker;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quran_chapter, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initialiser(view);

//        num = getArguments().getInt("number");

        num = 1;

        String message = QuranIndex.QuranIndexProfile.getIndexDisplay(num);
        String[] array = message.split("@");

        chapterName.setText(""+array[5]);



        quranViewModel = new ViewModelProvider(this, new QuranFactory(getActivity())).get(QuranViewModel.class);

        SharedPreferences sh = getActivity().getSharedPreferences("DB", Context.MODE_PRIVATE);
        int exe = sh.getInt("dataofquran", 1);


        if(exe == 1){
            fetcherArabic(exe);
        }
        if(exe == 2){
            fetcherTranslation(exe);
        }
        if(exe == 3){
            fetcherTransliteration(exe);
        }


    }

    private void fetcherTranslation(int exe){
        quranViewModel.getQuranEnglishChapterwise(new RetrofitResponseListener() {
            @Override
            public void onFailure() {
                getPop();
            }

            @Override
            public void onSuccess(TimingsData body) {

            }

            @Override
            public void onSuccess(Quran_Ar_En body) {

                data1 = body.data;
                adapter = new QuranChapterAdapter(getActivity(),data1,data2,quranViewModel,exe);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onSuccess(Quran_Transliteration body) {

            }
        }, num);

    }



    private void fetcherTransliteration(int exe) {
        quranViewModel.getQuranTransliterationChapterwise(new RetrofitResponseListener() {
            @Override
            public void onFailure() {
                getPop();
            }

            @Override
            public void onSuccess(TimingsData body) {

            }

            @Override
            public void onSuccess(Quran_Ar_En body) {

            }

            @Override
            public void onSuccess(Quran_Transliteration body) {

                data2 = body.data;
                adapter = new QuranChapterAdapter(getActivity(),data1,data2,quranViewModel,exe);
                recyclerView.setAdapter(adapter);
            }
        }, num);
    }

    private void fetcherArabic(int exe) {
        quranViewModel.getQuranArabicChapterwise(new RetrofitResponseListener() {
                @Override
                public void onFailure() {
                    getPop();
                }

                @Override
                public void onSuccess(TimingsData body) {

                }

                @Override
                public void onSuccess(Quran_Ar_En body) {
                    data1 = body.data;
                    adapter = new QuranChapterAdapter(getActivity(),data1,data2,quranViewModel,exe);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onSuccess(Quran_Transliteration body) {

                }
            }, num);
    }

    private void getPop() {
        TastyToast.makeText(getActivity(),"No data found",TastyToast.LENGTH_SHORT,TastyToast.ERROR).show();

        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack ("chapter", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    private void initialiser(View view) {

        recyclerView = (RecyclerView) view.findViewById(R.id.quranverses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        chapterName = (TextView) view.findViewById(R.id.chaptername);
        playpause = (ImageView) view.findViewById(R.id.playpause);
        stop = (ImageView) view.findViewById(R.id.stop);

        arabic = (TextView) view.findViewById(R.id.arabic);
        translation = (TextView) view.findViewById(R.id.translation);
        translitertion = (TextView) view.findViewById(R.id.transliteration);

        arabic.setOnClickListener(view1 -> {
           store(1);
           fetcherArabic(1);
        });

        translitertion.setOnClickListener(view1 -> {
            store(3);
            fetcherTransliteration(3);
        });

        translation.setOnClickListener(view1 -> {
            store(2);
            fetcherTranslation(2);
        });

        faker = new ArrayList<>();
        faker.add("Fetching Data");
        faker.add("Fetching Data");


        adapter = new QuranChapterAdapter(getActivity(),data1,faker,quranViewModel,0);
        recyclerView.setAdapter(adapter);


    }

    private void store(int i) {
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("DB", Context.MODE_PRIVATE).edit();
        editor.putInt("dataofquran", i);
        editor.apply();
    }


}