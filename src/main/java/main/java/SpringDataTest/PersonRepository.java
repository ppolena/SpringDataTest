package main.java.SpringDataTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface PersonRepository extends JpaRepository<Person, Long> {

    @RestResource(path = "names", rel = "names")
    List<Person> findByName(@Param("name") String name);
    @RestResource(path = "telnums", rel = "telnums")
    List<Person> findByTelnum(@Param("telnum") String telnum);

    //Only used for tests:
    @Modifying
    @Transactional
    @RestResource(exported = false)
    @Query(value = "UPDATE person SET name = ? where id = ?", nativeQuery = true)
    int updatePersonSetNameForIdNative(String name, long id);
    @Modifying
    @Transactional
    @RestResource(exported = false)
    @Query(value = "UPDATE person SET telnum = ? where id = ?", nativeQuery = true)
    int updatePersonSetTelnumForIdNative(String telnum, long id);
}
