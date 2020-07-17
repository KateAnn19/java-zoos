package local.kmcgeeka.javazoosweb31.services;

import local.kmcgeeka.javazoosweb31.repositories.AnimalRepository;
import local.kmcgeeka.javazoosweb31.views.AnimalCounts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service(value = "animalService")
public class AnimalServiceImpl implements AnimalService
{
    @Autowired
    AnimalRepository animalrepos;

    @Override
    public List<AnimalCounts> getAnimalCounts()
    {
        List<AnimalCounts> list = animalrepos.findAnimalCounts();
        return list;
    }

}
