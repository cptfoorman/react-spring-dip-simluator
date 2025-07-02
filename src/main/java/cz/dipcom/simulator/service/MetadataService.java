package cz.dipcom.simulator.service;

import org.springframework.http.HttpStatus;

import java.io.IOException;

public interface MetadataService {

    public HttpStatus loadMetadata() throws IOException;
}
