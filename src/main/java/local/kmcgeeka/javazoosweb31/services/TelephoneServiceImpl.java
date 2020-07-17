package local.kmcgeeka.javazoosweb31.services;

import local.kmcgeeka.javazoosweb31.models.Telephone;
import local.kmcgeeka.javazoosweb31.repositories.AnimalRepository;
import local.kmcgeeka.javazoosweb31.repositories.TelephoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service(value = "telephoneService")
public class TelephoneServiceImpl implements TelephoneService
{
    @Autowired
    TelephoneRepository telephonerepos;
}
