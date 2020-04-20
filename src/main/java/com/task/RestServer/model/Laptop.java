package com.task.RestServer.model;

import javax.persistence.*;

@Entity
@Table(name = "laptop")
public class Laptop {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    public Laptop() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
