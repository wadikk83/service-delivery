package by.wadikk.servicedelivery;

import java.util.*;

public class Test {


    public static void main(String[] args) {

        PriceParamsOfProduct priceParamsOfProduct = new PriceParamsOfProduct(new Price("Opt", 0),
                new Price("retail Price", 0));
        Product.setPriceParameters(priceParamsOfProduct);
        Product product1 = new Product("Pr#1", 10, 20);
        Product product2 = new Product("Pr#2", 30, 40);
    }


}

interface Priceable {
    Set<Price> getAllPriceParam();

    List<Price> getPriceParamByName(String namePriceParam);

    int getCountPriceParams();
}

class Product {
    private static Priceable priceParameters;
    private String name;
    private float shelfLife; // в днях
    private List<Price> pricesThisProd = new ArrayList<>();

    public Product(String name, float shelfLife, int... pricesIn) {
        this.name = name;
        this.shelfLife = shelfLife;
        this.pricesThisProd.addAll(priceParameters.getAllPriceParam());
        int ind = 0;
        for (int tmpPrise : pricesIn) {
            pricesThisProd.get(ind).setVal(tmpPrise);
            ind++;
        }

    }

    public Product(String name, int... pricesIn) {
        this.name = name;
        this.shelfLife = Integer.MAX_VALUE;
        this.pricesThisProd.addAll(priceParameters.getAllPriceParam());
        int ind = 0;
        for (int tmpPrise : pricesIn) {
            pricesThisProd.get(ind).setVal(tmpPrise);
            ind++;
        }
    }

    public static void setPriceParameters(Priceable priceShem) {
        priceParameters = priceShem;
    }
}

class Price {
    private String name;
    private int val; // для простоты

    public Price(String name, int val) {
        this.name = name;
        this.val = val;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return val == price.val &&
                Objects.equals(name, price.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, val);
    }

    public String getName() {
        return name;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Price{" +
                "name='" + name + '\'' +
                ", val=" + val +
                '}';
    }
}

class PriceParamsOfProduct implements Priceable {
    private Set<Price> priceList = new HashSet<>();

    public PriceParamsOfProduct(Price... prices) {
        Collections.addAll(priceList, prices);
    }

    private void addPrceParam(Price newParam) {
        priceList.add(newParam);
    }

    @Override
    public Set<Price> getAllPriceParam() {
        return priceList;
    }

    @Override
    public List<Price> getPriceParamByName(String namePriceParam) {
        List<Price> priceListName = new ArrayList<>();
        priceList.stream()
                .filter(price -> namePriceParam.equals(price.getName()))
                .forEach(priceListName::add);
        return priceListName;
    }

    @Override
    public int getCountPriceParams() {
        return priceList.size();
    }
}

