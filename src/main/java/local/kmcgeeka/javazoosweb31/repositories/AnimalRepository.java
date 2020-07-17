package local.kmcgeeka.javazoosweb31.repositories;

import local.kmcgeeka.javazoosweb31.models.Animal;
import local.kmcgeeka.javazoosweb31.views.AnimalCounts;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    //custom query
    @Query(value = "SELECT a.animaltype as type, a.animalid as animalid, count(ZOOID) as countzoos " +
        "FROM ZOOANIMALS z LEFT JOIN ANIMAL A on z.ANIMALID = A.ANIMALID GROUP BY a.ANIMALID", nativeQuery = true)
    List<AnimalCounts> findAnimalCounts();

}
