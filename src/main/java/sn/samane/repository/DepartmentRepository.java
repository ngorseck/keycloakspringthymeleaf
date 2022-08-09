package sn.samane.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sn.samane.entity.DepartmentEntity;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends CrudRepository<DepartmentEntity, String> {

    Optional<DepartmentEntity> findByNameIgnoreCase(String name);

}
