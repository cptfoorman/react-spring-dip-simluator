package cz.dipcom.simulator.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.service.MetadataService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

@Service
public class MetadataServiceImpl implements MetadataService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    @Override
    public List<BookDTO> loadMetadata() throws IOException {
        File file = Paths.get("data", "metadata.json").toFile();
        return objectMapper.readValue(file, new TypeReference<List<BookDTO>>() {});
    }
}
