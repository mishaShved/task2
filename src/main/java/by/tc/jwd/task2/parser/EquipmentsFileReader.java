package by.tc.jwd.task2.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EquipmentsFileReader {

    public static String[] readFile(String fileName) throws IOException {

        StringBuilder builder = new StringBuilder();


        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;

            while ((line = reader.readLine()) != null){
                builder.append(line).append("\n");
            }

        }

        return builder.toString().split("\n");
    }

    public static String getValue(String parameter, String appliance) {

        StringBuilder value = new StringBuilder();

        int i = appliance.indexOf(parameter) + parameter.length() + 1;

        while (appliance.toCharArray()[i] != ';' && appliance.toCharArray()[i] != '\n'
                && appliance.toCharArray()[i] != ',') {

            value.append(appliance.toCharArray()[i]);
            i++;

        }

        return value.toString();

    }
}
