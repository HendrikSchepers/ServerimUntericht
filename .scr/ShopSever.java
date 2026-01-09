import jutils.List;
import jutils.Server;

public class ShopSever extends Server {

    List<Bestellung> bestellungen= new List<>();
    public ShopSever(int pIP) {
        super(pIP);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
            send(pClientIP,pClientPort,"Willkommen bei He&He");
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
            String[] nachrichtTeil =pMessage.split(":");
            if(nachrichtTeil[0].equals("TSHIRT")){
                bestellungen.append(new Bestellung(new TShirt(nachrichtTeil[1],nachrichtTeil[2],30.27)));
                send(pClientIP,pClientPort,"Du möchtest ein TShirt in der Größe "+nachrichtTeil[1]+" und der Farbe "+ nachrichtTeil[2]+" . Dieser Artikkel kostet Nur 30,27 Euro");

            }
            else if (nachrichtTeil[0].equals("BESTAETIGUNG")){
                if (nachrichtTeil[1].equals("Ja")){
                    send(pClientIP,pClientPort,"Danke für dein Einkauf. Auf Wiedersehen");
                }else if (nachrichtTeil[1].equals("Nein")){
                    send(pClientIP,pClientPort,"Auf Wiedersehen");
                }else{
                    send(pClientIP,pClientPort,"Bitte gebe nu Ja oder Nein ein");
                }

            }else{
                send(pClientIP,pClientPort,"Bitte nutzte eine gültige Eingabe");
            }
    }

    @Override
    public void processClosingConnection(String pClientIP, int pClientPort) {
        send(pClientIP,pClientPort,"Auf Wiedersehen");
    }
}
