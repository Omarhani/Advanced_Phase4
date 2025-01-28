package reader;

import com.google.gson.Gson;
import data.DataModel;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadDataFromJson {

    public DataModel readJsonFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader("data/testData.json");

        DataModel dataModel = new Gson().fromJson(fileReader, DataModel.class);

        return dataModel;
    }

    public static DataModel dataModel() throws FileNotFoundException {
        ReadDataFromJson readDataFromJson = new ReadDataFromJson();
        return readDataFromJson.readJsonFile();
    }
}
