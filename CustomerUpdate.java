import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class CustomerUpdate extends DBcon {
    public void customerUpdate() throws SQLException, IOException {
        Connection c = DriverManager.getConnection("jdbc:MySQL://localhost:3306/bankdb?user=root&password=2446338Ahmet.");
        Statement st = c.createStatement();
        String url = "select * from customerbank Where CustomerID='" + customerNumber + "'";
        ResultSet rs = st.executeQuery(url);

        while (rs.next()) {
            setEmail(rs.getString("Email"));
            setPhoneNumber(rs.getString("PhoneNumber"));
        }

        System.out.println("Güncel email adresiniz: "+getEmail());
        System.out.println("Güncel telefon numaranız: "+getPhoneNumber());
        Scanner scan=new Scanner(System.in);
        System.out.println("Hangi bilgileri güncellemek istiyorsunuz?\n1-TELEFON\n2-Mail\n3-Şifre\n4-Menü");
        int secim=scan.nextInt();

        switch (secim){

            default:
                System.out.println("Hatalı tuşlama yaptınız.\nTekrar deneyiniz.");
                customerUpdate();
                break;

            case 1:
                System.out.println("Telefon Numaranızı giriniz: ");
                Scanner scanner=new Scanner(System.in);
                String telefonNo;
                telefonNo=scanner.nextLine();
                try {
                    Connection d = DriverManager.getConnection("jdbc:MySQL://localhost:3306/bankdb?user=root&password=2446338Ahmet.");
                    Statement sta=d.createStatement();
                    String url2=" UPDATE customerbank SET PhoneNumber='"+telefonNo+"'WHERE CustomerID='"+customerNumber+"'";
                    System.out.println("TEBRİKLER\nTelefon numaranızı güncellediniz\nGüncel telefon numaranız: "+telefonNo);
                    sta.executeUpdate(url2);
                }catch (Exception e){
                    System.out.println("Güncelleme olmadı.");
                }
                customerUpdate();
                break;

            case 2:
                String mail;
                Scanner scanner2=new Scanner(System.in);
                System.out.println("Mail adresinizi giriniz: ");
                mail= scanner2.nextLine();
                try {
                    Connection d = DriverManager.getConnection("jdbc:MySQL://localhost:3306/bankdb?user=root&password=2446338Ahmet.");
                    Statement sta=d.createStatement();
                    String url3=" UPDATE customerbank SET Email='"+mail+"'WHERE CustomerID='"+customerNumber+"'";
                    System.out.println("TEBRİKLER\nMail adresinizi güncellediniz\nGüncel mail adresiniz: "+mail);
                    sta.executeUpdate(url3);
                }catch (Exception e){
                    System.out.println("Güncelleme olmadı.");
                }
                customerUpdate();
                break;

            case 3:
                double pw;
                Scanner scanner3=new Scanner(System.in);
                System.out.println("Şifrenizi giriniz: ");
                pw= scanner3.nextDouble();

                try {
                    Connection d = DriverManager.getConnection("jdbc:MySQL://localhost:3306/bankdb?user=root&password=2446338Ahmet.");
                    Statement sta=d.createStatement();
                    String url3=" UPDATE customerbank SET Password='"+pw+"'WHERE CustomerID='"+customerNumber+"'";
                    System.out.println("TEBRİKLER\nŞifrenizi güncellediniz\nGüncel şifreniz:  "+pw);
                    sta.executeUpdate(url3);
                }catch (Exception e){
                    System.out.println("Güncelleme olmadı.");
                }
                customerUpdate();
                break;

            case 4:
                Menu menu=new Menu();
                menu.menu();
                break;
        }
    }
}