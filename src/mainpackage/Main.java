package mainpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {

	private static Set<String> uniqueUsers;

	private static ArrayList<Bill> collectionOfBills;

	public static void main(String[] args) throws IOException {
		if (args.length != 2) {
			System.out.println("Enter a source file");
			System.exit(1);
		}
		File file = new File(args[0]);
		String[] spaceSeparatedUniqueUsers = args[1].split(" ");
		uniqueUsers = new HashSet<String>(Arrays.asList(spaceSeparatedUniqueUsers));
		System.out.println(uniqueUsers);

		collectionOfBills = new ArrayList<Bill>();
		Map<String, Float> userPlus = new HashMap<String, Float>();
		Map<String, Float> userMinus = new HashMap<String, Float>();

		FileInputStream fis = new FileInputStream(file);
		// Construct BufferedReader from InputStreamReader
		BufferedReader br = new BufferedReader(new InputStreamReader(fis));

		String line = null;
		while ((line = br.readLine()) != null) {
			String[] firstSplit = line.split(",");
			String secondSplitForToBeDivided = firstSplit[2].substring(1, firstSplit[2].length() - 1);
			List<String> thisBillToBeDividedInto = Arrays.asList(secondSplitForToBeDivided.split(" "));
			Bill newBill = new Bill(Float.parseFloat(firstSplit[0]), firstSplit[1], thisBillToBeDividedInto, firstSplit[3]);
			collectionOfBills.add(newBill);
		}
		br.close();

		System.out.println(collectionOfBills);

		for (String user : uniqueUsers) {
			float totalPlus = 0;
			float totalMinus = 0;

			for (Bill bill : collectionOfBills) {
				if (bill.getPaidBy().equals(user)) {
					totalPlus += bill.getAmount_paid();
				}
				if (bill.getToBeDividedInto().contains(user)) {
					totalMinus += bill.getAmount_paid() / bill.getToBeDividedInto().size();
				}
			}

			userPlus.put(user, totalPlus);
			userMinus.put(user, totalMinus);
		}

		System.out.println("user-wise total plus: =>  " + userPlus);
		System.out.println("user-wise total minus:  =>  " + userMinus);

	}
}
