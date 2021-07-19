package by.wadikk.servicedelivery.test;

public abstract class DAOFactory<T> {

    abstract public DAO<T> getDao(String type);
}
