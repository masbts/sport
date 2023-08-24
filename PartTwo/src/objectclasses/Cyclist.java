package objectclasses;

/**
 * The Cyclist class is a child class of Competitor class, representing a
 * cyclist in a cycling competition.
 * It has an additional field called cyclistType which can take the following
 * values - road, mountain, BMX, track.
 * The class also overrides the getOverallRating method of the parent class, to
 * include the cyclistType in calculation of overall rating.
 * 
 * @version 1.0
 */
public class Cyclist extends Competitor {

    /**
     * cyclistType - representing the type of cyclist, which can take the following
     * values - road, mountain, BMX, track
     */
    String cyclistType;

    /**
     * Get the cyclist type of the competitor.
     * 
     * @return the cyclist type of the competitor.
     */
    public String getCyclistType() {
        return cyclistType;
    }

    /**
     * Set the cyclist type of the competitor.
     * 
     * @param cyclistType the new cyclist type for the competitor.
     */
    public void setCyclistType(String cyclistType) {
        this.cyclistType = cyclistType;
    }

    /**
     * Constructor of the class, calls the super constructor and sets the
     * cyclistType field
     * 
     * @param number            - representing the unique number of the cyclist in
     *                          the competition
     * @param name              - representing the name of the cyclist
     * @param levelOfCompetitor - representing the level of competitor, which can
     *                          take the following values - 1, 2 and 3
     * @param age               - representing the age of the cyclist
     * @param country           - representing the country of the cyclist
     * @param scores            - representing the scores of the cyclist in
     *                          different events
     * @param cyclistType       - representing the type of cyclist, which can take
     *                          the following values - road, mountain, BMX, track
     */
    public Cyclist(int number, Name name, int levelOfCompetitor, int age, String country, int[] scores,
            String cyclistType) {
        super(number, name, levelOfCompetitor, age, country, scores);
        this.cyclistType = cyclistType;
    }

    /**
     * Gets the overall score of the competitor.
     * 
     * The approach used here is to use a weighted average of the scores, where the
     * weights are determined by the level of the competitor. For example, if level
     * 1 competitors are considered more skilled than level 2 competitors, who are
     * in turn considered more skilled than level 3 competitors, the weights for
     * level 1, level 2, and level 3 could be set to 3, 2, and 1 respectively. Then,
     * the overall rating for a competitor with level n and scores s1, s2, ..., sn
     * could be calculated as (s1n + s2n + ... + sn*n) / (s1 + s2 + ... + sn).
     * 
     * I've added an additional if-else block, to check the value of cyclistType
     * field, and if the value of cyclistType is "road" then I've added 1 to weight,
     * if the value of cyclistType is "mountain" then I've added 2 to weight, if the
     * value of cyclistType is "BMX" then I've added 3 to weight and if the value of
     * cyclistType is "track" then I've added 4 to weight.
     * 
     * This way, the weight of the score is increased based on the cyclistType of
     * the cyclist and overall rating will be calculated by taking this weight into
     * account.
     * 
     * @return The overall score of the competitor
     */
    @Override
    public double getOverallScore() {
        int weight = 0;
        if (super.getLevelOfCompetitor() == 1)
            weight = 3;
        else if (super.getLevelOfCompetitor() == 2)
            weight = 2;
        else if (super.getLevelOfCompetitor() == 3)
            weight = 1;

        int totalWeight = 0;
        int weightedScore = 0;
        for (int score : super.getScoreArray()) {
            if (cyclistType.equals("road")) {
                weight += 1;
            } else if (cyclistType.equals("mountain")) {
                weight += 2;
            } else if (cyclistType.equals("BMX")) {
                weight += 3;
            } else if (cyclistType.equals("track")) {
                weight += 4;
            }
            totalWeight += weight;
            weightedScore += score * weight;
        }
        double overallScore = (double) weightedScore / totalWeight;
        if (overallScore < 0) {
            overallScore = 0;
        } else if (overallScore > 5) {
            overallScore = 5;
        }
        return overallScore;
    }

}
