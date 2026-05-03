package CoforgePOJOInterviewQuestion;

import java.util.ArrayList;

public class AddVehicalInList {

	public static void main(String[] args) {

		Vehical v1 = new Vehical(01, "maruti", false);
		Vehical v2 = new Vehical(02, "tata", true);
		Vehical v3 = new Vehical(03, "hyundai", true);
		Vehical v4 = new Vehical(04, "bmw", true);
		Vehical v5 = new Vehical(05, "mahindra", true);

		ArrayList<Vehical> VehicalList = new ArrayList<>();

		VehicalList.add(v1);
		VehicalList.add(v2);
		VehicalList.add(v3);
		VehicalList.add(v4);
		VehicalList.add(v5);

		int count = 0;
		for (Vehical vehical : VehicalList) {

			if (vehical!=null && vehical.getServiceStatus()) {

				count++;
			}

		}
		System.out.println(count);

	}

}
