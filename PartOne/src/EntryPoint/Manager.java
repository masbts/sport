package EntryPoint;

import FileIO.CompetitorList;
import objectclasses.Competitor;
import objectclasses.Name;

/**
 * EntryPoint.Manager is the main class which tests the functionality of the
 * Competitor class and CompetitorList class.
 * 
 * @author
 * @version 1.0
 */
public class Manager {

	public static void main(String[] args) {
		// Testing Competitor class
		System.out.println("Testing Competitor class\n");
		// Instantiates a Competitor object with the given parameters
		Competitor compititor = new Competitor(100, new Name("Keith", "John"), 1, 20, "Uk",
				new int[] { 5, 4, 5, 4, 3 });

		// Prints out the full details of the Competitor object
		System.out.println(compititor.getFullDetails());

		// Prints out the short details of the Competitor object
		System.out.println(compititor.getShortDetails());

		// Prints out the level of the Competitor object
		System.out.println(compititor.getLevelOfCompetitorName());

		// Prints out the overall score of the Competitor object
		System.out.println(compititor.getOverallScore());

		// Instantiates a CompetitorList object
		CompetitorList competitorList = new CompetitorList();

		// Writes the report to the specified file
		competitorList.reportToFile("report.txt");

		// Checks if the given competitor number is valid
		competitorList.checkIsValidCompetitorNo(101);
		competitorList.checkIsValidCompetitorNo(10001);
	}
}