package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.User;
import com.example.getmesocialservice.repository.AlbumRepository;
import com.example.getmesocialservice.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/album")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    //save Users
    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album)
    {
        return albumService.saveAlbum(album);

    }
    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }



    @GetMapping("/id")
    public List<Album> getAlbumById(@RequestParam(name = "id") String id)
    {
        return albumService.getAlbumById(id);
    }

    @PutMapping
    public Album updateAlbum(@RequestBody @Valid Album album)
    {
        return albumService.updateAlbum(album);
    }

    @DeleteMapping
    public void deleteAlbum(@RequestParam(name = "id") String id)
    {
        albumService.deleteAlbum(id);
    }
}

