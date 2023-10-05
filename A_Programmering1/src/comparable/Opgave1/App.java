package comparable.Opgave1;

public class App {

    public static void main(String[] args) {
        Measurable[] chilies = new Measurable[3];
        chilies[0] = new Chili("Rød", 10);
        chilies[1] = new Chili("Grøn", 20);
        chilies[2] = new Chili("Gul", 50);

        System.out.println(max(chilies).getMeasure());
        System.out.println(avg(chilies));

    }

    public static Measurable max(Measurable[] objects){
        Measurable max = objects[0];
        for (Measurable obj : objects){
            if (obj.getMeasure() > max.getMeasure()){
                max = obj;
            }
        }
        return max;
    }

    public static double avg(Measurable[] objects){
        double sum = 0;
        for (Measurable obj : objects) {
            sum += obj.getMeasure();
        }
        if (objects.length > 0){
            return sum / objects.length;
        } else {
            return 0;
        }
    }


}
