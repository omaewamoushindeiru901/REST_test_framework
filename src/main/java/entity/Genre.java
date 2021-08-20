package entity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Genre {
    @JsonProperty("genreId")
    private int genreId;
    @JsonProperty("genreName")
    private String genreName;
    @JsonProperty("genreDescription")
    private String genreDescription;

    public Genre(){}

    public Genre(int genreId, String genreName, String genreDescription) {
        this.genreId = genreId;
        this.genreName=genreName;
        this.genreDescription=genreDescription;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genreId=" + genreId +
                ", genreName='" + genreName + '\'' +
                ", genreDescription='" + genreDescription + '\'' +
                '}';
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public String getGenreDescription() {
        return genreDescription;
    }

    public void setGenreDescription(String genreDescription) {
        this.genreDescription = genreDescription;
    }


}
