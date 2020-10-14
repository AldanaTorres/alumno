package com.alumno.services;

import java.util.List;

public interface AlumnoService<Alumno>{
    //Aldana
    public List<Alumno> findAll() throws Exception;
    public Alumno findById(Long id) throws Exception;
    public Alumno save(Alumno entity) throws Exception;
    public Alumno update(Long id, Alumno entity) throws Exception;
    public boolean delete(Long id) throws Exception;
}
