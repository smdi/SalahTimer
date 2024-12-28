package aidev.com.salahtimer.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.pojo.HadithBookmarkDBTable;
import aidev.com.salahtimer.viewmodel.HadithBookmarkViewModel;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HadithBookmark extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private HadithBookmarkViewModel hadithBookmarkViewModel;
    private List<HadithBookmarkDBTable> listView;
    private ImageView nodata;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_hadithbookmark, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initialiser(view);

        nodata = (ImageView) view.findViewById(R.id.nodata);

        hadithBookmarkViewModel = new ViewModelProvider(this).get(HadithBookmarkViewModel.class);

        hadithBookmarkViewModel.getAllBookmarkHadiths().observe(this, hadithBookmarkDBTables -> {

            //set data to adapter
            listView = hadithBookmarkDBTables;
            if(listView.size()>0){
                recyclerView.setVisibility(View.VISIBLE);
                nodata.setVisibility(View.GONE);
            }
            else {
                recyclerView.setVisibility(View.GONE);
                nodata.setVisibility(View.VISIBLE);
            }
            adapter = new HadithBookmarkAdapter(getActivity(),listView, hadithBookmarkViewModel);
            recyclerView.setAdapter(adapter);

        });

    }



    private void initialiser(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
    }


}