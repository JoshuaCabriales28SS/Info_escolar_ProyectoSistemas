package mx.uam.service;


import mx.uam.dto.DivisionDTO;

import java.util.List;

public interface DivisionService {
    List<DivisionDTO> getDivisiones();

    DivisionDTO updateDivision(Long id, DivisionDTO divisionDTO);

    void deleteDivision(Long id);

    DivisionDTO createDivision(DivisionDTO divisionDTO);

    DivisionDTO getDivisionById(Long id);
}
