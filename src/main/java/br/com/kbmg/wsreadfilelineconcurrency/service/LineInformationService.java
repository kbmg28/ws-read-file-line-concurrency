package br.com.kbmg.wsreadfilelineconcurrency.service;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LineInformationService {
    private static final CSVParser PARSER = new CSVParserBuilder()
            .withSeparator(';')
            .withIgnoreQuotations(true)
            .build();

    private final AbstractProcessorService processorService;

    public void processFile(MultipartFile file) {
        validateRequiredFile(file);
        validateTypeFile(file.getContentType());

        try(Reader reader = new InputStreamReader(file.getInputStream())) {
            CSVReader csvReader = new CSVReaderBuilder(reader)
                    .withSkipLines(0)
                    .withCSVParser(PARSER)
                    .build();

            List<String> list = Arrays.asList(csvReader.readNext());
            int data2Index = list.indexOf("data2");

            csvReader.readAll()
                .stream()
                .forEach(line-> {
                        List<String> cellsOfLine = Arrays.asList(line);
                        System.err.println(cellsOfLine);
                        System.err.println(cellsOfLine.get(data2Index));
            });
        } catch (IOException | CsvException e) {
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "failed to read csv");
        }

    }

    private void validateTypeFile(String contentType) {
        if(!"text/csv".equals(contentType)) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "file should be CSV");
        }
    }

    private void validateRequiredFile(MultipartFile file) {
        if(file == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "file is required");
        }
    }
}
