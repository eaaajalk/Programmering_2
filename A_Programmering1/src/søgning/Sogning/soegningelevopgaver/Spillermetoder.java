package søgning.Sogning.soegningelevopgaver;

import java.util.ArrayList;

public class Spillermetoder {
    public Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        // TODO Opgave 4.1
        Spiller spiller = null;
        int i = 0;
        while (spiller == null && i < spillere.size()) {
            Spiller s = spillere.get(i);
            if (s.getMaal() == score)
                spiller = s;
            else
                i++;
        }
        return spiller;
    }

    public Spiller findScoreBinær (ArrayList<Spiller> spillere, int score) {
        // TODO Opgave 4.2
        Spiller spiller = null;
        int left = 0;
        int right = spillere.size() - 1;
        while (spiller == null && left <= right) {
            int middle = (left+right) / 2;
            Spiller s = spillere.get(middle);
            if (s.getMaal() == score)
                spiller = s;
            else if (s.getMaal() > 0)
                right = middle - 1;
            else
                left = middle + 1;
        }
        return spiller;

    }

    public String godSpiller (ArrayList<Spiller> spillere) {
        // TODO Opgave 4.3
        String result = "";
        Spiller spiller;
        int i = 0;
        while (result.equals("") && i < spillere.size()) {
            spiller = spillere.get(i);
            if (spiller.getMaal() > 50 && spiller.getHoejde() < 170)
                result = spiller.getNavn();
            else
                i++;
        }
        return result;
    }


    public static void main(String[] args) {
        Spillermetoder metoder = new Spillermetoder();

        // Her afprøves opgave 4.1
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Spiller der har scoret 35 mål: " + metoder.findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + metoder.findScoreLinear(spillerListe, 30));

        // Tilføj kode der afprøver opgaver 4.2 og 4.3

    }

}
