package objectclasses;

/**
 * The Name class represents a person's first and last name. It provides methods
 * for setting and getting the first and last name, as well as a method for
 * getting the full name (first name and last name concatenated together with a
 * space in between).
 */
public class Name {

	/** The person's first name */
	private String firstName;
	/** The person's last name */
	private String lastName;

	/**
	 * Creates a new Name object with empty first and last names.
	 */
	public Name() {
		this.firstName = "";
		this.lastName = "";
	}

	/**
	 * Creates a new Name object with the given first and last names.
	 *
	 * @param firstName The person's first name
	 * @param lastName  The person's last name
	 */
	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Gets the person's full name, which is the concatenation of their first and
	 * last names separated by a space.
	 * 
	 * @return The person's full name
	 */
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}

	/**
	 * Gets the person's first name.
	 * 
	 * @return The person's first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the person's first name.
	 * 
	 * @param firstName The new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the person's last name.
	 * 
	 * @return The person's last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the person's last name.
	 * 
	 * @param lastName The new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}