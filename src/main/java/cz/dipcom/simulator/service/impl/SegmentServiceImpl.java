package cz.dipcom.simulator.service.impl;


import cz.dipcom.simulator.DTO.ResourceDTO;
import cz.dipcom.simulator.DTO.SegmentDTO;
import cz.dipcom.simulator.DTO.mapper.SegmentMapper;
import cz.dipcom.simulator.entity.BookEntity;
import cz.dipcom.simulator.entity.ResourceEntity;
import cz.dipcom.simulator.entity.SegmentEntity;
import cz.dipcom.simulator.repository.SegmentRepository;
import cz.dipcom.simulator.service.SegmentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SegmentServiceImpl implements SegmentService {

    @Autowired
    private SegmentMapper segmentMapper;

    @Autowired
    private SegmentRepository segmentRepository;

    @Override
    public SegmentDTO getSegment(Long id) {
        SegmentEntity segment = segmentRepository.getReferenceById(id);
        return segmentMapper.toDTO(segment);
    }

    @Override
    public SegmentDTO addSegment(SegmentDTO segmentDTO) {
        SegmentEntity newSegment = segmentMapper.toEntity(segmentDTO);
        SegmentEntity savedSegment = segmentRepository.save(newSegment);
        return segmentMapper.toDTO(savedSegment);
    }

    @Override
    public SegmentDTO editSegment(Long id, SegmentDTO segmentDTO) {
        if (!segmentRepository.existsById(id)) {
            throw new EntityNotFoundException("Person with id " + id + " wasn't found in the database.");
        }
        SegmentEntity entity = segmentMapper.toEntity(segmentDTO);
        entity.setId(id);
        SegmentEntity saved = segmentRepository.save(entity);
        return segmentMapper.toDTO(saved);
    }

    @Override
    public SegmentDTO removeSegment(Long id) {
        SegmentEntity segment = segmentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        SegmentDTO model = segmentMapper.toDTO(segment);
        segmentRepository.delete(segment);
        return model;
    }

    @Override
    public List<SegmentDTO> getAllSegments() {
        List<SegmentDTO> results = new ArrayList<>();
        for (SegmentEntity segment:segmentRepository.findAll()){
            results.add(segmentMapper.toDTO(segment));
        }
        return results;
    }
}
