package com.example.tareaLaptops.entities;


import jakarta.persistence.*;

@Entity
@Table(name="laptops")
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String color;
    private Double price;

    public Laptop() {
    }

    public Laptop(Long id, String marca, String color, Double price) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", marca='" + marca + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                '}';
    }
}
