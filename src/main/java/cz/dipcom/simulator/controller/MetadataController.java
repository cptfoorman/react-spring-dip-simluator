package cz.dipcom.simulator.controller;


import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.service.BookService;
import cz.dipcom.simulator.service.impl.MetadataServiceImpl;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
@RequestMapping("/api")
public class MetadataController {

    @Autowired
    private MetadataServiceImpl metadataService;
    @Autowired
    private BookService bookService;

    @PostMapping("/import")
    public ResponseEntity<Void> importBooks() throws IOException {
        HttpStatus status = metadataService.loadMetadata();
        return ResponseEntity.status(status).build();
    }



}

