package org.rosebriar.moviecatalogservice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserRatingWithCatalog {
    @Getter
    @Setter
    private UserRating userRating;
    @Getter
    @Setter
    private List<CatalogItem> catalogItems;

    @SuppressWarnings("unused")
    public UserRatingWithCatalog() {}

    public UserRatingWithCatalog(UserRating userRating, List<CatalogItem> catalogItems) {
        this.userRating = userRating;
        this.catalogItems = catalogItems;
    }

}
