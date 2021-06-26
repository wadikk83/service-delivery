package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Shop;
import by.wadikk.servicedelivery.model.User;
import by.wadikk.servicedelivery.service.ShopService;
import by.wadikk.servicedelivery.service.UserService;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ShopServiceImpl implements ShopService {

    private static ShopService shopService;

    private List<Shop> shops = new ArrayList<Shop>();

    private ShopServiceImpl() {
        shops.add(new Shop(1, "Shop1", "My super shop 1", null));
        shops.add(new Shop(2, "Shop2", "My super shop 1", null));
        log.info("Create shop service with shops" + shops.toString());
    }

    public static ShopService getService() {
        if (shopService == null) {
            shopService = new ShopServiceImpl();
        }
        return shopService;
    }


    @Override
    public List<Shop> getAllShops() {
        return shops;
    }

    @Override
    public Shop getByName(String name) {
        return shops.stream().filter(u -> u.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public Boolean deleteShop(Integer id) {
        Shop toBeDeleted = shops.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeDeleted != null) {
            shops.remove(toBeDeleted);
            log.info("Detele shop " + toBeDeleted);
            return true;
        }
        log.info("Shop with id " + id + " can't be deleted - shop not found");
        return false;
    }

    @Override
    public Shop editShopById(Integer id, String name, String description) {
        if (id == null) return null;
        Shop toBeEdit = shops.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
        if (toBeEdit != null) {
            log.info("Edit shop " + toBeEdit);
            toBeEdit.setName(name);
            toBeEdit.setDescription(description);
            log.info("Shop after edit " + toBeEdit);
            return toBeEdit;
        }
        log.info("Shop with id " + id + " not found");
        return null;
    }

}
