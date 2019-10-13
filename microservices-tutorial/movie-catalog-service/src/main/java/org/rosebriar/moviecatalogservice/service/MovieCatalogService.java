package org.rosebriar.moviecatalogservice.service;

import org.rosebriar.moviecatalogservice.model.UserCatalog;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class MovieCatalogService {
    public UserCatalog findUserCatalog(String id) {
        switch (id) {
            case "jims":
                return new UserCatalog(id, "Jim Scherr", Arrays.asList("abc123", "def456"));
            case "julies":
                return new UserCatalog(id, "Julie Scherr", Arrays.asList("emma", "pandp"));
            default:
                return new UserCatalog(id, "", Collections.EMPTY_LIST);
        }
    }
}
