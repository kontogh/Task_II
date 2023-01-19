package pl.swies.service;

import pl.swies.container.CounterContainer;

import java.util.List;

public interface FileManager {

    String readFromFile();
    void saveToFile(List<CounterContainer> filledList);
}
