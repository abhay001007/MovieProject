package kumar.abhay.movieproject.repository;

import kumar.abhay.movieproject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository <Movie,Integer> {

    public Movie findMovieByMovieName (String movieName);
    }


