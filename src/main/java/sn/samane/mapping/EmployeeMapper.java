package sn.samane.mapping;

import org.mapstruct.Mapper;
import sn.samane.domain.Employee;
import sn.samane.entity.EmployeeEntity;

@Mapper
public interface EmployeeMapper {

    Employee toEmployee(EmployeeEntity employeeEntity);

    EmployeeEntity fromEmployee(Employee employee);

}
