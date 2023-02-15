package kumar.abhay.movieproject.sevice;
import kumar.abhay.movieproject.entity.Movie;
import kumar.abhay.movieproject.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class MovieService {
  @Autowired MovieRepository repo;

  public List<Movie> getAllMovie() {
    return repo.findAll();
  }
public Optional<Movie> getMovieById(int id) {
  return repo.findById(id);
}

  public Movie addMovie(String userPrivilege, Movie movie) {
    if (!userPrivilege.equals("admin")
        || movie.getMovieName().length() > 20
        || repo.findMovieByMovieName(movie.getMovieName()) != null) {
      logger.info(
          "Either your are not an Admin or movie name is already exists or either the movie name is too long");
      return null;
    }
    repo.save(movie);
    return movie;
  }

  public void deleteMovie(int id) {
    repo.deleteById(id);
  }

  public void deleteAllMovie() {
    repo.deleteAll();
  }

  public void updateMovieByPut(int id, Movie movie) {
    if (movie.getId() != id || getMovieById(id) == null) {
    } else {
           repo.save(movie);
    }
  }

  public Movie updateMovie(int id, Movie movie) {
    if (getMovieById(id) == null) {
      logger.info("Movie doesn't exits");
      return null;
    } else {
      Movie movie1 = repo.findById(id).get();
      if (movie.getMovieName() != null) {
        movie1.setMovieName(movie.getMovieName());
      }
      if (movie.getMovieDescription() != null) {
        movie1.setMovieDescription(movie.getMovieDescription());
      }
      if (movie.getReleaseDate() != null) {
              movie1.setReleaseDate(movie.getReleaseDate());
      }
      return repo.save(movie1);
    }
  }
  private Logger logger = LoggerFactory.getLogger(this.getClass());
}
