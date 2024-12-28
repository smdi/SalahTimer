package aidev.com.salahtimer.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.aidev.generictoast.GenericToast;

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

public class QuranOffline extends Fragment {

    private QuranViewModel quranViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private TextView  arabic, translitertion, translation;
    private ImageView playpause, stop;
    private int num;
    private List<Quran_Ar_En.Datum> data1;
    private List<String> data2;
    private List<String > faker;
    private ProgressDialog progressDialog;
    int pplay = 0;
    int length = 0;
    private MediaPlayer mediaPlayer;
    private int onceMedia = 0;
    private RelativeLayout head,quranchapter;
    private SeekBar seekBar;
    private Handler mSeekbarUpdateHandler;
    private Runnable mUpdateSeekbar;
    private String message;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_offline_quran_chapter, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initialiser(view);

        num = getArguments().getInt("number");


        message = QuranIndex.QuranIndexProfile.getIndexDisplay(num);

        quranViewModel = new ViewModelProvider(this, new QuranFactory(getActivity())).get(QuranViewModel.class);

        SharedPreferences sh = getActivity().getSharedPreferences("DB", Context.MODE_PRIVATE);
        int exe = sh.getInt("dataofquran", 3);


//        if(exe == 1){
//            fetcherArabic(exe);
//        }
        if(exe == 2){
            fetcherTranslation(exe,num);
        }
        if(exe == 3){
            fetcherTransliteration(exe,num);
        }


    }

    private void fetcherTranslation(int exe, int num){
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
                adapter = new QuranOfflineAdapter(getActivity(),data1,data2,quranViewModel,exe,message.split("@"),num,progressDialog,mediaPlayer);
                recyclerView.setAdapter(adapter);
//                recyclerView.scrollToPosition(data1.size() -1);
                if(getArguments().getString("bookmark") != null){
                    recyclerView.scrollToPosition(getArguments().getInt("scroll"));
                }
                else{
                    recyclerView.scrollToPosition(0);
                }

                progressDialog.dismiss();
            }

            @Override
            public void onSuccess(Quran_Transliteration body) {

            }
        }, this.num);

    }

    private void fetcherTransliteration(int exe, int num) {
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
                adapter = new QuranOfflineAdapter(getActivity(),data1,data2,quranViewModel,exe, message.split("@"),num,progressDialog, mediaPlayer);
                recyclerView.setAdapter(adapter);
//                recyclerView.scrollToPosition(data2.size() - 1);

                if(getArguments().getString("bookmark") != null){
                    recyclerView.scrollToPosition(getArguments().getInt("scroll"));
                }
                else{
                    recyclerView.scrollToPosition(0);
                }

                progressDialog.dismiss();
            }
        }, this.num);
    }

    private void getPop() {

        progressDialog.dismiss();
//        TastyToast.makeText(getActivity(),"slow Internet",TastyToast.LENGTH_SHORT,TastyToast.ERROR).show();
        GenericToast.showToast(getActivity(),
                "slow Internet connection",
                GenericToast.LENGTH_SHORT,
                GenericToast.INFO,
                GenericToast.LITE,
                GenericToast.DEFAULT_FONT,
                GenericToast.DEFAULT_FONT);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        fm.popBackStack ("chapter", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    private void initialiser(View view) {

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("processing data!");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.show();

        mediaPlayer = new MediaPlayer();

        recyclerView = (RecyclerView) view.findViewById(R.id.quranverses);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(true);


        recyclerView.setLayoutManager(linearLayoutManager);

        head = view.findViewById(R.id.head);

        head.setOnClickListener(view1 -> {

        });

        seekBar = view.findViewById(R.id.seekbar);
        seekBar.setEnabled(false);

        quranchapter = view.findViewById(R.id.quranchapter);

        quranchapter.setOnClickListener(view1 -> {});


        mediaPlayer = new MediaPlayer();

        playpause = (ImageView) view.findViewById(R.id.playpause);
        stop = (ImageView) view.findViewById(R.id.stop);


        mSeekbarUpdateHandler = new Handler();
        mUpdateSeekbar = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                mSeekbarUpdateHandler.postDelayed(this, 50);
            }
        };

        playpause.setOnClickListener(view1 -> {

//            startplayer();

            try{
                if(onceMedia == 0){

                    String copy = "";
                    if(num >=1 && num <=9){
                        copy = "s00"+num;
                    }
                    if(num >= 10 && num <= 99){
                        copy = "s0"+num;
                    }
                    if(num >= 100  && num <= 114){
                        copy = "s"+num;
                    }

                    mediaPlayer = MediaPlayer.create(getActivity(),
                            getActivity().getResources().getIdentifier(copy, "raw", getActivity().getPackageName()));
                    onceMedia = 1;

                    seekBar.setMax(mediaPlayer.getDuration());

                    mediaPlayer.setOnCompletionListener(mediaPlayer -> {
                        pplay = 0;
                        length  = 0;
                        onceMedia = 0;
                        mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);
                        seekBar.setProgress(0);
                        playpause.setBackgroundResource(R.drawable.play);
//                        TastyToast.makeText(getActivity(),"stop",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                        GenericToast.showToast(getActivity(),
                                "Quran verse audio stopped!",
                                GenericToast.LENGTH_SHORT,
                                GenericToast.INFO,
                                GenericToast.LITE,
                                GenericToast.DEFAULT_FONT,
                                GenericToast.DEFAULT_FONT);
                        mediaPlayer.stop();
                        seekBar.setEnabled(false);
                    });
                }
                playSurah(mediaPlayer,  mUpdateSeekbar,mSeekbarUpdateHandler);
            }
            catch (Exception e){

            }


        });

        stop.setOnClickListener(view1 -> {

//            startplayer();
            if( mediaPlayer!= null && mediaPlayer.isPlaying()){
                pplay = 0;
                length  = 0;
                onceMedia = 0;
                seekBar.setProgress(0);
                seekBar.setEnabled(false);
                mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);
                playpause.setBackgroundResource(R.drawable.play);
//                TastyToast.makeText(getActivity(),"stop",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                GenericToast.showToast(getActivity(),
                        "Quran verse audio stopped!",
                        GenericToast.LENGTH_SHORT,
                        GenericToast.INFO,
                        GenericToast.LITE,
                        GenericToast.DEFAULT_FONT,
                        GenericToast.DEFAULT_FONT);
                mediaPlayer.stop();
            }

        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser && mediaPlayer != null)
                    mediaPlayer.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


