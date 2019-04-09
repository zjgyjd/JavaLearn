package com.github.zjgyjd.generic;

import java.util.ArrayList;
import java.util.Random;

class Product {
    private final int id;//不可更改的id
    private String description;//描述
    private double price;//价格

    public Product(int IDnumber, String descr, double price) {
        id = IDnumber;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }

    public String toString() {
        return id + ": " + description + ",price: $" + price;
    }

    public void priceChange(double change) {
        price += change;//加价格
    }

    public static Generator<Product> generator = new Generator<Product>() {
        private Random rand = new Random(47);

        @Override
        public Product next() {
            return new Product(rand.nextInt(1000), "Test", Math.round(rand.nextDouble() * 1000.0) + 0.99);
        }//随机生成一个对象
    };
}

class Shelf extends ArrayList<Product> {
    public Shelf(int nProducts) {
        Generators.fill(this, Product.generator, nProducts);//利用集合建立n个对象并用数组储存
    }//同一个架子
}

class Aisle extends ArrayList<Shelf> {//继承ArrayList//代表商店的货架

    public Aisle(int nShelves, int nProducts) {//架子和商品
        for (int i = 0; i < nShelves; i++) {
            add(new Shelf(nProducts));//很多架子和商品
        }
    }
}

class CheckoutStand {
}

class Office {
}

public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts = new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisle, int nShelves, int nProducts) {
        for (int i = 0; i < nAisle; i++) {
            add(new Aisle(nShelves, nProducts));//向商店过道里加商品
        }
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Aisle a : this) {
            for (Shelf s : a) {
                for (Product p : s) {
                    result.append(p);
                    result.append("\n");
                }
            }
        }
        return result.toString();//打印商品信息
    }

    public static void main(String[] args) {
        System.out.println(new Store(14,5,10));//14个过道,每个5个货架,每个货架10件商品
    }
}
