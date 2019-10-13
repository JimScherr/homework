package org.rosebriar.moviecatalogservice.model;

import java.util.List;

public class UserCatalog {
    private String id;
    private String name;
    private List<String> movieIds;

    public UserCatalog() {
    }

    public UserCatalog(String id, String name, List<String> movieIds) {
        this.id = id;
        this.name = name;
        this.movieIds = movieIds;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getMovieIds() {
        return movieIds;
    }

    public void setMovieIds(List<String> movieIds) {
        this.movieIds = movieIds;
    }
}
