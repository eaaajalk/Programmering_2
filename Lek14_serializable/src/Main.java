import eksempelpersist.Person;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        MyTime myTime = null;

        try (FileInputStream f_in = new FileInputStream("mytime.ser")) {
            try (ObjectInputStream obj_in = new ObjectInputStream(f_in)) {
                Object obj = obj_in.readObject();
                if (obj instanceof MyTime) {
                    myTime = (MyTime) obj;
                    System.out.println(myTime);
                }
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        myTime.increase();
        myTime.increase();
        System.out.println(myTime.getTime());
        try {
            FileOutputStream f_out = new FileOutputStream("mytime.ser");
            ObjectOutputStream obj_out = new ObjectOutputStream(f_out);
            obj_out.writeObject(myTime);
            System.out.println("MyTime objekt er gemt:" + myTime);
            obj_out.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}