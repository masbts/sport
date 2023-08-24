package objectclasses;

/**
 * The Swimmer class is a child class of Competitor class, representing a
 * swimmer in a swimming competition.
 * It has an additional field called swimmingStyle which can take the following
 * values - Freestyle, Backstroke, Breaststroke, Butterfly.
 * The class also overrides the getOverallRating method of the parent class, to
 * include the swimmingStyle in calculation of overall rating.
 * 
 * @version 1.0
 */
public class Swimmer extends Competitor {

    /**
     * swimmingStyle - representing the style of swimming of a swimmer, which can
     * take the following values - Freestyle, Backstroke, Breaststroke, Butterfly
     */
    String swimmingStyle;

    /**
     * Get the swimming style of the competitor.
     * 
     * @return the swimming style of the competitor.
     */
    public String getSwimmingStyle() {
        return swimmingStyle;
    }

    /**
     * Set the swimming style of the competitor.
     * 
     * @param swimmingStyle the new swimming style for the competitor.
     */
    public void setSwimmingStyle(String swimmingStyle) {
        this.swimmingStyle = swimmingStyle;
    }

    /**
     * Constructor of the class, calls the super constructor and sets the
     * swimmingStyle field
     * 
     * @param number            - representing the unique number of the swimmer in
     *                          the competition
     * @param name              - representing the name of the swimmer
     * @param levelOfCompetitor - representing the level of competitor, which can
     *                          take the following values - 1, 2 and 3
     * @param age               - representing the age of the swimmer
     * @param country           - representing the country of the swimmer
     * @param scores            - representing the scores of the swimmer in
     *                          different events
     * @param swimmingStyle     - representing the style of swimming of a swimmer
     */
    public Swimmer(int number, Name name, int levelOfCompetitor, int age, String country, int[] scores,
            String swimmingStyle) {
        super(number, name, levelOfCompetitor, age, country, scores);
        this.swimmingStyle = swimmingStyle;
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
     * I've added an additional if-else block, to check the value of swimmingStyle
     * field, and if the value of swimmingStyle is "Freestyle" then I've added 1 to
     * weight, if the value of swimmingStyle is "Backstroke" then I've added 2 to
     * weight, if the value of swimmingStyle is "Breaststroke" then I've added 3 to
     * weight and if the value of swimmingStyle is "Butterfly" then I've added 4 to
     * weight.
     * 
     * This way, the weight of the score is increased based on the swimmingStyle of
     * the swimmer and overall rating will be calculated by taking this weight into
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
            if (swimmingStyle.equals("Freestyle")) {
                weight += 1;
            } else if (swimmingStyle.equals("Backstroke")) {
                weight += 2;
            } else if (swimmingStyle.equals("Breaststroke")) {
                weight += 3;
            } else if (swimmingStyle.equals("Butterfly")) {
                weight += 4;
            }
            totalWeight += weight;
            weightedScore += score * weight;
        }
        double overallRating = (double) weightedScore / totalWeight;
        if (overallRating < 0) {
            overallRating = 0;
        } else if (overallRating > 5) {
            overallRating = 5;
        }
        return overallRating;
    }

}
