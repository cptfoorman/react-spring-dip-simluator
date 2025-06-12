package cz.dipcom.simulator.service;

import cz.dipcom.simulator.DTO.ResourceDTO;

import java.util.List;

public interface ResourceService {

    ResourceDTO getResource(Long id);

    ResourceDTO editResource(Long id, ResourceDTO resourceDTO);

    ResourceDTO addResource(ResourceDTO resourceDTO);

    ResourceDTO removeResource(Long id);

    List<ResourceDTO> getAllResources();


}
