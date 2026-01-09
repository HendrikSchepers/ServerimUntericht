import jutils.*;

import java.util.Scanner;
import java.util.SortedMap;


public class Main {

     public static void main(String[] args) {
         Scanner scanner =new Scanner(System.in);
         /*Connection connection=new Connection("time-b.timefreq.bldrdoc.gov",13);
         String a=connection.receive();
         String Zeit = connection.receive();
         System.out.println("sever time:"+ Zeit);
         connection.close();
         */
         ShopSever sever =new ShopSever(16);

         ShopClient kunde = new ShopClient("localhost",16);

         while(true) {
             System.out.println("Was möchtest du machen? \n [1] Neues TShirt bestellen \n [2] Bestellung bestätigung \n [3]abmelden");
             int auswahl = scanner.nextInt();
             if (auswahl==1){

             }
             kunde.groesseFarbeWaehlen("s", "Grün");
             kunde.bestaetigen("Ja");
         }
         //Connection connection=new Connection("localhost",16);
         //DaytimeClient daytimeClient= new DaytimeClient("time.fu-berlin.de");

         //QOTDClient qotdClient=new QOTDClient("djxmmx.net" );


    }
}
