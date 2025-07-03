package cz.dipcom.simulator.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

/*
* Custom JSON parsing logic for the metadata
* had to implement better error management since some of the objects
* inside the provided JSON either have faults in them,
*  or somehow the object mapper cant parse so many files
* since it was resulting in errors I made it batch based
* it takes longer, but it does at least map most of the objects
* and sends back apropriate responses
* */

@Service
public class MetadataServiceImpl implements MetadataService {

    @Autowired
    private BookServiceImpl bookService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    /*
    * Method for loading metadata from data folder
    * @return HttpStatus -NOT_FOUND
    *                    -BAD_REQUEST
    *                    -CREATED
    *                    -PARTIAL_CONTENT*/
    @Override
    public HttpStatus loadMetadata() throws IOException {
        File file = Paths.get("data", "metadata.json").toFile();

        if (!file.exists()) {
            System.err.println("❌ ERROR: Metadata file not found at: " + file.getAbsolutePath());
            return HttpStatus.NOT_FOUND;
        }

        System.out.println("📄 INFO: Starting JSON stream parsing from file: " + file.getAbsolutePath());

        try (FileInputStream input = new FileInputStream(file);
             JsonParser parser = objectMapper.getFactory().createParser(input)) {

            if (parser.nextToken() != JsonToken.START_ARRAY) {
                System.err.println("❌ ERROR: Expected JSON array but found: " + parser.getCurrentToken());
                return HttpStatus.BAD_REQUEST;
            }

            int successCount = 0;
            int failureCount = 0;

            while (parser.nextToken() == JsonToken.START_OBJECT) {
                try {
                    BookDTO book = objectMapper.readValue(parser, BookDTO.class);

                    if (book.getType() == null) {
                        book.setType("text"); // default fallback
                    }
                    bookService.addBook(book); // Assume this saves one entry
                    successCount++;

                } catch (Exception e) {
                    failureCount++;
                    System.err.println("⚠️ Failed to parse/save a book: " + e.getMessage());
                }
            }

            System.out.printf("📊 Import completed: %d success / %d failed%n", successCount, failureCount);
            return (failureCount == 0) ? HttpStatus.CREATED : HttpStatus.PARTIAL_CONTENT;

        } catch (IOException e) {
            System.err.println("❌ I/O Error during JSON streaming: " + e.getMessage());
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

    }
}


