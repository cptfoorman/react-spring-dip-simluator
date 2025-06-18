package cz.dipcom.simulator.service;

import cz.dipcom.simulator.DTO.BookDTO;

import java.io.IOException;
import java.util.List;

public interface MetadataService {

    public List<BookDTO> loadMetadata() throws IOException;
}
