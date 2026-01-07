public class TShirt {
    String grosse;
    String farbe;
    double preis;

    public TShirt(String grosse, String farbe, double preis) {
        this.grosse = grosse;
        this.farbe = farbe;
        this.preis = preis;
    }

    public String getGrosse() {
        return grosse;
    }

    public void setGrosse(String grosse) {
        this.grosse = grosse;
    }

    public String getFarbe() {
        return farbe;
    }

    public void setFarbe(String farbe) {
        this.farbe = farbe;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }
}
