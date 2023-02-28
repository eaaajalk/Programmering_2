import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class main {

    public static void main(String[] args) {
        
        List<LocalDate> datolist = new ArrayList<>();
        
        LocalDate d = LocalDate.now();
        LocalDate d1 = LocalDate.now().plusDays(1);
        
        datolist.add(d1);
        datolist.add(d);
        System.out.println(datolist);

        Collections.sort(datolist);
        System.out.println(datolist);

        long diff = ChronoUnit.DAYS.between(d, d1);
        System.out.println(diff);
        
    }
}
