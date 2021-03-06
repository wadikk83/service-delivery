package by.wadikk.servicedelivery.service.impl;

import by.wadikk.servicedelivery.model.Product;
import by.wadikk.servicedelivery.model.Shop;
import by.wadikk.servicedelivery.model.WrapperForAmountPrice;
import by.wadikk.servicedelivery.repository.ShopRepository;
import by.wadikk.servicedelivery.repository.impl.ShopRepositoryImpl;
import by.wadikk.servicedelivery.service.ShopService;
import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class ShopServiceImpl implements ShopService {

    private ShopRepository shopRepository = new ShopRepositoryImpl().getService();

    @Override
    public List<Shop> getAllShops() {
        return shopRepository.getAll();
    }

    @Override
    public Shop getByName(String name) {
        return shopRepository.findByName(name);
    }

    @Override
    public Shop getById(Integer id) {
        return shopRepository.findById(id);
    }

    @Override
    public Boolean deleteShop(Integer id) {
        return shopRepository.deleteById(id);
    }

    @Override
    public Shop editShopById(Integer id, String name, String description) {
        Shop shop = shopRepository.findById(id);
        shop.setName(name);
        shop.setDescription(description);
        return shopRepository.updateShop(shop);
    }

    @Override
    public Boolean editProductPriceAndAmountByShopId(Integer id, Product product, Integer amount, Integer price) {
        Shop shop = shopRepository.findById(id);
        if (shop == null) {
            log.info("Shop with id " + id + " not found");
            return false;
        }

        shop.getAmountAndPrice().put(product, new WrapperForAmountPrice(amount, price));
        log.info("Edit product price with product id-> ", product.getId());
        return true;
    }

    @Override
    public Shop createShop(String name, String description) {
        Shop shop = new Shop(name, description);
        return shopRepository.addShop(shop);

    }

    @Override
    public Shop sortedProductByPrice(Integer id) {
        Shop shop = shopRepository.findById(id);
        Map<Product, WrapperForAmountPrice> mapToSort = shop.getAmountAndPrice();

        /*mapToSort.entrySet().stream()
                .sorted(Comparator.<Map.Entry<Product, WrapperForAmountPrice>, Integer>
                        comparing(e -> e.getValue().getPrice()).reversed()
                        .thenComparing((Comparator<? super Map.Entry<Product, WrapperForAmountPrice>>) Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));*/
        return null;
    }
}
