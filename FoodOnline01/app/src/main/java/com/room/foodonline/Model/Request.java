package com.room.foodonline.Model;

import java.util.List;

public class Request {

    private String phone;
    private String name;
    private String addres;
    private String total;
    private String status;
    private List<Order> foods;

    public Request() {
    }

    public Request(String phone, String name, String addres, String total, List<Order> foods) {
        this.phone = phone;
        this.name = name;
        this.addres = addres;
        this.total = total;
        this.foods = foods;
        this.status = "0";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
