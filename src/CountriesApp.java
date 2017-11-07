
public class CountriesApp {

	public static void main(String[] args) {

		String prompt = "Please enter your choice: \n1) View list of existing countries \n2) Enter a new country \n3) Exit \n";

		int choice = Validator.getInt(prompt, 1, 3);
		while (choice != 3) {

			if (choice == 1) {
				CountriesTextFile.readFromFile("countries.txt");
			} else if (choice == 2) {
				String countryInput = Validator.getString("Please enter your country choice: ");
				CountriesTextFile.writeToFile(countryInput, "countries.txt");
			} else {
				System.out.println("Its not working.");
			}
			choice = Validator.getInt(prompt, 1, 3);
		}
		Validator.closeScanner();

		System.out.println("Thank you, bye-bye!!!!");

	}

}
