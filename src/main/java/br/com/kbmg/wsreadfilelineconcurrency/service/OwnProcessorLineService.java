package br.com.kbmg.wsreadfilelineconcurrency.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OwnProcessorLineService extends AbstractProcessorService {

    @Override
    public void readLine(String line) {

    }
}
