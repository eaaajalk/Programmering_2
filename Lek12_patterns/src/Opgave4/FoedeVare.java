package Opgave4;

public class FoedeVare extends Vare {

    public FoedeVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        double moms = (getPris() / 100.0) * 5;
        if (moms < 3) {
            moms = 3;
        }
        return moms;
    }


}
