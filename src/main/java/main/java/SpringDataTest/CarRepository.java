package main.java.SpringDataTest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
    @RestResource(path = "brands", rel = "brands")
    List<Car> findByBrand(@Param("brand") String brand);
    @RestResource(path = "names", rel = "names")
    List<Car> findByName(@Param("name") String year);
    @RestResource(path = "years", rel = "years")
    List<Car> findByYear(@Param("year") int year);
    @RestResource(path = "conditions", rel = "conditions")
    List<Car> findByCondition(@Param("condition") Condition condition);
}
