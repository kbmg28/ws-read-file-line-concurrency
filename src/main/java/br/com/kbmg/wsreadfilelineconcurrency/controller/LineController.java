package br.com.kbmg.wsreadfilelineconcurrency.controller;

import br.com.kbmg.wsreadfilelineconcurrency.service.LineInformationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LineController {

    private final LineInformationService lineInformationService;

    @GetMapping
    public String get()  {
        return "ok";
    }

    @PostMapping(path=  "/process", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String processFile(@RequestParam("file") MultipartFile file)  {
        lineInformationService.processFile(file);
        return "ok";
    }
}
