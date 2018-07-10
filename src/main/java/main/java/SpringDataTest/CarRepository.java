package main.java.SpringDataTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RepositoryRestResource(collectionResourceRel = "cars", path = "cars")
public interface CarRepository extends JpaRepository<Car, Long> {

    @RestResource(path = "brands", rel = "brands")
    List<Car> findByBrand(@Param("brand") String brand);
    @RestResource(path = "names", rel = "names")
    List<Car> findByName(@Param("name") String name);
    @RestResource(path = "years", rel = "years")
    List<Car> findByYear(@Param("year") int year);
    @RestResource(path = "conditions", rel = "conditions")
    List<Car> findByCondition(@Param("condition") Condition condition);

    //Only used for tests:
    @Modifying
    @Transactional
    @RestResource(exported = false)
    @Query(value = "UPDATE car SET owner = ? where id = ?", nativeQuery = true)
    int updateCarSetOwnerForIdNative(Person owner, long id);
    @Modifying
    @Transactional
    @RestResource(exported = false)
    @Query(value = "UPDATE car SET brand = ? where id = ?", nativeQuery = true)
    int updateCarSetBrandForIdNative(String brand, long id);
    @Modifying
    @Transactional
    @RestResource(exported = false)
    @Query(value = "UPDATE car SET name = ? where id = ?", nativeQuery = true)
    int updateCarSetNameForIdNative(String name, long id);
    @Modifying
    @Transactional
    @RestResource(exported = false)
    @Query(value = "UPDATE car SET year = ? where id = ?", nativeQuery = true)
    int updateCarSetYearForIdNative(int year, long id);
    @Modifying
    @Transactional
    @RestResource(exported = false)
    @Query(value = "UPDATE car SET condition = ? where id = ?", nativeQuery = true)
    int updateCarSetConditionForIdNative(int condition, long id);
}
