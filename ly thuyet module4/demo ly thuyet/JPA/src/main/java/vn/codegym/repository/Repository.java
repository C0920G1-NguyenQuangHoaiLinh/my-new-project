package vn.codegym.repository;

import vn.codegym.model.Student;

import java.util.List;

public interface Repository {
    List<Student> findAll();
    void save(Student student);
    void update(Student student);
    void delete(Student student);

    Student findById(int id);
}
