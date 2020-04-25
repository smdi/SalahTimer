package aidev.com.salahtimer.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.R;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class QuranBookmark  extends Fragment {

    private TextView surahno, surahname, verses, revealedat, verseno, versename;
    private Button clicktoread;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.quran_bookmark, container, false);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        surahno = view.findViewById(R.id.surahno);
        surahname = view.findViewById(R.id.surahname);
        verses = view.findViewById(R.id.totalverses);
        revealedat = view.findViewById(R.id.revealed);
        verseno =view.findViewById(R.id.verseno);
        versename = view.findViewById(R.id.verse);
        clicktoread = view.findViewById(R.id.clickread);

        SharedPreferences sh = getActivity().getSharedPreferences("QuranBookmark", Context.MODE_PRIVATE);
        surahno.setText(""+sh.getInt("chapterno", 1));
        surahname.setText(sh.getString("chaptername","Al- Fatiha"));
        verses.setText(sh.getString("verses","6"));
        revealedat.setText(sh.getString("revealedat","Makki"));
        verseno.setText(""+sh.getInt("verseno",1));
        versename.setText(sh.getString("verse","Alhamdu lillahi Rabbil 'aalameen"));


        clicktoread.setOnClickListener(view1 -> movetoQuranChapter(sh.getInt("chapterno",1),sh.getInt("verseno",1)));
    }

    private void movetoQuranChapter(int num, int verseno){

        if(checkConnection()){
            Bundle bundle = new Bundle();
            bundle.putInt("number",num);
            bundle.putString("bookmark","scroll");
            bundle.putInt("scroll",verseno);
            Fragment fragment = new QuranChapter();  //online
//        Fragment fragment = new QuranOffline();  //offline
            fragment.setArguments(bundle);
            FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.quranbookmark,fragment).addToBackStack("chapter");
            fragmentTransaction.commit();
        }
        else { displayNoInternet("No Internet"); }
    }

    private boolean checkConnection() {


        ConnectivityManager connectivityManager = (ConnectivityManager)  getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }
    private void displayNoInternet(String msg) {
        TastyToast.makeText(getActivity(),msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
    }

}