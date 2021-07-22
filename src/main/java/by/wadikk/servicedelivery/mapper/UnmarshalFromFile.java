package by.wadikk.servicedelivery.mapper;

import by.wadikk.servicedelivery.dao.XMLUserDao;
import by.wadikk.servicedelivery.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

@Slf4j
@Component
public class UnmarshalFromFile {

    public static List<User> unmarshalFromFile(String pathname) {
        File file  = new File(pathname);
        if (!(file.isFile())) {
            log.error("File no found on path " + pathname);
            return null;
        }

        if (pathname.endsWith(MapperEnum.JSON.toString().toLowerCase(Locale.ROOT))){
            return unmarshalJSONFile(pathname);
        }
        if (pathname.endsWith(MapperEnum.XML.toString().toLowerCase(Locale.ROOT))){
            return unmarshalXMLFile(pathname);
        }
        return null;


    }


    public static List<User> unmarshalXMLFile(String pathname) {

        XMLUserDao userList = new XMLUserDao();
        System.out.println("Start XML mapper from file");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLUserDao.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            userList = (XMLUserDao) jaxbUnmarshaller.unmarshal(new File(pathname));
            userList.getUsers().stream().forEach(System.out::println);
            return userList.getUsers();

        } catch (JAXBException e) {
            log.error(e.toString());
            System.out.println("Cannot parse to xml file ->" + pathname);
            return null;
        }
    }


    public static List<User> unmarshalJSONFile(String pathname) {
        List<User> userList = null;
        System.out.println("Start JSON mapper from file");
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            userList = objectMapper.readValue(
                    new File(pathname),
                    new TypeReference<List<User>>() {
                    });
        } catch (IOException e) {
            log.error(e.toString());
            System.out.println("Cannot parse to Json file ->" + pathname);
            return null;
        }
        userList.forEach(x -> System.out.println(x.toString()));
        return userList;
    }
}
