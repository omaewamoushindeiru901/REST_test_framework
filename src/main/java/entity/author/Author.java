package entity.author;

import com.fasterxml.jackson.annotation.JsonProperty;
import groovy.transform.ToString;


public class Author {

    @JsonProperty("authorId")
    private int authorId;
    @JsonProperty("authorName")
    private AuthorName authorName;
    @JsonProperty("nationality")
    private String nationality;
    @JsonProperty("birth")
    private Birth birth;
    @JsonProperty("authorDescription")
    private String authorDescription;

    public Author(){}

    public Author(int authorId, AuthorName authorName, String nationality, Birth birth, String authorDescription) {
        this.authorId=authorId;
        this.authorName=authorName;
        this.nationality = nationality;
        this.birth=birth;
        this.authorDescription=authorDescription;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", authorName=" + authorName +
                ", nationality='" + nationality + '\'' +
                ", birth=" + birth +
                ", authorDescription='" + authorDescription + '\'' +
                '}';
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public AuthorName getAuthorName() {
        return authorName;
    }

    public void setAuthorName(AuthorName authorName) {
        this.authorName = authorName;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Birth getBirth() {
        return birth;
    }

    public void setBirth(Birth birth) {
        this.birth = birth;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

    public void setAuthorDescription(String authorDescription) {
        this.authorDescription = authorDescription;
    }
}