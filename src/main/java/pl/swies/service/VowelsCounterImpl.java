package pl.swies.service;

import pl.swies.container.CharacterType;
import pl.swies.container.CounterContainer;
import pl.swies.container.DistinctGroup;
import java.util.LinkedList;
import java.util.Optional;

public class VowelsCounterImpl implements VowelsCounter {

    private static final String VOWELS = "aeiouy";
    private static final String CONSTANTS = "bcdfgjklmnpqstvxzhrw";
    private FileManager fileManager;
    LinkedList<CounterContainer> list;

    public VowelsCounterImpl(String infile, String outfile) {
        list = new LinkedList<>();
        fileManager = new FileMangerOperations(infile, outfile);
    }


    @Override
    public void calculateVowels() {

        String data = fileManager.readFromFile();
        if (data == null || data.isEmpty())
            return;
        DistinctGroup group = new DistinctGroup();
        int wordVowels = 0;
        boolean firstReset = false;
        for (int i = 0; i < data.length(); i++) {
            String ch = String.valueOf(data.charAt(i));
            if (checkLetter(ch) == CharacterType.OTHER) {
                if (firstReset) {
                    updateTotalList(group, wordVowels);
                    group = new DistinctGroup();
                    wordVowels = 0;
                    firstReset = false;
                }
            } else if (checkLetter(ch) == CharacterType.VOWEL) {
                firstReset = true;
                wordVowels++;
                group.updateSet(ch);
                group.increaseLength();

            } else {
                group.increaseLength();
                firstReset = true;
            }
        }
        fileManager.saveToFile(list);
    }

    /**
     * Update collection with CounterContainers after checking another word
     */
    private void updateTotalList(DistinctGroup dgroup, int wordVowels) {
        Optional<CounterContainer> container = list.stream()
                .filter(cnt -> cnt.compareGroups(dgroup))
                .findFirst();
        if (container.isPresent())
            container.get().increaseCount(wordVowels);
        else {
            CounterContainer cc = new CounterContainer(dgroup);
            cc.increaseCount(wordVowels);
            list.add(cc);
        }
    }

    /**
     * Check kind of the given character
     *
     * @param letter (String) character
     * @return (CharacterType)
     */
    private CharacterType checkLetter(String letter) {
        if (VOWELS.contains(letter))
            return CharacterType.VOWEL;
        else if (CONSTANTS.contains(letter))
            return CharacterType.CONSTANT;
        else return CharacterType.OTHER;
    }
}
