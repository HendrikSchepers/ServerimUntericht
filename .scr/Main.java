import jutils.*;

import java.util.Scanner;
import java.util.SortedMap;


public class Main {

     public static void main(String[] args) throws InterruptedException {
         Scanner scanner =new Scanner(System.in);

         //wichti ist, das der sever und der Client denselben Port nutzten
         ShopSever sever =new ShopSever(16);
         ShopClient kunde = new ShopClient("localhost",16);
          int bezahlen =0;
          int anzahl = 0;
         Thread.sleep(45);

         while(kunde.isConnected()) {

             System.out.println("Was möchtest du machen? \n [1] Neues TShirt bestellen \n [2] Bestellung bestätigung \n [3] Trinkgeld geben\n [4] Abmelden");
             int auswahl = scanner.nextInt();
             if (auswahl==1){
                 String groessse;
                 String farbe;
                 System.out.println("In welcher Größe möchtest du dein TShirt bestellen? (S/M/L/XL/XXl)");
                 groessse = scanner.next();
                 System.out.println("Welche Farbe soll das TShirt haben? ");
                 farbe=scanner.next();
                 kunde.groesseFarbeWaehlen(groessse,farbe);
                 System.out.println("[1] für in den warenkorb packen ");
                 System.out.println("[2] für löschen ");
                 int antwort = scanner.nextInt();
                 if (antwort==1){

                     System.out.println("Wie viele Tshirts sollen in den warenkorb?");
                     int b = scanner.nextInt();
                     System.out.println("Das objekt wurde " + b +" mal in den Warenkorb hinzugefügt");
                 anzahl = anzahl + b;}


             }else if( auswahl==2){
                 System.out.println("Ja oder Nein");
                 String antwort= scanner.next();
                 bezahlen = bezahlen + anzahl* 30;
                 System.out.println("Sie müssen "+ bezahlen+ "€ bezahlen");

                 kunde.bestaetigen(antwort);
             }

             else if (auswahl == 3){
                 System.out.println("Wie viel Trinkgeld möchtest du geben?");
                 int wert = scanner.nextInt();
                 bezahlen = wert;
                 kunde.trinkgeldgeben(wert);
             }
             else if (auswahl == 4){
                 kunde.abmelden();
             }
             else {
                 System.out.println("Ungültige eingabe. Bitte Nutzte nur 1,2 oder 3");
             }

             Thread.sleep(45);
         }

    }
}
