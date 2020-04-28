package aidev.com.salahtimer.view;

import android.app.Fragment;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebViewFragment;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import aidev.com.salahtimer.R;
import aidev.com.salahtimer.model.pojo.HadithBookmarkDBTable;
import aidev.com.salahtimer.viewmodel.HadithBookmarkViewModel;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class HadithBookmarkAdapter extends RecyclerView.Adapter<HadithBookmarkAdapter.ViewHolder>{


    private List<HadithBookmarkDBTable> listitem;
    private Context ctx;
    private HadithBookmarkViewModel hadithBookmarkViewModel;



    public HadithBookmarkAdapter(Context ctx, List<HadithBookmarkDBTable> listitem, HadithBookmarkViewModel hadithBookmarkViewModel) {
        this.listitem = listitem;
        this.ctx = ctx;
        this.hadithBookmarkViewModel = hadithBookmarkViewModel;
    }

    @Override
    public HadithBookmarkAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.hadith_bookmark_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        HadithBookmarkDBTable hadithBookmarkDBTable = listitem.get(position);

        holder.title.setText(hadithBookmarkDBTable.getSerail_no_of_hadith()+"\t"+hadithBookmarkDBTable.getTitle());

        holder.content.setText(hadithBookmarkDBTable.getContent());


        holder.delete.setOnClickListener(view1 -> {

//            startplayer();
            hadithBookmarkViewModel.insert(new HadithBookmarkDBTable(hadithBookmarkDBTable.getSerail_no_of_hadith(),
                    hadithBookmarkDBTable.getTitle(),hadithBookmarkDBTable.getContent(),0));

        });

    }


    @Override
    public int getItemCount() {
        return listitem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        public TextView title,content;
        public ImageView delete;


        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            content = itemView.findViewById(R.id.content);
            delete = itemView.findViewById(R.id.delete);


        }
    }

    private void startplayer() {

        final MediaPlayer mp = MediaPlayer.create(ctx ,R.raw.knock);
        mp.start();
    }

}
