package by.wadikk.service.service.impl;

import by.wadikk.repository.ShopRepository;
import by.wadikk.repository.model.Product;
import by.wadikk.repository.model.Shop;
import by.wadikk.service.service.ShopService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

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
        // TODO: 17.07.2021 Rewrite this method
        /*Shop shop = shopRepository.findById(id);
        if (shop == null) {
            log.info("Shop with id " + id + " not found");
            return false;
        }

        shop.getAmountAndPrice().put(product, new WrapperForAmountPrice(amount, price));
        log.info("Edit product price with product id-> ", product.getId());*/
        return true;
    }

    @Override
    public Shop createShop(String name, String description) {
        // TODO: 17.07.2021 Rewrite this method
        /*Shop shop = new Shop(name, description);
        return shopRepository.addShop(shop);*/
        return null;
    }

    @Override
    public Shop sortedProductByPrice(Integer id) {
        Shop shop = shopRepository.findById(id);
        //Map<Product, WrapperForAmountPrice> mapToSort = shop.getAmountAndPrice();

        /*mapToSort.entrySet().stream()
                .sorted(Comparator.<Map.Entry<Product, WrapperForAmountPrice>, Integer>
                        comparing(e -> e.getValue().getPrice()).reversed()
                        .thenComparing((Comparator<? super Map.Entry<Product, WrapperForAmountPrice>>) Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));*/
        return null;
    }
}
