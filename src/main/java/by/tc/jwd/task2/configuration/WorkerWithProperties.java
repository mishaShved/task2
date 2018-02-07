package by.tc.jwd.task2.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WorkerWithProperties {

    private static WorkerWithProperties ourInstance;
    private String fileName;


    private WorkerWithProperties() throws IOException{

        Properties props = new Properties();
        props.load(new FileInputStream(new File("src/main/resources/properties.ini")));
        fileName = props.getProperty("SHOP_FILE_NAME");

    }

    public static WorkerWithProperties getOurInstance() throws IOException{

        if (ourInstance == null) {
            return ourInstance = new WorkerWithProperties();
        }else {
            return ourInstance;
        }
    }

    public String getShopFileName() {
        return fileName;
    }

}
