package aidev.com.salahtimer.view;

import aidev.com.salahtimer.R;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {


    private static int SPLASH_SCREEN_TIME_OUT=3000;
    private String image, title, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash_screen);

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
}
