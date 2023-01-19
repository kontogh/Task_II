package pl.swies.service;

import pl.swies.container.CounterContainer;

import java.io.*;
import java.util.List;

public class FileMangerOperations implements FileManager {

    private String inputFile;
    private String outputFile;

    public FileMangerOperations(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    @Override
    public String readFromFile() {
        StringBuilder sb = new StringBuilder();
        if (inputFile == null)
            inputFile = FileMangerOperations.class.getClassLoader().getResource("INPUT.txt").getFile().replace("%20", " ").replace("!", "");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile))) {

            String line = fileReader.readLine();
            while (line != null) {
                sb.append(line.toLowerCase());
                line = fileReader.readLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
        return sb.toString();
    }

    @Override
    public void saveToFile(List<CounterContainer> filledList) {
        if (outputFile == null)
            outputFile = FileMangerOperations.class.getClassLoader().getResource("OUTPUT.txt").getFile().replace("%20", " ").replace("!","");
        try (BufferedWriter fileReader = new BufferedWriter(new FileWriter(outputFile))) {
            for (CounterContainer cc : filledList) {
                System.out.println(cc.createLine());
                fileReader.append(cc.createLine());
                fileReader.newLine();
            }
        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }
}
