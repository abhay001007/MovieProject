package kumar.abhay.movieproject.entity;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private  String movieName;
    private String movieDescription;
    private String releaseDate;

    public Movie(String movieName, String movieDescription, String releaseDate) {
        this.movieName = movieName;
        this.movieDescription = movieDescription;
        this.releaseDate = releaseDate;
    }
}
