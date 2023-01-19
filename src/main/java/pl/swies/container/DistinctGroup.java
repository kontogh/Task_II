package pl.swies.container;

import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

public class DistinctGroup {

    private Set<String> vowels;
    private int wordLength;


    public DistinctGroup() {
        this.vowels = new HashSet<>();
        wordLength = 0;
    }

    /** Increases word length */
    public void increaseLength() {
        wordLength++;
    }

    /**
     * Add new vovel to current set
     * @param ch(String) a vovel
     */
    public void updateSet(String ch) {
        vowels.add(ch);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (obj instanceof DistinctGroup) {
            DistinctGroup dg = (DistinctGroup) obj;
            if (this.wordLength != dg.wordLength)
                return false;
            if (this.vowels.containsAll(dg.vowels) && dg.vowels.containsAll(this.vowels))
                return true;
        }

        return false;
    }

    @Override
    public String toString() {
        String group = "({";
        StringJoiner sb = new StringJoiner(",");
        for (String cha : vowels) {
            sb.add(cha);
        }

        group = group + sb + "}, " + wordLength + ") -> ";
        return group;
    }
}
