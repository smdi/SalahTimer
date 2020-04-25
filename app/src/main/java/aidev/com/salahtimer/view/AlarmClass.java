package aidev.com.salahtimer.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.preference.PreferenceManager;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.sdsmdg.tastytoast.TastyToast;

import aidev.com.salahtimer.R;
import androidx.core.app.NotificationCompat;


public class AlarmClass extends BroadcastReceiver {

    private int global;


    @Override
    public void onReceive(Context context, Intent intent) {


     try {
        MediaPlayer  mp = MediaPlayer.create(context, R.raw.bell);
        mp.start();
     }
     catch (Exception e){

         e.printStackTrace();
     }

     TastyToast.makeText(context, "its Hadith Time", Toast.LENGTH_LONG, TastyToast.SUCCESS).show();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        String title = category(context);
        String message = hadees(context);


        Intent i1 = new Intent(context, Router.class);
        i1.putExtra("menuFragment", "hadith");
        PendingIntent pi1 = PendingIntent.getActivity(context, 1, i1, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.hadith);

        NotificationCompat.BigTextStyle  bigTextStyle  = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(message);
        bigTextStyle.setBigContentTitle(title);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.hadith)
                        .setColor(Color.WHITE)
                        .setLights(1,1,1)
                        .setContentText(" Slide down to read completely ")
                        .setAutoCancel(true)
                        .setTicker(title)
                        .setLargeIcon(bitmap)
                        .setStyle(bigTextStyle)
                .setContentIntent(pi1);



        NotificationManager nf = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        nf.notify(0, mBuilder.build());

    }

    private String category(Context v) {

        global = load(v);

        String message = "";

        if(global>=1&&global<=65)
        {
            message =Reference.InnerReference.hadeesCategory1;
        }
        else  if(global>=66&&global<=130)
        {
            message =Reference.InnerReference.hadeesCategory2;
        }
        else  if(global>=131&&global<=195)
        {
            message =Reference.InnerReference.hadeesCategory3;
        } else if (global>=196&&global<=260) {
            message =Reference.InnerReference.hadeesCategory4;
        }
        else if(global>=261&&global<=293)
        {
            message =Reference.InnerReference.hadeesCategory5;
        }
        else if(global>=294&&global<=354){
            message =Reference.InnerReference.hadeesCategory6;
        }
        return message;
    }

    private String hadees(Context v) {

        global = load(v);

        return Reference.InnerReference.get(global);
    }

    public int load(Context v) {

        SharedPreferences sh = v.getSharedPreferences("HadithDB", Context.MODE_PRIVATE);
        int exe = sh.getInt("hno", 1);

        if(exe == 358){
            exe = 1;
        }
        else {
            exe +=1;
        }
        SharedPreferences.Editor editor = v.getSharedPreferences("HadithDB", Context.MODE_PRIVATE).edit();
        editor.putInt("hno", exe);
        editor.apply();

        return exe;
    }

}