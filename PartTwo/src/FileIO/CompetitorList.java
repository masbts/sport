package FileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import objectclasses.Competitor;
import objectclasses.Cyclist;
import objectclasses.Name;
import objectclasses.Swimmer;

/**
 * 
 * The CompetitorList class stores a list of competitor objects and provides
 * methods to read and write this list to/from a file.
 */
public class CompetitorList {

	/**
	 * competitorList - representing the list of competitors in the competition
	 */
	private List<Competitor> competitors;

	/**
	 * 
	 * Creates a new empty CompetitorList.
	 */
	public CompetitorList() {
		competitors = new ArrayList<>();
		readFile("CompetitorList.txt");
	}

	/**
	 * getter method to access the list of competitors
	 * 
	 * @return ArrayList<Competitor> - representing the list of competitors
	 */
	public List<Competitor> getCompetitors() {
		return competitors;
	}

	/**
	 * 
	 * Reads competitor data from a file and adds them to the competitorList. Each
	 * line of the file should contain the data for one competitor in the format:
	 * number,firstName lastName, level, age, country, score1, score2, score3,
	 * score4, score5, competitor-type and competitor-category
	 * 
	 * @param fileName The name of the file to read from
	 */
	public void readFile(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String str;

			while ((str = br.readLine()) != null) {

				String[] split = str.split(",");
				int number = Integer.valueOf(split[0]);
				String firstName = split[1].strip().split(" ")[0];
				String lastName = split[1].strip().split(" ")[1];

				String level = split[2];
				int age = Integer.valueOf(split[3]);
				String country = split[4];
				int[] scores = new int[] { Integer.valueOf(split[5].strip()), Integer.valueOf(split[6].strip()),
						Integer.valueOf(split[7].strip()), Integer.valueOf(split[8].strip()),
						Integer.valueOf(split[9].strip()) };

				String competitorType = split[10].strip();
				String competitorCategory = split[11].strip();

				Competitor competitor;

				if (competitorType.equals("Swimmer")) {
					competitor = new Swimmer(number, new Name(firstName, lastName), getLevelNumber(level),
							age, country, scores, competitorCategory);
				} else {
					competitor = new Cyclist(number, new Name(firstName, lastName), getLevelNumber(level),
							age, country, scores, competitorCategory);
				}

				competitors.add(competitor);
			}
		} catch (IOException e) {
			System.out.println("Error while reading a file.");
		}
	}

	/**
	 * 
	 * Writes the current list of competitors to a file in the format:
	 * Competitor,Level,Scores,Overall number,firstName
	 * lastName,level,score1,score2,score3,score4,score5,overallScore
	 * 
	 * @param fileName the name of the file to write to.
	 */
	public void reportToFile(String fileName) {

		try {
			FileWriter myWriter = new FileWriter(fileName);

			myWriter.write(String.format("%-25s%-10s%-10s%-10s\n", "Competitor", "Level", "Scores", "Overall"));
			int maxIndex = 0;
			double maxOverall = competitors.get(0).getOverallScore();

			int minIndex = 0;
			double minOverall = competitors.get(0).getOverallScore();
			int[] countScore = new int[] { 0, 0, 0, 0, 0 };

			for (int i = 0; i < competitors.size(); i++) {
				Competitor competitor = competitors.get(i);
				myWriter.write(String.format("%-5d%-20s%-10s", competitor.getNumber(),
						competitor.getName().getFullName(), competitor.getLevelOfCompetitorName()));
				for (int j = 0; j < competitor.getScoreArray().length; j++) {
					myWriter.write(competitor.getScoreArray()[j] + " ");
					countScore[competitor.getScoreArray()[j] - 1]++;
				}
				myWriter.write("\t" + competitor.getOverallScore() + "\n");

				if (maxOverall < competitor.getOverallScore()) {
					maxOverall = competitor.getOverallScore();
					maxIndex = i;
				}

				if (minOverall > competitor.getOverallScore()) {
					minOverall = competitor.getOverallScore();
					minIndex = i;
				}

			}
			myWriter.write("\n");
			myWriter.write("STATISTICAL\n");
			myWriter.write("There are " + competitors.size() + " competitors\n");
			myWriter.write(
					"The person with the highest score is " + competitors.get(maxIndex).getName().getFullName()
							+ " with a score of " + competitors.get(maxIndex).getOverallScore() + ".\n");
			myWriter.write("The person with the lowest score is " + competitors.get(minIndex).getName().getFullName()
					+ " with a score of " + competitors.get(minIndex).getOverallScore() + ".\n");
			myWriter.write("The following individual scores were awarded:\n");
			myWriter.write("Score :\t\t1\t2\t3\t4\t5\n");
			myWriter.write("Frequency :\t" + countScore[0] + "\t" + countScore[1] + "\t" + countScore[2] + "\t"
					+ countScore[3] + "\t" + countScore[4] + "\n");
			myWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * Convert the level string value to int.
	 * 
	 * @param level the level in string format.
	 * @return level number
	 */
	private int getLevelNumber(String level) {
		level = level.strip();
		if (level.contains("Novice")) {
			return 1;
		} else if (level.contains("Standard")) {
			return 2;
		} else if (level.contains("Veteran")) {
			return 3;
		} else if (level.contains("Expert")) {
			return 4;
		} else {
			return -1;
		}
	}

	/**
	 * 
	 * check whether the competitor number is valid or not.
	 * 
	 * @param number competitor number.
	 */
	public void checkIsValidCompetitorNo(int number) {
		boolean found = false;
		for (int i = 0; i < competitors.size(); i++) {
			Competitor competitor = competitors.get(i);
			if (competitor.getNumber() == number) {
				found = true;
				System.out.println(competitor.getShortDetails());
				break;
			}
		}

		if (!found) {
			System.out.println("competitor number is not valid.");
		}
	}

}
