package org.rosebriar.ratingsdataservice.resource;

import org.rosebriar.ratingsdataservice.model.Rating;
import org.rosebriar.ratingsdataservice.model.UserRating;
import org.rosebriar.ratingsdataservice.service.MovieRatingService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {
    private MovieRatingService movieRatingService;

    public RatingsDataResource(MovieRatingService movieRatingService) {
        this.movieRatingService = movieRatingService;
    }

    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId) {
        return movieRatingService.findMovieRating(movieId);
    }

    @RequestMapping("/user/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        return movieRatingService.findUserRatings(userId);
    }
}
