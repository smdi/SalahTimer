package aidev.com.salahtimer.model.pojo;


import android.content.Context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {HadithBookmarkDBTable.class}, version = 1, exportSchema = false)
public abstract class HadithBookmarkDBRoomDatabase  extends RoomDatabase {

    public abstract HadithBookmarkDBTableDAO hadithBookmarkDBTableDAO();

    private static volatile HadithBookmarkDBRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static HadithBookmarkDBRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (HadithBookmarkDBRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            HadithBookmarkDBRoomDatabase.class, "HadithBookmarkDBRoomDatabase")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
