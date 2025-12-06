package h1;

public class Bruch {
    public int zaehler;
    public int nenner;

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    /*
     * Berechnen des größten gemeinsamen Teiles
     */
    private int ggT(int x, int y) {

        // ggT existiert nicht für Bruch mit 0 und gtr 0 zwecks euklidischem Algorithmus
        if(x<=0 || y<=0)
            return 0;
        
        // x wird zur größeren Zahl
        int bufferNumber;
        if (x<y) {
            bufferNumber = x;
            x = y;
            y = bufferNumber;
        }
        
        // euklidischer Algorithmus
        while (x%y!=0) {
            bufferNumber = y;
            y = x%y;
            x = bufferNumber;
        }

        // y ist ggT
        return y;
    }

    /*
     * Kürzen vom Bruch mit der ggT Funktion.
     */
    public void shorten() {
        int bufferGGT = ggT(nenner, zaehler);
        nenner = nenner/bufferGGT;
        zaehler = zaehler/bufferGGT;
    }

    /*
     * Die gekürzten Brüche werden auf Gleichheit überprüft.
     */
    public boolean hasSameValueAs(Bruch b) {
        int thisGGT = ggT(this.nenner, this.zaehler);
        int bGGT = ggT(b.nenner, b.zaehler);
        if(this.nenner/thisGGT == b.nenner/bGGT && this.zaehler/thisGGT == b.zaehler/bGGT)
                return true;
        return false;
    }
}
