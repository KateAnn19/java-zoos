package local.kmcgeeka.javazoosweb31.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "zoo")
public class Zoo extends Auditable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long zooid;

    private String zooname;

    //There is a one to many relationship between zoos and telephones.
    //One zoo can have multiple phone numbers but each phone number can only belong to one zoo.
    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL, orphanRemoval = true)//mapped by is field in telephone (zoo)
    @JsonIgnoreProperties(value = "zoo", allowSetters = true) //zoo inside telephone
    private List<Telephone> telephones = new ArrayList<>(); //this is how spring knows (telephone is the many part)



    @OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL) //this is  the field inside ZooAnimal
    @JsonIgnoreProperties(value = "zoo", allowSetters = true) //I think it needs to be zoo because of zoo inside zooanimal
    Set<ZooAnimal> animals = new HashSet<>();

    public Zoo()
    {
    }

    public Zoo(String zooname)
    {
        this.zooname = zooname;
    }

    public long getZooid()
    {
        return zooid;
    }

    public void setZooid(long zooid)
    {
        this.zooid = zooid;
    }

    public String getZooname()
    {
        return zooname;
    }

    public void setZooname(String zooname)
    {
        this.zooname = zooname;
    }

    public List<Telephone> getTelephones()
    {
        return telephones;
    }

    public void setTelephones(List<Telephone> telephones)
    {
        this.telephones = telephones;
    }

    public Set<ZooAnimal> getAnimals()
    {
        return animals;
    }

    public void setAnimals(Set<ZooAnimal> animals)
    {
        this.animals = animals;
    }
}
