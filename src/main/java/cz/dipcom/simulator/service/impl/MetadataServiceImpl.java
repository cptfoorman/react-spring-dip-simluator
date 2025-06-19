package cz.dipcom.simulator.service.impl;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.service.MetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MetadataServiceImpl implements MetadataService {

    @Autowired
    private BookServiceImpl bookService;

    private final ObjectMapper objectMapper = new ObjectMapper();

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

                    System.out.println("✅ Parsed Book Type = " + book.getType());
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


