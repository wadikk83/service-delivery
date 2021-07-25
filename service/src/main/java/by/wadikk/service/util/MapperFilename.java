package by.wadikk.service.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Slf4j
@Component
public class MapperFilename {
    public String getFilename() {
        try {
            Properties prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream("resources/config.properties");
            prop.load(fileInputStream);
            String phyPath = prop.getProperty("phyPath");
            return phyPath;
        } catch (FileNotFoundException exception) {
            log.error("FileNotFoundException !!!!");
            log.error(exception.toString());
            return null;
        } catch (IOException e) {
            log.error("IOException !!!!");
            log.error(e.toString());
            return null;
        }
    }
}
