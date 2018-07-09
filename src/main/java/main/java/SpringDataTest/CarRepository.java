package main.java.SpringDataTest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
    List<Car> findByBrand(@Param("brand") String brand);
    List<Car> findByName(@Param("name") String year);
    List<Car> findByYear(@Param("year") int year);
    List<Car> findByCondition(@Param("condition") Condition condition);
}
