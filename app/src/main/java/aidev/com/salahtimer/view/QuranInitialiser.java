package aidev.com.salahtimer.view;

public class QuranInitialiser {


    private String chapterNo;
    private String nameOfChapter;
    private String totalAyahs;
    private String language;
    private String place;
    private String eChapName;


    public QuranInitialiser(String chapterNo, String nameOfChapter, String totalAyahs, String language, String place ,String eChapName) {
        this.chapterNo = chapterNo;
        this.nameOfChapter = nameOfChapter;
        this.totalAyahs = totalAyahs;
        this.language = language;
        this.place = place;
        this.eChapName = eChapName;
    }

    public String geteChapName() {
        return eChapName;
    }

    public void seteChapName(String eChapName) {
        this.eChapName = eChapName;
    }

    public String getChapterNo() {
        return chapterNo;
    }

    public String getNameOfChapter() {
        return nameOfChapter;
    }

    public String getTotalAyahs() {
        return totalAyahs;
    }

    public String getLanguage() {
        return language;
    }

    public String getPlace() {
        return place;
    }

    public void setChapterNo(String chapterNo) {
        this.chapterNo = chapterNo;
    }

    public void setNameOfChapter(String nameOfChapter) {
        this.nameOfChapter = nameOfChapter;
    }

    public void setTotalAyahs(String totalAyahs) {
        this.totalAyahs = totalAyahs;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPlace(String place) {
        this.place = place;
    }
}
