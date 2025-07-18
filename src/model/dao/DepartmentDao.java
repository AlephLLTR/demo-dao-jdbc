package model.dao;

import java.util.List;

import model.entities.Department;

public interface DepartmentDao {
    void insert(Department obj);

    void update(Department obj);

    void deleteById(Integer objId);

    Department findById(Integer objId);

    List<Department> findAll();
}
