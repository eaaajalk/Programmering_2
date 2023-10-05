package søgning.Sogning.soegningelevopgaver;

public class Soegning {

    public boolean findUlige(int[] tabel) {
        // TODO Opgave1
        boolean found = false;
        int i = 0;
        while (!found && i < tabel.length) {
            int k = tabel[i];
            if (k % 2 != 0)
                found = true;
            else
                i++;
        }
        return found;
    }

    // Opgave 2:
    public int findHeltal(int[] tabel) {
        // TODO Opgave2
        int index = -1;
        int i = 0;
        while (index == -1 && i < tabel.length) {
            int k = tabel[i];
            if (k % 2 == 0 && k >= 10 && k <= 15)
                index = k;
            else
                i++;
        }
        return index;
    }

    // Opgave 3:
    public boolean toEns(int[] tabel) {
        // TODO Opgave3
        boolean found = false;
        int i = 1;
        while (!found && i < tabel.length) {
            int k = tabel[i];
            int l = tabel[i-1];
            if (k == l)
                found = true;
            else
                i++;
        }
        return found;
    }



}
