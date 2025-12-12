package h1;

public class Bruch {
    public int zaehler;
    public int nenner;

    public Bruch(int zaehler, int nenner) {
        this.zaehler = zaehler;
        this.nenner = nenner;
    }

    /*
     * Berechnen des größten gemeinsamen Teilers
     */
    private int ggT(int x, int y) {

        // ggT für 0 und 0 ist 0
        if(x==0 && y==0)
            return 0;

        // ggT für negative Zahlen ist positiv definiert
        // so können x,y für den Algorithmus auch positiv sein
        x = Math.abs(x);
        y = Math.abs(y);

        // ggt für 0 und eine Zahl ist der Betrag der Zahl.
        if(x==0)
            return y;
        if(y==0)
            return x;

        // ggT mit euklidischer Algorithmus
        int bufferNumber;
        while (x%y!=0) {
            bufferNumber = y;
            y = x%y;
            x = bufferNumber;
        }
        return y;
    }

    /*
     * Kürzen vom Bruch mit der ggT Funktion.
     */
    public void shorten() {
        int bufferGGT = ggT(nenner, zaehler);
        if(this.nenner==0)
            this.zaehler = 1;

        if(bufferGGT!=0) {
            nenner = nenner/bufferGGT;
            zaehler = zaehler/bufferGGT;
        }
    }

    /*
     * Die gekürzten Brüche werden auf Gleichheit überprüft.
     * Die Brüche werden nicht gekürzt, da nicht von Aufgabe verlangt.
     */
    public boolean hasSameValueAs(Bruch b) {
        int thisGGT = ggT(this.nenner, this.zaehler);
        int bGGT = ggT(b.nenner, b.zaehler);
        if(this.zaehler!=0 && b.nenner!=0) {
            if (this.nenner==0 && b.nenner==0)
                return true;
            if(this.nenner/thisGGT == b.nenner/bGGT && this.zaehler/thisGGT == b.zaehler/bGGT)
                return true;
        }
        return false;
    }
}
