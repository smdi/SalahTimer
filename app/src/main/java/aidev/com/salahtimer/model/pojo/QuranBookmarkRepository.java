package aidev.com.salahtimer.model.pojo;

import android.app.Application;

import java.util.List;

import androidx.lifecycle.LiveData;

public class QuranBookmarkRepository {

    private QuranBookmarkDBTableDAO quranBookmarkDBTableDAO;
    private LiveData<List<QuranBookMarkDBTable>> bookmark;


   public QuranBookmarkRepository(Application application) {
        QuranBookmarkDBRoomDatabase db = QuranBookmarkDBRoomDatabase.getDatabase(application);
        quranBookmarkDBTableDAO = db.quranBookmarkDBTableDAO();
        bookmark = quranBookmarkDBTableDAO.getAllBookmarkedQuran();
   }


   public LiveData<List<QuranBookMarkDBTable>> getAllBookmarkedQuran() {
        return bookmark;
    }


    public  void deleteParticular(String sno){
        HadithBookmarkDBRoomDatabase.databaseWriteExecutor.execute(() -> {
            quranBookmarkDBTableDAO.deleteParticular(sno);
        });

    }


    public void insert(QuranBookMarkDBTable instance) {
        HadithBookmarkDBRoomDatabase.databaseWriteExecutor.execute(() -> {
            quranBookmarkDBTableDAO.insert(instance);
        });
    }



}
