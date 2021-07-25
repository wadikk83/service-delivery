package by.wadikk.service.mapper;


import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MapperFactory {
    public Mapper createMapper(String action) throws IllegalAccessException, InstantiationException {
        Mapper mapper = null;
        Reflections reflections = new Reflections("by.wadikk");
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(MapperMake.class);


        for (Class<?> clazz : annotated) {

            MapperMake mapperMake = clazz.getAnnotation(MapperMake.class);
            if (action.equals(mapperMake.action())) {
                mapper = (Mapper) clazz.newInstance();
            }
        }
        return mapper;
    }
}
