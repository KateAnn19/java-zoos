package local.kmcgeeka.javazoosweb31.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "telephone")
public class Telephone extends Auditable
{
    //phoneid, phonetype, phonenumber, zooid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    private String phonetype;

    private String phonenumber;

    //There is a one to many relationship between zoos and telephones.
    //One zoo can have multiple phone numbers but each phone number can only belong to one zoo.
    @ManyToOne
    @JoinColumn(name = "zooid", nullable = false) //this adds a foreign key to telephone // zooid is the field in zoo
    @JsonIgnoreProperties(value = "telephones", allowSetters = true)
    private Zoo zoo; //single zoo it relates to

    public Telephone()
    {
    }

    public Telephone(
        String phonetype,
        String phonenumber,
        Zoo zoo)
    {
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
        this.zoo = zoo;
    }

    public long getPhoneid()
    {
        return phoneid;
    }

    public void setPhoneid(long phoneid)
    {
        this.phoneid = phoneid;
    }

    public String getPhonetype()
    {
        return phonetype;
    }

    public void setPhonetype(String phonetype)
    {
        this.phonetype = phonetype;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo()
    {
        return zoo;
    }

    public void setZoo(Zoo zoo)
    {
        this.zoo = zoo;
    }
}
