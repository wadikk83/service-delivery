package by.wadikk.servicedelivery.mapper;


import org.reflections.Reflections;

import java.util.Set;

public class MapperFactory {
    public Mapper createMapper(String action) throws IllegalAccessException, InstantiationException {
        Mapper mapper = null;
        Reflections reflections = new Reflections("by.wadikk.servicedelivery");
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
