package cz.dipcom.simulator.service;

import cz.dipcom.simulator.DTO.ItemDTO;

import java.util.List;

public interface ItemService {

    ItemDTO getItem(Long id);

    ItemDTO removeItem(Long id);

    ItemDTO editItem(Long id, ItemDTO itemDTO);

    List<ItemDTO> getAllItems();

    ItemDTO addItem(ItemDTO itemDTO);

}
