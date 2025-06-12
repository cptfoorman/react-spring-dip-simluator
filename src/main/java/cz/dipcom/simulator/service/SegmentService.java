package cz.dipcom.simulator.service;

import cz.dipcom.simulator.DTO.SegmentDTO;

import java.util.List;

public interface SegmentService {

    SegmentDTO getSegment(Long id);

    SegmentDTO addSegment(SegmentDTO segmentDTO);

    SegmentDTO editSegment(Long id, SegmentDTO segmentDTO);

    SegmentDTO removeSegment(Long id);

    List<SegmentDTO> getAllSegments();
}
