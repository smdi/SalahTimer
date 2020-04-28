package aidev.com.salahtimer.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.sdsmdg.tastytoast.TastyToast;

import java.io.IOException;
import java.util.List;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.pojo.QuranBookMarkDBTable;
import aidev.com.salahtimer.model.pojo.QuranBookmarkRepository;
import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.viewmodel.QuranViewModel;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class QuranChapterAdapter extends RecyclerView.Adapter<QuranChapterAdapter.ViewHolder> {

    private QuranViewModel quranViewModel;
    private Context ctx;
    private List<Quran_Ar_En.Datum> listitem;
    private List<String> listitem1;
    private int use;
    private int num;
    private String[] split;
    private SharedPreferences sh;
    private ProgressDialog progressDialog;
    private SharedPreferences.Editor editor;
    private MediaPlayer mediaPlayer;
    private int onceMedia = 0;
    private int prevposition = -1;
    private int length = 0 ;
    private QuranBookmarkRepository quranBookmarkRepository;


    public QuranChapterAdapter(Activity ctx, List<Quran_Ar_En.Datum> listitem, List<String> listitem1
            , QuranViewModel quranViewModel, int exe, String[] split, int num, ProgressDialog progressDialog, MediaPlayer mediaPlayer) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.listitem1 = listitem1;
        this.quranViewModel = quranViewModel;
        this.use  =exe;
        this.num= num;
        this.split = split;
        this.progressDialog = progressDialog;
        sh = ctx.getSharedPreferences("QuranBookmark", Context.MODE_PRIVATE);
        this.mediaPlayer = mediaPlayer;
        quranBookmarkRepository = new QuranBookmarkRepository(ctx.getApplication());
    }

    public QuranChapterAdapter(Context ctx, List<Quran_Ar_En.Datum> listitem, List<String> listitem1
            , QuranViewModel quranViewModel,int use) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.listitem1 = listitem1;
        this.quranViewModel = quranViewModel;
        this.use  =use;
        this.split = split;
        sh = ctx.getSharedPreferences("QuranBookmark", Context.MODE_PRIVATE);
    }

    @Override
    public QuranChapterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_chapter_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        if(use == 0){

            holder.vno.setText("Data");

            holder.content.setText(""+listitem1.get(position));
        }

        if( use == 2){

            Quran_Ar_En.Datum data = listitem.get(position);

            holder.vno.setText(data.verseId);

            holder.content.setText(data.text);

            holder.cardView.setOnClickListener(view -> {

                TastyToast.makeText(ctx,"Bookmarked",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();

                quranBookmarkRepository.insert(new QuranBookMarkDBTable((num+""+data.verseId),split[5],split[1],""+data.verseId,""+num));
            });

            checkandSetBookmark(holder,data.verseId,split[0]);
        }

        if(use == 3){

            int ind = position+1;
            holder.vno.setText(""+(position+1));

            holder.content.setText(listitem1.get(position));

            holder.cardView.setOnClickListener(view -> {

                TastyToast.makeText(ctx,"Bookmarked",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();

                quranBookmarkRepository.insert(new QuranBookMarkDBTable((num+""+ind),split[5],split[1],""+ind,""+num));

            });
        }

        holder.stop.setEnabled(false);

        holder.play.setOnClickListener(view -> {

//            startplayer();
            if(checkConnection()){
                if(onceMedia == 0 && position!= prevposition){

//                mediaPlayer = new MediaPlayer();
                    holder.play.setBackgroundResource(R.drawable.pausecolored);
                    onceMedia = 1;
                    mediaPlayer.reset();
                    prevposition = position;
                    progressDialog.show();

                    String url = getStringUrl(position,num);

                    gotoMediaPlayer(url,holder);

                    mediaPlayer.setOnCompletionListener(mediaPlayer -> {
                        holder.play.setBackgroundResource(R.drawable.playcolored);

                        mediaPlayer.stop();
                        mediaPlayer.reset();
//                    mediaPlayer.release();
                        TastyToast.makeText(ctx,"stop",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                        length = 0;
                        onceMedia = 0;
                        prevposition = -1;
                        holder.stop.setEnabled(false);
                    });

                }
                else{


                    if(length!=0 && !mediaPlayer.isPlaying()){
                        TastyToast.makeText(ctx,"resume",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                        holder.play.setBackgroundResource(R.drawable.pausecolored);
                        mediaPlayer.seekTo(length);
                        mediaPlayer.start();
                    }
                    else if(mediaPlayer.isPlaying()) {
                        TastyToast.makeText(ctx,"pause",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
                        holder.play.setBackgroundResource(R.drawable.playcolored);
                        mediaPlayer.pause();
                        length = mediaPlayer.getCurrentPosition();
                    }
                    onceMedia = 0;
                }

            }
            else {
                progressDialog.dismiss();
                displayNoInternet("No Internet");
            }

        });

        holder.stop.setOnClickListener(view -> {

//            startplayer();
            holder.play.setBackgroundResource(R.drawable.playcolored);


            mediaPlayer.stop();
            mediaPlayer.reset();
//            mediaPlayer.release();
            TastyToast.makeText(ctx,"stop",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
            length = 0;
            onceMedia = 0;
            prevposition = -1;
            holder.stop.setEnabled(false);

        });

    }

    private void gotoMediaPlayer(String url, ViewHolder holder) {

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

        mediaPlayer.setOnPreparedListener(mediaPlayer -> {
            progressDialog.dismiss();
            holder.stop.setEnabled(true);
            TastyToast.makeText(ctx,"play",TastyToast.LENGTH_SHORT,TastyToast.INFO).show();
            mediaPlayer.start();
        });

    }

    private String getStringUrl(int position, int num) {


        String temp = "";
        int start = 0;
        String url= "";

        if(num==1)
        {

            url = "http://verse.mp3quran.net/arabic/saud_alshuraim/128/00100"+ (position+2) + ".mp3";

        }
        else if(num>1&&num<10)
        {
            temp = "00"+num+"000";
            start = Integer.parseInt(temp);
            url = "http://verse.mp3quran.net/arabic/saud_alshuraim/128/00"+ (start+position+1) + ".mp3";

        }
        else if(num == 17){


            if((position+1)==1 || (position+1)==2){
                temp = "0" + num+ "000";
                start = Integer.parseInt(temp);
                url = "http://verse.mp3quran.net/arabic/saud_alshuraim/128/0"+ (start+position+1) + ".mp3";

            }
            if((position+1)>=3){
                temp = "0" + num+ "000";
                start = Integer.parseInt(temp);
                url = "http://verse.mp3quran.net/arabic/saud_alshuraim/128/0"+ (start+position) + ".mp3";

            }



        }
        else if(num>=10 && num < 100)
        {
            temp = "0" + num+ "000";
            start = Integer.parseInt(temp);
            url = "http://verse.mp3quran.net/arabic/saud_alshuraim/128/0"+ (start+position+1) + ".mp3";

        }
        else if (num>=100 && num<115)
        {
            temp = num+"000";
            start = Integer.parseInt(temp);
            url = "http://verse.mp3quran.net/arabic/saud_alshuraim/128/"+ (start+position+1) + ".mp3";

        }

        return url;

    }

    private void checkandSetBookmark(ViewHolder holder, String verseId, String c) {


        String vno = ""+sh.getInt("verseno",1);
        String cno = ""+sh.getInt("chapterno",1);

        if(vno.equals(verseId) && cno.equals(c)){
            holder.bookmark.setVisibility(View.VISIBLE);
        }

    }

    private void setBookmark(ViewHolder holder, Context ctx, String[] split, int ind, String s) {


        holder.bookmark.setVisibility(View.INVISIBLE);



        editor = ctx.getSharedPreferences("QuranBookmark", Context.MODE_PRIVATE).edit();
        editor.putInt("chapterno", Integer.parseInt(split[0]));
        editor.putString("chaptername",split[5]);
        editor.putString("verses",split[2]);
        editor.putString("revealedat",split[4]);
        editor.putInt("verseno",ind);
        editor.putString("verse",s);
        editor.apply();

        checkandSetBookmark(holder, ""+ind, split[0]);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView vno, content;
        public ImageView bookmark, current, play, stop;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);

            vno = itemView.findViewById(R.id.vno);
            play = itemView.findViewById(R.id.play);
            stop = itemView.findViewById(R.id.stop);
            content = itemView.findViewById(R.id.content);
            cardView = itemView.findViewById(R.id.hadithbookmark);
            bookmark = itemView.findViewById(R.id.bookmark);

            bookmark.setVisibility(View.GONE);

        }
    }

    private void startplayer() {

        final MediaPlayer mp = MediaPlayer.create(ctx ,R.raw.knock);
        mp.start();
    }

    @Override
    public int getItemCount() {
        if (use == 0 || use == 3){
            return listitem1.size();
        }
        else {
            return listitem.size();
        }
    }

    private boolean checkConnection() {


        ConnectivityManager connectivityManager = (ConnectivityManager)  ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            return true;

        } else { return false; }

    }

    private void displayNoInternet(String msg) {
        TastyToast.makeText(ctx,msg,TastyToast.LENGTH_SHORT,TastyToast.DEFAULT).show();
    }

}
