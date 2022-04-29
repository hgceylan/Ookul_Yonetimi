import java.util.Scanner;

public class Islemler implements IslemlerInterface {

    static Scanner scan = new Scanner(System.in);
    static int secim = 0;  // static olmayan methodlari da cagirmak icin

    public static void IslemlerMenusu(int i) {
        secim = i;  //int ne olursa olsun hepsini kabul edecek
        Islemler obj = new Islemler();  // static olmayan methodlara ulasmak icin

        System.out.println("lutfen secim yapiniz ");
        System.out.println("1-ekleme 2- arama 3-listeleme 4-silme 5-Ana menu 6-cikis ");

        int scm =TryCatches.integerGiris();   // try cath

        switch (scm) {
            case 1:
                obj.ekleme();
                IslemlerMenusu(secim);
                break;
            case 2:
                obj.arama();
                IslemlerMenusu(secim);
                break;
            case 3:
                obj.listeleme();
                IslemlerMenusu(secim);
                break;
            case 4:
                obj.silme();
                IslemlerMenusu(secim);
                break;
            case 5:
                obj.anaMenu();
                break;
            case 6:
                obj.cikis();
                IslemlerMenusu(secim);
                break;
            default:
                System.out.println(" lutfen gecerli bir giris yapiniz ");
                IslemlerMenusu(secim);
        }
    }

    @Override
    public void ekleme() {
        System.out.println("kilmlik numarasi giriniz ");
        String kimlikID = scan.next();
        kimlikIDKontrol(kimlikID);
        if (secim == 1) {
            ogrenciBilgiAlKaydet(kimlikID);
        } else {
            ogretmenBilgiAlKaydet(kimlikID);
        }
    }

    private void ogretmenBilgiAlKaydet(String kimlikID) {
        System.out.println("lutfen ad soyad yas bolum sicil ");
        System.out.println(" lutfen ad soyad giriniz ");
        scan.nextLine();
        String adSoyad = scan.nextLine();
        System.out.println(" yas giriniz ");
        String yas = scan.next();
        System.out.println(" bolum giriniz");
        String bolum = scan.next();
        System.out.println(" sicil giriniz ");
        String sicil = scan.next();
        Ogretmen obj = new Ogretmen(adSoyad, yas, bolum, sicil);  // map icine atmak icin obj olusturduk
        Ogretmen.ogretmenListesiMap.put(kimlikID, obj);   // map icine kaydettik
    }

    private void ogrenciBilgiAlKaydet(String kimlikID) {
        System.out.println("lutfen ad soyad yas numara sinif ");
        System.out.println("ad soyad");
        scan.nextLine();
        String adSoyad = scan.nextLine();
        System.out.println("yas");
        String yas = scan.next();
        System.out.println("numara");
        String numara = scan.next();
        System.out.println("sinif");
        String sinif = scan.next();
        Ogrenci obj = new Ogrenci(adSoyad, yas, numara, sinif);  // map icine atmak iicin obj olusturmak gerekir
        Ogrenci.ogrenciListesiMap.put(kimlikID, obj);   // map icine kaydettik

    }

    private void kimlikIDKontrol(String kimlikID) {
        if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID) || Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
            System.out.println("bu ID kayit yapilmis");
            AnaMenu.giris();
        }
    }

    @Override
    public void arama() {
        System.out.println("kilmlik numarasi giriniz ");
        String kimlikID = scan.next();
        if (secim == 1) {
            if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID)) {
                System.out.println(Ogrenci.ogrenciListesiMap.get(kimlikID));
            } else
                System.out.println("kayitli degil");

        } else if (secim == 2) {
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
                System.out.println(Ogretmen.ogretmenListesiMap.get(kimlikID));
            } else {
                System.out.println("kayitli degil");
            }
        }

    }

    @Override
    public void listeleme() {
        if (secim == 1) {
            System.out.println(Ogrenci.ogrenciListesiMap);
        } else if (secim == 2) {
            System.out.println(Ogretmen.ogretmenListesiMap);
        }
    }

    @Override
    public void silme() {
        System.out.println("kilmlik numarasi giriniz ");
        String kimlikID = scan.next();

        if (secim == 1) {
            if (Ogrenci.ogrenciListesiMap.containsKey(kimlikID)) {
                Ogrenci.ogrenciListesiMap.remove(kimlikID);
            } else
                System.out.println(" kimlik ID mevcut degil");


        } else if (secim == 2) {
            if (Ogretmen.ogretmenListesiMap.containsKey(kimlikID)) {
                Ogretmen.ogretmenListesiMap.remove(kimlikID);
            } else
                System.out.println(" kimlik ID mevcut degil");

        }

    }

    @Override
    public void anaMenu() {
        AnaMenu.giris();

    }
    @Override
    public void cikis() {
        System.out.println("by by ");

    }
}