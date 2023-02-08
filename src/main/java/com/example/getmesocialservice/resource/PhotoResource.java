package com.example.getmesocialservice.resource;

import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.model.Photo;
import com.example.getmesocialservice.service.AlbumService;
import com.example.getmesocialservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {

    @Autowired
    private PhotoService photoService;

    //save Users
    @PostMapping
    public Photo savePhoto(@RequestBody Photo photo)
    {
        return photoService.savePhoto(photo);

    }
    @GetMapping
    public List<Photo> getAllphotos(){
        return photoService.getAllPhotos();
    }



    @GetMapping("/id")
    public List<Photo> getPhotoById(@RequestParam(name = "id") String id)
    {
        return photoService.getPhotoById(id);
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo)
    {
        return photoService.updatePhoto(photo);
    }

    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "id") String id)
    {
        photoService.deletePhoto(id);
    }
}
