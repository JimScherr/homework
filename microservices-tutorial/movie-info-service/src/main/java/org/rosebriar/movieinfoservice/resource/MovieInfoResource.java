package org.rosebriar.movieinfoservice.resource;

import org.rosebriar.movieinfoservice.model.MovieInfo.MovieInfo;
import org.rosebriar.movieinfoservice.service.MovieInfoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieInfoResource {
    private MovieInfoService movieInfoService;

    public MovieInfoResource(MovieInfoService movieInfoService) {
        this.movieInfoService = movieInfoService;
    }

    @RequestMapping("/{id}")
    public MovieInfo getMovieInfo(@PathVariable("id") String id) {
        return movieInfoService.findMovieInfo(id);
    }
}
