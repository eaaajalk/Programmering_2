package enumOgsemesterprove.OpgaveEnum;
public class EnumExample1 {

    // Definerer et enum for forskellige biltyper
    enum CarType {
        SEDAN("Sedan"),
        HATCHBACK("Hatchback"),
        SUV("SUV"),
        CONVERTIBLE("Convertible");

        private String type;

        CarType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }
    }

    public static void main(String[] args) {
        // Opretter en variabel af typen CarType og tilordner den værdien SEDAN
        CarType myCarType = CarType.SEDAN;

        // Udskriver biltypen og dens navn
        System.out.println("Min biltyp: " + myCarType);
        System.out.println("Biltype: " + myCarType.getType());

        // Sammenligner biltypen med en anden biltype
        if (myCarType == CarType.SEDAN) {
            System.out.println("Min biltyp er en sedan.");
        } else {
            System.out.println("Min biltyp er ikke en sedan.");
        }
    }
}
