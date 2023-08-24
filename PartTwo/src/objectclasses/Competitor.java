package objectclasses;

/**
 * The Competitor class is used to represent the details of a given competitor.
 * It stores and provides methods to access and modify the competitor details,
 * such as their name, age, country and scores.
 * 
 * @version 1.0
 */
public abstract class Competitor {

	private int number; // The competitor's number
	private Name name; // The competitor's name
	private int levelOfCompetitor; // The competitor's level
	private int age; // The competitor's age
	private String country; // The competitor's country
	private int[] scores = new int[5]; // The competitor's scores

	/**
	 * Constructor for creating a Competitor object with the given parameters.
	 * 
	 * @param number            The competitor's number
	 * @param name              The competitor's name
	 * @param levelOfCompetitor The competitor's level
	 * @param age               The competitor's age
	 * @param country           The competitor's country
	 * @param scores            The competitor's scores
	 */
	public Competitor(int number, Name name, int levelOfCompetitor, int age, String country, int[] scores) {

		this.number = number;
		this.name = name;
		this.levelOfCompetitor = levelOfCompetitor;
		this.age = age;
		this.country = country;
		this.scores = scores;
	}

	/**
	 * Gets the competitor's number.
	 * 
	 * @return The competitor's number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the competitor's number.
	 * 
	 * @param number The competitor's number
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Gets the competitor's name.
	 * 
	 * @return The competitor's name
	 */
	public Name getName() {
		return name;
	}

	/**
	 * Sets the competitor's name.
	 * 
	 * @param name The competitor's name
	 */
	public void setName(Name name) {
		this.name = name;
	}

	/**
	 * Gets the competitor's level.
	 * 
	 * @return The competitor's level
	 */
	public int getLevelOfCompetitor() {
		return levelOfCompetitor;
	}

	/**
	 * Sets the competitor's level.
	 * 
	 * @param levelOfCompetitor The competitor's level
	 */
	public void setLevelOfCompetitor(int levelOfCompetitor) {
		this.levelOfCompetitor = levelOfCompetitor;
	}

	/**
	 * Gets the competitor's age.
	 * 
	 * @return The competitor's age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the competitor's age.
	 * 
	 * @param age The competitor's age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Gets the competitor's country.
	 * 
	 * @return The competitor's country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the competitor's country.
	 * 
	 * @param country The competitor's country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the overall score of the competitor.
	 * 
	 * @return The overall score of the competitor
	 */
	public abstract double getOverallScore();

	/**
	 * Gets the level of competitor
	 * 
	 * @return The level of competitor as an string
	 */
	public String getLevelOfCompetitorName() {
		if (this.getLevelOfCompetitor() == 1) {
			return "Novice";
		} else if (this.getLevelOfCompetitor() == 2) {
			return "Standard";
		} else if (this.getLevelOfCompetitor() == 3) {
			return "Veteran";
		} else if (this.getLevelOfCompetitor() == 4) {
			return "Expert";
		} else {
			return "";
		}
	}

	/**
	 * 
	 * Gets a detailed report about a competitor
	 *
	 * @return A detailed report about a competitor
	 */
	public String getFullDetails() {
		String detail = "Competitor number " + this.getNumber() + ", name " + this.getName().getFullName()
				+ ", country " + this.getCountry() + ".\n";
		detail += this.getName().getFirstName() + " is a " + this.getLevelOfCompetitorName() + " aged " + this.getAge()
				+ " and received these scores : ";
		for (int i = 0; i < this.scores.length; i++) {
			if (i == this.scores.length - 1) {
				detail += this.scores[i];
			} else {
				detail += this.scores[i] + ",";
			}

		}

		detail += "\nThis gives him an overall score of " + this.getOverallScore() + ".\n";
		return detail;
	}

	/**
	 * Gets a short report about a competitor
	 *
	 * @return A short report about a competitor
	 */
	public String getShortDetails() {
		return "CN " + this.getNumber() + " (" + this.getName().getFirstName().charAt(0)
				+ this.getName().getLastName().charAt(0) + ") has overall score " + this.getOverallScore() + "\n";
	}

	/**
	 * Gets an array of scores for a competitor
	 *
	 * @return An array of scores for the competitor
	 */
	public int[] getScoreArray() {
		return this.scores;
	}

	/**
	 * Set the scores array for the competitor.
	 * 
	 * @param scores - the new scores array for the competitor.
	 */
	public void setScoreArray(int[] scores) {
		this.scores = scores;
	}

}