import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Entrance {
    public static final String ANSI_YEŞİL = "\u001B[32m";
    public static final String ANSI_MOR = "\u001B[35m";
    public void entrance() throws SQLException, IOException {

      for (int i=0;i<=20;i++) {
          System.out.print(" ");
      }

      System.out.println(ANSI_YEŞİL+"**********Bankamıza Hoşgeldiniz**********");
        for (int i=0;i<=10;i++) {
            System.out.print(" ");
        }

        Scanner scan=new Scanner(System.in);
        System.out.println("Güncel Döviz Kurları ");
        DataExtraction rates=new DataExtraction();
        rates.getData();

        for (int i=0;i<=12;i++) {
            System.out.print(" ");
        }

        System.out.println(ANSI_YEŞİL+"**HOŞGELDİNİZ**\nGiriş yapmak için 1" +
                "\nKayıt olmak için 2'ye basınız ");

       int procces=scan.nextInt();

       switch (procces){
           case 1:
               DBcon login=new DBcon();
               login.login();
               break;
               case 2:
               DBcon register=new DBcon();
               register.kayitol();
               entrance();
               break;
       }
    }
}
