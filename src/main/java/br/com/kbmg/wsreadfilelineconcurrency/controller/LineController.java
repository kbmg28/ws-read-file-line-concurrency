package br.com.kbmg.wsreadfilelineconcurrency.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class LineController {

    @GetMapping
    public String get()  {
        return "ok";
    }

    @PostMapping(path=  "/process", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String processFile(@RequestParam("file") MultipartFile file)  {
        return "ok";
    }
}
