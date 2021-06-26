package by.wadikk.servicedelivery.util;

import by.wadikk.servicedelivery.model.User;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Properties;

@Slf4j
public class JsonUtil {

    public void parseJsonListToFile(Collection list, String filename) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            FileInputStream fileInputStream;
            //инициализируем специальный объект Properties
            //типа Hashtable для удобной работы с данными
            Properties prop = new Properties();
            //обращаемся к файлу и получаем данные
            fileInputStream = new FileInputStream("src/main/resources/config.properties");
            prop.load(fileInputStream);

            String phyPath = prop.getProperty("phyPath");
            String filepath = phyPath + filename + ".json";


            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(filepath), list);

            log.info("Parse collection to Json to file " + filepath);

        } catch (Exception e) {
            log.error("Json writer error !!!!");
            log.error(e.toString());
        }
    }


}