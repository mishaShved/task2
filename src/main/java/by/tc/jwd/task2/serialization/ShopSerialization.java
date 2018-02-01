package by.tc.jwd.task2.serialization;

import by.tc.jwd.task2.configuration.WorkerWithProperties;
import by.tc.jwd.task2.entity.Shop;
import by.tc.jwd.task2.exception.PropertyFileNotFoundException;
import by.tc.jwd.task2.exception.WorkWithDataSourceException;

import java.io.*;

public class ShopSerialization {

    private static String file;

    static {
        try {
            file = WorkerWithProperties.getOurInstance().getShopFileName();
        } catch (IOException e) {
            file = null;
        }
    }

    public static Shop read() throws WorkWithDataSourceException, PropertyFileNotFoundException {

        Shop shop = null;

        try(ObjectInputStream stream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            shop = (Shop) stream.readObject();
        }catch (IOException | ClassNotFoundException e){
            throw new WorkWithDataSourceException(e);
        }catch (NullPointerException e){
            throw new PropertyFileNotFoundException();
        }

        return shop;
    }


    public static void write(Shop shop) throws WorkWithDataSourceException, PropertyFileNotFoundException {

        try(ObjectOutputStream stream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
            stream.writeObject(shop);
        }catch (IOException e){
            throw new WorkWithDataSourceException(e);
        }catch (NullPointerException e){
            throw new PropertyFileNotFoundException();
        }

    }
}
