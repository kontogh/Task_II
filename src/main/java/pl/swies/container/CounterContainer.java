package pl.swies.container;

public class CounterContainer {

    private DistinctGroup group;
    private int wordsCount;
    private int vowelsCount;

    /**
     * Constructor
     * @param dg (DisntictGroup)
     */
    public CounterContainer(DistinctGroup dg) {
        this.group = dg;
        this.wordsCount = 0;
        this.vowelsCount = 0;
    }

    /**
     * Increases the word count of the group and the number of vowels that occurred in that word
     * @param vowelsNum (int) number of vocels in given word
     */
    public void increaseCount(int vowelsNum) {
        wordsCount++;
        vowelsCount = vowelsCount + vowelsNum;
    }

    /**
     * Counts avarge of vowels in the given group
     * @return (double) average of vowels in given group
     */
    private double countAverage() {
        if (wordsCount == 0)
            return 0.0;

        return  (double) vowelsCount / wordsCount;
    }

    /**
     * Creates a result line to be appended to the file
     * @return (String) - result for a group
     */
    public String createLine() {
        return "" + group + countAverage();
    }

    /**
     * Compare this DistinctGroup with the group of a new word
     * @param dg (DistinctGroup) - of a new word
     * @return true if are the same
     */
    public boolean compareGroups(DistinctGroup dg) {
        return this.group.equals(dg);
    }
}
