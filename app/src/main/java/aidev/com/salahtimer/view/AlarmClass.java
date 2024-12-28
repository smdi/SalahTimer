package aidev.com.salahtimer.view;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;

import com.aidev.generictoast.GenericToast;

import aidev.com.salahtimer.R;
import androidx.core.app.NotificationCompat;


public class AlarmClass extends BroadcastReceiver {

    private int global;
    private static final String CHANNEL_ID = "ID100";
    private static final int NOTIFICATION_ID = 100;
    private static final String CHANNEL_NAME = "ISLAMIDUNIYA";

    @Override
    public void onReceive(Context context, Intent intent) {

        MediaPlayer  mp = MediaPlayer.create(context, R.raw.bell);
         try {
            mp.start();
         }
         catch (Exception e){
             e.printStackTrace();
         }
         finally {
             mp.stop();
         }

//     TastyToast.makeText(context, "", Toast.LENGTH_LONG, TastyToast.SUCCESS).show();
        GenericToast.showToast(context,
                "Its hadith time",
                GenericToast.LENGTH_SHORT,
                GenericToast.SUCCESS,
                GenericToast.LITE,
                GenericToast.DEFAULT_FONT,
                GenericToast.DEFAULT_FONT);

//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        String title = category(context);
        String message = hadees(context);


        Intent i1 = new Intent(context, Router.class);
        i1.putExtra("menuFragment", "hadith");
        @SuppressLint("UnspecifiedImmutableFlag")
        PendingIntent pi1 = PendingIntent.getActivity(context, 1, i1, PendingIntent.FLAG_UPDATE_CURRENT);

        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.hadith);

        NotificationCompat.BigTextStyle  bigTextStyle  = new NotificationCompat.BigTextStyle();
        bigTextStyle.bigText(message);
        bigTextStyle.setBigContentTitle(title);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setSmallIcon(R.drawable.hadith)
                        .setColor(Color.WHITE)
                        .setLights(1,1,1)
                        .setContentText("Slide down to read completely")
                        .setAutoCancel(true)
                        .setTicker(title)
                        .setLargeIcon(bitmap)
                        .setStyle(bigTextStyle)
                .setContentIntent(pi1);



        NotificationManager nf = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        createChannel(nf);
        nf.notify(NOTIFICATION_ID, mBuilder.build());

    }

    public void createChannel(NotificationManager notificationManager){
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH);
        notificationManager.createNotificationChannel(channel);
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

        String data = Reference.InnerReference.get(global);
        store(global+1,v);
        return data;
    }

    public int load(Context v) {

        SharedPreferences sh = v.getSharedPreferences("HadithDB", Context.MODE_PRIVATE);
        int exe = sh.getInt("hno", 1);

        return exe;
    }

    private void store(int i,Context v) {
        if(i == 355){
            i = 1;
        }

        SharedPreferences.Editor editor = v.getSharedPreferences("HadithDB", Context.MODE_PRIVATE).edit();
        editor.putInt("hno", i);
        editor.apply();

    }

}