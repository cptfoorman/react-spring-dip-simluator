package cz.dipcom.simulator.service.impl;


import cz.dipcom.simulator.DTO.BookDTO;
import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.DTO.mapper.ItemMapper;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ItemEntity;
import cz.dipcom.simulator.repository.ItemRepository;
import cz.dipcom.simulator.service.ItemService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;



    @Override
    public ItemDTO getItem(Long id) {
        ItemEntity item = itemRepository.findById(id).orElseThrow(()->new EntityNotFoundException("item id "+id+" has not been found"));
        return itemMapper.toDTO(item);
    }

    @Override
    public ItemDTO removeItem(Long id) {
        ItemEntity item = itemRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        ItemDTO model = itemMapper.toDTO(item);
        itemRepository.delete(item);
        return model;
    }

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

    @Override
    public List<ItemDTO> getAllItems() {
        List<ItemDTO> results =  new ArrayList<>();
        for (ItemEntity item:itemRepository.findAll()){
            results.add(itemMapper.toDTO(item));
        }
        return results;
    }

    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        ItemEntity newItem = itemRepository.save(itemMapper.toEntity(itemDTO));
        return itemMapper.toDTO(newItem);
    }
}
