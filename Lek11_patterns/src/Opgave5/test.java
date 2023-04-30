package Opgave5;
public class test {

    public test() {
        super();
    }
    public static void main(String[] args) {
        Observer saelger = new Saelger("Hansen");
        Observer indkoeber = new Indkoeber("Jensen");

        BogTitel b1 = new BogTitel("Anders And", 6);
        BogTitel b2 = new BogTitel("Java", 8);
        b1.addObersver(indkoeber);
        b2.addObersver(indkoeber);

        Kunde k1 = new Kunde("Læsehest1");
        Kunde k2 = new Kunde("Læsehest2");
        Kunde k3 = new Kunde("Læsehest3");

        b1.addObersver(saelger);

        b2.etKoeb(k1);
        b2.etKoeb(k2);
        b2.etKoeb(k3);
        b1.etKoeb(k1);
        b1.etKoeb(k2);
        b1.etKoeb(k3);
    }
}
