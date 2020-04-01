package aidev.com.salahtimer.model.pojo;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class HadithBookmarkRepository {

    private HadithBookmarkDBTableDAO hadithBookmarkDBTableDAO;
    private LiveData<List<HadithBookmarkDBTable>> allHadiths,bookmark;


   public HadithBookmarkRepository(Application application) {
        HadithBookmarkDBRoomDatabase db = HadithBookmarkDBRoomDatabase.getDatabase(application);
        hadithBookmarkDBTableDAO = db.hadithBookmarkDBTableDAO();
        allHadiths = hadithBookmarkDBTableDAO.getAllHadiths();
        bookmark = hadithBookmarkDBTableDAO.getAllBookmarkedHadiths(1);
   }


   public LiveData<List<HadithBookmarkDBTable>> getAllHadiths() {
        return allHadiths;
    }

    public LiveData<List<HadithBookmarkDBTable>> getAllBookmarkHadiths() {
        return bookmark;
    }

    public void insert(HadithBookmarkDBTable hadithBookmarkDBTable) {
        HadithBookmarkDBRoomDatabase.databaseWriteExecutor.execute(() -> {
            hadithBookmarkDBTableDAO.insert(hadithBookmarkDBTable);
        });
    }



}
