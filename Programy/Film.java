import java.util.*;
import javax.sql.rowset.serial.SerialBlob;
import java.time.LocalDate;

public class Film {
    private String title;
    private String director;
    private int year;
    private int price; // w groszach
    private List<String> genres;
    private String description;
    private SerialBlob poster;

    public Film(String g_title, String g_director, int g_year, int g_price, List<String> g_genres, String g_description,
            SerialBlob g_poster) {
        if (g_title == "") {
            throw new EmptyStringError("The title canot be empty.");
        }
        this.title = g_title;
        if (g_director == "") {
            throw new EmptyStringError("The director's name canot be empty.");
        }
        this.director = g_director;
        if (g_year > 1888 && g_year <= LocalDate.now().getYear()) {
            this.year = g_year;
        } else {
            throw new WrongReleaseYearExeption("The release year is either too early or later than current year.");
        }
        if (g_price <= 0) {
            throw new WrongPriceError("Price must be positive.");
        }
        price = g_price;
        if (g_genres.size() == 0) {
            throw new NoGenresError("Films must belong to at least one genre.");
        }
        genres = g_genres;
        description = g_description;
        poster = g_poster;
    } // g = given

    public String getTitle() {
        return this.title;
    }

    public String getDirector() {
        return this.director;
    }

    public int getYear() {
        return this.year;
    }

    public int getPrice() {
        return this.price;
    }

    public List<String> getGenres() {
        return this.genres;
    }

    public String getDescription() {
        return this.description;
    }

    public SerialBlob getPoster() {
        return this.poster;
    }

    // jedyne atrybuty, które mogą się zmieniać
    public void setPrice(int new_price) {
        if (price > 0) {
            this.price = new_price;
        }
    }

    public void setDescription(String new_description) {
        this.description = new_description;
    }

    public setPoster(SerialBlob new_poster) {
        this.poster = new_poster;
    s}
}
