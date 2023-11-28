package br.com.kbmg.wsreadfilelineconcurrency.service;

import br.com.kbmg.wsreadfilelineconcurrency.model.LineInformation;
import br.com.kbmg.wsreadfilelineconcurrency.repository.LineInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractProcessorService {

    @Autowired
    private LineInformationRepository lineInformationRepository;

    protected void readLine(String line) {

    }

    protected LineInformation saveInformation(String data1, String data2) {
        LineInformation lineInformation = new LineInformation();
        lineInformation.setData1(data1);
        lineInformation.setData2(data2);

        return lineInformationRepository.save(lineInformation);
    }
}
