package cz.dipcom.simulator.service.impl;


import cz.dipcom.simulator.DTO.ItemDTO;
import cz.dipcom.simulator.DTO.mapper.ItemMapper;
import cz.dipcom.simulator.entity.ItemEntity;
import cz.dipcom.simulator.repository.ItemRepository;
import cz.dipcom.simulator.service.ItemService;
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
        ItemEntity item = itemRepository.getReferenceById(id);
        return itemMapper.toDTO(item);
    }

    @Override
    public ItemDTO removeItem(Long id) {
        return null;
    }

    @Override
    public ItemDTO editItem(Long id, ItemDTO itemDTO) {
        return null;
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
