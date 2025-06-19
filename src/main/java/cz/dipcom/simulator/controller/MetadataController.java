package cz.dipcom.simulator.controller;



import cz.dipcom.simulator.service.impl.MetadataServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Controller for handling the request to import the data
 * made it its own thing for clarity
 */
@Controller
@RequestMapping("/api")
public class MetadataController {

    @Autowired
    private MetadataServiceImpl metadataService;

    @PostMapping("/import")
    public ResponseEntity<Void> importBooks() throws IOException {
        HttpStatus status = metadataService.loadMetadata();
        return ResponseEntity.status(status).build();
    }



}

