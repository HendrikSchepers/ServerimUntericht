import jutils.Client;

import java.sql.Time;
import java.util.concurrent.TimeUnit;


/**
 * Protokoll:
 * ANMELDUNG
 * TSHIRT:<groesse>:<Farbe>
 * BESTAETIGUNG:<Wahl>
 * ABMELDEN
 * TRINKGELD:<Menge>
 */
public class ShopClient extends Client {

    public ShopClient(String pServerIP, int pSeverPort) {
        super(pServerIP, pSeverPort);
        System.out.println("verbindung wird aufgebaut");
    }

    @Override
    public void processMessage(String pMessage) {
        System.out.println(pMessage);
    }

    public void groesseFarbeWaehlen(String pGroesse, String pFarbe){
      send("TSHIRT:"+pGroesse+":"+pFarbe);
    }
    public void Warenkorb(String pGroesse, String pFarbe, int Anzahl){
        send("Warenkorb:" + pGroesse + ":" + pFarbe + ":" + Anzahl);
        System.out.println("ww");
    }
    public void bestaetigen(String pAntwort){
        send("BESTAETIGUNG:"+pAntwort);
    }
    public void trinkgeldgeben(int pWert){
        send("TRINKGELD:"+pWert);
    }

    public void abmelden(){
        send("ABMELDEN");
    }

}
