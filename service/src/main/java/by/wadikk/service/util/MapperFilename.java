package by.wadikk.service.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class MapperFilename {

    @Value("${path.to}")
    String ppp;

    public String getFilename() {
        try {
            Properties prop = new Properties();
            File file = ResourceUtils.getFile("classpath:application.properties");
            FileInputStream fileInputStream = new FileInputStream(file);
            prop.load(fileInputStream);
            String phyPath = prop.getProperty("path.to");

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
