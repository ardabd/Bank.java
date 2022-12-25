import java.io.IOException;
import java.util.Scanner;
import java.sql.*;

public class Menu extends DBcon {
    public void menu() throws SQLException, IOException {

        Scanner scan=new Scanner(System.in);
        for (int i=0;i<=5;i++) {
            System.out.print(" ");
        }
        DBcon db=new DBcon();

        System.out.println("Sen ne olsun istiyorsun?");
        System.out.println("1-PARA YATIR       6-BORÇ YATIR\n" +
                "2-PARA ÇEK         7-KREDİ ÇEK\n" +
                "3-YATIRIM          8-HAVALE\n" +
                "4-VARLIKLARIM      9-BİLGİ GÜNCELLEME\n" +
                "5-HARCAMA GEÇMİŞİ 10-ÇIKIŞ\n"
                );
        int choose=scan.nextInt();
        switch (choose){
            default:
                System.out.println("Hatalı giriş yaptınız tekrar deneyiniz");
                menu();
            case 1:
                Deposit deposit=new Deposit();
                deposit.deposit();
                menu();
                break;
            case 2:
                Withdrawal withdrawal=new Withdrawal();
                withdrawal.ParaCek();
                menu();
                break;
            case 3:
                Investment investment=new Investment();
                investment.investment();
                menu();
                break;
            case 4:
                Wealth wealth=new Wealth();
                wealth.Wealth();
                menu();
                break;
            case 5:
                History history=new History();
                history.historyprint();
                menu();
                break;
            case 6:
               PayDebt payDebt=new PayDebt();
               payDebt.payDebt();
               menu();
                break;
            case 7:
                GetCredit getCredit=new GetCredit();
                getCredit.getCredit();
                menu();
                break;
            case 8:
                SendMoney sendMoney=new SendMoney();
                sendMoney.sendMoney();
                menu();
                break;
            case 9:
                CustomerUpdate customerUpdate=new CustomerUpdate();
                customerUpdate.customerUpdate();
                menu();
                break;
            case 10:
                System.exit(0);
                break;
        }
    }
}
