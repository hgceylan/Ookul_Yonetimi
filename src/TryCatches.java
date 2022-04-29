import java.util.Scanner;

public class TryCatches {

    public static int integerGiris() {
        Scanner scan=new Scanner(System.in);
        int giris=0;
        boolean flag=false;


        do{
            System.out.println("lutfen giris yapiniz ");

            if(flag==true){
                scan.nextLine();
                flag=false;
            }

            try {
                giris=scan.nextInt();    // ctrl +alt +t   // harf girdi
                scan.nextLine(); // dummy                   // dummy calismadan catch gidiyor

            } catch (Exception e) {            // basa donuyor bosta kaliyor dummy bosta kaliyor
                System.out.println("hatali giris yaptiniz ");
                flag= true;
                integerGiris();
            }



        }while(flag);
        return giris;

    }
}
