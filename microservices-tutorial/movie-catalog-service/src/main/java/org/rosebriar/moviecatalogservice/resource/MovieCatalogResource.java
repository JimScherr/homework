package org.rosebriar.moviecatalogservice.resource;

import org.rosebriar.moviecatalogservice.model.*;
import org.rosebriar.moviecatalogservice.service.MovieCatalogService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    private RestTemplate restTemplate;
    private MovieCatalogService movieCatalogService;

    public MovieCatalogResource(RestTemplate restTemplate, MovieCatalogService movieCatalogService) {
        this.restTemplate = restTemplate;
        this.movieCatalogService = movieCatalogService;
    }

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalogItems(@PathVariable("userId") String userId) {

        // get user's catalog
        UserCatalog userCatalog = movieCatalogService.findUserCatalog(userId);

        // get user's ratings
        UserRating userRating = restTemplate.getForObject("http://localhost:8083/ratingsdata/user/" + userId, UserRating.class);

        // for each rated movie id, get move info & rating
        return userCatalog.getMovieIds().stream()
                .map(movieId -> {
                    MovieInfo movieInfo = restTemplate.getForObject("http://localhost:8082/movies/" + movieId, MovieInfo.class);
                    Rating rating = restTemplate.getForObject("http://localhost:8083/ratingsdata/" + movieId, Rating.class);
                    if(movieInfo != null && rating != null) {
                        return new CatalogItem(movieInfo.getName(), movieInfo.getDescription(), rating.getRating());
                    } else {
                        return new CatalogItem();
                    }
                })
                .collect(Collectors.toList());
    }


}
