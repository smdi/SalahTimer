package aidev.com.salahtimer.view;



import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.AdapterView;
import android.widget.ListView;

import com.sdsmdg.tastytoast.TastyToast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.pojo.HadithBookmarkDBTable;
import aidev.com.salahtimer.viewmodel.HadithBookmarkViewModel;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Hadith extends Fragment {


    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private HadithBookmarkViewModel hadithBookmarkViewModel;
    private List<HadithBookmarkDBTable> listView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hadith,container,false);
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initialiser(view);

        hadithBookmarkViewModel = new ViewModelProvider(this).get(HadithBookmarkViewModel.class);

        hadithBookmarkViewModel.getAllHadiths().observe(this, hadithBookmarkDBTables -> {

            //set data to adapter
            SharedPreferences sh = getActivity().getSharedPreferences("HadithSNO", Context.MODE_PRIVATE);
            int exe = sh.getInt("hno", 1);
            listView = hadithBookmarkDBTables;
            adapter = new HadithAdapter(getActivity(), listView, hadithBookmarkViewModel);
            recyclerView.setAdapter(adapter);
            recyclerView.scrollToPosition(exe);

        });

    }

    private void initialiser(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(false);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

}
