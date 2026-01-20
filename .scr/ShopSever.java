import jutils.List;
import jutils.Server;
/**
 * Protokoll:
 * ANMELDUNG
 * TSHIRT:<groesse>:<Farbe>
 * BESTAETIGUNG:<Wahl>
 * ABMELDEN
 * TRINKGELD:<Menge>
 */
public class ShopSever extends Server {

    List<Bestellung> bestellungen= new List<>();
    public ShopSever(int pIP) {
        super(pIP);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
            send(pClientIP,pClientPort,"Willkommen bei He&He \n -----------------------------");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
            String[] nachrichtTeil =pMessage.split(":");
            if(nachrichtTeil[0].equals("TSHIRT")){

                send(pClientIP,pClientPort,"Du möchtest ein TShirt in der Größe "+nachrichtTeil[1]+" und der Farbe "+ nachrichtTeil[2]+" . Dieser Artikel kostet Nur 30 Euro");

            }else if (nachrichtTeil[0].equals("Warenkorb")) {
                send(pClientIP,pClientPort,"oisiisHDIUGHishouIHSGOIUhefou");
                int x = 0;

                while (Integer.parseInt(nachrichtTeil[3])< x) {
                    x++;

                    bestellungen.append(new Bestellung(new TShirt(nachrichtTeil[1], nachrichtTeil[2], 30)));
                }
            } else if (nachrichtTeil[0].equals("BESTAETIGUNG")) {


                if (nachrichtTeil[1].equals("Ja")) {
                    bestellungen.toFirst();
                    while (bestellungen.hasAccess()) {
                        send(pClientIP, pClientPort, bestellungen.getContent().getWare().getFarbe());
                        send(pClientIP, pClientPort, bestellungen.getContent().getWare().getFarbe());
                        bestellungen.next();
                    }
                    send(pClientIP, pClientPort, "Danke für dein Einkauf. Auf Wiedersehen");
                } else if (nachrichtTeil[1].equals("Nein")) {
                    send(pClientIP, pClientPort, "Auf Wiedersehen");
                } else {
                    send(pClientIP, pClientPort, "Bitte gebe nu Ja oder Nein ein");
                }

            } else if (nachrichtTeil[0].equals("ABMELDEN")) {
                this.closeConnection(pClientIP, pClientPort);
            } else if (nachrichtTeil[0].equals("TRINKGELD")) {
                send(pClientIP, pClientPort, "Danke für dein Trinkgeld in der höhe von " + nachrichtTeil[1]);
            } else {
                send(pClientIP, pClientPort, "Bitte nutzte eine gültige Eingabe");
            }
    }


    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {
        send(pClientIP,pClientPort,"Auf Wiedersehen");
    }
}
