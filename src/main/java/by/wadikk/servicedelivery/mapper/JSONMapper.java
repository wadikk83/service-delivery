package by.wadikk.servicedelivery.mapper;

import by.wadikk.servicedelivery.util.MapperFilename;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.Properties;

@Slf4j
@MapperMake(action = "JSON")
public class JSONMapper extends Mapper {
    @Override
    public Boolean parse(Class clazz, Collection list, String filename) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

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
