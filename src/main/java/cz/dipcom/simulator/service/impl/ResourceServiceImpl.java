package cz.dipcom.simulator.service.impl;


import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.DTO.ResourceDTO;
import cz.dipcom.simulator.DTO.mapper.ResourceMapper;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ItemEntity;
import cz.dipcom.simulator.entity.ResourceEntity;
import cz.dipcom.simulator.repository.ResourceRepository;
import cz.dipcom.simulator.service.ResourceService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {


    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private ResourceRepository resourceRepository;

    /**
     * Returns an entity according to its id
     *
     * @param id
     * @return ResourceDTO
     */
    @Override
    public ResourceDTO getResource(Long id) {
        ResourceEntity resource = resourceRepository.getReferenceById(id);
        return resourceMapper.toDTO(resource);
    }

    /**
     * Edits an existing Entity in the database using a new DTO and overwriting the old one
     * @param resourceDTO
     * @param id
     * @return ResourceDTO
     */
    @Override
    public ResourceDTO editResource(Long id, ResourceDTO resourceDTO) {
        if (resourceRepository.existsById(id)) {
            throw new EntityNotFoundException("Person with id " + id + " wasn't found in the database.");
        }
        ResourceEntity entity =resourceMapper.toEntity(resourceDTO);
        entity.setId(id);
        ResourceEntity saved =resourceRepository.save(entity);
        return resourceMapper.toDTO(saved);
    }

    /**
     * Adds an entity to the database
     *
     * @param resourceDTO
     * @return ResourceDTO
     */
    @Override
    public ResourceDTO addResource(ResourceDTO resourceDTO) {
        ResourceEntity newResource = resourceMapper.toEntity(resourceDTO);
        ResourceEntity savedResource = resourceRepository.save(newResource);
        return resourceMapper.toDTO(savedResource);
    }

    /**
     * Deletes an entity according to its id
     *
     * @param id
     * @return ResourceDTO
     */
    @Override
    public ResourceDTO removeResource(Long id) {
        ResourceEntity resource = resourceRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        ResourceDTO model = resourceMapper.toDTO(resource);
        resourceRepository.delete(resource);
        return model;
    }

    /**
     * Gets all resources without any filters
     *
     * @return List<ResourceDTO>
     */
    @Override
    public List<ResourceDTO> getAllResources() {
        List<ResourceDTO> results = new ArrayList<>();
        for (ResourceEntity resource : resourceRepository.findAll()) {
            results.add(resourceMapper.toDTO(resource));
        }
        return results;
    }
}
