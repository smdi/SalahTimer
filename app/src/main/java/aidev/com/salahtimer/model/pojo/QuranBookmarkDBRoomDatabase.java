package aidev.com.salahtimer.model.pojo;


import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {QuranBookMarkDBTable.class}, version = 1, exportSchema = false)
public abstract class QuranBookmarkDBRoomDatabase extends RoomDatabase {

    public abstract QuranBookmarkDBTableDAO quranBookmarkDBTableDAO();

    private static volatile QuranBookmarkDBRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static QuranBookmarkDBRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (QuranBookmarkDBRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            QuranBookmarkDBRoomDatabase.class, "QuranBookmarkDBRoomDatabase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
