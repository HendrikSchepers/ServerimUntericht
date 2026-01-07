import jutils.Client;

public class ShopClient extends Client {
    public ShopClient(String pServerIP, int pSeverPort) {
        super(pServerIP, pSeverPort);
    }

    @Override
    public void processMessage(String pMessage) {

    }

    public void groesseFarbeWaehlen(String pGroesse, String pFarbe){
      send("TSHIRT:"+pGroesse+":"+pFarbe);
    }
    public void bestaetigen(String pAntwort){
        send("BESTAETIGUNG:"+pAntwort);
    }

    public void abmelden(){
        send("ABMELDEN");
    }
}
