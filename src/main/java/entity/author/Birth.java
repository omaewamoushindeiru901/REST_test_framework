package entity.author;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Birth {

    @JsonProperty("date")
    private String date;
    @JsonProperty("country")
    private String country;
    @JsonProperty("city")
    private String city;

    public Birth(){}

    public Birth(String date, String country,String city) {
        this.date = date;
        this.country=country;
        this.city=city;
    }

    @Override
    public String toString() {
        return "Birth{" +
                "date='" + date + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
