package local.kmcgeeka.javazoosweb31.services;

import local.kmcgeeka.javazoosweb31.models.Zoo;
import local.kmcgeeka.javazoosweb31.repositories.TelephoneRepository;
import local.kmcgeeka.javazoosweb31.repositories.ZooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "zooService")
public class ZooServiceImpl implements ZooService
{
    @Autowired
    ZooRepository zoorepos;

    @Override
    public List<Zoo> findAllZoos()
    {
        List<Zoo> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        zoorepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Zoo findZooById(long id) throws EntityNotFoundException
    {
        return zoorepos.findById(id).orElseThrow(() -> new EntityNotFoundException("Zoo " + id + " Not Found"));
    }
}
