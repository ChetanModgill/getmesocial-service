package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.repository.AlbumRepository;
import com.example.getmesocialservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
   public Album getAlbum(){
        return albumService.getAlbum();
    }
}
