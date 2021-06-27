package by.wadikk.servicedelivery.todelete;

import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.model.Shop;
import by.wadikk.servicedelivery.model.WrapperForAmountPrice;
import by.wadikk.servicedelivery.service.ProductService;
import by.wadikk.servicedelivery.service.ShopService;
import by.wadikk.servicedelivery.todelete.ProductServiceImplOld;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ShopServiceImplOld {

    private static ShopService shopService;

    //private ProductService productService = new ProductServiceImplOld().getService();

    private List<Shop> shops = new ArrayList<Shop>();

    private static Integer idCount = 1;

    private ShopServiceImplOld() {
    }

    public static ShopService getService() {
        if (shopService == null) {
            //shopService = new ShopServiceImpl();
        }
        return shopService;
    }


    public List<Shop> getAllShops() {
        return shops;
    }


    public Shop getByName(String name) {
        return shops.stream().filter(u -> u.getName().equals(name)).findAny().orElse(null);
    }


    public Shop getById(Integer id) {
        return shops.stream().filter(u -> u.getId().equals(id)).findAny().orElse(null);
    }


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


    public Boolean editProductPriceAndAmountByShopId(Integer id, Product product, Integer amount, Integer price) {
        Shop shop = getById(id);
        if (shop == null) {
            log.info("Shop with id " + id + " not found");
            return false;
        }

        shop.getAmountAndPrice().put(product, new WrapperForAmountPrice(amount, price));
        log.info("Edit product price with product id-> ", product.getId());
        return true;
    }


    public Boolean createShop(String name, String description) {
        if (getByName(name) != null) {
            log.info("Error while trying to create new shop with name ->" + name + " : product name is exist");
            return false;
        }

        //shops.add(new Shop(idCount++, name, description));
        return true;
    }

}
