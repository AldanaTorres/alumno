package com.alumno.services;

import com.alumno.entities.Alumno;
import com.alumno.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Table;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public class AlumnoServiceImpl implements AlumnoService<Alumno>{

    @Autowired
    private AlumnoRepository alumnoRepository;
    @Override
    @Transactional
    public List<Alumno> findAll() throws Exception {
        try{
            List<Alumno> entities = alumnoRepository.findAll();
            return entities;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Alumno findById(Long id) throws Exception {
        try{
            Optional<Alumno> entityOptional = alumnoRepository.findById(id);
            return entityOptional.get();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Alumno save(Alumno entity) throws Exception {
        try {
            entity = alumnoRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public Alumno update(Long id, Alumno entity) throws Exception {
        try {
            Optional<Alumno> entityOptional = alumnoRepository.findById(id);
            Alumno alumno = entityOptional.get();
            alumno = alumnoRepository.save(entity);
            return alumno;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public boolean delete(Long id) throws Exception {
        try {
            if(alumnoRepository.existsById(id)){
                alumnoRepository.deleteById(id);
                return true;
            } else {
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
