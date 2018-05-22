package finalProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Data implements Titles {

	double X, Y;
	double objectID;
	String facilityType, facility, address, city, zipCode, jurisdiction, parkingLot, nameOfContact, situsCity, district,
			localDes, countyDes;
	ArrayList<String[]> data = new ArrayList<String[]>();

	Data() {

		String csvFile = "GGEVA_DATA_CSV.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] dataArray = line.split(cvsSplitBy);

				data.add(dataArray);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	Data(Boolean edit) {

		String csvFile = "GGEVA_DATA_CSV.csv";
		String line = "";
		String cvsSplitBy = ",";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] dataArray = line.split(cvsSplitBy);

				data.add(dataArray);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	Data(String string) {
		if (string == selectionChoicesArr[0]) {
			String csvFile = "County_Facility_CSV.csv";
			String line = "";
			String cvsSplitBy = ",";

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] dataArray = line.split(cvsSplitBy);

					data.add(dataArray);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (string == selectionChoicesArr[1]) {
			String csvFile = "Fire_Stations_CSV.csv";
			String line = "";
			String cvsSplitBy = ",";

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] dataArray = line.split(cvsSplitBy);

					data.add(dataArray);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (string == selectionChoicesArr[2]) {
			String csvFile = "Law_Enforcement_CSV.csv";
			String line = "";
			String cvsSplitBy = ",";

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] dataArray = line.split(cvsSplitBy);

					data.add(dataArray);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (string == selectionChoicesArr[3]) {
			String csvFile = "Library_CSV.csv";
			String line = "";
			String cvsSplitBy = ",";

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] dataArray = line.split(cvsSplitBy);

					data.add(dataArray);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (string == selectionChoicesArr[4]) {
			String csvFile = "Post_Office_CSV.csv";
			String line = "";
			String cvsSplitBy = ",";

			try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] dataArray = line.split(cvsSplitBy);

					data.add(dataArray);

				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
