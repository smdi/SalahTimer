package aidev.com.salahtimer.view;

import aidev.com.salahtimer.R;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;
import com.sdsmdg.tastytoast.TastyToast;

public class SplashScreen extends AppCompatActivity {


    private static int SPLASH_SCREEN_TIME_OUT=3000;
    private String image, title, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);


        try{
            // OneSignal Initialization
            OneSignal.startInit(this)
                    .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                    .unsubscribeWhenNotificationsAreDisabled(true)
                    .setNotificationOpenedHandler(new NotificationOpenHandler())
                    .init();
        }catch (Exception e){
            Log.e("Router","error in router activity",e);}


        new Handler().postDelayed(() -> {



            if(image==null && title == null && body == null){
                Intent i=new Intent(SplashScreen.this, Router.class);
                startActivity(i);
                finish();
            }
            else{
                Intent i=new Intent(SplashScreen.this, Router.class);
                i.putExtra("menuFragment", "notif");
                i.putExtra("image",image);
                i.putExtra("head",title);
                i.putExtra("body",body);
                startActivity(i);
                finish();
            }

        }, SPLASH_SCREEN_TIME_OUT);


    }

    private class NotificationOpenHandler implements OneSignal.NotificationOpenedHandler {
        // This fires when a notification is opened by tapping on it.
        @Override
        public void notificationOpened(OSNotificationOpenResult result) {


            Log.d("Router  " +result.notification.payload.title, "Notification clicked");
            Log.d("Router  " +result.notification.payload.body, "Notification clicked");
            Log.d("Router  " +result.notification.payload.bigPicture, "Notification clicked");


            image = result.notification.payload.bigPicture;
            body = result.notification.payload.body;
            title = result.notification.payload.title;

        }
    }


}
