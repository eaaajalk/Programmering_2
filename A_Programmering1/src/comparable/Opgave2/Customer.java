package comparable.Opgave2;

public class Customer implements Comparable<Customer> {
    private String fornavn;
    private String efternavn;
    private int alder;

    public Customer(String fornavn, String efternavn, int alder) {
        this.fornavn = fornavn;
        this.efternavn = efternavn;
        this.alder = alder;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEfternavn() {
        return efternavn;
    }

    public void setEfternavn(String efternavn) {
        this.efternavn = efternavn;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }
    @Override
    public String toString(){
        return fornavn;
    }

    @Override
    public int compareTo(Customer o) {
        int compEfternavn = this.efternavn.compareTo(o.efternavn);
        int compFornavn = this.fornavn.compareTo(o.fornavn);
        int compAlder = this.alder - o.getAlder();
            if (compEfternavn != 0) {
                return compEfternavn;
            } else if (compFornavn != 0){
                return compFornavn;
        } else {
                return compAlder;
            }
    }
}
