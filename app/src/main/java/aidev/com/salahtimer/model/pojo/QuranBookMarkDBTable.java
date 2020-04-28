package aidev.com.salahtimer.model.pojo;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "QuranBookMarkDBTable")
public class QuranBookMarkDBTable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "cno_vno")
    private String cno_vno;

    @NonNull
    @ColumnInfo(name = "surah_name_e")
    private String surah_name_e;


    @NonNull
    @ColumnInfo(name = "surah_name_a")
    private String surah_name_a;


    @NonNull
    @ColumnInfo(name = "verse_no")
    private String verse_no;

    @NonNull
    @ColumnInfo(name = "chapter_no")
    private String chapter_no;

    public QuranBookMarkDBTable(@NonNull String cno_vno, @NonNull String surah_name_e, @NonNull String surah_name_a, @NonNull String verse_no, @NonNull String chapter_no) {
        this.cno_vno = cno_vno;
        this.surah_name_e = surah_name_e;
        this.surah_name_a = surah_name_a;
        this.verse_no = verse_no;
        this.chapter_no = chapter_no;
    }

    @NonNull
    public String getChapter_no() {
        return chapter_no;
    }

    public void setChapter_no(@NonNull String chapter_no) {
        this.chapter_no = chapter_no;
    }

    @NonNull
    public String getCno_vno() {
        return cno_vno;
    }

    public void setCno_vno(@NonNull String cno_vno) {
        this.cno_vno = cno_vno;
    }

    @NonNull
    public String getSurah_name_e() {
        return surah_name_e;
    }

    public void setSurah_name_e(@NonNull String surah_name_e) {
        this.surah_name_e = surah_name_e;
    }

    @NonNull
    public String getSurah_name_a() {
        return surah_name_a;
    }

    public void setSurah_name_a(@NonNull String surah_name_a) {
        this.surah_name_a = surah_name_a;
    }

    @NonNull
    public String getVerse_no() {
        return verse_no;
    }

    public void setVerse_no(@NonNull String verse_no) {
        this.verse_no = verse_no;
    }
}
