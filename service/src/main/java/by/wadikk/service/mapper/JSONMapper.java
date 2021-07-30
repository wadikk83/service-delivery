package by.wadikk.service.mapper;


import by.wadikk.service.util.MapperFilename;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Collection;

@Slf4j
@Component
@PropertySource("classpath:application.properties")
@MapperMake(action = "JSON")
public class JSONMapper extends Mapper {

    @Value("${path.to}")
    private String pathToTest;

    @Override
    public Boolean parse(Class clazz, Collection list, String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

           // System.out.println(pathToTest);

            String pathTo = new MapperFilename().getFilename();
            if (pathTo == null) {
                log.error("Path to save is null");
                return false;
            }

            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(new File(pathTo + filename + ".json"), list);

            log.info("Parse collection to Json to file " + pathTo + filename + ".json");
            System.out.println("Parse collection to Json to file " + pathTo + filename + ".json");
            return true;

        } catch (Exception e) {
            log.error("Json writer error !!!!");
            log.error(e.toString());
            return false;
        }
    }
}
