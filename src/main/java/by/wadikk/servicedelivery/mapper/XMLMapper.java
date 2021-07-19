package by.wadikk.servicedelivery.mapper;

import by.wadikk.servicedelivery.dao.XMLUserDao;
import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.util.MapperFilename;
import lombok.extern.slf4j.Slf4j;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.Collection;
import java.util.List;

@Slf4j
@MapperMake(action = "XML")
public class XMLMapper extends Mapper {
    @Override
    public Boolean parse(Class clazz, Collection list, String filename) {

        XMLUserDao listUser = new XMLUserDao();
        listUser.setUsers((List<User>) list);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(XMLUserDao.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            String pathTo = new MapperFilename().getFilename();
            if (pathTo == null) {
                log.error("Path to save is null");
                return false;
            }
            marshaller.marshal(listUser, new File(pathTo + filename + ".xml"));
            //marshaller.marshal(listUser, System.out);
            //marshaller.marshal(daoList, System.out);
            log.info("Parse collection to XML to file " + pathTo + filename + ".xml");
            System.out.println("Parse collection to XML to file " + pathTo + filename + ".xml");
            return true;
        } catch (JAXBException e) {
            System.out.println("XML writer error !!!!");
            System.out.println(e.toString());
            log.error("XML writer error !!!!");
            log.error(e.toString());
            return false;
        }
    }
}
