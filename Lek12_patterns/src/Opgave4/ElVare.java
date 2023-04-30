package Opgave4;

public class ElVare extends Vare{


    public ElVare(int pris, String navn) {
        super(pris, navn);
    }

    @Override
    public double beregnMoms() {
        double moms = (getPris() / 100.0) * 30;
        if (moms < 3) {
            moms = 3;
        }
        return moms;
    }


}
