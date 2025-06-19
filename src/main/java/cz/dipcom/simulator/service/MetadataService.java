package cz.dipcom.simulator.service;

import cz.dipcom.simulator.DTO.BookDTO;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;

public interface MetadataService {

    public HttpStatus loadMetadata() throws IOException;
}
