package finalProject;

public interface Titles {

	String[] titles = { "X", "Y", "ObjectID", "Facility Type", "Facility", "Address", "City", "ZipCode", "Jurisdiction",
			"Parking Lot", "Name", "StrFormat", "SitusCity", "District", "LocalDesignation", "CountyDesignation" };

	String[] titlesCounty = { "X", "Y", "ObjectID", "Facility Type", "Facility", "Address", "City", "ZipCode" };
	String[] titlesFireStation = { "X", "Y", "ObjectID",  "Facility", "Address", "Zip Code", "SitusCity",
			"District", "LocalDesignation", "CountyDesignation", "Facility Type" };
	String[] titlesLawEnforcement = { "X", "Y", "ObjectID", "Facility", "Address", "ZipCode", "City", "Comment",
			"Facility Type" };
	String[] titlesLibrary = { "X", "Y", "ObjectID", "Facility", "Address", "ZipCode", "City", "Facility Type" };
	String[] titlesPostOffice = { "X", "Y", "ObjectID", "Facility", "Address", "ZipCode", "City", "Facility Type" };

	String[] selectionChoicesArr = { "County Facilities", "Fire Stations", "Law Enforcement", "Library",
			"Post Office" };
	

	
}