//        arabic = (TextView) view.findViewById(R.id.arabic);
        translation = (TextView) view.findViewById(R.id.translation);
        translitertion = (TextView) view.findViewById(R.id.transliteration);

//        arabic.setOnClickListener(view1 -> {
//           store(1);
//           fetcherArabic(1);
//        });

        translitertion.setOnClickListener(view1 -> {
//            startplayer();
            store(3);
            fetcherTransliteration(3, num);
        });

        translation.setOnClickListener(view1 -> {
//            startplayer();
            if(checkConnection()){
                store(2);
                fetcherTranslation(2, num);
            }
            else {
                displayNoInternet("No Internet connection");
            }
        });

        faker = new ArrayList<>();
        faker.add("Fetching Data");


        adapter = new QuranChapterAdapter(getActivity(),data1,faker,quranViewModel,0);
        recyclerView.setAdapter(adapter);


    }

    private void playSurah(MediaPlayer mediaPlayer, Runnable mUpdateSeekbar, Handler mSeekbarUpdateHandler) {

        if (pplay == 0){

            pplay = 1;
            if(!mediaPlayer.isPlaying()&& length != 0){
//                TastyToast.makeText(getActivity(),"resume",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                GenericToast.showToast(getActivity(),
                        "Quran verse audio resumed!",
                        GenericToast.LENGTH_SHORT,
                        GenericToast.INFO,
                        GenericToast.LITE,
                        GenericToast.DEFAULT_FONT,
                        GenericToast.DEFAULT_FONT);
                mediaPlayer.seekTo(length);
                mediaPlayer.start();
            }
            else {
//                TastyToast.makeText(getActivity(),"play",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                GenericToast.showToast(getActivity(),
                        "Quran verse audio playing!",
                        GenericToast.LENGTH_SHORT,
                        GenericToast.INFO,
                        GenericToast.LITE,
                        GenericToast.DEFAULT_FONT,
                        GenericToast.DEFAULT_FONT);
                mediaPlayer.start();}
            playpause.setBackgroundResource(R.drawable.pause);
            mSeekbarUpdateHandler.postDelayed(mUpdateSeekbar, 0);
            seekBar.setEnabled(true);
        }
        else{
//            TastyToast.makeText(getActivity(),"pause",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
            GenericToast.showToast(getActivity(),
                    "Quran verse audio paused!",
                    GenericToast.LENGTH_SHORT,
                    GenericToast.INFO,
                    GenericToast.LITE,
                    GenericToast.DEFAULT_FONT,
                    GenericToast.DEFAULT_FONT);
            pplay = 0;
            mediaPlayer.pause();
            length = mediaPlayer.getCurrentPosition();
            mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);
            playpause.setBackgroundResource(R.drawable.play);
            seekBar.setEnabled(true);
        }


    }

    private void store(int i) {
        progressDialog.show();
        SharedPreferences.Editor editor = getActivity().getSharedPreferences("DB", Context.MODE_PRIVATE).edit();
        editor.putInt("dataofquran", i);
        editor.apply();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mediaPlayer != null && mediaPlayer.isPlaying()){
            pplay = 0;
            length  = 0;
            onceMedia = 0;
            seekBar.setProgress(0);
            seekBar.setEnabled(false);
            mSeekbarUpdateHandler.removeCallbacks(mUpdateSeekbar);
            playpause.setBackgroundResource(R.drawable.play);
//            TastyToast.makeText(getActivity(),"stop",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
            GenericToast.showToast(getActivity(),
                    "Quran verse audio stopped!",
                    GenericToast.LENGTH_SHORT,
                    GenericToast.INFO,
                    GenericToast.LITE,
                    GenericToast.DEFAULT_FONT,
                    GenericToast.DEFAULT_FONT);
            mediaPlayer.stop();
        }
    }


    @SuppressLint("MissingPermission")
    private boolean checkConnection() {
        ConnectivityManager connectivityManager = (ConnectivityManager)  getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }
    private void displayNoInternet(String msg) {
//        TastyToast.makeText(getActivity(),msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
        GenericToast.showToast(getActivity(),
                msg,
                GenericToast.LENGTH_SHORT,
                GenericToast.ERROR,
                GenericToast.LITE,
                GenericToast.DEFAULT_FONT,
                GenericToast.DEFAULT_FONT);
    }

}