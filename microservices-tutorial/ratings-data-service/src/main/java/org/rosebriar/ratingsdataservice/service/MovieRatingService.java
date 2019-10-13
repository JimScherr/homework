package org.rosebriar.ratingsdataservice.service;

import org.rosebriar.ratingsdataservice.model.Rating;
import org.rosebriar.ratingsdataservice.model.UserRating;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class MovieRatingService {
    public Rating findMovieRating(String movieId) {
        switch (movieId) {
            case "abc123":
                return new Rating(movieId, 4);
            case "def456":
                return new Rating(movieId, 5);
            case "emma":
                return new Rating(movieId, 8);
            case "pnp":
                return new Rating(movieId, 10);
            default:
                return new Rating(movieId, -1);
        }
    }

    public UserRating findUserRatings(String userId) {
        UserRating userRating = new UserRating();
        userRating.setUserId(userId);
        switch (userId) {
            case "jims":
                userRating.setRatings(Arrays.asList(
                        new Rating("abc123", 4),
                        new Rating("def456", 5)
                ));
                break;
            case "julies":
                userRating.setRatings(Arrays.asList(
                        new Rating("emma", 10),
                        new Rating("pnp", 10)
                ));
                break;
            default:
                userRating.setRatings(Collections.EMPTY_LIST);
        }
        return userRating;
    }
}
