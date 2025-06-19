package cz.dipcom.simulator.service.impl;


import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.DTO.mapper.ItemMapper;
import cz.dipcom.simulator.entity.ItemEntity;
import cz.dipcom.simulator.repository.ItemRepository;
import cz.dipcom.simulator.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * service for base CRUD operations with Item Entities
 */
@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;


    /**
     * Returns an entity according to its id
     *
     * @param id
     * @return ItemDTO
     */
    @Override
    public ItemDTO getItem(Long id) {
        ItemEntity item = itemRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("item id " + id + " has not been found"));
        return itemMapper.toDTO(item);
    }

    /**
     * Deletes an entity according to its id
     *
     * @param id
     * @return ItemDTO
     */
    @Override
    public ItemDTO removeItem(Long id) {
        ItemEntity item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        ItemDTO model = itemMapper.toDTO(item);
        itemRepository.delete(item);
        return model;
    }


    /**
     * Edits an existing Entity in the database using a new DTO and
     * overwriting the old one
     *
     * @param itemDTO
     * @param id
     * @return ItemDTO
     */
    @Override
    public ItemDTO editItem(Long id, ItemDTO itemDTO) {
        if (!itemRepository.existsById(id)) {
            throw new EntityNotFoundException("Person with id " + id + " wasn't found in the database.");
        }
        ItemEntity entity = itemMapper.toEntity(itemDTO);
        entity.setId(id);
        ItemEntity saved = itemRepository.save(entity);
        return itemMapper.toDTO(saved);
    }

    /**
     * Gets all items without any filters
     *
     * @return List<ItemDTO>
     */
    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemDTO> results = new ArrayList<>();
        for (ItemEntity item : itemRepository.findAll()) {
            results.add(itemMapper.toDTO(item));
        }
        return results;
    }

    /**
     * Adds an entity to the database
     *
     * @param itemDTO
     * @return ItemDTO
     */
    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        ItemEntity newItem = itemRepository.save(itemMapper.toEntity(itemDTO));
        return itemMapper.toDTO(newItem);
    }
}
