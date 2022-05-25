package com.example.carsappproject.Entities;

import java.net.URI;

public  class Ad {
    private String carBrand;
    private String carModel;
    private String registrationNumber,price,city;
    private boolean forRental=false;
    private String urlImage;
    private String userUid;

    public Ad() {
    }

    public Ad(String carBrand, String carModel, String registrationNumber, String price, String city, boolean forRental, String urlImage, String userUid) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.city = city;
        this.forRental = forRental;
        this.urlImage = urlImage;
        this.userUid = userUid;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public Ad(String carBrand, String carModel, String price) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.price = price;
    }

    public Ad(String carBrand, String carModel, String registrationNumber, String price, String city, boolean forRental, String urlImage) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.city = city;
        this.forRental = forRental;
        this.urlImage = urlImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public Ad(String carBrand, String carModel, String registrationNumber, String price, String city, boolean forRental) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.registrationNumber = registrationNumber;
        this.price = price;
        this.city = city;
        this.forRental = forRental;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isForRental() {
        return forRental;
    }

    public void setForRental(boolean forRental) {
        this.forRental = forRental;
    }

    public Ad(String urlImage) {
        this.urlImage = urlImage;
    }
}
