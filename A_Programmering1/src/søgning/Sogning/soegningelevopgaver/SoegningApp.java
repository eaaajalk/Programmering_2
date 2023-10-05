package søgning.Sogning.soegningelevopgaver;

public class SoegningApp {

	
	public static void main(String[] args) {
		Soegning s = new Soegning();
		
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + s.findUlige(talArray));

		// Kode til afprøvning af opgave 2
		int[] talArray2 = {7, 56, 34, 3, 7, 14, 13, 4};
		System.out.println(s.findHeltal(talArray2));

		// Kode til afprøvning af opgave 3
		int[] talArray3 = {7, 9, 13, 7, 9, 13};
		System.out.println("Er der to ens tal ved siden af hinanden? " + s.toEns(talArray3));
		talArray3[3] = 13;
		System.out.println("Er der to ens tal ved siden af hinanden? " + s.toEns(talArray3));

	}




}
