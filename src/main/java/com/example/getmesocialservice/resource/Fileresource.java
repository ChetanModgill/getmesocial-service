package com.example.getmesocialservice.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmesocialservice.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
@CrossOrigin(origins = "http://localhost:4200" )
public class Fileresource {

    @Autowired
    private FileService fileService;
    @PostMapping
    public boolean upload(@RequestParam(name = "file")MultipartFile file){
        return fileService.upload(file);
    }

    @GetMapping("/view")
    public void view(@RequestParam(name = "key") String key, HttpServletResponse response) throws IOException {
        S3Object object = fileService.getFile(key);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam(name = "key") String key) throws IOException{
        S3Object object = fileService.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\"" + key +"\"")
                .body(new ByteArrayResource(object.getObjectContent(). readAllBytes()));
    }

    @DeleteMapping("/delete")
    public void deleteFile(@RequestParam(name = "key") String key){
        fileService.deleteFile(key);
    }

}
