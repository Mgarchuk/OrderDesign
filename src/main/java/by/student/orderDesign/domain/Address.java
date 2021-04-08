package by.student.orderDesign.domain;

public class Address {

    private final String country;
    private final String region;
    private final String district;
    private final String street;
    private final String numberOfHouse;
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

    public void setNumberOfFlat(String numberOfFlat) {
        this.numberOfFlat = numberOfFlat;
    }

    public void setNumberOfFlat(int numberOfFlat) {
        this.numberOfFlat = String.valueOf(numberOfFlat);
    }
}
