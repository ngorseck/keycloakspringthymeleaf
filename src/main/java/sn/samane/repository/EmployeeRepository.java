package sn.samane.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import sn.samane.entity.EmployeeEntity;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity, Long> {

    Optional<EmployeeEntity> findById(Long id);
}