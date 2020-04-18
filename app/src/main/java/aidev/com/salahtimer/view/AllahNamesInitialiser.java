package aidev.com.salahtimer.view;

public class AllahNamesInitialiser {

    private String arabicName, englishName, meaning;

    private String dua_ka_naam;
    private String dua_content;

    public AllahNamesInitialiser(String dua_ka_naam, String dua_content) {
        this.dua_ka_naam = dua_ka_naam;
        this.dua_content = dua_content;
    }

    public String getDua_ka_naam() {
        return dua_ka_naam;
    }

    public void setDua_ka_naam(String dua_ka_naam) {
        this.dua_ka_naam = dua_ka_naam;
    }

    public String getDua_content() {
        return dua_content;
    }

    public void setDua_content(String dua_content) {
        this.dua_content = dua_content;
    }

    public AllahNamesInitialiser(String arabicName, String englishName, String meaning) {
        this.arabicName = arabicName;
        this.englishName = englishName;
        this.meaning = meaning;
    }

    public String getArabicName() {
        return arabicName;
    }

    public void setArabicName(String arabicName) {
        this.arabicName = arabicName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
