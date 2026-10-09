import java.util.Scanner;
public class Main {

    public static void KoltukGoster(boolean[] koltuklar){

        for (int i=0; i< koltuklar.length; i ++){
            int num= i+1;
            if (!koltuklar[i]) {
                System.out.print("[" + num + " BOŞ]");
            }else{
                System.out.print("[" + num + " DOLU]");
            }
            if (num %5==0){
                System.out.println();
            }}}
    public static int BiletFiyatiHesapla(int bilet_turu) {
        if (bilet_turu == 1) {
            return 250;
        } else if (bilet_turu == 2) {
            return 150;
        }else {
            return 0;
        }}
    public static double DolulukYuzdeHesapla(int kapasite, int dolan){
        double doluluk_orani = ((double) dolan / kapasite) * 100;
        return doluluk_orani;
    }
    public static void FilmBilgileriniGoster(String film_adi, String salon_adi, int film_sure, int top_koltuk, int bos_yer){
        System.out.println("========== FİLM ==========\n");

        System.out.println("Film: " + film_adi);
        System.out.println("Salon: " + salon_adi);
        System.out.println("Süre: " + film_sure );
        System.out.println ("Toplam Yer:  " + top_koltuk );
        System.out.println("Boş Yer:" + bos_yer);
        System.out.println();
        for (int i=1;i<=26;i++) {
            System.out.print("=");

        }}
    public static void main(String[] args) {
        String film_adi= "Barbie";
        String salon_adi= "Atlas";
        int film_sure= 149;

        int tam_bilet = 250;
        int ögrenci_bilet = 150;
        int top_koltuk = 20;
        double top_gelir = 0;
        int satılmıs_bilet = 0;

        boolean[] koltuklar= new boolean[20];
        String[] musteriler = new String[20];
        double[] fiyatlar = new double[20];

        Scanner input = new Scanner(System.in);
        String secim;
        boolean devam = true;
        do {

            System.out.println("========== CINEJAVA ==========");
            System.out.println("1 - Koltukları Görüntüle");
            System.out.println("2 - Bilet Sat");
            System.out.println("3 - Bilet İptal Et");
            System.out.println("4 - Müşteri Ara");
            System.out.println("5 - Satış Raporu");
            System.out.println("6 - Film Bilgilerini Göster");
            System.out.println("0 - Çıkış");
            System.out.println("==============================");
            System.out.print("Seçiminiz: ");
            secim = input.nextLine();

            switch(secim){
                case "1":
                    KoltukGoster(koltuklar);
                    break;
                case "2":
                    System.out.println("Koltuk seçiniz.");

                    int koltuk_secim = input.nextInt();
                    input.nextLine();

                    if ((koltuk_secim>=1)&&(koltuk_secim<=20)){
                        if(koltuklar[koltuk_secim-1]){
                            System.out.println("Bu koltuk daha önce satılmıştır.");
                        }else{
                            String ad_soyad = "";
                            while (ad_soyad.length() == 0) {
                                System.out.print("Ad Soyad: ");
                                ad_soyad = input.nextLine().trim().toUpperCase();
                                if (ad_soyad.length() == 0) {
                                    System.out.println("Müşteri adı boş bırakılamaz.");
                                }}

                            int bilet_turu_num = 0;
                            while (bilet_turu_num != 1 && bilet_turu_num != 2) {
                                System.out.println("1- Tam");
                                System.out.println("2- Öğrenci");
                                System.out.print("Bilet türü: ");
                                bilet_turu_num = input.nextInt();
                                input.nextLine();
                                if (bilet_turu_num != 1 && bilet_turu_num != 2) {
                                    System.out.println("Geçersiz bilet türü.");
                                }}

                            String bilet_turu;
                            if (bilet_turu_num == 1) {
                                bilet_turu = "Tam";
                            } else {
                                bilet_turu = "Öğrenci";
                            }

                            int fiyat=BiletFiyatiHesapla(bilet_turu_num);

                            koltuklar[koltuk_secim -1] = true;
                            satılmıs_bilet ++;
                            top_gelir = top_gelir + fiyat;
                            musteriler[koltuk_secim-1]=ad_soyad;
                            fiyatlar[koltuk_secim -1]=fiyat;

                            System.out.println("===== BİLET =====");
                            System.out.println("Film: "+ film_adi);
                            System.out.println("Müşteri: "+ ad_soyad);
                            System.out.println("Koltuk:" + koltuk_secim);
                            System.out.println("Bilet Türü: "+ bilet_turu);
                            System.out.println("Fiyat: "+ fiyat);
                            System.out.println("=================");

                        }

                    }else{
                        System.out.println("Geçersiz koltuk numarası");
                    }
                    break;
                case "3":
                    System.out.println("Koltuk seçiniz.");

                    int koltuk_secim_iptal = input.nextInt();
                    input.nextLine();
                    if (!koltuklar[koltuk_secim_iptal -1]) {
                        System.out.println("Bu koltuk için aktif bilet bulunamadı.");
                    }else{
                        System.out.println("Müşteri: " + musteriler[koltuk_secim_iptal-1]);
                        System.out.println("Koltuk: " + koltuk_secim_iptal);
                        System.out. println("Ücret: " + fiyatlar[koltuk_secim_iptal -1] + "TL");

                        System.out.println("Bilet iptal edilsin mi?");
                        System.out.println("E/H:");

                        String iptal_cevap = input.next();
                        input.nextLine();
                        if (iptal_cevap.equalsIgnoreCase("E")){
                        koltuklar[koltuk_secim_iptal-1]=false;
                        musteriler[koltuk_secim_iptal-1]="";
                        top_gelir=top_gelir -fiyatlar[koltuk_secim_iptal-1];
                        fiyatlar[koltuk_secim_iptal-1]=0;
                        satılmıs_bilet--;

                        }}
                    break;
                case "4":
                    System.out.print("Arama: ");

                    String arama = input.nextLine().trim().toUpperCase();

                    System.out.println("Sonuçlar:");

                    for (int i = 0; i < musteriler.length; i++) {
                        if (musteriler[i] != null && musteriler[i].contains(arama)) {
                            System.out.println("Koltuk" + i+1);
                            System.out.println(musteriler[i]);
                            System.out.println(fiyatlar[i] + " TL");
                        }}
                    break;
                case "5":
                    System.out.println("========== SATIŞ RAPORU ==========\n");
                    System.out.println("Toplam Koltuk: " + top_koltuk);
                    System.out.println("Satılan Bilet: " + satılmıs_bilet);
                    System.out.println("Boş Koltuk: " + (top_koltuk-satılmıs_bilet) +"\n" );
                    System.out.println("Toplam Gelir:" + top_gelir + "TL" + "\n");
                    int ögr_count=0;
                    for (int i=0;i< fiyatlar.length;i++){
                        if (fiyatlar[i]==ögrenci_bilet){
                            ögr_count++;
                        }}
                    System.out.println("Tam Bilet: "+ (satılmıs_bilet-ögr_count));
                    System.out.println("Öğrenci Bilet: " + ögr_count + "\n");
                    System.out.println("Doluluk Oranı: " + "% " + DolulukYuzdeHesapla(top_koltuk,satılmıs_bilet) );
                    System.out.println("==================================");

                    double max=fiyatlar[0];
                    for (double fiyat:fiyatlar){
                        if (fiyat>max){
                            max=fiyat;
                        }}
                    double min=fiyatlar[0];
                    for (double fiyat:fiyatlar){
                        if (fiyat<min){
                            min=fiyat;
                        }}
                    System.out.println("En yüksek satış : " + max + "TL");
                    System.out.println("En düşük satış : "+ min + "TL");
                    break;

                case "6":
                    FilmBilgileriniGoster(film_adi, salon_adi, film_sure, top_koltuk, top_koltuk - satılmıs_bilet);

                break;

                case "0":
                    devam = false;
                    break;
            }


    }while (devam);
        input.close();
    }
}



