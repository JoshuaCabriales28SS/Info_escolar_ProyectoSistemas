package mx.uam.service.impl;

import mx.uam.dto.GrupoDTO;
import mx.uam.entity.Carrera;
import mx.uam.entity.Grupo;
import mx.uam.entity.Materia;
import mx.uam.entity.Profesor;
import mx.uam.repository.CarreraRepository;
import mx.uam.repository.GrupoRepository;
import mx.uam.repository.MateriaRepository;
import mx.uam.repository.ProfesorRepository;
import mx.uam.service.GrupoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrupoServiceImpl implements GrupoService {

    private final GrupoRepository grupoRepository;
    private final CarreraRepository carreraRepository;
    private final ProfesorRepository profesorRepository;
    private final MateriaRepository materiaRepository;

    public GrupoServiceImpl(
            GrupoRepository grupoRepository,
            CarreraRepository carreraRepository,
            ProfesorRepository profesorRepository,
            MateriaRepository materiaRepository) {

        this.grupoRepository = grupoRepository;
        this.carreraRepository = carreraRepository;
        this.profesorRepository = profesorRepository;
        this.materiaRepository = materiaRepository;
    }

    @Override
    public GrupoDTO createGrupo(GrupoDTO grupoDTO) {

        Grupo grupo = new Grupo();

        grupo.setGrupo(grupoDTO.getGrupo());
        grupo.setTrimestre(grupoDTO.getTrimestre());

        Carrera carrera = carreraRepository.findById(grupoDTO.getCarreras_id())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        Profesor profesor = profesorRepository.findById(grupoDTO.getProfesores_id())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Materia materia = materiaRepository.findById(grupoDTO.getMaterias_id())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        grupo.setCarrera(carrera);
        grupo.setProfesor(profesor);
        grupo.setMateria(materia);

        Grupo grupoSaved = grupoRepository.save(grupo);

        grupoDTO.setId(grupoSaved.getId());

        return grupoDTO;
    }

    @Override
    public List<GrupoDTO> getGrupos() {

        List<Grupo> grupos = grupoRepository.findAll();

        return grupos.stream().map(grupo -> {

            GrupoDTO dto = new GrupoDTO();

            dto.setId(grupo.getId());
            dto.setGrupo(grupo.getGrupo());
            dto.setTrimestre(grupo.getTrimestre());
            dto.setCarreras_id(grupo.getCarrera().getId());
            dto.setProfesores_id(grupo.getProfesor().getId());
            dto.setMaterias_id(grupo.getMateria().getId());

            return dto;

        }).toList();
    }

    @Override
    public GrupoDTO getGrupoById(Long id) {

        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        GrupoDTO dto = new GrupoDTO();

        dto.setId(grupo.getId());
        dto.setGrupo(grupo.getGrupo());
        dto.setTrimestre(grupo.getTrimestre());
        dto.setCarreras_id(grupo.getCarrera().getId());
        dto.setProfesores_id(grupo.getProfesor().getId());
        dto.setMaterias_id(grupo.getMateria().getId());

        return dto;
    }

    @Override
    public GrupoDTO updateGrupo(Long id, GrupoDTO grupoDTO) {

        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        grupo.setGrupo(grupoDTO.getGrupo());
        grupo.setTrimestre(grupoDTO.getTrimestre());

        Carrera carrera = carreraRepository.findById(grupoDTO.getCarreras_id())
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        Profesor profesor = profesorRepository.findById(grupoDTO.getProfesores_id())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        Materia materia = materiaRepository.findById(grupoDTO.getMaterias_id())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        grupo.setCarrera(carrera);
        grupo.setProfesor(profesor);
        grupo.setMateria(materia);

        Grupo grupoUpdated = grupoRepository.save(grupo);

        GrupoDTO dto = new GrupoDTO();

        dto.setId(grupoUpdated.getId());
        dto.setGrupo(grupoUpdated.getGrupo());
        dto.setTrimestre(grupoUpdated.getTrimestre());
        dto.setCarreras_id(grupoUpdated.getCarrera().getId());
        dto.setProfesores_id(grupoUpdated.getProfesor().getId());
        dto.setMaterias_id(grupoUpdated.getMateria().getId());

        return dto;
    }

    @Override
    public void deleteGrupo(Long id) {

        Grupo grupo = grupoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Grupo no encontrado"));

        grupoRepository.delete(grupo);
    }
}