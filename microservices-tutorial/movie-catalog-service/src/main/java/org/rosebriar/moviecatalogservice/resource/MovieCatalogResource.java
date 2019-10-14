package org.rosebriar.moviecatalogservice.resource;

import com.netflix.discovery.DiscoveryClient;
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
    private static final String RATINGS_DATA_SERVICE_URL = "http://ratings-data-service/ratingsdata/";
    private static final String RATINGS_DATA_SERVICE_USER_PATH = "user/";
    private static final String RATINGS_DATA_SERVICE_GET_USER = RATINGS_DATA_SERVICE_URL + RATINGS_DATA_SERVICE_USER_PATH;

    private static final String MOVIE_INFO_SERVICE_URL = "http://movie-info-service/movies/";

    private RestTemplate restTemplate;
    private MovieCatalogService movieCatalogService;

    public MovieCatalogResource(RestTemplate restTemplate, MovieCatalogService movieCatalogService) {
        this.restTemplate = restTemplate;
        this.movieCatalogService = movieCatalogService;
    }

    @RequestMapping("/{userId}")
    public UserRatingWithCatalog getCatalogItems(@PathVariable("userId") String userId) {

        // get user's catalog
        UserCatalog userCatalog = movieCatalogService.findUserCatalog(userId);

        // get user's ratings
        UserRating userRating = restTemplate.getForObject(RATINGS_DATA_SERVICE_GET_USER + userId, UserRating.class);

        // for each rated movie id, get move info & rating
        List<CatalogItem> catalogItems = userCatalog.getMovieIds().stream()
                .map(movieId -> {
                    MovieInfo movieInfo = restTemplate.getForObject(MOVIE_INFO_SERVICE_URL + movieId, MovieInfo.class);
                    Rating rating = restTemplate.getForObject(RATINGS_DATA_SERVICE_URL + movieId, Rating.class);
                    if(movieInfo != null && rating != null) {
                        return new CatalogItem(movieInfo.getName(), movieInfo.getDescription(), rating.getRating());
                    } else {
                        return new CatalogItem();
                    }
                })
                .collect(Collectors.toList());

        return new UserRatingWithCatalog(userRating, catalogItems);
    }
}
