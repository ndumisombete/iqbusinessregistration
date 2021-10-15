package za.com.iqbusiness.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import za.com.iqbusiness.entity.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}
