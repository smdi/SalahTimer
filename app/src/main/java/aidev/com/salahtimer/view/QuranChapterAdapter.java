package aidev.com.salahtimer.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aidev.generictoast.GenericToast;

import java.io.IOException;
import java.net.InetAddress;
import java.util.List;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.InternetChecker;
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
    private static final long DOUBLE_CLICK_TIME_DELTA = 300; // milliseconds
    private long lastClickTime = 0;
    private ViewHolder previousViewHolder = null; // Keep track of the previous ViewHolder
    private final InternetChecker internetChecker;
    private boolean isConnectionAvailable = false;

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

        internetChecker = new InternetChecker(ctx);
        internetChecker.setNetworkStateListener(new InternetChecker.NetworkStateListener() {
            @Override
            public void onNetworkAvailable() {
                isConnectionAvailable = true;
                System.out.println("Network available in SomeClass");
//                GenericToast.showToast(ctx, "Nw available"+isConnectionAvailable, GenericToast.LENGTH_SHORT, GenericToast.SUCCESS, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
            }

            @Override
            public void onNetworkLost() {
                isConnectionAvailable = false;
                System.out.println("Network lost in SomeClass");
//                GenericToast.showToast(ctx, "Network lost"+isConnectionAvailable, GenericToast.LENGTH_SHORT, GenericToast.SUCCESS, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
            }

            @Override
            public void onInternetCapabilityChanged(boolean hasInternet) {
                System.out.println("Internet capability in SomeClass: " + hasInternet);
            }
        });
        internetChecker.startMonitoring();
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

        internetChecker = new InternetChecker(ctx);
        internetChecker.setNetworkStateListener(new InternetChecker.NetworkStateListener() {
            @Override
            public void onNetworkAvailable() {
                isConnectionAvailable = true;
                System.out.println("Network available in SomeClass");
//                GenericToast.showToast(ctx, "Nw available"+isConnectionAvailable, GenericToast.LENGTH_SHORT, GenericToast.SUCCESS, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
            }

            @Override
            public void onNetworkLost() {
                isConnectionAvailable = false;
                System.out.println("Network lost in SomeClass");
//                GenericToast.showToast(ctx, "Network lost"+isConnectionAvailable, GenericToast.LENGTH_SHORT, GenericToast.SUCCESS, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
            }

            @Override
            public void onInternetCapabilityChanged(boolean hasInternet) {
                System.out.println("Internet capability in SomeClass: " + hasInternet);

            }
        });
        internetChecker.startMonitoring();
    }

    @Override
    public QuranChapterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.quran_chapter_list,parent,false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        if (use == 0) {
            holder.vno.setText("Data");
            holder.content.setText("" + listitem1.get(position));
        }

        if (use == 2) {
            Quran_Ar_En.Datum data = listitem.get(position);
            holder.vno.setText(data.verseId);
            holder.content.setText(data.text);
            checkandSetBookmark(holder, data.verseId, split[0]);
        }

        if (use == 3) {
            int ind = position + 1;
            holder.vno.setText("" + ind);
            holder.content.setText(listitem1.get(position));
            holder.cardView.setOnLongClickListener(v -> {
                GenericToast.showToast(ctx, "Quran verse bookmarked!", GenericToast.LENGTH_SHORT, GenericToast.SUCCESS, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
                quranBookmarkRepository.insert(new QuranBookMarkDBTable((num + "" + ind), split[5], split[1], "" + ind, "" + num));
                return true;
            });
        }

        // Alternate background color for rows
        if ((position + 1) % 2 == 0) {
            holder.cardView.setBackgroundColor(ctx.getResources().getColor(R.color.gray));
        } else {
            holder.cardView.setBackgroundColor(ctx.getResources().getColor(R.color.white));
        }

        // Manage play/pause button visibility
        if (position == prevposition) {
            // Show buttons for the currently playing verse
            holder.play.setVisibility(View.VISIBLE);
            holder.stop.setEnabled(true);
            holder.play.setBackgroundResource(mediaPlayer.isPlaying() ? R.drawable.pausecolored : R.drawable.playcolored);
        } else {
            // Hide buttons for all other verses
            holder.play.setVisibility(View.INVISIBLE);
            holder.stop.setEnabled(false);
        }

        // Click listener for each verse
        holder.cardView.setOnClickListener(view -> {
            if (!isConnectionAvailable) {
                // Show the "No Internet connection" message and exit
                progressDialog.dismiss();
                displayNoInternet("No Internet connection");
                return; // Exit early to avoid further execution
            }

            if (position != prevposition) {
                // Reset UI for the previously selected verse
                if (previousViewHolder != null) {
                    previousViewHolder.play.setBackgroundResource(R.drawable.playcolored);
                    previousViewHolder.play.setVisibility(View.INVISIBLE);
                    previousViewHolder.stop.setEnabled(false);
                }

                // Start playing the new verse
                holder.play.setBackgroundResource(R.drawable.pausecolored);
                holder.play.setVisibility(View.VISIBLE);
                onceMedia = 1;
                mediaPlayer.reset();
                prevposition = position;
                previousViewHolder = holder;
                progressDialog.show();

                String url = getStringUrl(position, num);
                gotoMediaPlayer(url, holder);

                mediaPlayer.setOnCompletionListener(mediaPlayer -> {
                    holder.play.setBackgroundResource(R.drawable.playcolored);
                    holder.play.setVisibility(View.INVISIBLE); // Hide play button on completion
                    mediaPlayer.stop();
                    mediaPlayer.reset();

                    length = 0;
                    onceMedia = 0;
                    prevposition = -1;
                    holder.stop.setEnabled(false);
                    previousViewHolder = null;
                });
            } else {
                // Toggle pause/resume for the currently playing verse
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    length = mediaPlayer.getCurrentPosition();
                    holder.play.setBackgroundResource(R.drawable.playcolored); // Update to play icon
                } else {
                    mediaPlayer.seekTo(length);
                    mediaPlayer.start();
                    holder.play.setBackgroundResource(R.drawable.pausecolored); // Update to pause icon
                }
                holder.play.setVisibility(View.VISIBLE);
            }
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
            mediaPlayer.start();
        });

    }

    private String getStringUrl(int position, int num) {


        String temp = "";
        int start = 0;
        String url= "";

        if(num==1)
        {

            url = "https://verse.mp3quran.net/arabic/nasser_alqatami/128/00100"+ (position+2) + ".mp3";

        }
        else if(num>1&&num<10)
        {
            temp = "00"+num+"000";
            start = Integer.parseInt(temp);
            url = "https://verse.mp3quran.net/arabic/nasser_alqatami/128/00"+ (start+position+1) + ".mp3";

        }
        else if(num == 17){


            if((position+1)==1 || (position+1)==2){
                temp = "0" + num+ "000";
                start = Integer.parseInt(temp);
                url = "https://verse.mp3quran.net/arabic/nasser_alqatami/128/0"+ (start+position+1) + ".mp3";

            }
            if((position+1)>=3){
                temp = "0" + num+ "000";
                start = Integer.parseInt(temp);
                url = "https://verse.mp3quran.net/arabic/nasser_alqatami/128/0"+ (start+position) + ".mp3";

            }
        }
        else if(num>=10 && num < 100)
        {
            temp = "0" + num+ "000";
            start = Integer.parseInt(temp);
            url = "https://verse.mp3quran.net/arabic/nasser_alqatami/128/0"+ (start+position+1) + ".mp3";

        }
        else if (num>=100 && num<115)
        {
            temp = num+"000";
            start = Integer.parseInt(temp);
            url = "https://verse.mp3quran.net/arabic/nasser_alqatami/128/"+ (start+position+1) + ".mp3";

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

    @Override
    public int getItemCount() {
        if (use == 0 || use == 3){
            return listitem1.size();
        }
        else {
            return listitem.size();
        }
    }

    ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() {
        @Override
        public void onAvailable(@NonNull Network network) {
            super.onAvailable(network);
        }

        @Override
        public void onLost(@NonNull Network network) {
            super.onLost(network);
        }

        @Override
        public void onCapabilitiesChanged(@NonNull Network network, @NonNull NetworkCapabilities networkCapabilities) {
            super.onCapabilitiesChanged(network, networkCapabilities);
            final boolean unmetered = networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_NOT_METERED);
        }
    };



    public static boolean checkConnection(Context context) {
        return true;
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

}
