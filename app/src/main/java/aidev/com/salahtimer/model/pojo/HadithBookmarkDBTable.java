package aidev.com.salahtimer.model.pojo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "HadithBookmarkDBTable")
public class HadithBookmarkDBTable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "serail_no_of_hadith")
    private int serail_no_of_hadith;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "content")
    private String content;

    @NonNull
    @ColumnInfo(name = "bookmarked")
    private int bookmarked;

    public HadithBookmarkDBTable(@NonNull int serail_no_of_hadith, @NonNull String title, @NonNull String content, @NonNull int bookmarked) {
        this.serail_no_of_hadith = serail_no_of_hadith;
        this.title = title;
        this.content = content;
        this.bookmarked = bookmarked;
    }

    @NonNull
    public int getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(@NonNull int bookmarked) {
        this.bookmarked = bookmarked;
    }

    @NonNull
    public int getSerail_no_of_hadith() {
        return serail_no_of_hadith;
    }

    public void setSerail_no_of_hadith(@NonNull int serail_no_of_hadith) {
        this.serail_no_of_hadith = serail_no_of_hadith;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getContent() {
        return content;
    }

    public void setContent(@NonNull String content) {
        this.content = content;
    }
}
