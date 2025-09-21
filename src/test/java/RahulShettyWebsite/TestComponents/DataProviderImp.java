package RahulShettyWebsite.TestComponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class DataProviderImp {

    public static List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        // JSON To String 'common.io'
        String jsonContent = FileUtils.readFileToString(new File(filePath));
        // String To HashMap 'Jackson Databind'
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent
                , new TypeReference<List<HashMap<String, String>>>() {
                });
        return data;
    }

    @DataProvider
    public static Object[][] getData () throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap("D:\\Testing\\Projects\\Automation\\Selenium\\SeleniumFrameworkDesign\\src\\main\\resources\\PurchaseOrder.json");
        return new Object[][] {{data.get(0)},{data.get(1)}};
    }
}
