package by.wadikk.service.mapper;

import javax.xml.bind.JAXBException;
import java.util.Collection;

public abstract class Mapper {

    public abstract Boolean parse(Class clazz, Collection list, String filename) throws JAXBException;
}
