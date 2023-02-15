package kumar.abhay.movieproject.controller;
import kumar.abhay.movieproject.entity.Movie;
import kumar.abhay.movieproject.execption.ResourceNotFoundException;
import kumar.abhay.movieproject.sevice.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping(value = "/movie")
public class MovieController {
  @Autowired MovieService service;


  @RequestMapping(value = "getAllMovies", method = RequestMethod.GET)
  public List<Movie> getAllMovie() {
    return  service.getAllMovie();
  }

  @RequestMapping(value = "addMovie", method = RequestMethod.POST)
  public Movie addMovie(
      @RequestHeader(value = "userPrivilege") String userPrivilege, @RequestBody Movie movie) {
    return service.addMovie(userPrivilege, movie);
  }

  @RequestMapping(value = "getMovie/{id}", method = RequestMethod.GET)
  public ResponseEntity<Movie> getMovieById(@PathVariable("id") int id) {
    Optional<Movie> movie = service.getMovieById(id);
    Movie movie2 =
        movie.orElseThrow(
            () -> new ResourceNotFoundException("User with ID :" + id + " Not Found!"));
    return ResponseEntity.ok().body(movie2);
    //      if(movie==null){
    //          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    //
    //      }
    //      else
    //          return new ResponseEntity<>(movie,HttpStatus.OK);

  }

  @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
  public void deleteMovieById(@PathVariable("id") int id) {
    service.deleteMovie(id);
  }

  @RequestMapping(value = "deleteAll", method = RequestMethod.DELETE)
  public void deleteAllMovie() {
    service.deleteAllMovie();
  }

  @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
  public void updateMovieByIdByPut(@PathVariable("id") int id, @RequestBody Movie movie) {
    service.updateMovieByPut(id, movie);
  }

  @RequestMapping(value = "update/{id}", method = RequestMethod.PATCH)
  public Movie updateMovieById(@PathVariable("id") int id, @RequestBody Movie movie) {
    return service.updateMovie(id, movie);
  }
}
