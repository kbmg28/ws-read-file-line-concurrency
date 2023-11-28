package br.com.kbmg.wsreadfilelineconcurrency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class LineInformationService {

    private final AbstractProcessorService processorService;

    public void processFile(MultipartFile file) {

    }
}
