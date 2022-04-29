import java.util.Scanner;

public class AnaMenu implements AnaMenuInterface {

    static Scanner scan = new Scanner(System.in);


    public static void giris() {
        AnaMenu object = new AnaMenu();  // static olmayan methodu kullnamak icin override lar static degil ondan


        System.out.println("Okul Yonetimi");
        System.out.println("lutfen seciminizi yapiniz ");
        System.out.println("1- ogrenci islemleri  2- ogretmen islemleri Q- cikis ");

        String scm = scan.next().toUpperCase();

        switch (scm) {
            case "1":
                object.ogrenciIslemleri();
                break;
            case "2":
                object.ogretmenIslemleri();
                break;

            case "Q":
                object.cikis();
                break;
            default:
                System.out.println("lutfen gecerli bir islem yapiniz ");
                giris();

        }

    }

    @Override
    public void ogrenciIslemleri() {
        Islemler.IslemlerMenusu(1);


    }

    @Override
    public void ogretmenIslemleri() {
        Islemler.IslemlerMenusu(2);

    }

    @Override
    public void cikis() {

    }
}
