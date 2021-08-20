package entity.author;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorName {
    @JsonProperty("first")
    private String first;
    @JsonProperty("second")
    private String second;

    AuthorName(){}

    AuthorName(String first, String second){
        this.first=first;
        this.second=second;
    }

    @Override
    public String toString() {
        return "AuthorName{" +
                "first='" + first + '\'' +
                ", second='" + second + '\'' +
                '}';
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
}
