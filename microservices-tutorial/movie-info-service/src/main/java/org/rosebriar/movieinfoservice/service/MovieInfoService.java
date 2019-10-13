package org.rosebriar.movieinfoservice.service;

import org.rosebriar.movieinfoservice.model.MovieInfo.MovieInfo;
import org.springframework.stereotype.Service;

@Service
public class MovieInfoService {

    public MovieInfo findMovieInfo(String id) {
        switch (id) {
            case "abc123":
                return new MovieInfo(id, "Transformers", "Krazy Kars");
            case "def456":
                return new MovieInfo(id, "It Happened On The Way To The Forum", "Zany Comedy");
            case "emma":
                return new MovieInfo(id, "Emma", "Coming of age story by Jane Austen");
            case "pandp":
                return new MovieInfo(id, "Pride and Prejudice", "The classic Jane Austen");
            default:
                return new MovieInfo("-1", "no movie found", "nothing");
        }
    }
}
