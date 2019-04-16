package be.tim.vercruysse.adventofcode.exercise15.input;

import com.google.common.collect.Lists;
import com.google.common.io.Resources;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    private String fileName;

    public FileReader(String fileName) {
        this.fileName = fileName;
    }

    public List<String> readFile(){
        return split(readInput(fileName));
    }

    private List<String> split(String input){
        return Lists.newArrayList(input.split("\n"))
                .stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private String readInput(String resourceName) {
        try {
            return Resources.toString(Resources.getResource(resourceName), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
