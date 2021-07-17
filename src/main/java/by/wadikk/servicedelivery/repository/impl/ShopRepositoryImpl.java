package by.wadikk.servicedelivery.repository.impl;

import by.wadikk.servicedelivery.model.Shop;
import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.repository.ShopRepository;
import by.wadikk.servicedelivery.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ShopRepositoryImpl implements ShopRepository {

    private static ShopRepository shopRepository;

    private List<Shop> shops = new ArrayList<Shop>();

    private static Integer idCount = 1;

    public ShopRepositoryImpl() {
    }

    //singleton
    public static ShopRepository getService() {
        if (shopRepository == null) {
            shopRepository = new ShopRepositoryImpl();
        }
        return shopRepository;
    }

    @Override
    public Shop findById(Integer id) {
        return shops.stream()
                .filter(u -> u.getId().equals(id))
                .findAny()
                .orElse(null);
    }

    @Override
    public Shop findByName(String shopName) {
        return shops.stream()
                .filter(u -> u.getName().equals(shopName))
                .findAny()
                .orElse(null);
    }

    @Override
    public Shop addShop(Shop shop) {
        shop.setId(idCount++);
        shops.add(shop);
        log.info("Add new shop ->" + shop);
        return shop;
    }

    @Override
    public Shop updateShop(Shop shop) {

        // TODO: 17.07.2021 Rewrite this method
        /*for (Shop sh : shops) {
            if (sh.getId().equals(shop.getId()) || sh.getName().equals(shop.getName())) {
                sh.setDescription(sh.getDescription());
                sh.setAmountAndPrice(sh.getAmountAndPrice());
                log.info("Update shop with id -> " + sh.getId() + " and name->" + sh.getName());
                return sh;
            }
        }
        log.info("Can't update user with id -> " + shop.getId() + " and name->" + shop.getName());*/
        return null;
    }

    @Override
    public Boolean deleteById(Integer id) {
        Shop toBeDeleted = findById(id);
        if (toBeDeleted != null) {
            shops.remove(toBeDeleted);
            log.info("Detele shop " + toBeDeleted);
            return true;
        }
        log.info("Shop with id " + id + " can't be deleted - user not found");
        return false;
    }

    @Override
    public List<Shop> getAll() {
        return shops;
    }
}
