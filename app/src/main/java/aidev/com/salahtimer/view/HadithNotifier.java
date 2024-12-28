package aidev.com.salahtimer.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TimePicker;
import com.aidev.generictoast.GenericToast;
import aidev.com.salahtimer.R;
import androidx.annotation.Nullable;
import java.util.Calendar;
import androidx.fragment.app.Fragment;

public class HadithNotifier extends Fragment {


    private TimePicker tp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_hadithnotifier,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initialiser(view);
    }

    private void initialiser(View view) {

        tp = (TimePicker) view.findViewById(R.id.timePicker);
        Button b1 = (Button) view.findViewById(R.id.butonnsetNotification);

        b1.setOnClickListener(view1 -> {

//            getMedia();

            Calendar cl = Calendar.getInstance();
            if(Build.VERSION.SDK_INT >= 23) {
                cl.set(
                        cl.get(Calendar.YEAR),
                        cl.get(Calendar.MONTH),
                        cl.get(Calendar.DAY_OF_MONTH),
                        tp.getHour(),
                        tp.getMinute(),
                        0

                );
            }
            else
            {
                cl.set(
                        cl.get(Calendar.YEAR),
                        cl.get(Calendar.MONTH),
                        cl.get(Calendar.DAY_OF_MONTH),
                        tp.getCurrentHour(),
                        tp.getCurrentMinute(),
                        0

                );
            }
            setAlarm(cl.getTimeInMillis() , view1);
        });
    }


    private void setAlarm(long timeInMillis , View view) {

        AlarmManager al = (AlarmManager) view.getContext().getSystemService(Context.ALARM_SERVICE);

        Intent i = new Intent(getActivity(), AlarmClass.class);

        PendingIntent pi = PendingIntent.getBroadcast(getActivity() ,0 ,i ,0);

        al.setRepeating(AlarmManager.RTC_WAKEUP ,timeInMillis, 86400000 , pi);

//        TastyToast.makeText(getActivity(),"Hadith Notification set", Toast.LENGTH_LONG,TastyToast.SUCCESS).show();
        GenericToast.showToast(getActivity(),
                "Hadith notification set!",
                GenericToast.LENGTH_SHORT,
                GenericToast.SUCCESS,
                GenericToast.LITE,
                GenericToast.DEFAULT_FONT,
                GenericToast.DEFAULT_FONT);
    }


//    private void getMedia() {
//        final MediaPlayer mp = MediaPlayer.create(getActivity() ,R.raw.bell);
//        mp.start();
//    }

}
