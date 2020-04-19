package aidev.com.salahtimer.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by Imran on 22-02-2018.
 */

public final class Reference {

    public static abstract class InnerReference
    {
         public static final String hadeesCategory1 = "Kalima-e-tayyaba";
         public static final String hadeesCategory2 = "Hadees on Namaaz";
         public static final String hadeesCategory3 = "Ilm aur Dhikr";
         public static final String hadeesCategory4 = "Ikram-e-Muslimeen";
         public static final String hadeesCategory5 = "Ikhlas-e-Niyyat";
         public static final String hadeesCategory6 = "Daw'ah aur Tabligh";


        public static String get(int i)
        {


            String message = "";

            switch(i) {
                case 1:
                    message="Allah Ta’ala ne rasulallah Sallallahu Alaihi Wasallam se irshaad farmaaya ke aur\n" +
                            "                    humne aapse pehle aisa koi paigambar nahi bheja jiske paas humne yeh wahi na bheji ho ke\n" +
                            "                    mere siwa koi ma’abood nahi is liye meri hi ibaadath karo.";

                    break;
                case 2:
                    message="Allah Ta’ala ka irshaad hai Beshak hum apne Rasooolon aur imaanwaalon ki\n" +
                            "                    duniya ki zindagi mein bhi madad karthe hai aur qayamat ke din bhi madad karenge jis din\n" +
                            "                    aamal likhne waale farishte gawahi dene khade honge.";
                    
                    break;
                case 3:
                    message="Allah Ta’ala ka irshad hai Jo log imaan laaye aur unhone apne imaan mein Shirk ki\n" +
                            "                    milawat nahi ki, aman inhi ke liye hai aur yehi log hidayat par hai.";
                    
                    break;
                case 4:
                    message="Allah Ta’ala ka irshad hai Aur imaanwaalon ko tho Allah Ta’ala hi se zyada\n" +
                            "                    mohabbat hothi hai.";
                    
                    break;
                case 5:
                    message="Allah Ta’ala ne rasulallah Sallallahu Alaihi Wasallam se irshaad farmaaya, Aap\n" +
                            "                    farmaadijiye ke meri namaz aur meri har ibadat , aur mera jeena aur marna,sab kuch Allah\n" +
                            "                    Ta’ala ke hai aur saare jahan ke paalne wale hai.";
                    
                    break;
                case 6:
                    message="Hazrat Jaber Bin Abdullah farmaate hai ke maine Rasool allah Sallallahu alaihi\n" +
                            "                    Wasallam ko ye irshaad farmaate hue suna:Tamaam zikr mein sabse afzal zikr Lailaha Illallah\n" +
                            "                    hai tamaam duaon mein sabse afzal dua Alhamdulillah hai.";
                    
                    break;
                case 7:
                    message="Hazrat Abu Huraira raziallahu anhu se riwayat hai ke Rasool Allah Sallallahu alaihi\n" +
                            "                    wasallam ne irshaad farmaaya: Jis ne Lailaha Illallah kaha is ko ye kalmia ek din (yaum-e-qaya\n" +
                            "                        mat)zaroor faida dega (nijat dilayega) agrache us ko kuch na kuch saza pehle bhugatna pade.";
                    
                    break;
                case 8:
                    message="Hazrat Talha Bin Obaidullah R.A. se riwayat hai ke nabiye kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Mai ek aisa kalmia jaantha hoon jise aisa shaks padhe jis ki maut ka waqt qareeb ho\n" +
                            "                    tho is ki rooh jism se nikalthe waqt is kalmia ki badaulat zaroor rahat payegi aur kalmia is ke\n" +
                            "                    liye qayamat ke din noor hoga ";
                    
                    break;
                case 9:
                    message="Hazrat Omer R.A se riwayat hai ke Nabi kareem S.A.W ne irshaad farmaaya :\n" +
                            "                    Khattab ke bete! Jao, logon mein yeh elaan kardo ke jannat mein sirf imaan waalw hi daqil\n" +
                            "                    honge";
                    
                    break;
                case 10:
                    message="Hazrat Abu Laila R.A. se riwayat hai ke nabiye kareem S.A.W ne (Abu Sufiyan se)\n" +
                            "                    irshaad farmaaya : Abu Sufiyan tumhari haalat par afsos hai. Mai tho tumhare paas duniya wa\n" +
                            "                    akhirat ( ki bhalayi) le kar aaya hoon,tum Islam qubool karlo,salamati mein aajaoge ";
                    
                    break;
                case 11:
                    message="Hazrat Abu Umama R.A. se riwayat hai k eek shaks ne Rasoolallah S.A.W se sawal\n" +
                            "                    kiya ke imaan kya hai? Aap S.A.W ne irshaad farmaaya: Jab tum ko apne ache amal se khushi\n" +
                            "                    ho aur apne bure kaam par ranj ho to tum momin ho.";
                    
                    break;
                case 12:
                    message="Hazrat Abbas Bin Abdul Muttalib R.A. se riwayat hai ke inhone Rasoolallah S.A.W ko\n" +
                            "                    ye irshaad farmaate huye suna : Imaan ka mazaa usne chakha (aur imaan ki lazzat use mili) jo\n" +
                            "                    Allah Ta,ala ko Rabb, Islam ko deen aur Mohammed S.A.W ko Rasool maan,ne par raazi hai ";
                    
                    break;
                case 13:
                    message="Hazrat Abu Umama R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    jis shaks ne Allah Ta’ala hi ke liye kisi se mohabbat ki aue ussi keliye dushmani ki aur (jis ko\n" +
                            "                    diya) Allah Ta’ala hi ke liye diya aur(jis ko nahi diya) Allah Ta’ala ke liye nahi diya to us ne\n" +
                            "                    imaan ki takmeel Karli. ";
                    
                    break;
                case 14:
                    message="Hazrat Anas Bin Malik R.A. riwayat karte hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : jis shaks ne mujhe dekha aur mujh par imaan laya usko to ek baar Mubarak baad\n" +
                            "                    aur jis ne mujhe nahi dekha aur phir mujh par imaan laya usko saath baar Mubarak baa”;";
                    
                    break;
                case 15:
                    message="Hazrat Anas Bin Malik R.A. bayan karthe hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Mujhe tamanna hai ke mein apne bhaiyon se milta. Sahaba ne arz kiya : kya hum\n" +
                            "                    aapke bhai nahi hai? Aap S.A.W ne irshaad farmaya: Tum tho mere sahaba ho aur mere bhai\n" +
                            "                    wo log hain jo mujhe dekhe bagair mujh par imaan laenge ";
                    
                    break;
                case 16:
                    message="Hazrat Amr Bin Shoeb apne baap dada se riwayat karthe hain ke Nabi kareem\n" +
                            "                    S.A.W ne irshaad farmaaya : Is ummat ki islah ki ibteda yaqeen aur duniya se berukhbati ki\n" +
                            "                    Wajha se hui hai aur iski barbaadi ki ibteda najal aur lambi umeedon ki wajah se hogi";
                    
                    break;
                case 17:
                    message="Hazrat Omer Bin Khattab R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Agar tum Allah Ta’ala par is tarah tawakkal karne lago jaisa ke tawakkal ka haq hai\n" +
                            "                    to tumhe is tarah rozi di jaye jis tarah parindon ko rozi di jati hai. Who subah khaali pait\n" +
                            "                    nikalte hain aur sham bhare pait waapas aathe hain";
                    
                    break;
                case 18:
                    message="Hazrat Maiz R.A. se riwayat hai ke Rasoolallah S.A.W se daryaaft kiya ke kaunsa\n" +
                            "                    amal sabse Afzal hai?Aap S.A.W ne irshaad farmaaya : Allah Ta’ala par imaan laana,jo akele hai\n" +
                            "                    phir jihad karna phir maqbool haj. In aamal aur baqi aamal mein fazilath ka itna farq hai jitna\n" +
                            "                    ke mashriq wa magrib ke darmiyaan faasle ka farq hain. ";
                    
                    break;
                case 19:
                    message="Hazrat Abu Umama R.A. farmaate hai ke Rasoolallah S.A.W ke sahaba ne ek din Aap\n" +
                            "                    S.A.W ke saamne duniya ka zikr kiya tho Rasoolallah S.A.W ne irshaad farmaya: Gaur se suno,\n" +
                            "                        Dihaan do.Yaqeenan saadgi dimaag ka hissa hai,yaqeenan saadgi imaan ka hissa hai. ";
                    
                    break;
                case 20:
                    message="Hazrat Amar Bin Abbas R.A. se riwayat hai ke inhone Rasoolallah S.A.W se daryaft\n" +
                            "                    kiya: Kaunsa imaan Afzal hai? Irshaad farmaaya: who imaan jis ke saath hijrath ho.inhone\n" +
                            "                    daryaft kiya: hijrath kya hai? Irshaad farmaaya: hijrath ye hai ke tum burayi ko chod dho. ";
                    
                    break;
                case 21:
                    message="Hazrat Abdullah Bin Amr Bin Aas R.A se riwayat hai ke Rasool Allah S.A.W ne\n" +
                            "                    farmaaya : Imaan tumhare dilon mein issi tarah purana ( aur kamzor) hojatha hai jis tarah\n" +
                            "                    kapda purana hojatha hai lehza Allah Ta’ala se dua kiya karo ke who tumhare dilon mein\n" +
                            "                    imaan ko taaza rakhein. ";
                    
                    break;
                case 22:
                    message="Hazrat Abu Huraira R.A se riwayat hai ke Rasool Allah S.A.W ne irshaad farmaya\n" +
                            "                    Allah Ta’ala ne meri ummat ke(un) waswason ko mu’af farma diya hai ( jo imaan aur yaqeen ke\n" +
                            "                    Khilaaf ya gunah ke bare mein in ke dil mein bagair ekhiyat ke aayein ) jab take ke who in\n" +
                            "                    Waswason kae mutabiq amal na karlein ya inko zuban par na layein. ";
                    
                    break;
                case 23:
                    message="Hazrat Abu Huraira R.A. Nabi Kareem ka irshaad naql farmaate hai Lailaha Illallah ki\n" +
                            "                    gawahi kasrat se dethe raha karo,is se pehle ke aisa waqt aaye ke tum is kalima ko ( maut ya\n" +
                            "                        bimari wagair ki wajah se) na keh sako. ";
                    
                    break;
                case 24:
                    message="Hazrat Usmaan R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya : jis\n" +
                            "                    shaks ki maut is haal mein aaye ke who yaqeen ke saath jaantha ho ke Allah Ta’ala ke siwa koi\n" +
                            "                    ma’abood nahi wo jannat mein dakhil hoga. ";
                    
                    break;
                case 25:
                    message="Hazrat Osman Bin Affan R.A. se riwaayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jis ki maut is haal mein aaye ke who is baat ka yaqeen karta hoke Allah Ta’ala (ka\n" +
                            "                        wajood) haq hai wo jannat mein jaayega. ";
                    
                    break;
                case 26:
                    message="Hazrat Ali R.A. se Nabi Kareem S.A.W ka irshaad manqool hai ke Allah Ta’ala irshaad\n" +
                            "                    farmaate hain ke: Mai hi Allah hoon,mere siwa koi ma’abood nahi,jis ne eri tauheed ka iqrar\n" +
                            "                    kiya mere qilay mein dakhil hua,aur jo mere qilay mein dakhil hua who mere azaab se mehfooz\n" +
                            "                    hai. ";
                    
                    break;
                case 27:
                    message="Hazrat Etbaan Bin Malik R.A. se riwaayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya: aisa nahi hosaktha ke koi shaks is baat ki gawahi de ke Allah Ta’ala ke siwa koi\n" +
                            "                    ma’abood nahi aur mai Allah Ta’ala ka Rasool hoon phir wo jahanum mein dakhil hoy a dozakh\n" +
                            "                    ki aag is ko khaye. ";
                    
                    break;
                case 28:
                    message="Hazrat Mu’az Bin Jabal R.A. se riwayat hai Nabi Kareem S.A.W ne irshaad farmaaya\n" +
                            " : jis shaks ki bhi is haal mein maut aaye ki wo paake dil se gawahi deta ho ke Allah Ta’ala ke\n" +
                            "                    Siwa koi ma’abood nahi aur mai Allah Ta’ala ka Rasool hoon. Allah Ta’ala is ki zaroor maghfirat\n" +
                            "                    Denge. ";
                    
                    break;
                case 29:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasool Allah S.A.W ne irshaad farmaaya\n" +
                            "                    Meri shafaat ka sab se zyada nafa uthane wala wo shaks hoga jo apn dil ke khulaas ke saath\n" +
                            "                    Lailaha Illallah kahe. ";
                    
                    break;
                case 30:
                    message="Hazrat Omer Bin Khatteb R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate huye suna: Mai ek aisa kalima jaanta hoon jise koi banda bhu dil se haq\n" +
                            "                    samajh kar kahe aur issi halat par iski maut aaye to Allah Ta’ala is par zaroor jahanum ki aag\n" +
                            "                    haram farma denge,wo kalima Lailaha Illallah hai. ";
                    
                    break;
                case 31:
                    message="Hazrat Abu Bakar Siddiq se riwayat hai ke Nabi Kareem S.A.W ne irshaad farmaaya\n" +
                            " : Jisne Lilaha Illallah ki gawahi is tarah di ke uska dil uski zubaan ki tasdeeq karta ho to wo\n" +
                            "                    Jannat ke jis darwaaje se chahe dakhil hojaye. ";
                    
                    break;
                case 32:
                    message="Hazrat Abu Moosa R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaya:\n" +
                            "                    khush khabri lo aur dusron ko bhi khush khabri dedo ke jo shaks sachche dil se Lailaha Illallah\n" +
                            "                    ka iqraar kare wo jannat mein dakhil hoga. ";
                    
                    break;
                case 33:
                    message="Hazrat Abu Darda’a R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya:\n" +
                            "                    jo shaks ekhlaas ke saath is baat ki gawahi de ke Allah Ta’ala ke siwa koi Ma’abood nahi aur\n" +
                            "                    Mohammed S.A.W uske bande aur uske Rsool hain wo jannat mein dakhil hoga. ";
                    
                    break;
                case 34:
                    message="Hazrat Utban Bin Malik Ansari R.A. se riwayat hai ke Rasoolallah S.A.W ne irshad\n" +
                            "                    framaaya : jo shaks qayamat ke din Lilaha Illallah ko is tarah se kehta hua aaye ke is kalima ke\n" +
                            "                    zariye Allah Ta’ala hi kirazamandi chahte ho Allah Ta’ala is par dozakh ki aag ko zaroor haram\n" +
                            "                    farmadenge. ";
                    
                    break;
                case 35:
                    message="Hazrat Obada Bin Samit R.A. se riwayat hai ke maine Rasoolallah S.A.W ko irshaad\n" +
                            "                    farmaate huye suna : jis shaks ki maut is haal mein aayi ke wo Allah Ta’ala ke saath kisiko\n" +
                            "                    shareek na tehraya ho to yaqeenan Allah Ta’ala ne is par dozakh ki aag haram kardi. ";
                    
                    break;
                case 36:
                    message="Hazrat Nawas Bin Sama’an R.A. se riwayat hai ke inho ne Rasoolallah S.A.W ko\n" +
                            "                    farmaate huye suna : jis ki maut is haal mein aayi ke isne Allah Ta’ala ke saath kisiko shareek\n" +
                            "                    na tehraya ho to yaqeenan is keliye maghfirat zaroor hogi. ";
                    
                    break;
                case 37:
                    message="Hazrat Jareer R.A. se riwayat hai ke Nabi Kareem ne irshaad farmaya: jis shaks ki\n" +
                            "                    maut is haal mein aaye ke wo Allah Ta’ala ke saath kisi ko shareek na tehrata ho aur na kisi ke\n" +
                            "                    nahaq khoon mein haat na range ho to wo jannat ke darwazon mein jis darwaaze se chahe\n" +
                            "                    dakhil kardiya jayega. ";
                    
                    break;
                case 38:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Nabi Kreem S.A.w se irsaad farmaaya\n" +
                            "                    Imaan ye hai ke tum Allah Ta’ala ko aur uske farishton ko (akhirat mein) Allah Ta’ala se milne\n" +
                            "                    Ko aur uske Rasoolon ko haq jaano aur haq maano (aur marne ke baad dubara) uthaye jaane\n" +
                            "                    Ko haq jaano aur haq maano. ";
                    
                    break;
                case 39:
                    message="Hazrat Omer Bin Khattab R.A. se riwayat hai ke Nabi kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : jis shaks ki maut is haal mein aaye ke wo Allah Ta’ala par aur Qyamat ke din par\n" +
                            "                    imaan rakhta ho isse kaha jayega ke tum jannat ke aat(8) darwazon mein jis se chaho dakhil\n" +
                            "                    hojao. ";
                    
                    break;
                case 40:
                    message="Hazrat Abu Darda’a R.A. farmaate hain ke Rasoolallah S.A.W ne irshaad farmaaya:\n" +
                            "                    Allah Ta’ala ki azmath dil mein badhao wo tumhein baksh denge. ";
                    
                    break;
                case 41:
                    message="Hazrat Zurara Bin Aofa R.A. se riwayat hai ke Rasoolallah S.A.W ne Hazrat Jibrael A.S\n" +
                            "                    se poocha : kya tumne apne Rabb ko dekha hai? Ye sun kar Jibrael A.S. kaanp uthe aur arz kiya:\n" +
                            "                Ae Mohammed! Mere aur inkw darmiyaan to noor ke sattar(70) parde hai agar main kisi ek ke\n" +
                            "                    Nazdeek bhi pahunch jaon to jal jaon. ";
                    
                    break;
                case 42:
                    message="Hazrat Abu Huraira SR.A se riwayat karte hai ke aap S.A.W ne irshaad farmaaya:\n" +
                            "                    Allah Ta’ala qayamath ke din zameen ko apne qabze mein lenge aur aasmaanon ko apne\n" +
                            "                    Dahne haath mein lapeteneg phir farmaayenge ke mai hi baadhah hoon,kahan hai zameen ka\n" +
                            "                    Baadshah. ";
                    
                    break;
                case 43:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Allah Ta’ala ke ninnanwe(99) naam haun,ek kam sau.Jisne inko khoob achchi tarah yaad kiya\n" +
                            "                    Wo jannat mein dakhil hoga. ";
                    
                    break;
                case 44:
                    message="Hazrat Abu Huraira R.A. farmaate hai ke Rasoolallah S.A.W ko ye irshaad farmate\n" +
                            "                    huye suna: log hamesh (Allah Ta’ala ki zaat ki bare mein) ek dusre se poochte rahenge yahan\n" +
                            "                    tak ke ye kaha jayega ke Allah Ta’ala ko kisne paida kiya?(n’a0zbillah) jab log ye baath kahe tho\n" +
                            "                    thum kalimaat kaho. ";
                    
                    break;
                case 45:
                    message="Hazrat Abu Moosa Ashari R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Takleefda baat sunkar Allah Ta’ala se zyada bardash karne wala koi nahi hain.\n" +
                            "                        Mushrikeen iske beta hone ka dawa karte hain aur phir bhi wo inhein aafiyat deta hai aur\n" +
                            "                    Rozi ata’a karta hain.";
                    
                    break;
                case 46:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W. ne irshaad farmaaya\n" +
                            "                : jab Allah Ta’ala ne makhlooq ko paida kiya to looh-e-mehfooz mein ye likh diya ‘meri rehmat\n" +
                            "                    Mere gusse se badi hui hai’.Ye tehreer inke saamne arsh par maujood hai. ";
                    
                    break;
                case 47:
                    message="Hazrat Abu Huraira R.A. riwayat karte hain ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : is zaat ki qasam jis ke qabze mein Mohammed S.A.W ki jaan hai is ummat mein koi\n" +
                            "                    shaks yahoodi ya isai aisa nahi jo meri (nabu’at ki) khabr sune phir is deen par imaan na laye jis\n" +
                            "                    ko dekar mujhe bheja gaya hai aur (isi haal par) marjaaye to wo yaqeenan dozakh mein hoga ";
                    
                    break;
                case 48:
                    message="Hazrat Abdullah Bin Amr R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Koi shaks is waqt tak (kamil) imaan wala nahi hosakta jab tak ke uski nafsaani\n" +
                            "                    chahate is deen ke tabey na hojaye jis ko mai lekar aaya hoon. ";
                    
                    break;
                case 49:
                    message="Hazrat Abu Huraira R.A. Rasoolallah S.A.W ka irshaad naql farmaate hai ke jis ne\n" +
                            "                    mere tareeqe ko meri ummat ke bigaad ke waqt mazbooti se thama rakha use shaheed ka\n" +
                            "                    sawab milega. ";
                    
                    break;
                case 50:
                    message="Hazrat Malik Bin Anas farmaate hai ke mujhe ye riwayat pahunchi hai ke\n" +
                            "                    Rasoolallah S.A.W ne irshhad farmaaya : Maine tumhare paas do cheezein chordi hai jab tak\n" +
                            "                    Tum inko mazbooti se pakdhe rahoge hargeez gumrah nahi hoge. Wo Allah Ta’ala ki kitaab aur\n" +
                            "                    Iske Rasool ki sunnat hai. ";
                    
                    break;
                case 51:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya:\n" +
                            "                    Meri ummat mein mujhse zyada mohabbat rakhne walw logon mein wo bhi hai jo mere baad\n" +
                            "                    Aayenge, inki ye aarzoo hogi ke kaash wo apna ghar baar aur maal sab qurbaan karke kisi\n" +
                            "                    Tarah mujhko dekhlete. ";
                    
                    break;
                case 52:
                    message="Hazrat Arbaaz Bin Sariya R.A. se riwayat hai farmate hai ke maine Rasoolallah S.A.W\n" +
                            "                    ko irshaad farmaate hue suna: Bilashuba mai Allah Ta’ala ka banda aur aakri Nabi hoon. ";
                    
                    break;
                case 53:
                    message="Hazrat Abu Darda R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad farmaya:\n" +
                            "                    Har cheez ki ek haqiqat hoti hai koi banda is waqt imaan ki haqiqat ko nahi pahunchta jab tak\n" +
                            "                    Ke iska pokhta yaqeen ye nah o ke jo halaat isko pesh aaye hain wo aane hi the aur jo halaat\n" +
                            "                    Is par nahi aaye wo aa nahi sakthe.";
                    
                    break;
                case 54:
                    message="Hazrat Abdullah Bin Amr Bin Aas R.A. farmaate hain ke maina Rasoolallah S.A.W ko\n" +
                            "                    ye irshaad farmaate hue suna: Alaah Ta’ala ne zameen wa aasmaan banana se pachaas hazaar\n" +
                            "                    saal pehle tamaam makhlooqat ki taqdeerein likh di us waqt Allah Ta’ala ka arsh paani par\n" +
                            "                    tha.";
                    
                    break;
                case 55:
                    message="Hazrat Abu Darda’a R.A. farmaate hai ke maine Nabi Kareem S.A.W ko ye irshaad\n" +
                            "                    farmaate huye suna : Allah Ta’ala har bande ki paanch baatein likh kar farig hochuke hai iski\n" +
                            "                    maut ka waqt iska amaal ( acha hoy a bura), iske dafn hone ki jagah , iski umar iska rizq. ";
                    
                    break;
                case 56:
                    message="Hazrat Amr Bin Shoeb apne baap dada ke hawaale se riwayat karte hain ke Nabi\n" +
                            "                    Kareem S.A.W ne irshaad farmaaya: Koi shaks is waqt tak momin nahi ho saktha jab tak ke har\n" +
                            "                    Achchi buri taqdeer par ke wo Allah ki taraf se hai imaan na rakhe. ";
                    
                    break;
                case 57:
                    message="Hazrat Abdullah Bin Omr R.A se riwayat hai ke Rasoolallaj S.A.W ne irshaad\n" +
                            "                    farmaaya : Sab kuch taqdeer mein likha ja chukka hai yahan tak ke (insan ka) nasamajh aur\n" +
                            "                    nakara hona,hoshiyar aur kaabil hona bhi taqdeer hi se hai. ";
                    
                    break;
                case 58:
                    message="Hazrat Ibn Abbas R.A riwayat karte hai ke Hazrat Abu Bakr R.A. ne arz kiya ya\n" +
                            "                    Rasoolallah Aap par budhapa aagaya Aap S.A.W ne irshaad farmaaya: Mujhe Surah Hood,\n" +
                            "                        Surah Waqiya, Surah Umm Yatasa’lun aur Surah Iza AlShams Kuirat ne budha kardiya. ";
                    
                    break;
                case 59:
                    message="Hazrat Ayesha R.A. riwayat karte hain ke jab bhi Rasoolallah S.A.W ki mere haan\n" +
                            "                    bari hoti aur raat ko tashreef late tho aap S.A.W raat ke aakhri hisse mein baqe’e ( qabrastaan)\n" +
                            "                    tashreef lejathe aur irshaad farmate. ";
                    
                    break;
                case 60:
                    message="Hazrat Osman Bin Affan R.A. se riwayat hai ke Rassolallah S.A.W ne jab mayyat ke\n" +
                            "                    dafn se farikh hojate to khabr ke paas khade hote aur irshaad farmaate ke apne bhai ke liye\n" +
                            "                    Allah Ta’ala se maqfirat dua karo , aur ye mango ke Allah Ta’ala isko (sawaalat ke jawaabat\n" +
                            "                    Mein) sabit khadm rakhe kyun ke is waqt is se pooch gooch ho rahi hai.";
                    
                    break;
                case 61:
                    message="Hazrat Anas R.A se riwayat haik ke Rasoolallah S.A.W ne irshaad farmaaya qayamat\n" +
                            "                    is waqt tak nahi aayegi jab tak ke ( aisa bura waqt na aajaye ke) duniya mein Allah bilkul na\n" +
                            "                    kaha jaaye. Ek aur hades mein is tarah hai ke kisi aise shaks ke hote huye qayamat qayam nahi\n" +
                            "                    hogi jo Allah Allah kehta ho. ";
                    
                    break;
                case 62:
                    message="Hazrat Abdullah R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    qayamat badtareen aadmiyon par hi qayam hogi. ";
                    
                    break;
                case 63:
                    message="Hazrat Anas Bin Malik R.A. se farmaate hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Gunah kabira karne walon ke haq mein meri shafat sirf meri ummat ke logon\n" +
                            "                    ke liye makhsoos hogi (dusri ummaton ke logan keliye nahi hogi. ";
                    
                    break;
                case 64:
                    message="Hazrat Imran Bin Hussain riwayat karte hain ke Rasoolallah S.A.W ne irshhad\n" +
                            "                    farmaaya: Logon ki ek jamaat jink a laqb jahanumi hoga Hazrat Mohammed S.A.W ki shafat par\n" +
                            "                    ye log dozakh se nikal kar jannat mein dakhil honge.";
                    
                    break;
                case 65:
                    message="Hazrat Smarab R.A se riwayat hai ke Rasoolallah S.A.W ne irshhad farmaaya:\n" +
                            "                    (Akhirat mein) har Nabi ka ek hauz hai aur anbiya aapas mein is baat par fakhr karenge ke in\n" +
                            "                    Mein se kiske paas peene waale zyada aatey hain mai umeed rakhta hoon ke sab se zyada\n" +
                            "                    Peene ke liye log mere paas aayenge(aur mere hauz se sairaab honge). ";
                    
                    break;
                case 66:
                    message="Hazrat Suhail Bin Saad R.A.. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Jannat mein ek kodhe ki jagah yani kam se kam jagah bhi duniya aur jo kuch\n" +
                            "                    is mein hai is se behtar (aur zyada qeemti) hai. ";
                    
                    break;
                case 67:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            " : Jannat mein ek darqt aisa hai ke sawaar is ka saaye mein sau saal chal kar bhi isko paar na\n" +
                            "                    Kar sake aur tum chaho to ye aayat padho ‘wazillim’mumdudin’ aur(jannati) lambe saayon\n" +
                            "                    Mein (honge). ";
                    
                    break;
                case 68:
                    message="Hazrat Sumra Bin Jandub R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Baaz dozakhiyon ko aag inke takhnon tak padhegi aur baaz ko inki hainsili\n" +
                            "                        (gardan ke neeche ki haddi) tak padegi. ";
                    
                    break;

                case 69:
                    message="Hazrat Mu’az Bin Jabal R.A. se riwayat farmaate hai ke maine Nabi Kareem S.A.W\n" +
                            "                    ko ye irshaad farmaate huye suna: Jo shaks Allah Ta’ala se is haal mein mile ke who inke\n" +
                            "                    saath kisi ko shareek na karta ho, paancho waqt ki namaz padhta ho aur ramzan ke roza\n" +
                            "                    rakhta ho is ki maghfirat kardi jayegi.";
                    
                    break;
                case 70:
                    message="Hazrat Fazala Bin Obaid R.A. se riwayat hai Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaate : Mujahid who hai jo apne nafs se jihad kare yani nafsani khwahishat ke khilaf\n" +
                            "                    chalne ki koshish kare.";
                    
                    break;
                case 71:
                    message="Hazrat Otbah Bin Abdi R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            " : Ke Agar koi shaks apni paidaish ke sin se maut ke din tak Allah Ta’ala ko razi karne ke liye\n" +
                            "                    Mooh ke bal( sajde mein) padha raha tho qayamat ke din wo apne is amal ko bhi kam\n" +
                            "                    Samjhega. ";
                    
                    break;
                case 72:
                    message="Hazrat Abu Huraira R.A. farmaate hain ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    ke Duniya momin ke liye qaid khana aur kafir ke liye jannat hai. ";
                    
                    break;
                case 73:
                    message="Hazrat Abu Huraira R.A se riwayat hai ke inhone ek sahib ko ye kehte huye suna ke\n" +
                            "                    zalim aadmi sirf apna hi nuqsan kartha hai. Is par Hazrat Abu Huraita R.A. ne irshaad farmaaya\n" +
                            "                    ke apna to nuqsan karta hai hai Allah Ta’ala ki qasam!Zalim ke zulm se surkhaab (parinde) bhi\n" +
                            "                    apne ghosle mein such such kar marjaata hai. ";
                    
                    break;
                case 74:
                    message="Hazrat Anas Ibne Malik R.A. riwayat karthe hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya mayyat ke saath teen cheese jaathi hai. Do cheese waapas aajathi hai. Aur ek saath\n" +
                            "                    rah jaathi hai. Ghar waale,maal aur amaal saath jaathe hai.phir gharwale aur maal waapas\n" +
                            "                    aajaathe hai,aamal saath reh jaatha hai. ";
                    
                    break;
                case 75:
                    message="Allah Ta’ala ka irshaad hai: Jo kuch tumhare paas duniya mein hai,woe k din khatm\n" +
                            "                    hojayega,aur jo aamal thum Allah Ta’ala ke paas bhej dho ge wo hamesh baakhi rahega. ";
                    
                    break;
                case 76:
                    message="Hazrat Jaber Bin Abdullah se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    ke jannat ki kunji namaz hai aur namaz ki kunji wuzu hai. ";
                    
                    break;
                case 77:
                    message="Hazrat Anas R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya : Meri\n" +
                            "                    aankhoon ki thandak namaz me rakhi gayi hai. ";
                    
                    break;
                case 78:
                    message="Hazrat Omer R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya ki namaz\n" +
                            "                    deen ka Sutoon hai. ";
                    
                    break;
                case 79:
                    message="Hazrat Ali R.A. se riwayat hai ke Rasoolallah S.A.W ne aakhri wasiyat ye irshaad\n" +
                            "                    farmaayi: namaz,namaz. Apne ghulamon aur matehataon ke bare mein Allah Ta’ala se daro\n" +
                            "                    yani inke huqooq ada karo. ";
                    
                    break;
                case 80:
                    message="Hazrat Osman Bin Affan R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks namaz padhne ko zaroori samjhein wo jannat mein dakhil hoga. ";
                    
                    break;
                case 81:
                    message="Hazrat Abdullah Bin Qurt R.A. se riwayat hai ke Rasoolallah S.A.W ne irshhaad\n" +
                            "                    farmaaya ke qayamat ke din sabse pehle namaz ka hisab kiya jayega. Agar namaz achchi hui to\n" +
                            "                    baaqi aamal bhi achche honge ,aur agar namaz kharaab hui to baaqi amaal bhi kharaab\n" +
                            "                    honge.";
                    
                    break;
                case 82:
                    message="Hazrat Jaber R.A. farmaate hai k eek shaks Nabi-e-Kareem S.A.W se araz kiya: Falan\n" +
                            "                    shaks (raat ko) namaaz padhta hai phir subah hothe hi chori kartha hai. Nabi-e-Kareem S.A.W.\n" +
                            "                        ne irshaad farmaaya : Iski namaz usko us bure kaam se ankhareeb hi rok degi. ";
                    
                    break;
                case 83:
                    message="Hazrat Salman R.A. se riwayat karte hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Jab musalman achchi tarah wuzu karta hai phir paancon namazein padhta hai to uske gunaah\n" +
                            "                    Aise girjaate hai jaise ye paathe gir rahe hain. ";
                    
                    break;
                case 84:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    ke Paanchon namazein jumma ki namaz pichle jumma tak aur ramza ke roze pichle roze tak\n" +
                            "                    darmiyaani auqat ke tamaam gunahon ke liye kafara hai jab ke in amaal ko larne waala kabira\n" +
                            "                    gunahon se bache. ";
                    
                    break;
                case 85:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya: Jo\n" +
                            "                    shaks in paanch farz namaazon ko pabandi se padhta hai wo Allah Ta’ala ki ibadat se gafil\n" +
                            "                    rehne walon mein shumaar nahi hota. ";
                    
                    break;
                case 86:
                    message="Hazrat Abu Malik Asjyahi R.A. apne waalid se riwaayat karte hain ke Rasoolallah\n" +
                            "                    S.A.W Ke zamane mein jab koi shaks musalman hota to (sahaba karaam) sabse ise namaz\n" +
                            "                    Sikhate. ";
                    
                    break;
                case 87:
                    message="Hazrat Abu Umama R.A. se riwayat hai ke Rasoolallah S.A.W se daryaft kiya gaya: ya\n" +
                            "                    Rasoolallah! Kaun se waqt ki dua zyada qubool hoti hai? Irshaad farmaaya: Raat ke aakhiri\n" +
                            "                    Hisse Mein aur farz namazon ke baad. ";
                    
                    break;
                case 88:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaay : Jo\n" +
                            "                    shaks har namaz ke baad ‘subhanallah’ 33 mataba, ‘alhamdulillah’ 33 martaba, ‘allahuakbar’\n" +
                            "                    33 martaba padhe , Ye kul 99 martaba hua aur sau(100) ki ginti poori karte hue ek martaba\n" +
                            " ‘Lailaha illallahu wahadahu lashareekalahu lahulmulu walahulhamdhu wahuwa ala kulli\n" +
                            "                    Shayyin khadeer’ padhe iske gunah maaf hojathe hain. ";
                    
                    break;
                case 89:
                    message="Hazrat Ka’af Bin Ujrah R.A. se riwayat hai ke Rasoolallah S.A.W. ne irshaad\n" +
                            "                    farmaaya: namaz ke baad padhe jaane waale chand kalimaat aise hai jinka padhne wala kabhi\n" +
                            "                    mehroom nahi hota. Wo kalimaat har farz namaz ke baad 33 martaba ‘subhanallah’,33\n" +
                            "                    martaba ‘alhamdulillah’ , 33 martaba ‘allahuakbar’ hain. ";
                    
                    break;
                case 90:
                    message="Hazrat Abu Umama R.A. se riwayar hai ke Rasoolallah S.A.W ne irshaad farmaaya:\n" +
                            "                    Jo shaks har farz namaz ke baad ayatal kursi padh liya kare usko jannat mein jaane se sirf iski\n" +
                            "                    Maut hi roke hui hai. Ek riwayat mein ayatul kursi ke saath sura-e-ikhlas padhne ka bhi zikr\n" +
                            "                    Hai. ";
                    
                    break;
                case 91:
                    message="Hazrat Assan Bin Ali riwayat krte hain ke Rasoolallah S.A.W ne irshaad farmaaya : Jo\n" +
                            "                    shaks farz namaz ke baad ‘ayatul kursi’ padh leta hai wo dusri namaz tak Allah Ta’ala ki hifazat\n" +
                            "                    mein rehta hai. ";
                    
                    break;
                case 92:
                    message="Hazrat Abu Moosa R.A. se riwayat hain ke Rasoolallah S.AW ne irshaad farmaaya: Jo\n" +
                            "                    do thandi namazein padhta hai wo jannat mein dakhil hoga. ";
                    
                    break;
                case 93:
                    message="Hazrat Ruyeba R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye irshaad farmate\n" +
                            "                    huye suna: Jo shaks suraj nikalne se pehle aur suraj ghuroob hone se pehle namaz padhta hai\n" +
                            "                    yani fazr aur asar wo jahanum mein daakhil nahi hoga. ";
                    
                    break;
                case 94:
                    message="Hazrat Umm Farwah Farmati hain ke Rasoolallah S.A.W se poocha gaya ke sab se\n" +
                            "                    Afzal amal kya hai? Aap S.A.W ne irshaad farmaaya: Awal waqt mein namaz padhna. ";
                    
                    break;
                case 95:
                    message="Hazrat Ali R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya: Quran\n" +
                            "                    waalo yani musalmano!Witar padh liya karo kyunke Allah Ta’ala witar hain,witar padhne ko\n" +
                            "                    pasand farmaate hain. ";
                    
                    break;
                case 96:
                    message="Hazrat Abu Darda R.A. farmaate hain mujhe mere Habeeb S.A.W ne teen baton ki\n" +
                            "                    wasiyat farmayee: Har mahine teen din ke roze rakhna,sone se pehle witar padhna aur fajr ke\n" +
                            "                    do rakaat sunnat ada karna. ";
                    
                    break;
                case 97:
                    message="Hazrat Jaber Bin Abdullah R.A. se riwayat hai ke mai ne Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate huye sun: namaz ka chodna musalman ko kufr wa shirk tak pahunchane\n" +
                            "                    wala hai. ";
                    
                    break;
                case 98:
                    message="Hazrat Ibn Abbas se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaya: Jis shaks\n" +
                            "                    ne namaz chod di wo Allah Ta’ala se aisi halat mein milega ke Allah Ta’ala isse sakht naraz\n" +
                            "                    honge. ";
                    
                    break;
                case 99:
                    message="Hazrat Naufal Bin Muawiya R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Jis shaks ki ek namaz bhi faut hogayee wo aisa hai ke goya uske ghar ke log aur\n" +
                            "                    maal-o-daulat sab cheenliya gaya ho. ";
                    
                    break;
                case 100:
                    message="Hazrat Muawiya R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye irshaad\n" +
                            "                    farmaate huye suna : Mauzan qayamat ke din sabse zyada lambi gardan wale honge.";
                    
                    break;
                case 101:
                    message="Hazrat Abdullah Bin Omar se riwayar hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaye: Jisne 12 saal azaan di uske liye jannat wajib hogayee. Iske liye har azaan ke badle\n" +
                            "                    mein 60 nekiyan likhi jaati hain aur har iqamat ke badle mein 30 nekiyan likhi jati hai. ";
                    
                    break;
                case 102:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            " : imam zimedar hai aur mauzan par bharosa kiya jaata hai. Aye Allah! Imamon ki rehnumayee\n" +
                            "                    Farma aur mauzanon ki maghfirat farma. ";
                    
                    break;
                case 103:
                    message="Hazrat Abu Huraira R.A. riwayat karte hau ki Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            " : Agar logon ko azaan aur pehli saf qura andazi ke bagair hasil na hoti to wo zaroor qura andazi\n" +
                            "                    Karte. ";
                    
                    break;
                case 104:
                    message="Hazrat Sohail Bin Saad R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    ke Do waqton ki duaein rad nahi ki jaathi. Ek azaan ke waqt dusri us waqt jab ghamsaan ki\n" +
                            "                    ladai shuru ho jaye. ";
                    
                    break;
                case 105:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke hum Rasoolallah ke saath the. Hazrat Bilal\n" +
                            "                    azaan dene khade hue. Jab azaan de chuke to Raoolallah ne irshaad farmaya : Jo shaks yaqeen\n" +
                            "                    ke saath in jaise kalimaat kehta hai jo mauzan ne azaan mai kahe wo jannat mai dakhil hoga. ";
                    
                    break;
                case 106:
                    message="Hazrat Jaber Bin Abdullah se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaya:\n" +
                            "                    Jab namaz ke liye aqamat kahi jati hai to aasmaan ke darwaze khol diye jate hain aur dua\n" +
                            "                    Qubool ki jaathi hai. ";
                    
                    break;
                case 107:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Jab tum mein se koi shaks ghar se wuzu karke masjid aata hai to ghar wapis aane tak isse\n" +
                            "                    Namaz ka sawab milega. Is ke baad Rasoolallah S.A.W ne apne haathon ki ungliyaanek dusre\n" +
                            "                    Mein dakhil kiye aur irshaad farmaaya : Isse aisa nahi karna chahiye. ";
                    
                    break;
                case 108:
                    message="Hazrat Salman R.A se riwayat hai ke Nabi Kareem S.A.W ne irshaad farmaaya ke Jo\n" +
                            "                    shaks apne ghar mein achchi tarah wuzu karke masjid aata hai wo Allah Ta’ala ka mehmaan\n" +
                            "                    hai (Allah Ta’ala iske mezbaan hai) aur mezbaan ke zimma hai aur zimma hai ke mehmaan ka\n" +
                            "                    ikraam kare. ";
                    
                    break;
                case 109:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Nabi Kareem S.A.AW ne irshaad farmaaya\n" +
                            "                    ke Jab tum mein se koi shaks apne ghar se meri masjid ke liye nikalta hai to iske ghar wapis\n" +
                            "                    hone tak har qadam par ek naiki likhi jati hai aur har dusre qadam pre k burai mitayi jati hai. ";
                    
                    break;
                case 110:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Qayamat ke din Allah Ta’ala in logon ko jo andheron mein masjid ki taraf jaate hain, ( chaaron\n" +
                            "                    Taraf) phailane waale noor se munawar farmainge. ";
                    
                    break;
                case 111:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Andheron mein bakasrat masjidon mein jaane waale log hi Allah Ta’ala ki rehmat mein ghauta\n" +
                            "                    Lagane waale hain. ";
                    
                    break;
                case 112:
                    message="Hazrat Buraidah R.A se riwayat hai ke Nabi Kareem S.A.W ne irshaad farmaaya : Jo\n" +
                            "                    log andheron mein bakasrat masjidon ko jaate rehte hain inko qayamat ke din poore noor ki\n" +
                            "                    khush khabri suna dijiye. ";
                    
                    break;
                case 113:
                    message="Hazrat Arbaz Bin Sariya R.A. se riwayat hai ke Rasoolallah S.A.W pehli Saf walon ke\n" +
                            "                    liye teen martaba aur dusri saf walon ke liye ek martaba dua-e-maghfirat farmate the. ";
                    
                    break;
                case 114:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya:\n" +
                            "                    Mardon ki safon mein sabse zyada sawab pehli saf ka hai aur sabse kam sawab aakri saf ka hai\n" +
                            "                    Auraton ki safon mein sabse zyada sawab aakhri saf ka hai aur sab se kum sawab pehli saf ka\n" +
                            "                    Hai. ";
                    
                    break;
                case 115:
                    message="Hazrat Baara’a Bin Aazib riwayat karte hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Allah Ta’ala agli safon se khareeb saf walon par rehmat nazil farmaate hain aur iski\n" +
                            "                    farishte unke liye dua karthe hai.Allah Ta’ala ko is khadam se zyada koi khadam mehboob nahi\n" +
                            "                    jisko insaan saf ki khali jagah ko pura karne ke liye uthata hai. ";
                    
                    break;
                case 116:
                    message="Hazrat Ayesha riwayat karthi hai ke Rasoolallah S.A.W ne irshaad farmaaya: Allah\n" +
                            "                    Ta’ala safon ki dayein janib khade hone walon par rehmat nazil farmaate hai aur farishte unke\n" +
                            "                    Liye maghfirat ki dua karthe hai. ";
                    
                    break;
                case 117:
                    message="Hazrat Ibn Abbas se riwayat hai ke Rasoolallah S.A.Wne irshaad farmaaya : Jo shaks\n" +
                            "                    Masjid mein saf ki bayein janib isliye khada hota hai ke wahan log kam khade hain to ise do\n" +
                            "                    Ajar milte hain. ";
                    
                    break;
                case 118:
                    message="Hazrat Ayesh riwayat karthi hai ke Rasoolallah S.A.W ne irshaad farmaaya Allah\n" +
                            "                    Ta’ala safon ki khali jagaon ko pure karne walon par rehmat nazil farmaate hai aur farishte unki\n" +
                            "                    Liye istigfaar karthe hai. ";
                    
                    break;
                case 119:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :Jo\n" +
                            "                    shaks kisi saf ko milatha hai Allah Ta’ala iski wajah se uska ek darja buland farmadete hai aur\n" +
                            "                    farishte us par rehmaton ko bikhar dete hain. ";
                    
                    break;
                case 120:
                    message="Hazrat Abdullah Bin Omer se riwayat hai ke Rsoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Tum mein behtareen log woh hai jo namaz mein apne moundeh narm rakthe hain.Sabse zyada\n" +
                            "                    Sawab dilaane waala wo khadam hai jisko insaan saf ki khali jagah ko pura karne ke liye uthata\n" +
                            "                    Hai.";
                    
                    break;
                case 121:
                    message="Hazrat Abu Huzaifa R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad farmaaya :\n" +
                            "                    Jis shaks ne saf mein khali jagah k pur kiya uski magfirat kardi jaati hai. ";
                    
                    break;
                case 122:
                    message="Hazrat Abdullah Bin Omer se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya:\n" +
                            "                    Jo shaks saf ko milata hai Allah Ta’ala use apni rehmat se mila dete hai aur jo shaks saf ko\n" +
                            "                    Thodta hai Allah Ta’ala use apni rehmat se dur kar dethe hai. ";
                    
                    break;
                case 123:
                    message="Hazrat Anas R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad farmaaya : Apni\n" +
                            "                    safon ko seedha kiya karo kyunki namaz ko achchi tarah adaa karne mein safon ko seedha\n" +
                            "                    seedha karna shamil hai. ";
                    
                    break;
                case 124:
                    message="Hazrat Osman Bin Affan R.A. se riwayat hai ke Maine Rasoolallah S.A.W ko irshaad\n" +
                            "                    farmaate huye suna : Jo shaks kamil wuzu karta hai phir farz namaz ke liye chal kar jata hai aur\n" +
                            "                    aur namaz jamaat ke saath Masjid mein adaa karta hai to Allah Ta’ala uske gunahon ko mu’af\n" +
                            "                    farma dete hai. ";
                    
                    break;
                case 125:
                    message="Hazrat Omer Bin Khattab R.A. farmaate hai ke maine Rasoolallah S.A.W ko irshaad\n" +
                            "                    farmaate huye suna: Allah Ta’ala bajamaat namaz padhne par khush hote hai. ";
                    
                    break;
                case 126:
                    message="Hazrat Abdullah Bin Masood R.A. riwayat karte hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Aadmi ka jamaat ke saath se namaz padhna akele namaz padhne se bees (20) darje\n" +
                            "                    zyada fazilat rakhta hai.";
                    
                    break;
                case 127:
                    message="Hazrat Abu Huraira R.A.riwayat karte hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    ke Aadmi ka jamaat se namaz padhna apne shar aur bazaar mein namaz padhne se paachees\n" +
                            "                    (25) darje zyada sawab rakhta hai. ";
                    
                    break;
                case 128:
                    message="Hazrat Abdullah Bin Omer se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    ke Jamaat ki namaaz akele ki namaz se ajar wo sawab mai sattais(27) darje zyada hai. ";
                    
                    break;
                case 129:
                    message="Hazrat Abu Darda’a R.A. se riwayat hai ke maine Rasoolallah S.A.W ko irshaaad\n" +
                            "                    farmaate huye suna : Jis gaon ya jungle mein teen aadmi ho aur wahan bajamaat namaz na\n" +
                            "                    hoti to un par shaitan puri tarha ghalib aajata hai isliye jamaat se namaz padhne ko zaroori\n" +
                            "                    samjhoo. Bhedya akeli bakri ko kha jata hai ( aur aadmiyon ka bhediya shaitan hai). ";
                    
                    break;
                case 130:
                    message="Hazrat Osman Bin Affan R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye irshaad\n" +
                            "                    farmaate huye suna: Jo shaks isha ki namaz jamaat ke saath padhe goya isne aadhi raat ibadat\n" +
                            "                    ki aur jo fazr ki namaz bhi jamaat ke saath padhle goya isne puri raat ibaadat ki. ";
                    
                    break;
                case 131:
                    message ="Hazrat Abdul Malik Bin Amir farmaate hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Surah Fatah mein har beemari se shifa hai. ";
                    
                    break;
                case 132:
                    message="Hazrat Abu Huraiara R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Jab tum mein se koi (Surah Fatah ke aakhir mein ) amen kehta hai to issi waqt farishte\n" +
                            "                    Aasmaan par amen kehte hain, agar is shaks ki amen farishton ki amen ke saath mil jati hai to\n" +
                            "                    Iske pichle tamaam gunah mua’f hojate hain.";
                    
                    break;
                case 133:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Apne gharon ko khabristaan na banao yani gharon ko Allah Ta’ala ke zikr se abaad rakho. Jis\n" +
                            "                    Ghar mein Surah Baqra padhi jati hai shaitan is ghar se bhaag jaata hai. ";
                    
                    break;
                case 134:
                    message="Hazrat Jaber R.A. se riwayat hai ke Rasoolallah S.A.W is waqt tak nahi sote the jab\n" +
                            "                    tak ke Surah Sajda ( jo 21 pareh mein hai) aur tabarakallazi biyadeehilmulku na padhlete. ";
                    
                    break;
                case 135:
                    message="Hazrat Jundub se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya: Jis shaks ne\n" +
                            "                    Surah Yaseen kisi raat mein Allah Ta’ala ki raza keliye padhi to iski maghfirat kardi jati hai. ";
                    
                    break;
                case 136:
                    message="Hazrat Abdullah Bin Masood R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate hue suna: Jis shaks ne har raat mein Surah Waqiya padhi is par faqar nahi\n" +
                            "                    aayega.";
                    
                    break;
                case 137:
                    message="Hazrat Abu Huraira R.A ser riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Quran Kareem mein ek Surat tees(30) aayat ki aisi hai ke wo apne padhne waale ki shafaat\n" +
                            "                    Karthi rehthi hai yahan tak ke iski magfirat kardi jaye wo surah Tabarakallazee hai. ";
                    
                    break;
                case 138:
                    message="Hazrat Suleman Bin Surd R.A. farmaate hai ke Rasoolallah S.A.W ne (ek shaks ke\n" +
                            "                    bare mein jo dusre par naraz hotha ho) irshaad farmaaya : Agar ye shaks ‘Aozubillahi\n" +
                            "                    Minashshaitan’ padhl to iska gussa utar jaatha hai. ";
                    
                    break;
                case 139:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya:\n" +
                            "                    teen duaien kahas taur par qabool ki jaathi hai jinke qubool hone mein koi shak nahi. (Aulad)\n" +
                            "                        ke haq mein) baapki dua,musafir ki dua aur mazloom ki dua. ";
                    
                    break;
                case 140:
                    message="Hazrat Jaber R.A. farmaate hai ke maine Nabi Kareem S.A.W ko ye irshaad farmaate\n" +
                            "                    huye suna : Har raat mein ek ghadi aisi hoti hai ke musalman banda is mein duniya wa aqhirat\n" +
                            "                    ki jo khair maangta hai Allah Ta’ala ise zaroor ataa farmaate hain. ";
                    
                    break;
                case 141:
                    message="Hazrat Ayesh R.A. farmaati hain ke Rasoolallah S.A.W jaame duaon ko pasand\n" +
                            "                    farmaate the aur iske alawa ki duan ko chod dethe the. ";
                    
                    break;
                case 142:
                    message="Hazrat Habeeb Bin Muslima Febri R.A. farmaate hain ke maine Rasoolallah S.A.W ko\n" +
                            "                    ye irshaad farmaate hue suna: Jo jamaat ek jagah jamaa ho aur in mein ek dua kare aur dusre\n" +
                            "                    amen kahe to Allah Ta’ala inki dua zaroor qubool farmaate hain. ";
                    
                    break;
                case 143:
                    message="Hazrat Abu Huraira R.a. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaya :\n" +
                            "                    Log namaz mein dua ke waqt apni nigahein aasmaan ki taraf uthane se baaz aaye warna inki\n" +
                            "                    Binayi tuchak li jaayegi. ";
                    
                    break;
                case 144:
                    message="Hazrat Ali R.A. riwayat karte hain ke Rasoolallah S.A.w ne irshaad farmaaya : Dua\n" +
                            "                    mominka hatiyaar hai,deen ka sutoon hai aur zameen wa aasmaan ka noor hai. ";
                    
                    break;
                case 145:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    ke Jo shaks ye chahe ke Allah Ta’ala sakhiyon aur bechaniyon ke waqt iski dua qubool farmaye\n" +
                            "                    ise chahiye ke wo khushhali ke zamane mein zyada dua kya kare. ";
                    
                    break;
                case 146:
                    message="Hazrat Abu Huraira R.A. riwayat karte hain ke Rasoolallah S.A.W ne irshaad farmaya\n" +
                            "                    ke Allah Ta’ala ke nazdeek dua se zyada buland martaba koi cheez nahi. ";
                    
                    break;
                case 147:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    Allah Ta’ala irshaad farmaate hain : Mai apne bande ke saath waisa hi muamla karta ho jaisa\n" +
                            "                    Wo mere saath gumaan rakhta hai. Aur jis waqt wo mujhse dua karta hai to mai iske saath\n" +
                            "                    Hotha hoon. ";
                    
                    break;
                case 148:
                    message="Hazrat Abdullah R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Allah Ta’ala se iska fazal mango kyunke Allah Ta’ala ko ye baat pasand hai ke inse maanga jaye\n" +
                            "                    Aur kushadgi (ki dua ke baad kushadgi) ka intezar karna Afzal ibadat hai. ";
                    
                    break;
                case 149:
                    message="Hazrat Anas Bin Malik R.A. se riwayatNabi Kareem S.A.W ka irshaad manqool hai\n" +
                            "                    dua ibadat ka magz hai. ";
                    
                    break;
                case 150:
                    message="Hazrat Abdullah Bin Amr farmaate hain ke maine Nabi Kareem S.A.W ko apne haath\n" +
                            "                    Mubarak Mubarak ki ungliyon par tasbeeh shumaar karte dekha.";
                        
                    break;
                case 151:
                    message="Hazrat Osman Bin Affan R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Tum mein sab se behtar shaks wo hai jo Quran shareef seekhein aur sikhayein. ";
                    
                    break;
                case 152:
                    message="Hazrat Muawiya farmaate hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Allah Ta’ala jis shaks ke saath bhalai ka irada farmaate hai use deen ki samajh aytaa farmaate\n" +
                            "                    Hai.Mai tho sirf taqseem karnewala hoon.,jabke Allah Ta’ala ataaa karne waale hai. ";
                    
                    break;
                case 153:
                    message="Hazrat Ibn Abbas farmaate hai k eek martaba Rasoolallah S.A.W ne mujhe apne\n" +
                            "                    seene se lagaya aur ye dua di : Ya Allah! Ise Quran ka ilm ataa farmadijiye. ";
                    
                    break;
                case 154:
                    message="Hazrat Anas R.A farmaate hai ke Rasoolallah S.A.W ne irshaad farmaaya : Qayamat\n" +
                            "                    ki alamath mein se ye hai ke ilm utha liya jayega, jahalat aajayegi,sharaab(khullam khulla)\n" +
                            "                    pijayegi. Aur zeena phail jayegi. ";
                    
                    break;
                case 155:
                    message="Hazrat Abu Saeed Khudri R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Momin bhalai (yani ilm) se kabhu sair nahi hota. Wo ilm ki baton ko sunkar seekhta\n" +
                            "                    rehta hai(Yahan tak ke use maut tak aajaathi hai) aur jannat mein daqil hojatha hai. ";
                    
                    break;
                case 156:
                    message="Hazrat Abu Huraira R.A farmaate hai ke maine Abdul Qasim ko ye irshaad farmaate\n" +
                            "                    huye suna : Tum mein se behtar wo log hai jot hum mein se ache aqlaq waale hai jab ke saath\n" +
                            "                    saath un mein deen ki samajh bhi ho.";

                    
                    break;
                case 157:
                    message="Hazrat Jaber Bin Abdullah se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Log kanon ki tarah hai jis tarah sone chandi ke kaane hothi hai. Jo log islam lane se pehle\n" +
                            "                    Behtar rahe wo log islam ke zamane mein bhi behtar hai jab ke un mein deen ki samajh hai. ";
                    
                    break;
                case 158:
                    message="Hazrat Abu Omama R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad farmaaya:\n" +
                            "                    Jo shaks khair ki baat seekhne ya sikhane ke liye hi masjid jaye to iska sawab us haji ke sawab\n" +
                            "                    Ki tarah hai jis ka haj kamil ho. ";
                    
                    break;
                case 159:
                    message="Hazrat Ibn Abbas se riwayat hai ke Rasoolalalh S.A.W ne irshaad farmaaya : Logon\n" +
                            "                    ko(deen) sikhao unke saath aasani ka bartao karo aur sakhti ka bartao na karo. ";
                    
                    break;
                case 160:
                    message="Hazrat Abdullah Bin Masood R.A se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jab Allah Ta’ala kisi bande ka saath bhalai ka iraada farmaate hai tho use deen ki\n" +
                            "                    samajh ataa farmaate hai aur sahi baat uske dil mein dalte hai. ";
                    
                    break;
                case 161:
                    message="Hazrat Wasila Bin Aqsa R.A. riwaayat farmaate hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks ilm ki talash mein lage phir usko hasil bhi karle to Allah Ta’ala uske liye do\n" +
                            "                    ajar likh dete hai. Aur jo shaks ilm ka talib ho aur usko hasil na kar sake to Allah Ta’ala uske liye\n" +
                            "                    ek ajar likh dete hai. ";
                    
                    break;
                case 162:
                    message="Hazrat Abu Darda’a R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye irshaad\n" +
                            "                    farmaate huye suna : Alim ki maut aisi musibat hai jis ki talafi nahi hosakthi aur aisa nuqsan hai\n" +
                            "                    jo pura nahi ho saktha aur alim aisa sitaara hai jo ( maut ki wajha se ) be noor hogaya ek pure\n" +
                            "                    qabeela ki maut ek talim ki maut se kam darje ki nahi. ";
                    
                    break;
                case 163:
                    message="Hazrat Anas Bin Malik R.A. farmate hai ke Nabi Kareem S.A.W ne irshaad farmaaya :\n" +
                            "                    Ulma ki misaal un sitaron ki tarah hai jinse khushki aur tari ke andheron mein rehnumai hasil ki\n" +
                            "                    Jati hai. Jab sitare be noor hojate hai to is baat ka imkaan hota hai ke raasta chalne waale\n" +
                            "                    Bhatak jaaye. ";
                    
                    break;
                case 164:
                    message="Hazrat Ibn Abbas R.A farmaate hai ke Rasoolallah S.A.W ne irshaad farmaaya : Ek\n" +
                            "                    alim –e-deen ek hazar abidon se zyada saqt hai. ";
                    
                    break;
                case 165:
                    message="Hazrat Abu Umama Baheli R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Logon! Ilm ke wapas liye jaane aur utha liye jaane se pehle ilm hasil karo. ";
                    
                    break;
                case 166:
                    message="Hazrat Anas R.A. farmaate hai ke Aap S.A.W ne jab koi baat irshaad farmaate to\n" +
                            "                    usko teen martaba dohrate tak ke (is baat ko) samajh liya jaaye. ";
                    
                    break;
                case 167:
                    message="Hazrat Jaber Bin Abdullah riwayat karte hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Ulma par badai jataane,bewaqufon se jhagadne yani nasamajh awaam se ulajhne\n" +
                            "                    aur majlisein jamaane ke liye ilm hasil na akro. Jo shaks aisa kare uske liye aag hai aag. ";
                    
                    break;
                case 168:
                    message="Hazrat Abu Huraira R.A. farmaate hai ke Rasoolallah S.A.W ne irshaad farmaya : Jis\n" +
                            "                    shaks se koi ilm ki baat poochi jaye aur wo (bawajud jaanne ke) usko chupaye to Allah Ta’ala\n" +
                            "                    qayamat ke din uske muh mein aag ki lagaam dalenge. ";
                    
                    break;
                case 169:
                    message="Hazrat Abu Huraira R.A se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Uss shaks ki misaal jo ilm seekhta hai phir logon ko nahi sikhata us shaks ki tarha hai jo\n" +
                            "                    Khazana jama karta hai phir us mein se kharch nahi karta. ";
                    
                    break;
                case 170:
                    message="Hazrat Jundub R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya : Jisne\n" +
                            "                    Quran Kareem (ki tafseer) mein apni raaye se kuch kaha aur wo haqeeqat mein sahi ho thab\n" +
                            "                    Bhi usne galti ki. ";
                    
                    break;
                case 171:
                    message="Hazrat Abu Zarr Gafari R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya\n" +
                            "                    ke Tum log Allah Ta’ala ka qurb is cheez se badh kar kisi aur cheez se hasil nahi kar sakthe jo\n" +
                            "                    khud Allah Ta’ala se nikli hai yani Quran Kareem. ";
                    
                    break;
                case 172:
                    message="Hazrat Omer Bin Absa R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jis ne ek din Allah Ta’ala ke raasthe mein roza rakha is se\n" +
                            "                    jahanu ki aag sau saal ki masafat ke baqdr door hojayegi.";
                    break;
                case 173:
                    message="Hazrat Abu Zarr R.A. riwayat karte hain ke Rasoolallah S.A.W ne mujhse irshaad\n" +
                            "                    farmaaya : Quran Kareem ki tilawat aur Allah Ta’ala ke zikr ka ehtemaam kiya karo, is amal se\n" +
                            "                    aasmaanon mein tumhara zikr hoga aur ye amal zameen mein tumhare liye hidayat ka noor\n" +
                            "                    hoga. ";
                    
                    break;
                case 174:
                    message="Hazrat Imran Bin Haseen farmaate hain ke maine Rasoolallah S.A.W ko ye irshaad\n" +
                            "                    farmaate huye suna : Jo shaks Quran Majeed padhe ise Quran ke jariye Allah Ta’ala se hi sawal\n" +
                            "                    karna chahiye,anqareeb aise log aayenge jo Quran Majeed padhenge aur iske zariye logon se\n" +
                            "                    sawal karenge. ";
                    
                    break;
                case 175:
                    message="Hazrat Abu Huraira R.A. riwayar karte hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Allah Ta’ala itna kisi ki taraf tawajh nahi farmaate jitna ki is Nabi ki awaz ko\n" +
                            "                    tawajah se sunte hain jo Quran Kareem khush-al-hani se padhta hai.";
                    
                    break;
                case 176:
                    message="Hazrat Bara’a R.A. riwayat karte hain ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Achchi awaaz se Quran Shareef ko muzayan karo kyunke achchi awaaz Quran Kareem ke husn\n" +
                            "                    Ko badha deti hai. ";
                    
                    break;
                case 177:
                    message="Hazrat Abu Huraira R.A. farmaate hain ke maine Rasoolalalh S.A.W se\n" +
                            "                    zyada apne saathiyon se mashwara karne wala koi nahi dekha yani Aap bahut\n" +
                            "                    zyada mashwara farmaya karthe the. ";

                    break;
                case 178:
                    message="Hazrat Abu Sayed Khudri R.A. farmaate hain ke (hum ne ye dua padhni\n" +
                            "                        shuru kardi jis ki barkat se) Allah Ta’ala ne sakht hawa bhej dushmanon ke chehre\n" +
                            "                    kop hair diya (aur yun) Allah Ta’ala ne in ko hawa ke zariye shikast dedi. ";

                    break;
                case 179:
                    message="Hazrat Uqba Bin Aamir R.A. farmaate hai ke maine Rasoolallah S.A.W ko irshaad\n" +
                            "                    farmaate hue suna: Quan Kareem awaaz se padhne waale ka sawab alania sadqa karne wale ki\n" +
                            "                    tarah hai. Aur ahista padhne waale ka sawab chup kar sadqa karne waale ki tarah hai. ";
                    
                    break;
                case 180:
                    message="Hazrat Abu Moosa R.A. riwayat karte hai ke Rasoolallah S.A.W ne in se irshaad\n" +
                            "                    farmaaya: Agar tum mujhse guzishta raat dekh lete jab mai Quran tawajah se sun raha tha\n" +
                            "                        (to yaqeenan khush hothe) tum ko Hazrat Daood Alaihissalam ki khush-al-hani se hisa mila\n" +
                            "                    Hai. ";
                    
                    break;
                case 181:
                    message="Hazrat Anas R.A. riwayat karthe hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Allah Ta’ala ke liye baaz log aise hain jaise kisi ke ghar ke khaas log hote hain.Sahaba ne arz\n" +
                            "                    Kiya: Wo kaun log hain? Irshaad farmaaya : Quran shareef waale ko wo Allah waale aur iske\n" +
                            "                    Khaas log hain. ";
                    
                    break;
                case 182:
                    message="Hazrat Ibn Abbas riwayat karte hai ke Rasoolallah S.A.W ne irshaad farmaaya : Jis\n" +
                            "                    shaks ke dil mein Quran Kareem ka koi hissa bhi mehfooz nahi wo viraan ghar ki tarah hai yani\n" +
                            "                    jaise makaan ki raunaq wa abadi rehne waale se hai aise hi insaan ke dil ki raunaq wa aabadi\n" +
                            "                    Quran Kareem ko yaad rakhne se hai. ";
                    
                    break;
                case 183:
                    message="Hazrat Saad Bin Obada R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks Quran Shareef padh kar bhula de to wo qayamat ke din Allah Ta’ala\n" +
                            "                    ke yahan is haal mein aayega ke kodh ke marz ki wajha se a’aza jhade huye honge. ";
                    
                    break;
                case 184:
                    message="Hazrat Abdullah Bin Amr riwayat karte hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Quran Kareem ko teen din se kam mein khatm karne wla ise achchi tarah nahi\n" +
                            "                    samajh sakta.";
                    
                    break;
                case 185:
                    message="Hazrat Abdullah Bin Amr riwayat karte hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Quran Kareem ko teen din se kam mein khatm karne wla ise achchi tarah nahi\n" +
                            "                    samajh sakta.";
                    
                    break;
                case 186:
                    message="Hazrat Abu Darda’a R.A. se riwayat hai ke Nabi Kareem S.A.w ne irshaad farmaaya :\n" +
                            "                    Jisne Surah Kahaf ki shuru dus aayat yaad Karli wo Dajjal ke fitne se mehfooz hogaya. Aur ek\n" +
                            "                    Riwayat mein Surah Kahaf ki aakhri dus aayaton ke yaad karne ka zikr hai. ";
                    
                    break;
                case 187:
                    message="Hazrat Sauban R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad farmaaya : Jo\n" +
                            "                    shaks Surah Kahaf ki aakhri dus aayatein padh le to ye padhna is ke liye Dajjal ke fitne se\n" +
                            "                    bachao hoga. ";
                    
                    break;
                case 188:
                    message="Hazrat Ali R.A. farmaate hai ke Rasoolallah S.A.W ne irshaad farmaaya : Jo shaks\n" +
                            "                    juma ke din Surah Kahaf padhle wo aat din tak yani agle juma tak har fitne se mehfooz rahega\n" +
                            "                    aur agar is dauraan Dajjal nikal aayein to ye iske fitne bhi mehfooz hoga.";
                    
                    break;
                case 189:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Surah Baqra mein ek aayat hai jo Quran Shareef ki tamaam aayaton ki sardaar hau. Wo aayat\n" +
                            "                    Jaise hi kisi ghar mein padhi jaye aur wahan shaitaan ho to fauraan nikal jata hai,wo\n" +
                            "                    AYAT-AL-KURSI hai. ";
                    
                    break;
                case 190:
                    message="Hazrat Abu Masood Ansari R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks Surah Baqra ki aakhiri do aayatein kisi raat mein padhle to ye aayatein\n" +
                            "                    is ke liye kaafi hojayengi. ";
                    
                    break;
                case 191:
                    message="Hazrat Fazala Bin Obaid aur Hazrat Tameem Daraise riwayat hai ke Nabi Kareem\n" +
                            "                    S.A.W ne irshaad farmaaya : Jo shaks kisi raat dus aayat ki tilawat kare iske liye ek qantaar\n" +
                            "                    Likha jata hai aur qantaar duniya aur duniya mein jo kuch hai in sabse behtar hai. ";
                    
                    break;
                case 192:
                    message="Hazrat Abu Huraira R.A. se riwayat karte hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks raat mein dus aayaton ki tilawat kare wo is raat Allah Ta’ala ki ibadat se\n" +
                            "                    gafil rehne waalon mein shumaar nahi hoga. ";
                    
                    break;
                case 193:
                    message="Hazrat Abu Huraira R.A. riwayat karte hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks raat mein sau aayat ki tilawat kare wo is raat ibadat guzaaron mein\n" +
                            "                    shumar kiya jayega. ";
                    
                    break;
                case 194:
                    message="Hazrat Shadad Bin Aos R.A. riwayat karte hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo musalmaan bhi bistar par ja kar Quran Kareem ki koi si bhi surat padhleta hai to\n" +
                            "                    Allah Ta’ala iski hifaazat ke liye ek farishta muqarar farma dete hai. Phir jab bhi wo bedar ho\n" +
                            "                    Iske bedar hone tak koi takleef da cheez iske qareeb bhi nahi aati. ";
                    
                    break;
                case 195:
                    message="Hazrat Ayesha R.A farmaati hai ke humein Rasoolallah S.A.W ne is baat\n" +
                            "                    ka hukm farmaaya ke hum logon ke saat inke muratib ka lehaz karke bartao kiya\n" +
                            "                    karo. ";
                    
                    break;
                case 196:
                    message="Hazrat Jaber Bin Abdullah riwayat karte hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaya: Ghareeb-o-nadaar musalmaan maaldaar musalmaan se chalees\n" +
                            "                        (40) saal pehle jannat mein dakhil honge. ";
                    
                    break;
                case 197:
                    message="Hazrat Abu Huraira R.A. riwayat karte hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaya: Ghareeb ghurba maldaron se aadhe din pehle jannat mei dakhil\n" +
                            "                    honge aur is aadhe din ki miqdaar paanch sau baras hogi.";
                    
                    break;
                case 198:
                    message="Hazrat Abu Sayeed R.A. se riwayat hai ke maine Rasoolallah S.A.W ko\n" +
                            "                    irshaad farmaate huye suna : Ya Allah! Mujhe miskeen tabiyat bana kar zinda\n" +
                            "                    rakhiye,miskeeni ki halat mein duniya se uthaiye aur mera hasher miskeenon ki\n" +
                            "                    jannat mein farmaayiye. ";
                    
                    break;
                case 199:
                    message="Hazrat Raafa Bin Khadij R.A. se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jab Allah Ta’ala kisi banda se mohabbat farmate hain to isko\n" +
                            "                    duniya se is tarah bchate hain jis tarah tum mein se koi shaks apne mareez ko\n" +
                            "                    paani se bachate hain. ";
                    
                    break;
                case 200:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Ghareebon se mohabbat karo aur inke saat baitho. Arbaon se dil se\n" +
                            "                    mohabbat karo. Aur jo aib tum mein maujood hain wo tumhe dusron par ta’an wa\n" +
                            "                    tashni’a karne se rokdein. ";
                    
                    break;
                case 201:
                    message="Hazrat Anas R.A. farmaate hain ke maine Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate huye suna Bahut se pargandah baal,gard-alooda chadaron waale\n" +
                            "                    logon ko darwazon se hataye jaane waalw,agar Allah Ta’ala (ke bharosa)par qasam\n" +
                            "                    khale to Allah Ta’ala inki qasam ko zaroor poora farmaade. ";
                    
                    break;
                case 202:
                    message="Hazrat Abu Darda’a farmaate hai ke maine Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate hue suna : Mujhe kamzoron mein talaash kiya karo isliye ke\n" +
                            "                    tumhare kamzoron ki wajah se tumhe rozi milti hai aur tumhari madad hothi hai. ";
                    
                    break;
                case 203:
                    message="Hazrat Muaz Bin Jabal R.A. se riwayat hai ke aakhri nasihat jo\n" +
                            "                    Rasoolallah S.A.W ne mujhe farmayi jis waqt maine apna paon rikaab mein rakhliya\n" +
                            "                    Tha wo ye thi: Muaz! Apne akhlaaq ko logon ke liye acha banao. ";
                    
                    break;
                case 204:
                    message="Hazrat Imam Malik farmaate hai mujhe ye hades pahunchu hai ke Aap\n" +
                            "                    S.A.W ne irshaad farmaaya: Mai achche akhlaq ko mukammil karne ke liye bheja\n" +
                            "                    Gaya hoon. ";
                    
                    break;
                case 205:
                    message="Hazrat Jaber R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Tum sab mein se mujhe zyada mehboob aur qayamath ke din mere\n" +
                            "                    sabse qareeb wo log honge jinke akhlaaq zyada ache honge.";
                    
                    break;

                case 206:
                    message="Hazrat Nawas Bin Samaan Ansaari R.A. farmaate hai ke maine\n" +
                            "                    Rasoolallah S.A.W se naiki aur gunah ke bare mein poocha: Rasoolallah S.A.W ne\n" +
                            "                    Irshaad farmaaya : Naiki achche akhlaq ka naam hai aur gunah wo hai jo tumhare\n" +
                            "                    Khatke aur tumhe ye baat na pasand ho ke logon koi ski khabr lo. ";
                    
                    break;
                case 207:
                    message="Hazrat Makbool riwayat karte hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaye : Imaan waale log Allah Ta’al ka bahut hukm man’ne waale aur nihayat\n" +
                            "                    narm tabiyat hote hain jaise tabedar ount jidhar isko chalaya jaata hai chala jaatha\n" +
                            "                    hai aur agar isko kisi chattan par bitha diya jaatha hai to is par baith jaata hai. ";
                    
                    break;
                case 208:
                    message="Qabeela Nabi Majasha ke Hazrat Ayaaz Bin Hamaar R.A. se riwayat hai\n" +
                            "                    ke Rasoolallah S.A.W ne irshaad farmaaya: Allah ta’ala ne meri taraf is baat ki\n" +
                            "                    wahi farmayi hai ke tum log is qadr tawaza ikhtiyar karo yahan tak ke koi kisi par\n" +
                            "                    fakr na kare aur koi kisi par zulm na kare.";
                    
                    break;
                case 209:
                    message="Hazrat Abdullah R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya: Wo shaks jannat mein nahi jaayega jiske dil mein zara barabar\n" +
                            "                    takabbur ho. ";
                    
                    break;
                case 210:
                    message="Hazrat Mawiya R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate hue suna: Jo shals is baat ko pasand ho ke log is(ki ta’zeem)\n" +
                            "                    ke liye khade rahe wo apna thikana jahanum mein banale. ";
                    
                    break;
                case 211:
                    message="Hazrat Anas R.A. se riwayat hai ke sahaba ke nazdeek koi shaks bhi\n" +
                            "                    Rasoolallah S.A.W se zyada mehboob nahi tha. Iske bawajud wo Rasoolallah S.A.W\n" +
                            "                    Ko dekh kar khade nahi hote the kyunke wo jaanthe the wo Aap S.A.W isko na\n" +
                            "                    Pasand farmate the. ";
                    
                    break;
                case 212:
                    message="Hazrat Abu Darda’a se riwayat hai maine Rasoolallah S.A.W ko ye irshad\n" +
                            "                    farmaate hue suna: Jis shaks ko bhi ( kisi ki taraf se) jismani takleef pahunche phir\n" +
                            "                    wo isko mu’af karde to Allah Ta’ala iski wajah se ek darja phir wo buland farma\n" +
                            "                    dete hain aur ek gunah mu’af farma dethe hai. ";
                    
                    break;
                case 213:
                    message="Hazrat Judaan R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Jo shaks apne musalmaan bhau ke saamne azr pesh karta hai aur wo\n" +
                            "                    iske azr ko qubool nahi karta to isko aisa gunah hoga jaisa na haq tax wasool karne\n" +
                            "                    waale ka gunah hotha hai. ";
                    
                    break;
                case 214:
                    message="Hazrat Abu Huraira R.A. riwayat karte hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Hazrat Moosa Bin Imran R.A. ne Allah Ta’ala ki bargah mein\n" +
                            "                    arz kiya : Ae mere Rabb! Aapke bandon mein aapke nazdeek zyada izzat waala\n" +
                            "                    kaun hai? Allah Ta’ala ne irshaad farmaaya : Wo banda jo badla le sakta ho aur phir\n" +
                            "                    mu’af kardhe. ";
                    
                    break;
                case 215:
                    message="Hazrat Abu Qataada R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate huye suna: Jo shaks ye chahte hai ke Allah Ta’ala isko qayamat ke\n" +
                            "                    din ki takleefon se bachale to isko chahiye ke tangdust ko(jis par iska qarz waghaira\n" +
                            "                        ho) mahulat de de ya (apna poora matlab ya is ka kuch hissa)mua’af karde. ";
                    
                    break;
                case 216:
                    message="Hazrat Abu Huraira R.A se riwayat hai ke ek shaks ne Nabi Kareem\n" +
                            "                    S.A.W se arz kiya ke mujhe koi waseeyat farmadijiye. Aap S.A.W ne irshaad\n" +
                            "                    Farmaaya : Gussa na kiya karo. Is shaks ne apni (wohi) darkhwast kayi baar\n" +
                            "                    Dauhrayi. Aap S.A.W ne har martaba yahi irshaad farmaaya : Gussa na kiya karo. ";
                    
                    break;
                case 217:
                    message="Hazrat Abu Huraira R.A se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Taqatwar wo nahi hai jo (apne muqabal ko) pachadh de taqatwar wo\n" +
                            "                    hai jo gusse ki haalat mein apne aap par qaabu pale. ";
                    
                    break;
                case 218:
                    message="Hazrat Abu Zarr R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jab tum mein se kisi ko gussa aaye aur wo khada ho to isko chahiye ke\n" +
                            "                    baith jaaye agar baithe se gussa chalajaay (to theek hai) warna isko chahiye ke lait\n" +
                            "                    jaaye. ";
                    
                    break;
                case 219:
                    message="Hazrat Ibn Abbas R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Logon ko (deen) sikhao aurr khushkhabriyan sunao aur dushwariyan\n" +
                            "                    paida na karo. Aur jab tum mein se kisi gussa aaye to ise chahiye ke khamoshi\n" +
                            "                    ikhtiyaar karle. ";
                    
                    break;
                case 220:
                    message="Hazrat Atiya R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Gussa shaitan (ke asr se ) hota hai. Shaitan ki paidaish aag se hui hai\n" +
                            "                    aur aag paani se bujhayi jati hai lehaza jab tum mein se kisi ko gussa aaye to isko\n" +
                            "                    chahiye ke wuzu karle. ";
                    
                    break;
                case 221:
                    message="Hazrat Abdullah Bin Omer riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya: Banda ( kisi cheez ka ) aisa koi ghunt nahi peeta jo Allah Ta’ala\n" +
                            "                    ke nazdeek gusse ka ghunte peene se behtar ho,jisko wo mehaz Allah Ta’ala raza\n" +
                            "                    ke liye pee jaye. ";
                    
                    break;
                case 222:
                    message="Hazrat Mu’az R.A. riwayat karte hain ke Rasoolallah S.A.W ne qabeele\n" +
                            "                    abdqais ke sardar Hazrat Ashaj R.A. se irshaad farmaaya : Tum mein do khslatein\n" +
                            "                    aisi hain jo Allah Ta’ala ko mehboob hain. Ek hilm yani narmi aur bardasht dusre\n" +
                            "                    jald baazi se kaam na kare. ";
                    
                    break;
                case 223:
                    message="Hazrat Jareer R.A. riwayat karte hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks narmi(ki sifat) se mehroom raha wo (saari) bhalayi se\n" +
                            "                    mehroom raha. ";
                    
                    break;
                case 224:
                    message="Hazrat Ayesha riwayat karti hai ke Rasoolallah S.A.W ne irshaad farmaya\n" +
                            "                    ke Jis shaks ko (Allah Ta’ala ki taraf se) narmi mein se hissa diya gaya isko duniya\n" +
                            "                    wa akhirat ki bhalayon mein se hissa diya gaya aur jo shaks narmi ke hisse se\n" +
                            "                    mehroom raha wo duniya aur akhirat ki bhalayion se mehroom raha. ";
                    
                    break;
                case 225:
                    message="Hazrat Jaber Bin Abdullah se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Allah Ta’ala ki rehmat ho us bande par jo baichne, kharidne aur\n" +
                            "                    apne haq ka taqza karne aur wasool karne mein narmi ikhtiyaar kare. ";
                    
                    break;
                case 226:
                    message="Hazrat Abu Huraira R.A. farmaate hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaya : Jo shaks musalamaan ki baichi ya kharidi hui cheez ki waapsi par raazi\n" +
                            "                    hojate hai Allah Ta’al iski lagzish ko mu’af farmadethe hai.";
                    
                    break;
                case 227:
                    message="Hazrat Abu Huraira R.A. se riwayat karthe hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya: Jo musalman ki kagzish ko mu’af kare Allah Ta’ala qayamat ke\n" +
                            "                    din ski lagzish ki mu’af farmayenge. ";
                    
                    break;
                case 228:
                    message="Hazrat Abu Darda’a R.A se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Salam ko khoob phailo take tum buland hojao.";
                    
                    break;
                case 229:
                    message="Hazrat Ibn Masood R.A. riwayat karte hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya: Alamat-e-qayamat mein se ek alamat ye hai k eek shaks dusre\n" +
                            "                    shakhs dusre shaks ko sirf jaan pehchaan ki bunyaad par salam kare ( na ke\n" +
                            "                    muslaman hone ki bunyaad par).";
                    
                    break;
                case 230:
                    message="Hazrat Abu Umama R.A riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya: Logon mein Allah Ta’ala ke qareeb ka zyada mustahaq wo hai jo\n" +
                            "                    salam karne mein pahel kare. ";
                    
                    break;
                case 231:
                    message="Hazrat Abdullah R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Sala, mein pahel karne waala takkabur se bari hai. ";
                    
                    break;
                case 232:
                    message="”Hazrat Anas R.A farmaate hain ke mujhse Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Beta! Jab tum apne ghar mein dakhil ho to ghar walon ko salam karo. Ye\n" +
                            "                    tumhare liye aur ghar walon ke liye barkat ka sabab hai. ";
                    
                    break;
                case 233:
                    message="Hazrat Qattada se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya: Jab tum kisi ghar mein dakhil ho to is ghar walon ko salam karo. Aur jab\n" +
                            "                    (ghar se)jane lago to ghar walon se salam ke saath rukhsat ho. ";
                    
                    break;
                case 234:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya: Chote bade ko salam kare,guzarne waale baithe hue ko salam kare aur\n" +
                            "                    thode admi zyada admiyon ko salam kare. ";
                    
                    break;
                case 235:
                    message="Hazrat Ali R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    (Raaste se) guzarne wali jamaat mein se agar ek shaks salam karle to is sab ki tarf\n" +
                            "                    Se kaafi hai aur baithe hue logon mein se ek jawab dede to sab ki taraf se kaafi\n" +
                            "                    Hai.";
                    
                    break;
                case 236:
                    message="Hazrat Miqdad Bin Aswad R.A. farmaate hain ke Rasoolallah S.A.W raat\n" +
                            "                    ko tashreef laate to is tarah salam farmate ke sone waale na jaagte aur jaagne\n" +
                            "                    waale sunlete. ";
                    
                    break;
                case 237:
                    message="Hazrat Abu Huraira R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Logon mein sabse zyada aajiz wo shaks hai jo dua karne se aajiz\n" +
                            "                    ho yani dua na karta ho. Aur logon mein sabse zyada bakheel wo hai jo salam mein\n" +
                            "                    bhi bakhal kare. ";
                    
                    break;
                case 238:
                    message="Hazrat Ibn Masood R.A. Rasoolallah S.A.w ka irshaad naqal karte hain ke\n" +
                            "                    salam ki takmeel musafeha hai. ";
                    
                    break;
                case 239:
                    message="Hazrat Bara’a R.A. riwayat karte hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Momin jab momin se milta hai isko salam karta hai aur iska haath pakad\n" +
                            "                    kar musafa karta hai to dono ke gunah is tarah jhadte hain jaise darqt ke patthe\n" +
                            "                    jhadte hain. ";
                    
                    break;
                case 240:
                    message="Hazrat Huzaifa Bin Yamaan R.A. se riwayat hai ke Nabi Kareem S.A.W ne\n" +
                            "                    irshaad farmaaya : Momin jab momin se milta hai isko salam karta hai aur iska\n" +
                            "                    haath pakad kar musafa karta hai to dono ke gunah is tarah jhadte hain jaise darqt\n" +
                            "                    ke gunah is tarag jhadte hain jaise ke patte jhadte hain. ";
                    
                    break;
                case 241:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya: Jab nigah ghar mein chali gayi to phir ijazat koi cheez nahi (yani ijazat ka\n" +
                            "                    phir koi faida nahi). ";
                    
                    break;
                case 242:
                    message="Hazrat Abdullah Bin Omer se riwayat hai ke Nabi Kareem S.A.W ne\n" +
                            "                    irshaad farmaya : Kisi shaks ko is baat ka ijazata nahi ke kisi dusre koi ski jagah se\n" +
                            "                    utha kar khud is jagah baith jaye. ";
                    
                    break;
                case 243:
                    message="Hazrat Abu Huraira R.A se riwayt hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks apni jagah se (kisi zaroorat se) utha aur phir wapas aagaya to\n" +
                            "                    iski jagah baithne ka wohi shaks zyada haqdaar hai. ";
                    
                    break;
                case 244:
                    message="Hazrat Omer Bin Sho’eb apne baap dada ke hawale se riwayat karte\n" +
                            "                    hain ke Rasoolallah S.A.W ne irshaad farmaya : Do aadmiyon ke darmiyaan mein\n" +
                            "                    inki ijazat ke bhagair na baitha jaaye. ";
                    
                    break;
                case 245:
                    message="Hazrat Huzaifa R.A. se riwayat hai ke Rasoolallah S.A.W ne halqe ke\n" +
                            "                    beech mein baithne walon par lanat farmayi hai. ";
                    
                    break;
                case 246:
                    message="Hazrat Amr Bin Hazm R.A. ki riwayt mein hai ke bemaar ke paas se uth\n" +
                            "                    jaane ke baad bhi wo rehmat mein gothe lagatha rehta hai yahan tak ke jis jagah se\n" +
                            "                    ayadat se gaya tha wahan wapas laut aaye. ";
                    
                    break;
                case 247:
                    message="Hazrat Omer Bin Khatab R.A. riwayat karte hai ke Nabi Kareem S.A.W ne\n" +
                            "                    mujhse irshaad farmaaya : Jab tum bemaar ke paas jao to ise kaho ke wo tumhare\n" +
                            "                    liye dua kare kyunki iski dua farishton ki tarah (qubool hoti) hai. ";
                    
                    break;
                case 248:
                    message="Hazrat Abdullah R.A. se riwayat karte hain ke Nabi Kareem S.A.W ne\n" +
                            "                    irshaad farmaaya: Jo shaks kisi musibatzada ko tasalli deta hai to isko musibatzada\n" +
                            "                    ki tarah sawab milta hai. ";
                    
                    break;
                case 249:
                    message="Hazrat Mohammed Bin Amr Bin Amr Hazm R.A. riwayat karte hain ke\n" +
                            "                    Nabi Kareem S.A.W ne irshaad farmaaya : Jo momin apne kisi momin bhai ki\n" +
                            "                    Musibat mein ise sabr wa sukoon ki talqeen karega. Allah Ta’ala qayamath ke din\n" +
                            "                    Ise izzat ka libas pehnaenge. ";
                    
                    break;
                case 250:
                    message="Hazrat Anas R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya: Tum mein se koi shaks is waqt tak (kaamil) imaan waala nahi hosaktha\n" +
                            "                    jab tak ke wo apne musalmaan bhai ke liye wohi pasand na kare jo apne liye\n" +
                            "                    pasand karta ho. ";
                    
                    break;
                case 251:
                    message="Hazrat Ayesha R.A. farmaati hain ke Rasoolallah S.A.W ne apne zaati\n" +
                            "                    muamle mein kabhi kisi se inteqaam nahi liye lekin jab Allah Ta’ala ki haram\n" +
                            "                    karda cheez ka irtekaab kiya jaata to Aap S.A.W Allah Ta’ala ka hukm tootne ki\n" +
                            "                    wajah se saza dete the. ";
                    
                    break;
                case 252:
                    message="Hazrat Abdullah Bin Omer se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jo ghulam apne aaqa ke saath khair khwahi aur wafadari kare\n" +
                            "                    aur Allah Ta’ala ki ibadat bhoi achchi tarah kare wo dohre sawaab ka mustahiq\n" +
                            "                    hoga. ";
                    
                    break;
                case 253:
                    message="Hazrat Imran Bin Husain riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaya: Jis shaks ka kisi dusre shaks par koi haq (qarz wagaira) ho aur wo\n" +
                            "                    is maqruz ko adaa karne ke liye dair tak maholat dede to iske har din ke badle\n" +
                            "                    sadqa ka sawab milega. ";
                    
                    break;
                case 254:
                    message="Hazrat Ibn Abbas se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Barkat tumhare badhaon ke saath hai. ";
                    
                    break;
                case 255:
                    message="Hazrat Obada Bin Samit R.A se riwayat karte hai ke Rasoolallah S.A.W\n" +
                            "                    ne irshaad farmaaya : Jo shaks humare badhaon ki ta’zeem na kare, hamare\n" +
                            "                    bachchon par rahem na kare aur hamare aalim ka haq na pehchane wo meri\n" +
                            "                    ummat mein se nahi hai. ";
                    
                    break;
                case 256:
                    message="Hazrat Amr Bin Shoeb apne baap dada ke harwale se riwayat karte hain\n" +
                            "                    ke Nabi Karem S.A.W ne safaid baalon ko nochne se manaa farmaaya aur irshaad\n" +
                            "                    farmaaya: Keye budhapa musalman ka noor hai. ";
                    
                    break;
                case 257:
                    message="Hazrat Ayesha farmate hain ke Rasoolallah S.A.W hadiya qubool\n" +
                            "                    farmaate the aur iske jawab mein (khuwah issi waqt ya dusre waqt) khud bhi ataa\n" +
                            "                    farmaate the. ";
                    
                    break;
                case 258:
                    message="Hazrat Abu Huraira R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya: Bande ke dil mein kabhi bakhl aur Imaan jamaa nahi hosakthe. ";
                    
                    break;
                case 259:
                    message="Hazrat Abu Bakar Siddiq R.A. se riwayat hai ke Nabi Kareem S.A.W ne\n" +
                            "                    irshaad farmaaya : Bande ke dil mein kabhi bakhl aur Imaan jamaa nahi hosakthe.";
                    
                    break;
                case 260:
                    message="Hazrat Abu Huraira R.A. se riwayt hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Beshak Allah Ta’ala tumhari suraton aur tumhare maalon ko nahi\n" +
                            "                    dekhte balke tumhare dilon ko aur tumhare amaal ko dekhte hain.";
                    
                    break;
                case 261:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Qayamat ke din logon ko inki niyaton ke mutabiq uthaya jayega yani har\n" +
                            "                    ek ke saath iske niyat ke mutabiq muamla hoga. ";
                    
                    break;
                case 262:
                    message="Hazrat Abu Umama Bahli R.A. riwayat karte hai ke Nabi Kareem S.A.W\n" +
                            "                    ne irshaad farmaaya: Allah Ta’ala amaal mein se sirf isi amal ko qubool farmaate\n" +
                            "                    hain jo khalis inhi ke liye ho aur is mein sirf Allah Ta’ala hi ki khushnaudi maqsood\n" +
                            "                    ho. ";
                    
                    break;
                case 263:
                    message="Hazrat Saad R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Allah Ta’ala is ummat ki madad (iski qabiliyat aur salahiyat ki bunyad\n" +
                            "                        par nahi farmate balke ) kamzor aur khasta haal logon ki duaon,namazon aur\n" +
                            "                    unke ikhlas ki wajha farmate hain. ";
                    
                    break;
                case 264:
                    message="Hazrat Sauban R.A. riwayat karte hain ke maine Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate huye suna: Ikhlas waalon ke liye khushkhabri ho ke wo andheron\n" +
                            "                    mein chirag hain inki wajah se sakht sse sakht fitne door hojathe hain. ";
                    
                    break;
                case 265:
                    message="Qabila Asla, ke Hazrat Abu Faras farmaate hain k eek shaks ne pukaar\n" +
                            "                    kar poocha : Ya Rasoolallah imaan kya hai? Aap Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Imaan ikhlas hai. ";
                    
                    break;
                case 266:
                    message="Hazrat Abu Umama R.A. Rasoolallah S.A.W ka irshaad naql karte hain\n" +
                            " : Poshida taur par sadqa karna Allah Ta’ala ke gusse ko thanda karta hai. ";
                    
                    break;
                case 267:
                    message="Hazrat Saad R.A. farmaate hai ke maine Rasoolallah S.A.W ko ye irshaad\n" +
                            "                    farmaate huye suna: Allah Ta’ala parhezgaar,makhlooq se beniyaz,gumnaam\n" +
                            "                    bande ko pasand farmaate hain. ";
                    
                    break;
                case 268:
                    message="Hazrat Abu Sayeed Khudri R.A. farmaate hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Agar koi shaks aisi chataan ke andar baitkar jis mein na koi\n" +
                            "                    darwaaza ho na kooi surakh ho,koi bhi amal kare to wo logon par zahir hokar\n" +
                            "                    rahega chahe wo amal achcha ho ya bura. ";
                    
                    break;
                case 269:
                    message="Hazrat Abu Masood R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jo aadmi apne ghar walon par sawab ki niyat se kharch karta\n" +
                            "                    hai to ( is kharch se) isko sadqa ka sawab milta hai. ";
                    
                    break;
                case 270:
                    message="Hazrat Anas Bin Malik R.A. Rasoolallah ka irshaad naqal farmaate hain\n" +
                            "                    ke: Insaan ke bura hone ke liye itna kaafi hai ke deen ya duniya ke bare mein iski\n" +
                            "                    taraf ungliyon se ishaara kiya jaaye magar ye ke kisi ko Allah Ta’ala hi mehfooz\n" +
                            "                    rakhe ";
                    
                    break;
                case 271:
                    message="Hazrat Malik R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Wo do bhuke bhediye jinhe bakriyon ke reward mein cord diya jaaye\n" +
                            "                    bakriyon ka utna nuqsaan nahi pahunchate jitna aadmi ke deen ko, maal ki hirs\n" +
                            "                    aur badha banne ki chahat nuqsaan pahunchahti hai. ";
                    
                    break;
                case 272:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jisne wo ilm jo Allah Ta’ala ki raza ke liye sikhna chahiye tha duniya ka\n" +
                            "                    maal wa mataa hasil karne ke liye sikha wo Qayamat ke din jannat ki khushboo bhi\n" +
                            "                    na soongh sakega. ";
                    
                    break;
                case 273:
                    message="Hazrat Abdullah Bin Omer R.A. se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jis shaks ne ilm Allah Ta’ala ki raza ke alawa kisi aur maqsas\n" +
                            "                    ( masalan izzat, shauhrat, maal waghaira hasil karne ) keliye sikha to wo apna\n" +
                            "                    Thikana jahanum mein banaale. ";
                    
                    break;
                case 274:
                    message="Hazrat Shadad Bin Aos R.A. farmaaate hain ke maine Rasoolallah S.A.W\n" +
                            "                    ko irshaad farmaate huye suna : Jis ne dikhlane ke liye namaz padhi isne shirk\n" +
                            "                    kiya,jisme dikhlane keliye roza rakha isne shirk kiya aur jisne dikhlane keliye sadqa\n" +
                            "                    kiya isne shirk kiya. ";
                    
                    break;
                case 275:
                    message="Hazrat Anas R.A. se riwayat hai ke Rasoolallah S.A.W irshaad farmaaya :\n" +
                            "                Halak karne waali cheezein ye hain : who bukhal jiski et’at ki jaaye yani bukhal kiya\n" +
                            "                    Jaaye,wo khwahish-e-nafs jis par chala jay aur aadmi ka apne aap ko behtar\n" +
                            "                    Samajhna. ";
                    
                    break;
                case 276:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Badtareen shaks wo hai jo dusron ki duniya ke liye apni aakhirat ko\n" +
                            "                    barbaad karle. Yani duraon ko duniyawi faida pahunchane ke lilye Allah Ta’ala ko\n" +
                            "                    naraaz karne wala kaam karke apni aakhirat ko barbaad karle. ";
                    
                    break;
                case 277:
                    message="Hazrat Omer Bin Khattab R.A. se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Mujhe is ummat par sabse zyada darr is munafiq ka hai jo zuban\n" +
                            "                    ka aalim ho (ilm ki baatein karta ho lekin imaan aura mal se khali ho). ";
                    
                    break;
                case 278:
                    message="Hazrat Abdullah Bin Qais Khuzayi R.A. Rasoolallah S.A.W ka irshaad naql\n" +
                            "                    farmaate hain :Jo shaks kisi naik kaam mein dikhlawe aur shahuhrat ki niyat se lage\n" +
                            "                    to jab tak wo is niyat ko chod na dhe Allah Ta’ala ki sakht narazgi mein rehta hai. ";
                    
                    break;
                case 279:
                    message="Hazrat Abdullah Bin Omer farmaate hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jis shaks e duniya mein shahuhrat ka libaas pehna, Allah\n" +
                            "                    Ta’ala qayamat ke din isko zillat ka libaas pehna kar is mein aag bhadka denge. ";
                    
                    break;
                case 280:
                    message="Allah Ta’ala ka irshaad hai : Aur Allah Ta’ala ki razamandi hi keliye\n" +
                            "                    kharch kiya karo. ";
                    
                    break;
                case 281:
                    message="Allah Ta’ala ka irshaad hai : Aur jo sadqa mehez Allah Ta’ala ki razajoyi\n" +
                            "                    ke iraade se dete ho to jo log aisa karte hain wahi log apna maal aur sawaab\n" +
                            "                    badhane waale hain. ";
                    
                    break;
                case 282:
                    message="Allah Ta’ala ka irshaad hai : Aur khaas isi ki ibadat karo aur isi ko\n" +
                            "                    pukaro.";
                    
                    break;
                case 283:
                    message="Hazrat Abu Drda’a R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Jo shaks ( sone keliye ) apne bistar par aaye aur iski niyat ye ho le raat\n" +
                            "                    ko uthkar tahajaud padhoonga phir neend ka aisa galba hojaye ke subah hi aankh\n" +
                            "                    khule to iske liye tahajud ka sawaab likhdiya jata hai,aur iska sona iske Rabb ki taraf\n" +
                            "                    se iske liye aatiya hota hai. ";
                    
                    break;
                case 284:
                    message="Allah Ta’ala ka irshaad hai : Aur ye munafiq jab namaz keliye khade hote\n" +
                            "                    hain to bade sust banker khade hote hain, logon ko dikhate hain aur Allah Ta’ala ko\n" +
                            "                    bahut kam yaad karthe hain. ";
                    
                    break;
                case 285:
                    message="Allah Ta’ala ka irshaad hai : Aise namaziyon keliye badhi qarabi hai jo\n" +
                            "                    apni namaz se ghafil hain,jo aise hain ke (jab namaz padhte hain to) dikhlawa karte\n" +
                            "                    hain. ";
                    
                    break;
                case 286:
                    message="Hazrat Muaz Bin Jabal R.A. se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jo bandha duniya mein shauhrat aur dikhlane ke liye koi naik\n" +
                            "                    amal karega Allah Ta’ala khiyamat ke din is baath ko tamam maqlooq ke saamne\n" +
                            "                    shauhrat denge(ke is shaks ne naik amaal logon ko dikhlane ke liye kiye tha).";
                    
                    break;
                case 287:
                    message="Hazrat Abdullah Ibne Amr R.A. farmaate hai ke maine Rasoolallah S.A.W\n" +
                            "                    ko ye irshaad framaate huye suna : Jo shaks apne amal ko logon ke darmiyaan\n" +
                            "                    mashhur karega tho, Allah Ta’ala uske is riyawale amal ko apni maqlooq ke kaanon\n" +
                            "                    tak pahuncha denge aur usko logon ki nazron mein chota aur daleel kardenge. ";
                    
                    break;
                case 288:
                    message="Ek jagah irshaad hai : Jisne apna chehra Allah Ta’ala ke saamne jhuka\n" +
                            "                    diya,aur wo muqlees bhi ho tho,aise shaqs ko uska azar uske rabb ke paas milta\n" +
                            "                    hai. Aise logon par na koi khauf hoga,na wo ghamgeen honge. ";
                    
                    break;
                case 289:
                    message="Hazrat Saleh alaihissalam ne apne khaum se farmaaya : Mai tumhe is\n" +
                            "                    tableegh par koi bala nahi chahta. Mera badla tho Rabbul Aalameen hi ke zimme\n" +
                            "                    hai. ";
                    
                    break;
                case 290:
                    message="Ek jagah irshaad hai : Aur jo sadqa mehaz Allah Ta’ala ki raza ke irade se\n" +
                            "                    dethe ho yho, jo log aisa karte hai,wahi log apna maal wa sawaab badhane waale\n" +
                            "                    hai. ";
                    
                    break;
                case 291:
                    message="Allah Ta’ala ka irshaad hai : Aur khaas usi ki ( yaani Allah ki ) ibaadath\n" +
                            "                    karo aur usi ko ( yani Allah ko ) pukaro. ";
                    
                    break;
                case 292:
                    message="Ek jagah Irshaad hai ke Allah Ta’ala ke paas na tho un qurbaaniyon ka\n" +
                            "                    ghosht pahunchta hai, aur na hi unka khoon, balke unke paas tho tumhari\n" +
                            "                    parhezgari pahunchthi hai, yani unke yahan tho tumhare dili jazbaath dekhe jaathe\n" +
                            "                    hai. ";
                    
                    break;
                case 293:
                    message="Hazrat Muawiya R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Mai tho Allah Ta’ala ka paigham logon tak pahunchane waala hoon aur\n" +
                            "                    atta karne wale tho Allah Ta’ala hi hain. ";
                    
                    break;
                case 294:
                    message="Hazrat Urs Bin Ameera R.A. farmate hain ke Rasoolallah S.A.W ne irshad\n" +
                            "                    farmaaya : Allah Ta’ala baaz logon ki galtiyon par sab ko azaab nahi dethe albatta\n" +
                            "                    sab ko is surat mein azaab dethe hain jab ke farmabardaar bawajud khudrat ke\n" +
                            "                    nafarmani karnewalo ko na roke.";
                    
                    break;
                case 295:
                    message="Hazrat Zainab Binte Hajash R.A. farmaate hain ke maine Rasoolallah\n" +
                            "                    S.A.W se poocha : Ya Rasoolallah kya hum log aisi halat mein bhi halaak hojayenge\n" +
                            "                    Jab ke hum mein naik log bhi ho? Aap S.A.W ne irshaad farmaaya: Haan jab burai\n" +
                            "                    Aam hojaye.";
                    
                    break;
                case 296:
                    message="Hazrat Jaree R.A. farmaate hain k eek martaba maine Aap S.A.W se\n" +
                            "                    shikayat ki ke mai ghode ki sawari achchi tarah nahi karpata to Aap S.A.W ne mere\n" +
                            "                    sine par haath maar kar dua di: Ae Allah isse achcha gudh sawar banadijiye aur\n" +
                            "                    khud seedhe raste par chalet hue dusron ko bhi seedha rasta batane wala bana\n" +
                            "                    dijiye. ";
                    
                    break;
                case 297:
                    message="Hazrat Huzaifa R.A. farmaate hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Aadmi se biwi ,maal,aulad aur padosi ke mutaliq ehkamat ke pura karne\n" +
                            "                    ke silsil mein jo kotahiyan aur gunah hojate in ka kafara namaz,sadqa banjate hai.";
                    
                    break;
                case 298:
                    message="Hazrat Ibn Abbas se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Who shaks humari itba’a karne waalon mein se nahi hai jo humare\n" +
                            "                    chotaon par shafaqat na kare,humare badaon ka ehteram na kare, naiki ka hukm\n" +
                            "                    na kare aur burai se mana na kare. ";
                    
                    break;
                case 299:
                    message="Hazrat Anas farmaate hai ke Rasoolallah S.A.W ne kasrra,qaisar,najashi\n" +
                            "                    aur har bade hakim ko khat likhna (in khatoot mein) inhe Allah Ta’ala ki tarf bulaya.\n" +
                            "                    Ye najashi wo nahi hai(jo muslmaan hogaye the aur) Rasoolallah S.A.W ne in ki\n" +
                            "                    Namaz janaza padhayi thi. ";
                    
                    break;
                case 300:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Agar koi shaks ye kahe ke log tabah hogaye to wo shaks in mein sabse\n" +
                            "                    zyada tabah hone wala hai (kyunke ye kehne wala dusron ko haqeer samjhne ki\n" +
                            "                        wajah se tukkabur ke gunah mein mubtela hai). ";
                    
                    break;
                case 301:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Aadmi ke hunahgar hone ke liye kaafi hai ke wo har suni sunayi baat ko\n" +
                            "                    baghair tehqeeq ke bayan kare. ";
                    
                    break;
                case 302:
                    message="Hazrat Afs Bin Asim R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Aadmi ke jhoota hone ke liye yehi kaafi hai ke wo jo kuch sune\n" +
                            "                    ise(baghair tehqeeq) ke bayan karde. ";
                    
                    break;
                case 303:
                    message="Hazrat Abu Umama R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya: Momin mein paidaishi taur par saari khaslatein ho sakthi hain(khuwah\n" +
                            "                    achchi hoy a buri) albatta khayant aur jhoot ki (buri) aadat nahi ho sakthi. ";
                    
                    break;
                case 304:
                    message="Hazrat Sufiyan Bin Aseed Hazarmi R.A. farmate hain ke maine Rasool\n" +
                            "                    Allah S.A.W ko ye irshaad farmaate huye suna: ye bahut badi khayant hai ke tum\n" +
                            "                    Apne bhai se koi jhooti baat bayan karo halake wo yumhari is baat ko sachcha\n" +
                            "                    Samajhta ho. ";
                    
                    break;
                case 305:
                    message="Hazrat Abdullah Bin Omer se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jab banda jhoot boltha hai to farishta iske jhoot ki badbu ki\n" +
                            "                    wajah se ek meel door chala jaata hai. ";
                    
                    break;
                case 306:
                    message="Hazrat Muawiya Bin Hida R.A. farmaate hai ke maine Rasoolallah S.A.W\n" +
                            "                    ko ye irshaad farmaate huye suna : Is shaks ke liye barbaadi hai jo logon ko hasane\n" +
                            "                    ke liye jhoot bole. Is ke liye rabahi hai,is ke liye tabahi hai. ";
                    
                    break;
                case 307:
                    message="Hazrat Mu’az R.A ne arz kiya Ya Rasoolallah! Mujhe aisa amal bata dijiye\n" +
                            "                    jo mujhe jannat mein dakhil karde. Aap S.A.W ne irshaad farmaaya : Allah Ta’ala\n" +
                            "                    par imaan lao aur bhali baat kaho,tumhare liye ajar likha jayega aur buri baat na\n" +
                            "                    kaho tumhare liye gunah likha jayega. ";
                    
                    break;
                case 308:
                    message="Hazrat Amaar R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Duniya mein jis shaks ke do rukh ho( yani munafiq ki tarah muqhtalif\n" +
                            "                    logon se muqhtalif qism ki baatein kare) to qayamat ke din iske mooh mein aag\n" +
                            "                    ki do zubaanein hongi. ";
                    
                    break;
                case 309:
                    message="Hazrat Mughair Bin Shauba R.A. farmaate hain ke maine Rasoolallah\n" +
                            "                    S.A.W ko ye irshaad farmaate huye suna: Allah Ta’ala ne tumhare liye teen\n" +
                            "                    Cheezon ko napasand farmaya hai. Ek (befaida) idhar udhar ki baatein karna,dusre\n" +
                            "                    Ke maal ko zaaya karna,teesre zyada sawalat karna. ";
                    
                    break;
                case 310:
                    message="Hazrat Abdullah Bin Omer se riwayat hai ke Rasoolallah S.A.W ne irshad\n" +
                            "                    farmaaya : Allah Ta’ala ke zikr ke alawa zyada baatein na kiya karo,kyunke isse dil\n" +
                            "                    mein sakhti (aur behasi) paida hoti hai aur logon mein Allah Ta’ala se zyada door\n" +
                            "                    wo aadmi hai jiska dil sakht ho. ";
                    
                    break;
                case 311:
                    message="Rasoolallah S.A.W ki zauja mohtarma Hazrat Um Habeeba farmaati\n" +
                            "                    hain ke Rasoolallah S.A.W ne irshaad farmaaya : Naiki ka hukm karne ya burai se\n" +
                            "                    rokna ya Allah Ta’ala ka zikr karne ke alawa insaan ki tamaam baatein is par wabaal\n" +
                            "                    hain yani pakad ka zariya hain.";
                    
                    break;
                case 312:
                    message="Hazrat Abu Huraira R.A. riwayat krte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jo Allah Ta’ala par aur aakhirat ke din par Imaan rakhta ho usko\n" +
                            "                    chahiye ke khair ki baat kahe ya khamosh rahe. ";
                    
                    break;
                case 313:
                    message="Hazrat Amro Bin Aas farmaate hain ke maine Rasoolallah S.A.W ko\n" +
                            "                    irshaad farmaate huye suna: Mujhe mukhtasar baat karne ka hokum diya gaya hai\n" +
                            "                    kyunke mukhtasar baat karna hi behtar hai. ";
                    
                    break;
                case 314:
                    message= "Hazrat Abu Huraira R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya: Insaan koi baat keh detha hai aur iske kehne mein harj nahi\n" +
                            "                    samajhta lekin iski wajah se jahanum mein sattar saal ki musafat ke baraabar\n" +
                            "                        (neeche) girjata hai. ";
                    
                    break;
                case 315:
                    message="Hazrat Abu Huraiar R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Banda kabhi besonche samjhe koi aisi baat kehdeta hai jiski\n" +
                            "                    wajha se mashriq maghrib ke darmiyani faasle se bhi zyada door dozakh mein ja\n" +
                            "                    girta hai. ";
                    
                    break;
                case 316:
                    message="Hazrat Abu Sayeed Khudri R.A. riwayat karte hain ke Rasoolallah S.A.W\n" +
                            "                    ne irshaad farmaaya : Aadmi sirf logon ko hasane keliye koi aisi baat kehdeta hai jis\n" +
                            "                    mein koi harj nahi samajhta lekin iski wajha se jahanum mein zameen aasmaan ke\n" +
                            "                    darmiyaani faasle se bhi zyada gehrayi mein pahunch jaata hai. ";
                    
                    break;
                case 317:
                    message="Hazrat Abdullah R.A. farmaate hain ke maine Rasoolallah S.A.W ko ye\n" +
                            "                    irshaad farmaate huye suna : Insaan ki aksar galtiyan iski zuban se hoti hain. ";
                    
                    break;
                case 318:
                    message="Hazrat Abdullah Bin Omer se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jo chup raha wo najaat pagaya. ";
                    
                    break;
                case 319:
                    message="Hazrat Hasan farmate hain humein ye hades pahuchi hai ke Rasoolallah\n" +
                            "                    S.A.W ne irshaad farmaaya : Allah Ta’ala is bande par rahem farmaye jo achchi\n" +
                            "                    Baat kare aur duniya wa aakhirat mein iska faida uthaye ya khamosh rahe aur\n" +
                            "                    Zuban ki lagzishon se bachjaye.";
                    
                    break;
                case 320:
                    message="Hazrat Aadi Bin Hatim R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Aadmi ki naikhbakhti aur badbakhti iske dono jabdaon ke\n" +
                            "                    darmiyan hai yani zuban ka sahi istemaal naikhbakhti aur ghalat istemaal badbakht\n" +
                            "                    ka zariya hai. ";
                    
                    break;
                case 321:
                    message="Hazrat Abu Sayeed Khudri R.A. se riwayat hai k eek shaks Rasoolallah\n" +
                            "                    S.A.W ke paas aaye aur arz kiya : Ya Rasoolallah! Mujhe wasiyat farmadijiye. Aap\n" +
                            "                    S.A.W ne chand wasiyatein ke har qism ki baat se mehfooz rakho isse tum shaitan\n" +
                            "                    Par qaboo paaloge. ";
                    
                    break;
                case 322:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Jisko Allah Ta’ala ne in azaa ki buraiyon se bachaliye jo dono jabdaon\n" +
                            "                    aur tangon ke darmiyaan hai (yani zuban aur sharmgah) to wo jannat mein daakhil\n" +
                            "                    hoga. ";
                    
                    break;
                case 323:
                    message="Hazrat Uqba Bin Aamir R.A. farmate hain ke maine arz kiya : Ya Rasool\n" +
                            "                    Allah! Nijaat haasil karne ka kya tareeqa hai? Aap S.A.W ne irshaad farmaaya : Apni\n" +
                            "                    Zuban ko qaboo mein rakho,apne ghar mein raho (fuzool baher na phiro) aur apne\n" +
                            "                    Gunahon par roya karo. ";
                    
                    break;
                case 324:
                    message="Hazrat Anas Bin Malik R.A. se riwayat hai ke Rasoolallah S.A.W ne irshad\n" +
                            "                    farmaaya : Banda jab tak apni zuban ki hifazat na karle Imaan ki haqeeqat ko haasil\n" +
                            "                    nahi kar saktha. ";
                    
                    break;
                case 325:
                    message="Hazrat Abu Huzaifa R.A. se riwayat hai ke Rasoolallah S.A.W ne Sahaba\n" +
                            "                    se poocha : Allah Ta’ala ke nazdeek sabse pasandida amal kaunsa hai? Sab\n" +
                            "                    khamosh rahe kisi ne jawab na diya to Aap S.A.W ne irshaad farmaaya : Sabse\n" +
                            "                    pasandida amal zuban ki hifazat karna hai.";
                    
                    break;
                case 326:
                    message="Hazrat Haris Bin Hasham R.A. se riwayat hai ke inhone Rasoolallah\n" +
                            "                    S.A.W se arz kiya : Mujhe koi aisi cheez batadein jise mai mazbooti se pakda\n" +
                            "                    Rahoon. Aap S.A.W ne apni zuban mubark ki taraf ishaara karke farmaya : Isko\n" +
                            "                    Apne qaboo mein rakho. ";
                    
                    break;
                case 327:
                    message="Hazrat Sahel Bin Saad R.A. se riwayat hai ke Rasoolallah S.A.W ne irshad\n" +
                            "                    farmaya: Jo shaks mujhe apne dono jabdaon aur dono taangon ke darmiyaan wale\n" +
                            "                    azaa ki zimmedaari de de ( ke wo zuban aur saharmargh ko ghalat istemaal nahi\n" +
                            "                        karega) to mai iske liye jannat ki zimmedari leta hoon. ";
                    
                    break;
                case 328:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Aadmi ke islaam ki khoobi aur kamaal ye hai ke wo fuzool kaamon aur\n" +
                            "                    baton ko chorde. ";
                    
                    break;
                case 329:
                    message="Hazrat Jaber Bin Abdullah R.A. farmaate hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jab kisi insaan ki ghar se ghair haazri ka zamana zyada hojaye\n" +
                            "                    yani isko safar mein zyada din lag jaayein to wo (achanak) raat ko apne ghar na\n" +
                            "                    jaaye. ";
                    
                    break;
                case 330:
                    message="Hazrat Jaber R.A. farmaate hai Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Safar se waapas aane waale mard ke liye apne ghar walon ke paas pahunchne ka\n" +
                            "                    Behtareen waqt raat ka ibtedayi hissa hai(ye is surat mein hai ke ghar waalon ko\n" +
                            "                        Aane ke bare mein pehle se ilm ho ya qareeb safar ho). ";
                    
                    break;
                case 331:
                    message="Hazrat Jaber Bin Abdullah R.A. farmaate hain ke jab hum (safar se\n" +
                            "                        waapas) madina aagaye to Rasoolallah S.A.W ne (mujh se) irshaad farmaaya:\n" +
                            "                    Masjid jao aur do rakaat namaz padho. ";
                    
                    break;
                case 332:
                    message="Hazrat Kaab Bin Malik R.A. farmaate hain ke Rasoolallah S.A.W ka\n" +
                            "                    mamool tha ke din mein chasht ke waqt safar s tashreef laate aur aane ke baad\n" +
                            "                    pehle masjid jaate,do rakaat namaz adaa farmaate phir masjid mein baith the. ";
                    
                    break;
                case 333:
                    message="Hazrat Abdullah Bin Amr R.A. se riwayat hai ke Nabi Kareem S.A.W ne\n" +
                            "                    irshaad farmaaya : Jihad se laut kar aana bhi Jihad mein jaane ki tarah hai. ";
                    
                    break;
                case 334:
                    message="Hazrat Mataam Bin Muqdaam R.A. se riwayat hai ke Rasoolalah S.A.W\n" +
                            "                    ne irshaad farmaaya : Aadmi jab safar par jane lage tho sab se behtar naib jise wo\n" +
                            "                    apne ahl-o-aayal ke paas chord kar jaaye wo do rakatein hai jo ke paas padh kar\n" +
                            "                    jaayein. ";
                    
                    break;
                case 335:
                    message="Hazrat Jaber Bin Abdullah R.A. bayam karte hain ke Rasoolallah S.A.W\n" +
                            "                    ek gazwah par jan lage to irshaad farmaaya : Muhajireen wa ansaar ki jamaat!\n" +
                            "                        Tumhare bhaiyon mein se kuch log aise hain jink e paas na maal hai na inke\n" +
                            "                    Rishtedaar hain isliye tum mein se har ek in mein se do ya teen apne saath milale.";

                    break;
                case 336:
                    message="Hazrat Abu Huraira R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya: Jab tum safar karo to tumhare imam wo hona chahiye jis ko\n" +
                            "                    Qur’an zyada yaad ho( aur masayal ko zyada jaann wala ho) agarcha wo tum mein\n" +
                            "                    Sab se chota ho aur wo jab tumhara namaz mein imam bana to wo tumhara ameer\n" +
                            "                    Bhi hai. ";

                    break;
                case 337:
                    message="Hazrat Ali R.A. se riwayat hai ke Rasoolallah S.A.W ne irshaad farmaya :\n" +
                            "                    Allah Ta’ala ki nafarmani mein kisi ki eta’t na karo,eta’at to sirf naiki ke kaamon\n" +
                            "                    Mein hai. ";

                    break;
                case 338:
                    message="Hazrat Ibn Abbas R.A. riwayat karte hain k Rasoolallah S.A.W ne irshad\n" +
                            "                    farmaaya : Tum mein se jo shaks apne ameer ki aisi baat dekhe jo isse nagawar ho\n" +
                            "                    to isse iss chahiyeke is par sabr kare kyumke jo shaks muslamanon ki jamaat yani\n" +
                            "                    ijtemayat se baalish bhar bhi juda hua ( aur tauba kiye baghair ) isiis haalat mein\n" +
                            "                    mar gaya to wo jahaliyat ki maut mara. ";

                    break;
                case 339:
                    message="Hazrat Anas Bin Malik R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Ameer ki baat sunte aur maante raho agarcha tumpar habshi\n" +
                            "                    gulaam bhi ameer kyun na banaya gaya ho jis ka sar goya ( chote hone mein )\n" +
                            "                    kishmish ki tarah ho. ";

                    break;
                case 340:
                    message="Hazrat Umm Husain R.A. farmaate hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmmaaya : Agar tumpar kisi naak,kaan kate hue kaaale gulaam ko bhi ameer\n" +
                            "                    banya jaye jo tumhe Allah Ta’ala ki kitaab ke zariye yani Allah Ta’ala ke hukm ke\n" +
                            "                    mutabiq chalayr to yum iska hukm suno aur maano. ";

                    break;
                case 341:
                    message="Hazrat Jaber Bin Nafer, Hazrat Kaseer Bin Marah, Hazrat Amr Bin Aswad\n" +
                            "                    Hazrat Miqdam Bin Maad Yukarb aur Hazrat Abu Umama R.A. riwayat karte hain\n" +
                            "                    Ke Nabi Kareem S.A.W ne irshaad farmaaya: Ameer jab logon mein shak wa shuba\n" +
                            "                    Ki baat dhundta hai to logon ko kharab kar detha hau. ";

                    break;
                case 342:
                    message="Hazrat Abu Huraira R.A. se riwayat hai ke Nabi Kareem S.A.W ne irshaad\n" +
                            "                    farmaaya : Har ameer chahe dus aadmiyon ka hi kyun nah o qayamat ke din is\n" +
                            "                    tarah laya jayga ke iski gardan mein tauq hoga yahan tak ke is ko tauq se iska adal\n" +
                            "                    chuddwaega ya iska zulm isko halaak kardega. ";

                    break;
                case 343:
                    message="Hazrat Abu Huraira R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jo shaks dus ya dus se ziyaad afraad par ameer banaya jaye aur\n" +
                            "                    wo inke saath adal wa insaf ke muamlaat na kare to qayamat ke din baidiyon aur\n" +
                            "                    hathkaidyon mein (bandha hua) aayega.";

                    break;
                case 344:
                    message="Hazrat Maaqil Bin Yasaar R.A. se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Jo shaks kisi musalmaan raiyat ka zimedar bane phir inke saath\n" +
                            "                    dhoke ka muamla kare aur issi haalat par iski maut aajaye to Allah Ta’ala jannat ko\n" +
                            "                    is par haram kar denge. ";

                    break;
                case 345:
                    message="Hazrat Maaqil Bin Yasaar R.A farmaate hain ke maine Rasoolallah S.A.W\n" +
                            "                    ko ye farmaate huye suna: Jo ameer musalmaanon ke muamalaat ka zimedar ban\n" +
                            "                    kar musalamanon ki khair khuwahi mein koshish na kare wo musalamanon ke saat\n" +
                            "                    jannat mein dakhil nahi ho sakega. ";

                    break;
                case 346:
                    message="Hazrat Anas R.A. riwayat karte hain ke Rasoolallah S.A.W ne irshaad\n" +
                            "                    farmaaya : Bilashuba Allah Ta’ala har nigraan se iski zimedari mein di hui cheezon\n" +
                            "                    ke bare mein poochenge ke isne apni zimedari ki hifazat ki ya isse zaaya kiya (yani\n" +
                            "                        is zimedari ko poore taur par adaa kiya ya nahi). ";

                    break;
                case 347:
                    message="Hazrat Huzaifa R.A. farmaate hain ke maine Rasoollaha ko ye irshaad\n" +
                            "                    farmaate huye suna: Jo shaks musalamaanon ki jamaat se alag hua aur ameer ki\n" +
                            "                    amaratko haqeer jaana thi Allah Ta’ala isse is haal mein milenge ke Allah Ta’ala ke\n" +
                            "                    yahan iska koi rutbaa na hoga yani Allah Ta’ala ki nigah se gir jayega. ";

                    break;
                case 348:
                    message="Hazrat Abu Sayeed Khudri se riwayat hai ke Rasoolallah S.A.W ne irshad\n" +
                            "                    farmaaya:Jab teen shaks safar mein nikle to apne mein kisi ek ko ameer banalein.";

                    break;
                case 349:
                    message="Hazrat Abu Huraira R.A. riwayat karte hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Shaitaan ek aur do (musafiron) ke saath burayi ka irada karta\n" +
                            "                    hai yani nuqsaan pahunchana chahta hai lekin jab (musafir) teen ho to inke saath\n" +
                            "                    burayi ka irada nahi karta. ";

                    break;
                case 350:
                    message="Hazrat Amr Bin Shoeb apne walid se aur who apne dada se riwayat\n" +
                            "                    karte hain ke Rasoolallah S.A.W ne irshaad farmaaya : Ek sawar ek shaitaan hai,\n" +
                            "                    do sawar do shaitaan hain aur teen sawar jamaat hain.";

                    break;
                case 351:
                    message="Hazrat Anas farmaate hain ke Rasoolallah S.A.W ne irshaad farmaaya :\n" +
                            "                    Tum jab safar karo to raat bhi zaroor kuch safar karliya karo kyunke raat ke waqt\n" +
                            "                    Zameen lapit di jati hai. ";

                    break;
                case 352:
                    message="Hazrat Abdullah Bin Omer R.A se riwayat hai ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaaya : Agar logon ka tanha safar karne mein (deeni aur duniyawi)\n" +
                            "                    nuqsanat ka ilm hojaye jo mujhe maloom hain to koi sawar raat mein tanha safar\n" +
                            "                    karne ki himmat na kare.";

                    break;
                case 353:
                    message="Hazrat Nomaan Bin Basher R.A. farmaate hain ke Rasoolallah S.A.W ne\n" +
                            "                    irshaad farmaya : Jamaat (ke saath milkar chalna) rehmat hai aur jamaat se alag\n" +
                            "                    hona azaab hai. ";

                    break;
                case 354:
                    message="Hazrat Osman Bin Affan R.A. farmaate hain ke maine Rasoolallah S.A.W\n" +
                            "                    ko irshaad farmaate huye suna: Allah Ta’ala ke raasthe mein ek raat ka pehra dena\n" +
                            "                    in hazaar raton se behtar hai jin mein raat bhar khade hokar Allah Ta’ala ki ibadat\n" +
                            "                    ki jaye aur din mein roza rakha jaye. ";

                    break;



            }

            return message.replaceAll("\\s+"," ");
        }

    }

}
