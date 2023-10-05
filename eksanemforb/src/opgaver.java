import java.util.ArrayList;
import java.util.Arrays;

public class opgaver {

    public static void main(String[] args) {
        System.out.println("Opg1:");
        int[] array = {3, 1, 4, 2, 5, 6, 7};
        System.out.println(Arrays.toString(opg1(array)));
        System.out.println();
        System.out.println("Opg2:");
        System.out.println(opg2("banan"));
        System.out.println();
        System.out.println("Opg3:");
        int[][] matrix = new int[2][2];
        fill(matrix);
        //udskriver matrix:
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("______");
        System.out.println(opg3(matrix));


    }

    //Opgave 1: Skriv en metode, der tager imod et array af tal og returnerer det længste stigende delarray i arrayet.
    // Eksempel:
    // Input: [3, 1, 4, 2, 5, 6, 7] Output: [2, 5, 6, 7]


    public static Object[] opg1 (int[] list) {
        ArrayList<Integer> max = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(list[0]);
        for (int j = 0; j < list.length-1; j++) {
            if (list[j+1] > list[j]) {
                temp.add(list[j+1]);
            } else {
                if (temp.size() > max.size()) {
                    max = temp;
                }
                temp.clear();
                temp.add(list[j+1]);
            }
        }
        return max.toArray();
    }


    //Opgave 2: Skriv en metode, der tager imod en tekststreng og returnerer den længste palindromiske delstreng i strengen.
    // Eksempel: "banan" => "ana"
    public static String opg2 (String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n]; // Dynamisk programmering tabel
        int maxLength = 0; // Længden af den længste palindromiske delstreng
        int start = 0; // Startpositionen for den længste palindromiske delstreng

        // Initialisering: Enkelttegn er altid palindromiske
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            maxLength = 1;
        }

        // Behandling af to-karakter-delstrengene
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Behandling af længere delstrengene
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    start = i;
                    maxLength = len;
                }
            }
        }

        // Returnerer den længste palindromiske delstreng
        return s.substring(start, start + maxLength);
    }

    //Opgave: Skriv en metode, der tager imod et 2D array af tal og returnerer den maksimale sum,
    // der kan opnås ved at bevæge sig fra øverste venstre hjørne til nederste højre hjørne ved
    // kun at bevæge sig nedad eller mod højre.
    public static void fill (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 10);
            }
        }

    }
    public static int opg3 (int[][] matrix) {
        int col = 0;
        int row = 0;
        int temp = matrix[col][row];
        while (col != matrix.length-1 && row != matrix[col].length-1) {
            if (matrix[col+1][row] > matrix[col][row+1]) {
                col++;
            } else {
                row++;
            }
            temp += matrix[col][row];
        }
        if (row < matrix[col].length-1) {
            row++;
        } else {
            col++;
        }
        temp += matrix[col][row];
        return temp;
    }
}
