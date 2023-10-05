package enumOgsemesterprove.OpgaveEnum;

public class EnumExample {

    // Definerer et enum for forskellige ugedage
    enum Weekday {
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    public static void main(String[] args) {
        // Opretter en variabel af typen Weekday og tilskriver den en værdi fra enum
        Weekday today = Weekday.WEDNESDAY;

        // Bruger switch-case til at udføre forskellige handlinger baseret på ugedagen
        switch (today) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Det er en arbejdsdag.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Det er weekend!");
                break;
            default:
                System.out.println("Ugyldig ugedag.");
        }
    }
}
