package tråde.udskrivskriv;

public class Test {

    public static void main(String[] args) {
        Common common = new Common("hej");
        Thread udskriv = new Udskriv(common);
        Thread indlæs = new Indlæs(common);
        indlæs.start();
        udskriv.start();


    }
}
