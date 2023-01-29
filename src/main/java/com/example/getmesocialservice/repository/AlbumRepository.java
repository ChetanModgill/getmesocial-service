package com.example.getmesocialservice.repository;

import com.example.getmesocialservice.model.Album;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public class AlbumRepository {
    public Album getAlbum() {
        Album album = new Album("Sidhu","Best Singer", "will soon");
        return album;
    }
}
