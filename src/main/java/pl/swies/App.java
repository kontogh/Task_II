package pl.swies;

import pl.swies.service.VowelsCounter;
import pl.swies.service.VowelsCounterImpl;

public class App
{
    public static void main(String[] args )
    {
        String fileIn = args.length == 2 ? args[0] : null;
        String fileOut = args.length == 2 ? args[1] : null;
        VowelsCounter vowelsCounter = new VowelsCounterImpl(fileIn, fileOut);
        vowelsCounter.calculateVowels();
    }
}
