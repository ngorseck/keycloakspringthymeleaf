package sn.samane.mapping;

import org.mapstruct.Mapper;
import sn.samane.domain.Department;
import sn.samane.entity.DepartmentEntity;

@Mapper
public interface DepartmentMapper {

    Department toDepartment(DepartmentEntity departmentEntity);

    DepartmentEntity fromDepartment(Department department);

}
