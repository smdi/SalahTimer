package aidev.com.salahtimer.view;

public  class QuranIndex  {


  public static  abstract class QuranIndexProfile {

      public static String getIndexDisplay(int i) {

           String chapNo;
           String chapName;
           String eChapName;
           String totAyahs;
           String lang;
           String place;
           String message = "";

          switch (i) {

              case 1:

                  chapNo = ""+i+"@";
                 chapName =  "الفَاتِحَة" + "@" ;
                 eChapName = "Al-Fatiha" + "@";
                 totAyahs = ""+6+"\tverses"+"@" ;
                 lang = "Arabic" + "@";
                 place = "Makki"+"@" ;
                 message  +=  chapNo + chapName + totAyahs + lang +place +eChapName ;
                 break;
              case 2:

                  chapNo =i+"@";
                  chapName =  "البَقَرَة"  + "@";
                  eChapName = "Al-Baqara" + "@";
                  totAyahs = 286+"\tverses"+ "@" ;
                  lang = "Arabic" + "@";
                  place = "Madani"+"@" ;
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                    break;
             case 3:
                  chapNo =i+"@";
                  chapName = "آل عِمرَان" + "@" ;
                  totAyahs = 200+"\tverses"+"@";
                  lang = "Arabic"+"@";
                  place = "Madani" + "@";
                 eChapName = "Al-E-Imran" + "@";
                 message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 4:
                  chapNo =""+i+"@";
                  chapName = "النِّسَاء"+"@";
                  totAyahs = ""+176+"\tverses"+"@" ;
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "An-Nisa" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 5:
                  chapNo =""+i+"@";
                  chapName = "المَائدة"+"@";
                  totAyahs = ""+120+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Maeda" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 6:
                  chapNo =""+i+"@";
                  chapName = "الاٴنعَام"+"@";
                  totAyahs = ""+165+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Anaam" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 7:
                  chapNo =""+i+"@";
                  chapName = "الاٴعرَاف"+"@";
                  totAyahs = ""+206+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Araf" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 8:
                  chapNo =""+i+"@";
                  chapName = "الاٴنفَال"+"@";
                  totAyahs = ""+75+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Anfal" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 9:
                  chapNo =""+i+"@";
                  chapName = "التّوبَة"+"@";
                  totAyahs = ""+129+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Tawba" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 10:
                  chapNo =""+i+"@";
                  chapName = "ُونس"+"@";
                  totAyahs = ""+109+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Yunus" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 11:
                  chapNo =""+i+"@";
                  chapName = "هُود"+"@";
                  totAyahs = ""+123+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Hud" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 12:
                  chapNo =""+i+"@";
                  chapName = "وسُف"+"@";
                  totAyahs = ""+111+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Yusuf" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 13:
                  chapNo =""+i+"@";
                  chapName = "الرّعد"+"@";
                  totAyahs = ""+43+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Rad" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 14:
                  chapNo =""+i+"@";
                  chapName = "ٕبراهیم"+"@";
                  totAyahs = ""+52+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ibrahim" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 15:
                  chapNo =""+i+"@";
                  chapName = "الحِجر"+"@";
                  totAyahs = ""+99+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Hijr" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 16:
                  chapNo =""+i+"@";
                  chapName = "النّحل"+"@";
                  totAyahs = ""+128+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "An-Nahl" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 17:
                  chapNo =""+i+"@";
                  chapName = "الإسرَاء"+"@";
                  totAyahs = ""+111+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Isra" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 18:
                  chapNo =""+i+"@";
                  chapName = "الکهف"+"@";
                  totAyahs = ""+110+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Kahf" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 19:
                  chapNo =""+i+"@";
                  chapName = "مَریَم"+"@";
                  totAyahs = ""+98+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Maryam" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 20:
                  chapNo =""+i+"@";
                  chapName = "طٰه"+"@";
                  totAyahs = ""+135+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ta-Ha" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 21:
                  chapNo =""+i+"@";
                  chapName = "الاٴنبیَاء"+"@";
                  totAyahs = ""+112+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Anbiya" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 22:
                  chapNo =""+i+"@";
                  chapName = "الحَجّ"+"@";
                  totAyahs = ""+78+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Hajj" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 23:
                  chapNo =""+i+"@";
                  chapName = "المؤمنون"+"@";
                  totAyahs = ""+118+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Mumenoon" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 24:
                  chapNo =""+i+"@";
                  chapName = "النُّور"+"@";
                  totAyahs = ""+64+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Noor" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 25:
                  chapNo =""+i+"@";
                  chapName = "الفُرقان"+"@";
                  totAyahs = ""+77+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Furqan" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 26:
                  chapNo =""+i+"@";
                  chapName = "الشُّعَرَاء"+"@";
                  totAyahs = ""+227+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Shuara" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 27:
                  chapNo =""+i+"@";
                  chapName = "النَّمل"+"@";
                  totAyahs = ""+93+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Naml" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 28:
                  chapNo =""+i+"@";
                  chapName = "القَصَص"+"@";
                  totAyahs = ""+88+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Qasas" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 29:
                  chapNo =""+i+"@";
                  chapName = "العَنکبوت"+"@";
                  totAyahs = ""+69+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Ankaboot" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 30:
                  chapNo =""+i+"@";
                  chapName = "الرُّوم"+"@";
                  totAyahs = ""+60+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Room" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 31:
                  chapNo =""+i+"@";
                  chapName = "لقمَان"+"@";
                  totAyahs = ""+34+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Luqman" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 32:
                  chapNo =""+i+"@";
                  chapName = "السَّجدَة"+"@";
                  totAyahs = ""+30+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "As-Sajda" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 33:
                  chapNo =""+i+"@";
                  chapName = "الاٴحزَاب"+"@";
                  totAyahs = ""+73+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Ahzab" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 34:
                  chapNo =""+i+"@";
                  chapName = "سَبَإ"+"@";
                  totAyahs = ""+54+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Saba" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 35:
                  chapNo =""+i+"@";
                  chapName = "فَاطِر"+"@";
                  totAyahs = ""+45+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Fatir" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 36:
                  chapNo =""+i+"@";
                  chapName = "یسٓ"+"@";
                  totAyahs = ""+83+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ya-Seen" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 37:
                  chapNo =""+i+"@";
                  chapName = "الصَّافات"+"@";
                  totAyahs = ""+182+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "As-Saaffat" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 38:
                  chapNo =""+i+"@";
                  chapName = "صٓ"+"@";
                  totAyahs = ""+88+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Sad" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;

              case 39:
                  chapNo =""+i+"@";
                  chapName = "الزُّمَر"+"@";
                  totAyahs = ""+75+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Az-Zumar" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 40:
                  chapNo =""+i+"@";
                  chapName = "غَافر"+"@";
                  totAyahs = ""+85+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ghafir" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 42:
                  chapNo =""+i+"@";
                  chapName = "الشّوریٰ"+"@";
                  totAyahs = ""+53+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ash-Shura" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 41:
                  chapNo =""+i+"@";
                  chapName = " فُصّلَت"+"@";
                  totAyahs = ""+54+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Fussilat" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 43:
                  chapNo =""+i+"@";
                  chapName = "الزّخرُف"+"@";
                  totAyahs = ""+89+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Az-Zukhruf" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 44:
                  chapNo =""+i+"@";
                  chapName = "الدّخان"+"@";
                  totAyahs = ""+59+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ad-Dukhan" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 45:
                  chapNo =""+i+"@";
                  chapName = "الجَاثیَة"+"@";
                  totAyahs = ""+37+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Jathiya" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 46:
                  chapNo =""+i+"@";
                  chapName = "الاٴحقاف"+"@";
                  totAyahs = ""+35+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Ahqaf" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 47:
                  chapNo =""+i+"@";
                  chapName = "محَمَّد"+"@";
                  totAyahs = ""+38+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Muhammad" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 48:
                  chapNo =""+i+"@";
                  chapName = "الفَتْح"+"@";
                  totAyahs = ""+29+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Fath" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 49:
                  chapNo =""+i+"@";
                  chapName = "الحُجرَات"+"@";
                  totAyahs = ""+18+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Hujraat" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 50:
                  chapNo =""+i+"@";
                  chapName = "قٓ"+"@";
                  totAyahs = ""+45+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Qaf" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 51:
                  chapNo =""+i+"@";
                  chapName = "الذّاریَات"+"@";
                  totAyahs = ""+60+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Adh-Dhariyat" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 52:
                  chapNo =""+i+"@";
                  chapName = "الطُّور"+"@";
                  totAyahs = ""+49+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "At-Tur" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 53:
                  chapNo =""+i+"@";
                  chapName = "النّجْم"+"@";
                  totAyahs = ""+62+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "An-Najm" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 54:
                  chapNo =""+i+"@";
                  chapName = "القَمَر"+"@";
                  totAyahs = ""+55+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Qamar" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 55:
                  chapNo =""+i+"@";
                  chapName = "الرَّحمٰن"+"@";
                  totAyahs = ""+78+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Ar-Rahman" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 56:
                  chapNo =""+i+"@";
                  chapName = "الواقِعَة"+"@";
                  totAyahs = ""+96+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Waqia" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 57:
                  chapNo =""+i+"@";
                  chapName = "الحَدید"+"@";
                  totAyahs = ""+29+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Hadid" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 58:
                  chapNo =""+i+"@";
                  chapName = "المجَادلة"+"@";
                  totAyahs = ""+22+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Mujadila" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 59:
                  chapNo =""+i+"@";
                  chapName = "الحَشر"+"@";
                  totAyahs = ""+24+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Hashr" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 60:
                  chapNo =""+i+"@";
                  chapName = "المُمتَحنَة"+"@";
                  totAyahs = ""+13+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Mumtahina" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 61:
                  chapNo =""+i+"@";
                  chapName = "الصَّف"+"@";
                  totAyahs = ""+14+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "As-Saff" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 62:
                  chapNo =""+i+"@";
                  chapName = "الجُمُعَة"+"@";
                  totAyahs = ""+11+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Jumua" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 63:
                  chapNo =""+i+"@";
                  chapName = "المنَافِقون"+"@";
                  totAyahs = ""+11+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Munafiqoon" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 64:
                  chapNo =""+i+"@";
                  chapName = "التّغَابُن"+"@";
                  totAyahs = ""+18+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "At-Taghabun" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 65:
                  chapNo =""+i+"@";
                  chapName = "الطّلاَق"+"@";
                  totAyahs = ""+12+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "At-Talaq" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 66:
                  chapNo =""+i+"@";
                  chapName = "التّحْریم"+"@";
                  totAyahs = ""+12+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "At-Tahrim" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 67:
                  chapNo =""+i+"@";
                  chapName = "المُلک"+"@";
                  totAyahs = ""+30+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Mulk" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 68:
                  chapNo =""+i+"@";
                  chapName = "القَلَم"+"@";
                  totAyahs = ""+52+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Qalam" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 69:
                  chapNo =""+i+"@";
                  chapName = "الحَاقَّة"+"@";
                  totAyahs = ""+52+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Haaqqa" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 70:
                  chapNo =""+i+"@";
                  chapName = "المعَارج"+"@";
                  totAyahs = ""+44+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Maarij" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 71:
                  chapNo =""+i+"@";
                  chapName = "نُوح"+"@";
                  totAyahs = ""+28+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Nooh" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 72:
                  chapNo =""+i+"@";
                  chapName = "الجنّ"+"@";
                  totAyahs = ""+28+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Jinn" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 73:
                  chapNo =""+i+"@";
                  chapName = "المُزمّل"+"@";
                  totAyahs = ""+20+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Muzzammil" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 74:
                  chapNo =""+i+"@";
                  chapName = "المدَّثِّر"+"@";
                  totAyahs = ""+56+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Muddaththir" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 75:
                  chapNo =""+i+"@";
                  chapName = "القِیَامَة"+"@";
                  totAyahs = ""+40+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Qiyama" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 76:
                  chapNo =""+i+"@";
                  chapName = "الإنسَان"+"@";
                  totAyahs = ""+31+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Insan" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 77:
                  chapNo =""+i+"@";
                  chapName = "المُرسَلات"+"@";
                  totAyahs = ""+50+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Mursalat" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 78:
                  chapNo =""+i+"@";
                  chapName = "النّبَإ"+"@";
                  totAyahs = ""+40+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "An-Naba" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 79:
                  chapNo =""+i+"@";
                  chapName = "النَّازعَات"+"@";
                  totAyahs = ""+46+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "An-Naziat" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 80:
                  chapNo =""+i+"@";
                  chapName = "عَبَسَ"+"@";
                  totAyahs = ""+42+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Abasa" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 81:
                  chapNo =""+i+"@";
                  chapName = "التّکویر"+"@";
                  totAyahs = ""+29+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "At-Takwir" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 82:
                  chapNo =""+i+"@";
                  chapName = "الانفِطار"+"@";
                  totAyahs = ""+19+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Infitar" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 83:

                  chapNo =""+i+"@";
                  chapName = "المطفّفِین"+"@";
                  totAyahs = ""+36+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Mutaffifin" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 84:
                  chapNo =""+i+"@";
                  chapName = "الانشقاق"+"@";
                  totAyahs = ""+25+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Inshiqaq" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;

              case 85:

                  chapNo =""+i+"@";
                  chapName = "البُرُوج"+"@";
                  totAyahs = ""+22+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Burooj" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 86:
                  chapNo =""+i+"@";
                  chapName = "الطّارق"+"@";
                  totAyahs = ""+17+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "At-Tariq" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 87:
                  chapNo =""+i+"@";
                  chapName = "الاٴعلی"+"@";
                  totAyahs = ""+19+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Ala" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 88:
                  chapNo =""+i+"@";
                  chapName = "الغَاشِیَة"+"@";
                  totAyahs = ""+26+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Ghashiya" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 89:
                  chapNo =""+i+"@";
                  chapName = "الفَجر"+"@";
                  totAyahs = ""+30+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Fajr" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 90:
                  chapNo =""+i+"@";
                  chapName = "البَلَد"+"@";
                  totAyahs = ""+20+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Balad" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 91:
                  chapNo =""+i+"@";
                  chapName = "الشّمس"+"@";
                  totAyahs = ""+15+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ash-Shams" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;

              case 92:
                  chapNo =""+i+"@";
                  chapName = "اللیْل"+"@";
                  totAyahs = ""+21+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Lail" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 93:
                  chapNo =""+i+"@";
                  chapName = "الِضُّحىٰ"+"@";
                  totAyahs = ""+11+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ad-Dhuha" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 94:
                  chapNo =""+i+"@";
                  chapName = "الشَّرح"+"@";
                  totAyahs = ""+8+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Ash-Sharh" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 95:
                  chapNo =""+i+"@";
                  chapName = "التِّین"+"@";
                  totAyahs = ""+8+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "At-Tin" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 96:
                  chapNo =""+i+"@";
                  chapName = "العَلق"+"@";
                  totAyahs = ""+19+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Alaq" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 97:
                  chapNo =""+i+"@";
                  chapName = "القَدر"+"@";
                  totAyahs = ""+5+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Qadr" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 98:
                  chapNo =""+i+"@";
                  chapName = "البَیّنَة"+"@";
                  totAyahs = ""+8+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Bayyina" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 99:
                  chapNo =""+i+"@";
                  chapName = "الزّلزَلة"+"@";
                  totAyahs = ""+8+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "Al-Zalzala" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 100:
                  chapNo =""+i+"@";
                  chapName = "العَادیَات"+"@";
                  totAyahs = ""+11+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Adiyat" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;

              case 101:
                  chapNo =""+i+"@";
                  chapName = "القَارعَة"+"@";
                  totAyahs = ""+11+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Qaria" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 102:
                  chapNo =""+i+"@";
                  chapName = "التّکاثُر"+"@";
                  totAyahs = ""+8+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "At-Takathur" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 103:
                  chapNo =""+i+"@";
                  chapName = "العَصر"+"@";
                  totAyahs = ""+3+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Asr" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 104:
                  chapNo =""+i+"@";
                  chapName = "الهُمَزة"+"@";
                  totAyahs = ""+9+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Humaza" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 105:
                  chapNo =""+i+"@";
                  chapName = "الفِیل"+"@";
                  totAyahs = ""+5+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Fil" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 106:
                  chapNo =""+i+"@";
                  chapName = "قُرَیش"+"@";
                  totAyahs = ""+4+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Quraish" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 107:
                  chapNo =""+i+"@";
                  chapName = "المَاعون"+"@";
                  totAyahs = ""+7+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Maun" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 108:
                  chapNo =""+i+"@";
                  chapName = "الکَوثَر"+"@";
                  totAyahs = ""+3+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Kauther" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 109:
                  chapNo =""+i+"@";
                  chapName = "الکافِرون"+"@";
                  totAyahs = ""+6+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Kafiroon" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 110:
                  chapNo =""+i+"@";
                  chapName = "النّصر"+"@";
                  totAyahs = ""+3+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Madani"+"@";
                  eChapName = "An-Nasr" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 111:
                  chapNo =""+i+"@";
                  chapName = "المَسَد"+"@";
                  totAyahs = ""+5+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Masadd" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 112:
                  chapNo =""+i+"@";
                  chapName = "الإخلاص"+"@";
                  totAyahs = ""+4+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Ikhlas" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 113:
                  chapNo =""+i+"@";
                  chapName = "الفَلَق"+"@";
                  totAyahs = ""+5+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "Al-Falaq" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
              case 114:
                  chapNo =""+i+"@";
                  chapName = "النَّاس"+"@";
                  totAyahs = ""+6+"\tverses" +"@";
                  lang = "Arabic"+"@";
                  place = "Makki"+"@";
                  eChapName = "An-Nas" + "@";
                  message += chapNo + chapName + totAyahs + lang +place +eChapName ;
                  break;
          }

          return message;
      }


  }
}
