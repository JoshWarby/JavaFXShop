package model;

/**
 * A name has a first name and a family name.
 * There is an option to produce a full name by combining these.
 * 
 * @author la
 */
public class Name {

	//fields
	private String firstName;
	private String familyName;
	
	
	//constructors
	public Name() {
		firstName = "";
		familyName = "";
	}
	
	public Name(String firstName, String familyName) {
		this.firstName = firstName;
		this.familyName = familyName;
	}
	
	
	//methods
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFamilyName() {
		return familyName;
	}

	public String getFullName() {
		return firstName + " " + familyName;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + ":[firstName=" + firstName + ", familyName=" + familyName + "]";
	}
}
