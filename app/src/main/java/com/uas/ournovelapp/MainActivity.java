package com.uas.ournovelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    FloatingActionButton btn_tambah;
    Adaptercerita adaptercerita;
    DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    ArrayList<Penghubung> listCerita;
    RecyclerView tv_tampil;
    private ArrayList<String> sampulNovel = new ArrayList<>();
    private ArrayList<String> judulNovel = new ArrayList<>();
    private ArrayList<String> infoNovel = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_tambah = findViewById(R.id.btn_tambah);
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SubmitCerita.class));
            }
        });
        tv_tampil = findViewById(R.id.tv_tampil);
        RecyclerView.LayoutManager mlayout = new LinearLayoutManager(this);
        tv_tampil.setLayoutManager(mlayout);
        tv_tampil.setItemAnimator(new DefaultItemAnimator());




        getDataFromInternet();
    }



    private void prosesRecyclerViewAdapter(){
        RecyclerView recyclerView = findViewById(R.id.tv_tampil);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(sampulNovel,judulNovel, infoNovel, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getDataFromInternet(){

            sampulNovel.add("https://i0.wp.com/tambahpinter.com/wp-content/uploads/2021/05/Lazuardi-Waktu-768x512.jpeg");
            judulNovel.add("Lazuardi Waktu");
            infoNovel.add("Tak ada yang mengetahui ujung jalan pertemanan. Begitu pun dua manusia\n" +
                    "yang kini sama-sama tak percaya bahwa belasan tahun bersahabat, berubah menjadi hubungan yang sebelumnya tak pernah terbangkan akan berjalan ke jenjang yang lebih jauh.\n" +
                    "\n" +
                    "“Aku tau mimpi kamu, kamu tau mimpi aku, cuma kita berdua yang bisa mewujudkannya, cuma kita yang percaya ini semua akan jadi nyata, Ris” ujar Saga kala matahari sudah pamit undur diri di horizon langit.\n" +
                    "Beberapa saat tak ada satupun kata yang keluar dari mulut manis Eris. Hanya desir angin dan debur ombak yang terdengar jelas seolah memainkan lagu paling merdu di dunia. Eris yang awalnya hanya ingin mengajak Saga, teman masa SMP nya ke pantai, tetapi berujung dengan pertanyaan cinta Saga yang tak pernah Eris bayangkan.\n" +
                    "“Kamu pasti kaget, Ris. Tapi, aku akan selalu mewujudkan keinginanmu. Begitupun ketika aku sekarang memberanikan diri mengatakan apa yang sebenarnya ingin aku katakan dan menawarkan kamu untuk memakai cincin ini” Saga mengeluarkan cincin berlian perak dengan mata cincin berwarna lazuardi, warna kesukaan Eris.\n" +
                    "\n" +
                    "Eris tetap tak bergeming dan hanya melihat cincin yang ada di hadapannya itu. Ternyata Saga mendengar dan mengingat apa yang selalu dikatakan Eris waktu dahulu kala saat mereka selesai masa kuliah. Eris selalu ingin dilamar di tepi pantai dan mendapatkan cincin berwarna lazuardi.\n" +
                    "Saga hanya menatap Eris dan sedangkan Eris berusaha memalingkan pandangan kembali ke arah rambut. Beberapa helai rambut Eris tertiup angin dan dengan sigap Saga menguncirkan rambut Eris agar terlihat lebih rapi. Sekali lagi, Eris hanya tertegun.\n" +
                    "“Tak apa Ris, aku tak butuh jawabannya sekarang. Tapi Kalau kamu..”\n" +
                    "“Saga..” Tiba-tiba Eris bersuara dan memotong pembicaraan “Belasan tahun kam selalu ada dan kamu selalu menawarkan diri, bukan aku yang meminta. Sangat aneh jika aku memandangmu hanya sebatas sahabat, karena segala sesuatu yang kamu berikan untukku sangatlah besar. Terima kasih, Saga, ternyata perasaanku tidak bertepuk sebelah tangan.”\n" +
                    "Mata mereka saling pandang dan mereka melihat masa depan mereka bersama. Senyum yang terpatri di antara keduanya sangat terlihat jelas. Ada rasa yang telah ditanam dengan sangat baik dan tinggal mereka sendirilah yang memetik bunganya.\n");

            sampulNovel.add("https://i0.wp.com/tambahpinter.com/wp-content/uploads/2021/05/Sang-Pembaca-Pertama-768x512.jpeg");
            judulNovel.add("Sang Pembaca Pertama");
            infoNovel.add("“Kamu tahu ga resiko dicintai penulis?”\n" +
                    "“Apa?”\n" +
                    "“Kamu bakal abadi dalam sebuah tulisan.”\n" +
                    "“seperti apa misalnya?”\n" +
                    "“misalnya kalau kamu mematahkan hati sang penulis, kamu akan abadi sebagai antagonis atau bisa jadi namamu akan tersemat pada tokoh yang nasibnya paling menderita”\n" +
                    "“kalau sebaliknya bagaimana?”tanyanya lagi penasaran\n" +
                    " “mungkin kamu akan menjadi pemeran utama pria, yang dimana semua tokoh Wanita didalam tulisan itu akan tergila gila padamu”\n" +
                    "Aku sangat ingat jawaban itu. Jawaban dari novelis perempuan yang karyanya sudah jutaan kali dibaca oleh orang-orang di mancanegara. Dan aku adalah salah satu pembaca setianya.\n" +
                    "Pertanyaan yang ia lontarkan itu ia tanyakan ketika ia masih meniti karier sebagai penulis. Seringkali aku menemaninya mengetik di tempat-tempat yang ingin ia kunjungi. Bukan hanya sebagai pengantar, tetapi juga pembaca pertama. Ia selalu memberikan kewenangan khusus itu kepadaku, yang saat dulu tak kusadari, bahwa hal tersebut sangatlah istimewa.\n" +
                    "Aku tidak menyadarinya. Sungguh sangat tidak menyadarinya. Bagaimana mungkin aku menjadi pria bodoh dan tidak tau diuntung terhadap perasaanku sendiri? Sampai akhirnya, ia sangat sulit untuk ditemui. Kurasa, waktunya hanya terfokus dengan menulis dan menulis. Yang kutahu, ada hal yang ganjil dalam hatiku dan aku butuh dia untuk menggenapkan.\n" +
                    "Untuk mengkhatamkan rasa yang bersarang di dada itu, segera aku pergi ke toko buku dan mencari buku terbarunya. Masih sama seperti minggu lalu, buku-bukunya masih menjadi 10 Buku Terpopuler di toko buku tersebut. Aku pun tersenyum puas, ia telah mendapatkan apa yang ia mau, apa yang ia inginkan.\n" +
                    "Aku pun mengambil buku yang bergambar langit perpaduan warna jingga dan biru. Buku-bukunya memang selalu mendeskripsikan tentang kehidupan dengan menggunakan simbol di bumi sebagai sampulnya. Tak lupa aku pun membaca sinopsisnya, dan melihat percakapan yang pernah kami bicarakan beberapa tahun lalu, sangat tercetak jelas di belakang buku.\n" +
                    "Tiba-tiba ada suara yang selalu ingin ku dengar,\n" +
                    "“Kamu pembaca dan aku penulis. Aku tahu, kita sama-sama membutuhkan. Jangan jalan sendiri-sendiri lagi ya, Axel?”\n" +
                    "“Azela!” Detik berikutnya, aku tersadar bahwa aku berada di peluknya dan ia sudah berada di pelukku. Aku merasa ini seperti kisah di cerpen romantis tapi ini benar-benar terjadi!\n");

            sampulNovel.add("https://i0.wp.com/tambahpinter.com/wp-content/uploads/2021/05/Pertanyaan-Satu-Kali.jpeg");
            judulNovel.add("Pertanyaan Satu Kali");
            infoNovel.add("Tuhan memberikan kisah cinta pertama yang mulus hanya kepada orang-orang beruntung. Salah satunya kepada sepasang suami istri yang setiap hari selalu menikmati hari-hari mereka dengan berbagi tangis dan tawa.\n" +
                    "Kisah yang dimulai ketika mereka menginjakan kaki di bangku putih biru. Saat itu perpaduan antara mentari pagi dan upacara yang melelahkan menjadi jembatan pertemuan mereka. Kala, gadis berambut lurus itu tengah menyeka cucuran keringat di keningnya. Sementara di barisan ketiga di kelas 7A ada sosok yang memerhatikan gadis itu diam-diam.\n" +
                    "Dialah Arka.\n" +
                    "Pemuda berusia 14 tahun itu mungkin sudah menyadari bahwa sosok wanita berambut lurus itu adalah cinta pertamanya. Bukan suatu hal yang kebetulan, Arka telah melihat Kala pertama kali saat upacara penyambutan siswa baru, yang pada saat itu Kala merupakan salah satu murid yang lulus di SMP dengan nilai UN tertinggi.\n" +
                    "Saat itulah Arka sudah kagum kepadanya. Kekaguman tersebut bermetamorfosis menjadi rasa suka yang ingin ia jaga. Dengan bantuan teman Kala yaitu Mirsya, Arka berhasil mengetahui segala seluk beluk tentang Kala. Sampai suatu hari, Arka dapat mengatakan segala hal yang ingin ia katakan kepada Kala.\n" +
                    "“Aku hanya ingin mengatakan ini sekali dan tak akan memaksa kamu untuk menyetujuinya, Kal. Aku ingin menghabiskan waktuku bersamamu, mau gak kamu terus bareng sama aku?”\n" +
                    "“Ya, aku mau” jawab Kala dengan tersipu.\n" +
                    "Begitulah mereka memulai masa-masa remaja yang sangat diimpi-impikan orang. Kisah percintaan di putih biru yang katanya sebagai cinta monyet pun mereka rasakan berdua. Pulang sekolah bersama, mengerjakan tugas bersama, dan lain sebagainya.\n" +
                    "Hanya saja sangat disayangkan. satu tahun hari jadi mereka menjadi hari perpisahan yang cukup menyakitkan. Hingga tahun-tahun berlalu, Kala sudah menemukan obat untuk lukanya yang sembuh. Sementara Arka masih berada di sisa-sisa mimpi yang sama.\n" +
                    "Dan kedewasaan menyambut mereka kembali. Semenjak reuni itu, mereka dipertemukan dengan kisah-kisah lama. Semua sudut sekolah seolah menjadi saksi bisu mereka berdua. Setelah dari mereka memiliki kesiapan yang sama, Arka bertanya sekali lagi kepada Kala di depan orang tuanya.\n" +
                    "“Kala aku hanya ingin mengatakan ini sekali. Dari dulu aku pun tak akan memaksa untuk kamu menyetujuinya. Aku ingin menghabiskan seluruh sisa waktuku bersamamu. Maukah kamu menjadi pendamping hidupku sepenuhnya?”\n" +
                    "Dengan tersipu, Kala mengangguk setuju.\n" +
                    "\n");

            sampulNovel.add("https://i0.wp.com/tambahpinter.com/wp-content/uploads/2021/05/Aku-kamu-dan-puisi.jpg");
            judulNovel.add("Aku, Kamu, dan Puisi");
            infoNovel.add("“Kerikil di setapak merintih tak pernah istirah.\n" +
                    "Membaurkan harum tubuhmu yang meranggas”\n" +
                    "Dua larik puisi itu kulihat tertulis dalam kertas coklat di mading jurusan. Setiap minggu, BEM prodi di jurusan kami selalu mengadakan program ‘Puisi Berantai’ yang mempersilahkan seluruh mahasiswa dapat menyumbangkan beberapa baris puisi sehingga bisa membuat puisi yang utuh secara bersamaan.\n" +
                    "Beberapa menit kupandangi dua baris puisi tersebut, kebetulan sunyi sangat terasa di lorong jurusan. Hanya menyisakan aku dengan dinding mading yang ada di hadapan. Sejenak aku berpikir, tidak ada salahnya untuk menuliskan beberapa kalimat.\n" +
                    "Kukeluarkan bolpoin yang tintanya hanya tinggal sisa. Satu persatu huruf yang tadinya hanya ada di kepala, kini sudah tertuang dalam kertas tersebut. Kukeluarkan diksi yang setidaknya nyambung dengan baris puisi sebelumnya.\n" +
                    "“Angin pun mengeluarkan suara angan\n" +
                    "dan meminta bahwa kau adalah impian”\n" +
                    "Esok harinya, saat aku terburu-buru masuk kelas di pagi hari, kulihat sudah ada dua baris puisi lagi di bawah pusiku. Ternyata balasan untuk puisiku dibalas tak lebih dari 24 jam. Aku cukup berdecak kagum dan tertegun, siapa orang yang menulis puisi se pagi ini di lorong jurusan? Melihat tulisan itu, segera kubalas puisi itu kembali.\n" +
                    "“Laras! Ayo masuk kelas!” aku tersadarkan oleh suara nyaring yang berasal dari belakang. Ternyata Rana, temanku dari zaman mahasiswa baru yang sampai saat ini masih doyan masuk kelas terlambat.\n" +
                    "Segera aku menyusulnya yang telah menaiki beberapa anak tangga. Tanpa memperhatikan sekitar, kakiku tersandung dan menabrak seseorang yang hendak turun. Tanpa babibu lagi, aku langsung minta maaf dan menancapkan gas untuk pergi saat itu juga. Bukan hanya karena terlambat masuk kelas, tetapi aku tak berani menatap dan berurusan dengan orang yang telah kutabrak.\n" +
                    "Nyawaku masih bisa diselamatkan karena dosen masih boleh mempersilahkan aku memasuki kelasnya. Tentu saja tidak gratis, setelah kelas pastinya aku akan mendapatkan beberapa tugas tambahan. Tetapi, hal itu tentu saja masih untung dibandingkan dengan absen kehadiranku yang berkurang.\n" +
                    "Alhasil, setelah pembelajaran selesai. aku harus menyelesaikan tugasnya. Saat semua orang sudah keluar kelas, tinggalah aku seorang diri. Tiba-tiba datang seorang lelaki yang mengetuk pintu kelas.\n" +
                    "“Sorry kelasnya masih dipakai ya?”\n" +
                    "“Oh nggak kok. Cuma numpang ngerjain tugas aja. Mau ada kelas juga ya, Kak?” akupun memasukan buku dan segera meninggalkan kelas. Entah siapa lelaki itu, tapi kuyakin dia adalah kakak tingkat.\n" +
                    "“Nanti sih habis istirahat. Jam 1” jawabnya singkat\n" +
                    "“Okey kak, silakan”\n" +
                    "Ia hanya tersenyum tipis dan menaruh tas nya di bangku. Untungnya, tugas tersebut sudah selesai kukerjakan dan bisa aku langsung kumpulkan di ruang dosen. Saat aku menuruni tangga, sekitar 4-5 orang berkerumun di mading. Setelah lihat dari dekat, ternyata mereka memfoto dan terkagum-kagum dengan puisi berantai minggu ini.\n" +
                    "“Ini so sweet banget, Ras! Pasti salah satu penulis puisi ini Kak Deo.”\n" +
                    "“Siapa tuh Kak Deo?”\n" +
                    "Aku yang antisosial memang tak tahu menahu tentang orang populer di jurusan. Rana dengan semangat menjelaskan sosok orang bernama Deo yang merupakan pemenang lomba cipta puisi tingkat nasional. Setelah selesai menjelaskan itu semua, kami pun pergi meninggalkan gedung dan akan kembali saat matkul terakhir di jam sore.\n" +
                    "Tak mau terlambat kembali. aku menjadi yang pertama untuk memasuki kelas. Namun, sebelum itu, ku sisihkan waktuku untuk melihat puisi berantai itu. Puisi yang sudah dua bait itu berhasil membuatku untuk menuliskan beberapa patah kata kembali. dan tanpa kusadari, ada sosok lelaki yang entah sejak kapan memperhatikanku menulis.\n" +
                    "“Jadi selama ini kamu yang membalas puisiku. Perkenalkan, aku Deo.”\n" +
                    "Senyuman itu memberikanku nyawa untuk bisa memperlihatkan senyuman manis yang kupunya.\n" +
                    "\n");

            sampulNovel.add("https://img.wattpad.com/cover/101951983-352-k386678.jpg");
            judulNovel.add("Di Balik Perjodohan");
            infoNovel.add("“Pernikahan apa yang kamu inginkan?”\n" +
                    "“Pernikahan megah dengan kereta kencana atau pernikahan lari serupa Laila dan Majnun?”\n" +
                    "Pertanyaan itu sering diajukan oleh kedua orang tuaku. Sampai saat ini aku tak tahu jawabannya dan bagaimana memahami maksud pertanyaannya. Hingga suatu hari, aku dinikahkan dengan seorang lelaki yang rupa dan wajahnya tak sama sekali aku kenali. Bahkan sebelum akad dilangsungkan pun, wajah lelaki tersebut masih disembunyikan. Aku hanya diberitahu nama dan silsilah keluarganya. Hanya sebatas itu.\n" +
                    "Tak ada pilihan bagi aku. Tak ada pilihan bagi perempuan. Semua pertanyaan-pertanyaan yang berupa pilihan tersebut hanyalah basa-basi belaka. Nyatanya, hidup kami pun selalu ditentukan dan dikendalikan.\n" +
                    "Sehari setelah pernikahan, pikiranku tentang suami buruk rupa dan ringan tangan selalu menghantui. Namun, sosok lelaki itu pun ternyata lebih pendiam daripada yang aku bayangkan. Ia tak segan membantuku membereskan baju, walaupun tidak ada percakapan dan hanya canggung yang menyelimuti kami.\n" +
                    "“Winta, kalau kamu tidak mau saya tidur di kasur, saya bisa tidur di sofa” suara itu sangat meneduhkan. Ada beberapa detik aku terpana dengan sikap sopan yang ia berikan.\n" +
                    "“Tidak apa-apa, biasa saja” jawabku dengan dingin.\n" +
                    "Hari-hari setelahnya, aku terbuai dengan segala kelemahlembutannya. Bagaimana ia bersama mengurusi kebutuhan rumah tangga, sikap tak pernah marah, kesabaran yang luar biasa. Itu semua lebih dari cukup menjadi suami idaman. Seringkali ia pun memberikan hadia bunga lili jingga kesukaanku. Entah darimana ia tahu apa yang kusuka, tetapi ia selalu berusaha membuatku berbunga-bunga.\n" +
                    "Tak kulihat lagi rupawan wajah sebagai kriteria suami idaman. Karena sesungguhnya keromantisan rumah tangga akan tetap terasa, bila sepasang kekasih saling mengisi dan berbagi. Jika aku jago merangkai kata dan menjadi penulis, mungkin kisahku ini bisa menjadi cerpen romantis pernikahan karena perjodohan.\n" +
                    "\n");

            sampulNovel.add("https://img.wattpad.com/cover/266155240-352-k633351.jpg");
            judulNovel.add("Pilot Pilihan Ayah");
            infoNovel.add("Memberikan bunga dan coklat saat valentine mungkin sudah biasa, tetapi lelaki itu memberikan seluruh yang ia punya hanya untukku, mungkin itulah setulusnya cinta.\n" +
                    "Hal itu mengingatkanku pada mendiang Ayah pernah bertanya,\n" +
                    "“Andin, jika ada dua lelaki yang melamar kamu, lelaki pertama memberikan setengah hartanya untuk mahar dan lelaki kedua memberikan seluruh harta yang ia punya untuk mahar. Maka kamu akan pilih yang mana?”\n" +
                    "Aku sempat terdiam lalu perlahan menjawab “Aku akan pilih lelaki yang memberikan setengah hartanya untuk mahar. Karena itu adalah pilihan realistis, Yah. Setengah harta lainnya bisa ia pergunakan untuk kebutuhan di masa depan”\n" +
                    "“Jawaban yang bagus” Kulihat Ayah melengkungkan senyum tipis kala itu menandakan ia puas dengan jawabanku.\n" +
                    "Sampai suatu ketika aku dihadapkan dengan lelaki yang selalu ingin memberikan segala yang ia punya untukku. Namanya Dima. Kenalanku semasa kuliah yang ternyata telah memperhatikanku dari jauh selama bertahun-tahun. Hanya sesekali kami pernah mengobrol biasa sebagai seorang teman, namun kini, ia berbincang panjang lebar denganku—dan juga keluargaku.\n" +
                    "Niat baik itu yang ia sampaikan tentu saja membuatku terheran. Bukan mahar ratusan juta yang ia tawarkan, bukan juga rumah dan aset lainnya. Hanya uang berjumlah Rp1.112.021 yang menandakan hari pertama kami berjumpa kembali yaitu tanggal 1 bulan 11 tahun 2021. Tak lupa dengan perjanjian yang kami buat sendiri saat ia akan mengabulkan dan menemani segala aktivitasku sehari-hari.\n" +
                    "Pernikahan yang tergolong masih muda ini tatkala sering juga melatih kesabaran. Namun, pekerjaannya yang rentan sibuk membuatnya betah di rumah menemaniku. Pergi belanja, menemani anak, membantu urusan rumah tangga, tak lupa dengan kejutan-kejutan kecil yang seolah memberikanku kekuatan untuk selalu mempertahankan hubungan. Hingga aku menyadari bahwa ia pun telah memberikan seluruh yang ia punya. Raga dan waktunya.\n" +
                    "\n");

            sampulNovel.add("https://img.wattpad.com/ccover/336484562-300-587302.png?v=2");
            judulNovel.add("Obituarium Hujan");
            infoNovel.add("Hujan selalu menawarkan perasaan yang entah mengapa selalu sulit untuk dijelaskan. Perasaan kesal karena tidak punya payung, perjalanan yang harus terhenti, atau jalanan yang becek mungkin membuat kejengkelan semakin berlipat ganda. Tetapi kala itu, kejengkelan dan kebahagian selalu membias menawarkan kebahagiaan yang Tama rasakan.\n" +
                    "Apabila tidak terjadi hujan di bulan Maret itu, mungkin Tama tidak akan sebahagia sekarang. Ia tidak memperkirakan bahwa walaupun sudah memasuki bulan Maret, terkadang hujan masih selalu hadir sebagai musim pancaroba. Kala itu ia terpaksa harus masuk terlambat karena hujan. Sampai suatu ketika, ada sosok perempuan berjilbab menyapanya.\n" +
                    "“Kak Tama!”\n" +
                    "“Oh iya, Qias”\n" +
                    "“Kakak mau ke kampus, mau bareng ga, Kak?”\n" +
                    "Tawaran Qias sempat membuat Tama terpana, akhirnya ada orang yang mau menolongnya. Tama pun segera mengiyakan tawaran tersebut. Qias merupakan adik tingkat Tama hanya berbeda fakultas. Qias yang anak seni dan bahasa mungkin cukup santai apabila berpayung berdua dengan lelaki, tetapi Tama merasakan sedikit canggung. Ia berusaha semaksimal mungkin menghilangkan kecanggungannya.\n" +
                    "Tak disangka keceriaan Qias dan keramahtamahannya saat berbicara seolah menyihir pandangan Tama. Ia menjadi tahu bagaimana seluk beluk tentang Qias, cita-citanya, dan obrolan-obrolan ringan lainnya sambil berpayung di kala hujan. Bola mata Qias yang kecoklatan seolah berbias menjadi warna emas ketika ia mengisahkan cerita hidupnya. Sebelumnya, ia hanya memandang Qias sebagai adik tingkat yang mungkin tidak pernah membuat hatinya berdebar.\n" +
                    "Tak terasa hujan sudah mulai reda dan mereka sudah sampai di gerbang kampus Qias. Mereka pun berpisah menuju fakultas masing-masing, namun semesta tak pernah membuat mereka berpisah sejak saat itu. Qias tetap menjadi pencerita dan Tama menjadi pendengar setia.\n" +
                    "\n");

            sampulNovel.add("https://img.wattpad.com/cover/233463280-256-k608656.jpg");
            judulNovel.add("Cin dan Ta");
            infoNovel.add("Lelaki itu mungkin sudah lupa bagaimana rasanya di atas awan dan terbang tinggi menggapai bintang. Sudah bertahun-tahun ia melindungi dirinya sendiri dalam selimut ketakutan akan cinta. Namun, semua itu berubah ketika ia menemukan gadis pecinta George Benson yang ia temui di pasar kaset satu bulan lalu.\n" +
                    "Namanya Cin. Cin berhasil membuat lelaki itu kembali memiliki sayap. Seperti adegan dalam film dan cerpen romantis, mata Cin dan mata lelaki itu beradu pandang saat bersama-sama hendak mengambil satu-satunya kaset album George Benson di rak toko. Ada beberapa detik yang membuat mereka saling terpana.\n" +
                    "Satu detik, tiga detik, lima detik, dan di hitungan ke sepuluh, lelaki itu pun melepaskan tangannya dari kaset.\n" +
                    "“Silakan, Mba”\n" +
                    "“Terima kasih, Mas”\n" +
                    "Sejak mendengar suara itu lah, lelaki yang biasa dipanggil Ta mengetahui bahwa hatinya telah berbunga-bunga kembali. Perkenalan mereka pun terjadi begitu saja seperti kebanyakan orang. Berbincang seadanya dan saling melemparkan senyum. Sampai satu minggu setelah pertemuan pertama, mereka pun bertemu kembali di tempat yang sama.\n" +
                    "Bagai gayung bersambut, keinginan Ta terpenuhi. Ta tak ingin menyia-nyiakan kesempatan kembali. Dengan sedikit sikap malu-malu tapi mau, ia berhasil mengajak berbincang Cin. Bukan hanya itu saja, Ta pun mendapatkan nomor teleponnya.\n" +
                    "Percakapan mereka di ujung telepon pun tak pernah ada habisnya. Dengan membahas album-album dari George Benson dan saling memberikan makna setiap liriknya, mereka pun terus membiarkan diri mereka saling terjatuh satu sama lain.\n" +
                    "Tak jarang, mereka pun saling salah paham. Mengingat rumah mereka yang terpisahkan jarak puluhan kilometer. Rumah Ta berada di sebelah Barat kota, sedangkan rumah Cin justru berada di Timur kota. Seringkali pula Ta tak keberatan menyelesaikan masalah mereka dengan menemui Cin, walaupun rumah mereka saling berjauhan.\n" +
                    "Begitulah Ta, berhasil menemukan separuh hatinya yang pernah kosong. Hingga hari ini, ia berhasil mendapatkan Cin seutuhnya dan melangsungkan janji suci dengan suasana pernikahan ala tahun 1980-an. Tak lupa dengan penampilan spesial Ta untuk Cin yang menyanyikan lagu Nothing’s Gonna Change My Love for You dari George Benson.\n" +
                    "“Hold me now, touch me now\n" +
                    "I don’t want to live without you..”\n" +
                    "\n");

            sampulNovel.add("https://img.wattpad.com/userbg/tmrmjingga.78940.jpg");
            judulNovel.add("Sebuah Senyuman");
            infoNovel.add("Cerpen romantis ini akan mengisahkan cinta di masa depan.\n" +
                    "Kisah cinta romantis mungkin sudah usang saat ini. Di zaman yang segalanya sudah berubah, kata cinta sudah tidak ada lagi untuk diungkapkan. Di 3035, orang-orang berlomba mengungkapkan cinta dengan kemahiran teknologi. Ada yang menunjukan dengan membelikan mobil yang bisa terbang (Mobang), ada pula yang membuat robot untuk membantu Si Kekasih dalam menjalankan kegiatan sehari-hari.\n" +
                    "Berbeda dengan sosok pemuda bernama Opaja.\n" +
                    "Opaja termasuk seseorang yang beruntung, karena pemuda berusia 27 tahun itu sudah mendapatkan warisan besar dan segala hal yang ia mau. Tetapi, tidak dengan hati seorang gadis yang telah ia incar sejak remaja.\n" +
                    "Beragam upaya telah ia kerahkan untuk membuat hati gadis itu luluh. memberikan robot, teknologi AI, Mobang, dan masih banyak lagi. tetapi semua itu berujung kembali ke gudang rumah Opaja. Sampai suatu ketika ia menemukan ide yang tidak dari biasanya.Segera ia mengenakan Mobang dan menemui gadis itu di rumahnya.\n" +
                    "“Selamat siang Nona. Mulai saat ini saya akan berhenti memberikan berbagai macam perhatian dengan hadiah. Jadi terimalah hadiah sederhana dari saya.”\n" +
                    "“Apa maksudmu Opaja?”\n" +
                    "Nona yang kebingungan itu mendadak tertegun, lalu setelahnya mengerti maksud Opaja. Opaja tersenyum. sangat tulus. bahkan matanya memancarkan cahaya yang tidak bisa ia deskripsikan dengan kata-kata. Selama ini, ia tidak menyadari bahwa senyuman Opaja lebih merekah dibanding biasanya. Senyuman itulah yang membuat pipinya pun kemerahan.\n" +
                    "Berbulan-bulan, Opaja tidak pernah lagi memberikan perhatian dalam bentuk barang ataupun teknologi termutakhir, walaupun ia sangat mampu untuk membelikannya. Ternyata, Nona hanya membutuhkan sebuah senyuman tulus darinya.\n" +
                    "Di saat orang-orang memiliki kisah romantis dalam bentuk barang, Opaja dan Nona membuktikan bahwa cinta dan perasaan yang tulus mengalahkan segala kebimbangan hati. Hingga mereka membuktikan bahwa pernikahan pun bisa dilangsungkan dengan sangat sederhana, bersama keluarga terdekat, dan diiringi dengan senyuman tulus dari masing-masing keluarga.\n" +
                    "\n");






        prosesRecyclerViewAdapter();


    }
}