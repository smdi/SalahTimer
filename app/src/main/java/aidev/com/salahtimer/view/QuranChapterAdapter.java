package aidev.com.salahtimer.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.aidev.generictoast.GenericToast;

import java.io.IOException;
import java.util.List;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.InternetChecker;
import aidev.com.salahtimer.model.pojo.QuranBookMarkDBTable;
import aidev.com.salahtimer.model.pojo.QuranBookmarkRepository;
import aidev.com.salahtimer.model.pojo.Quran_Ar_En;
import aidev.com.salahtimer.viewmodel.QuranViewModel;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    private long lastClickTime = 0;
    private ViewHolder previousViewHolder = null; // Keep track of the previous ViewHolder
    private final InternetChecker internetChecker;
    private boolean isConnectionAvailable = false;
    private final String UNAVAILABLE_AT_THE_MOMENT = "Unavailable at the moment!";
    private RecyclerView recyclerView;
    private int violet = Color.rgb(163, 28, 235); //Color.rgb(183, 33, 255);  // RGB value for #B721FF
    private static final String PREFS_NAME = "AppPrefs";
    private static final String KEY_TOOLTIP_SHOWN = "tooltip_shown";
    private static int oncePopup = 0;

    public QuranChapterAdapter(Activity ctx, List<Quran_Ar_En.Datum> listitem, List<String> listitem1
            , QuranViewModel quranViewModel, int exe, String[] split, int num, ProgressDialog progressDialog, MediaPlayer mediaPlayer) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.listitem1 = listitem1;
        this.quranViewModel = quranViewModel;
        this.use = exe;
        this.num = num;
        this.split = split;
        this.progressDialog = progressDialog;
        sh = ctx.getSharedPreferences("QuranBookmark", Context.MODE_PRIVATE);
        this.mediaPlayer = mediaPlayer;
        recyclerView = ((Activity) ctx).findViewById(R.id.quranverses);
        quranBookmarkRepository = new QuranBookmarkRepository(ctx.getApplication());

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false; // No move operation in this case
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                // Get the position of the item
                playSwipe();
                int position = viewHolder.getAdapterPosition();
                position = position + 1;
                GenericToast.showToast(ctx, "Quran verse bookmarked!", GenericToast.LENGTH_SHORT, GenericToast.SUCCESS, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
                quranBookmarkRepository.insert(new QuranBookMarkDBTable((num + "" + position), split[5], split[1], "" + position, "" + num));
                notifyItemChanged(position-1);
            }
            @Override
            public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView,
                                    @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);

                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
                    // Customize the swipe effect if needed (optional)
                    float alpha = 1.0f - Math.abs(dX) / recyclerView.getWidth();
                    viewHolder.itemView.setAlpha(alpha); // Fade out the item as it swipes
                    viewHolder.itemView.setTranslationX(dX); // Translate the item
                } else {
                    super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                }
                // Get the item view
                View itemView = viewHolder.itemView;

                // Set the background color depending on swipe direction
                Paint paint = new Paint();
                if (dX > 0) {
                    // Swipe right
                    paint.setColor(violet); // Example: Green color for swipe right
                } else if (dX < 0) {
                    // Swipe left
                    paint.setColor(violet); // Example: Red color for swipe left
                }

                // Apply the background color to the item view
                if (dX != 0) {
                    c.drawRect(itemView.getLeft(), itemView.getTop(), itemView.getRight(), itemView.getBottom(), paint);
                }
            }

            @Override
            public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
                return 0.7f; // Adjust swipe threshold if needed (e.g., 70% of item width)
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);

        internetChecker = new InternetChecker(ctx);
        internetChecker.setNetworkStateListener(new InternetChecker.NetworkStateListener() {
            @Override
            public void onNetworkAvailable() {
                isConnectionAvailable = true;
            }

            @Override
            public void onNetworkLost() {
                isConnectionAvailable = false;
            }

            @Override
            public void onInternetCapabilityChanged(boolean hasInternet) {
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
            }

            @Override
            public void onNetworkLost() {
                isConnectionAvailable = false;
            }

            @Override
            public void onInternetCapabilityChanged(boolean hasInternet) {
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

        int ind = position + 1;
        holder.vno.setText("" + ind);

        // Check if the tooltip has been shown before
        SharedPreferences sharedPreferences = ctx.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        boolean isTooltipShown = sharedPreferences.getBoolean(KEY_TOOLTIP_SHOWN, false);

        if (!isTooltipShown && oncePopup == 0) {

            showTooltip(holder.content);
            oncePopup = 1;
            // Save the state to preferences
            sharedPreferences.edit().putBoolean(KEY_TOOLTIP_SHOWN, true).apply();
        }

        holder.content.setText(listitem1.get(position));
        holder.cardView.setOnLongClickListener(v -> {

            try{
                if (!isConnectionAvailable) {
                    progressDialog.dismiss();
                    displayNoInternet("No Internet connection");
                    return true;
                }

                // Start recursive playback from the current verse
                playVersesSequentially(position, mediaPlayer);
            }catch(Exception e){
                GenericToast.showToast(ctx, UNAVAILABLE_AT_THE_MOMENT, GenericToast.LENGTH_SHORT, GenericToast.CUSTOM, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
            }

            return true;
        });


        // Alternate background color for rows
        if ((position + 1) % 2 == 0) {
            holder.cardView.setBackgroundColor(ctx.getResources().getColor(R.color.gray));
        } else {
            holder.cardView.setBackgroundColor(ctx.getResources().getColor(R.color.white));
        }



        // Click listener for each verse
        holder.cardView.setOnClickListener(view -> {
            try {
                if (!isConnectionAvailable) {
                    // Show the "No Internet connection" message and exit
                    progressDialog.dismiss();
                    displayNoInternet("No Internet connection");
                    return; // Exit early to avoid further execution
                }

                playSingleVerse(position, holder, mediaPlayer);
            }catch(Exception e){
                GenericToast.showToast(ctx, UNAVAILABLE_AT_THE_MOMENT, GenericToast.LENGTH_SHORT, GenericToast.CUSTOM, GenericToast.LITE, GenericToast.DEFAULT_FONT, GenericToast.DEFAULT_FONT);
            }

        });

    }

    private void showTooltip(View anchorView) {
        // Inflate the tooltip layout
        LayoutInflater inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tooltipView = inflater.inflate(R.layout.tooltip_layout, null);

        // Create a PopupWindow
        final PopupWindow popupWindow = new PopupWindow(
                tooltipView,
                RecyclerView.LayoutParams.WRAP_CONTENT,
                RecyclerView.LayoutParams.WRAP_CONTENT,
                true
        );

        // Dismiss button functionality
        Button dismissButton = tooltipView.findViewById(R.id.tooltipDismiss);
        dismissButton.setOnClickListener(v -> popupWindow.dismiss());

        // Show the tooltip near the anchor view
        popupWindow.showAtLocation(anchorView, Gravity.CENTER, 0, 0);
    }


    private void playSingleVerse(int position, ViewHolder holder, MediaPlayer mediaPlayer) {
        // Reset the previous ViewHolder if the position has changed
        if (position != prevposition) {
            // Reset the UI for the previous ViewHolder
            if (previousViewHolder != null) {
                previousViewHolder.play.setVisibility(View.INVISIBLE); // Hide play button for the previous ViewHolder
                previousViewHolder.stop.setEnabled(false); // Disable stop button for the previous ViewHolder
                previousViewHolder.play.setBackgroundResource(R.drawable.playcolored); // Reset to play icon
            }

            // Update UI for the current ViewHolder
            holder.play.setVisibility(View.VISIBLE); // Show play button for the current ViewHolder
            holder.play.setBackgroundResource(R.drawable.pausecolored); // Show pause icon
            holder.stop.setEnabled(true); // Enable stop button

            // Reset and prepare the MediaPlayer for the new verse
            mediaPlayer.reset();
            prevposition = position; // Update the position tracker
            previousViewHolder = holder; // Update the reference to the current ViewHolder

            // Show progress dialog while loading the verse
            progressDialog.show();

            // Get the URL for the current verse and play
            String url = getStringUrl(position, num);
            gotoMediaPlayer(url, holder);

            // Handle the completion of the MediaPlayer
            mediaPlayer.setOnCompletionListener(mp -> {
                holder.play.setBackgroundResource(R.drawable.playcolored); // Reset to play icon
                holder.play.setVisibility(View.INVISIBLE); // Hide the play button
                holder.stop.setEnabled(false); // Disable stop button
                mediaPlayer.stop();
                mediaPlayer.reset();

                length = 0; // Reset playback position
                prevposition = -1; // Reset the position tracker
                previousViewHolder = null; // Clear the previous ViewHolder reference
            });
        } else {
            // If playing the same verse, toggle play/pause
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause(); // Pause playback
                length = mediaPlayer.getCurrentPosition(); // Save the current position
                holder.play.setBackgroundResource(R.drawable.playcolored); // Switch to play icon
            } else {
                mediaPlayer.seekTo(length); // Resume from the saved position
                mediaPlayer.start(); // Start playback
                holder.play.setBackgroundResource(R.drawable.pausecolored); // Switch to pause icon
            }
            holder.play.setVisibility(View.VISIBLE); // Ensure the play button is visible
        }
    }

    private void playVersesSequentially(int position, MediaPlayer mediaPlayer) {
        // Stop recursion if all verses have been played
        if (position >= listitem1.size()) {
            return;
        }

        // Scroll to the current verse
        scrollToNextBatch(position, recyclerView);

        // Retrieve the ViewHolder for the current position
        ViewHolder currentHolder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(position);

        if (currentHolder == null) {
            // If the ViewHolder is not available (e.g., off-screen), delay and retry
            recyclerView.postDelayed(() -> {
                ViewHolder updatedHolder = (ViewHolder) recyclerView.findViewHolderForAdapterPosition(position);
                if (updatedHolder != null) {
                    // Play the verse once the ViewHolder becomes available
                    playSingleVerse(position, updatedHolder, mediaPlayer);

                    // Listen for completion to move to the next verse
                    mediaPlayer.setOnCompletionListener(mp -> playVersesSequentially(position + 1, mediaPlayer));
                } else {
                    // If still unavailable, skip to the next verse
                    playVersesSequentially(position + 1, mediaPlayer);
                }
            }, 300); // Adjust the delay for smooth scrolling and binding
            return;
        }

        // Play the current verse
        playSingleVerse(position, currentHolder, mediaPlayer);

        // Set an OnCompletionListener to proceed to the next verse
        mediaPlayer.setOnCompletionListener(mp -> {
            // If it's the last verse, stop the player and reset
            if (position == listitem1.size() - 1) {
//                Toast.makeText(ctx,("MediaPlayer "+"Playback completed for position: " + position), Toast.LENGTH_LONG).show();
                currentHolder.play.setBackgroundResource(R.drawable.playcolored); // Reset to play icon
                currentHolder.play.setVisibility(View.INVISIBLE); // Hide the play button
                currentHolder.stop.setEnabled(false); // Disable stop button
                mediaPlayer.stop();
                mediaPlayer.reset();
                length = 0; // Reset playback position
                prevposition = -1; // Reset the position tracker
                previousViewHolder = null; // Clear the previous ViewHolder reference
//                Log.d("MediaPlayer", "Last verse completed, media stopped.");
            } else {
                playVersesSequentially(position + 1, mediaPlayer); // Otherwise, move to the next verse
            }
        });
    }

    private void scrollToNextBatch(int position, RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;

            // Check if the position is outside the current visible range
            int lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
            if (position > lastVisibleItem) {
                // Smooth scroll to the current position
                recyclerView.smoothScrollToPosition(position);
            }
        }
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

    private void playSwipe() {
        MediaPlayer playSwipe;
        try{
            playSwipe = MediaPlayer.create(ctx, R.raw.swipe);
            playSwipe.start();
        }catch (Exception e){

        }
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