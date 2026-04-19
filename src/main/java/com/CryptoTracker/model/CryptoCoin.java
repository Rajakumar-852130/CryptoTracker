package com.example.demo.model;


public class CryptoCoin {
    private String id;
    private String name;
    private double price;
    private double change24h;

    // Constructors
    public CryptoCoin() {}
    public CryptoCoin(String id, String name, double price, double change24h) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.change24h = change24h;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public double getChange24h() { return change24h; }
    public void setChange24h(double change24h) { this.change24h = change24h; }
}