package aidev.com.salahtimer.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.aidev.generictoast.GenericToast;
import java.util.List;
import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.pojo.QuranBookMarkDBTable;
import aidev.com.salahtimer.model.pojo.QuranBookmarkRepository;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

public class QuranBookmarkAdapter extends RecyclerView.Adapter<QuranBookmarkAdapter.ViewHolder>{


    private List<QuranBookMarkDBTable> listitem;
    private Context ctx;
    private QuranBookmarkRepository repository;
    private FragmentManager supportFragmentManager;



    public QuranBookmarkAdapter(Context ctx, List<QuranBookMarkDBTable> listitem, QuranBookmarkRepository repository, FragmentManager supportFragmentManager) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.repository = repository;
        this.supportFragmentManager = supportFragmentManager;
    }

    @Override
    public QuranBookmarkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_bookmark,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        QuranBookMarkDBTable quranBookMarkDBTable = listitem.get(position);

        holder.achapname.setText(quranBookMarkDBTable.getSurah_name_a());

        holder.echapname.setText(quranBookMarkDBTable.getSurah_name_e());

        holder.chapno.setText(quranBookMarkDBTable.getChapter_no());

        holder.verseno.setText(("VERSE "+quranBookMarkDBTable.getVerse_no()));

        holder.delete.setOnClickListener(view -> {
            repository.deleteParticular((quranBookMarkDBTable.getChapter_no()+""+quranBookMarkDBTable.getVerse_no()));
        });

        holder.continueread.setOnClickListener(view -> {

            movetoQuranChapter(Integer.parseInt(quranBookMarkDBTable.getChapter_no()),Integer.parseInt(quranBookMarkDBTable.getVerse_no()));
        });

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
            FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.quranbookmark,fragment).addToBackStack("chapter");
            fragmentTransaction.commit();
        }
        else { displayNoInternet("No Internet connection"); }
    }

    @SuppressLint("MissingPermission")
    private boolean checkConnection() {

        ConnectivityManager connectivityManager = (ConnectivityManager)  ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }
    private void displayNoInternet(String msg) {
//        TastyToast.makeText(ctx,msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
        GenericToast.showToast(ctx,
                msg,
                GenericToast.LENGTH_SHORT,
                GenericToast.ERROR,
                GenericToast.LITE,
                GenericToast.DEFAULT_FONT,
                GenericToast.DEFAULT_FONT);
    }

    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


       public TextView achapname, echapname, chapno, verseno, delete, continueread;


        public ViewHolder(View itemView) {
            super(itemView);

            achapname = (TextView) itemView.findViewById(R.id.achaptername);
            echapname = (TextView) itemView.findViewById(R.id.echaptername);
            chapno = (TextView) itemView.findViewById(R.id.chapterno);
            verseno = (TextView) itemView.findViewById(R.id.versebookmarked);
            delete = (TextView) itemView.findViewById(R.id.delete);
            continueread = (TextView) itemView.findViewById(R.id.read);

        }
    }

//    private void startplayer() {
//
//        final MediaPlayer mp = MediaPlayer.create(ctx ,R.raw.knock);
//        mp.start();
//    }

}
