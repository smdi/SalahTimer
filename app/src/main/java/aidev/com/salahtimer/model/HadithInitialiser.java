package aidev.com.salahtimer.model;

public class HadithInitialiser {

    private String hadithTitle;
    private String hadithContent;
    private int sno;
    private int bookmarked;

    public HadithInitialiser(int sno,String hadithTitle, String hadithContent,int bookmarked) {
        this.sno =sno;
        this.hadithTitle = hadithTitle;
        this.hadithContent = hadithContent;
        this.bookmarked = bookmarked;
    }

    public int getBookmarked() {
        return bookmarked;
    }

    public void setBookmarked(int bookmarked) {
        this.bookmarked = bookmarked;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getHadithTitle() {
        return hadithTitle;
    }

    public void setHadithTitle(String hadithTitle) {
        this.hadithTitle = hadithTitle;
    }

    public String getHadithContent() {
        return hadithContent;
    }

    public void setHadithContent(String hadithContent) {
        this.hadithContent = hadithContent;
    }
}
