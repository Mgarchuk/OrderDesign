package by.student.orderDesign.domain;

public class Address {

    private String country;
    private String region;
    private String district;
    private String street;
    private String numberOfHouse;
    private String numberOfFlat;

    public Address(String country, String region, String district, String street, String numberOfHouse) {
        this.country = country;
        this.region = region;
        this.district = district;
        this.street = street;
        this.numberOfHouse = numberOfHouse;
    }

    public Address(String country, String region, String district, String street, String numberOfHouse, String numberOfFlat) {
        this(country, region, district, street, numberOfHouse);
        this.numberOfFlat = numberOfFlat;
    }

    public Address(String country, String region, String district, String street, int numberOfHouse) {
        this(country, region, district, street, String.valueOf(numberOfHouse));
    }

    public Address(String country, String region, String district, String street, int numberOfHouse, int numberOfFlat) {
        this(country, region, district, street, String.valueOf(numberOfHouse), String.valueOf(numberOfFlat));
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getDistrict() {
        return district;
    }

    public String getStreet() {
        return street;
    }

    public String getNumberOfHouse() {
        return numberOfHouse;
    }

    public String getNumberOfFlat() {
        return numberOfFlat;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumberOfHouse(String numberOfHouse) {
        this.numberOfHouse = numberOfHouse;
    }

    public void setNumberOfHouse(int numberOfHouse) {
        this.numberOfHouse = String.valueOf(numberOfHouse);
    }

    public void setNumberOfFlat(String numberOfFlat) {
        this.numberOfFlat = numberOfFlat;
    }

    public void setNumberOfFlat(int numberOfFlat) {
        this.numberOfFlat = String.valueOf(numberOfFlat);
    }
}
