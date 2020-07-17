package local.kmcgeeka.javazoosweb31.controllers;

import local.kmcgeeka.javazoosweb31.models.Zoo;
import local.kmcgeeka.javazoosweb31.services.AnimalService;
import local.kmcgeeka.javazoosweb31.services.ZooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/zoos")
public class ZooController
{
    @Autowired
    private ZooService zooService;
    //Web 31 MVP
    //http://localhost:2019/zoos/zoos
    //http://localhost:2019/zoos/zoo/5

    //GET /zoos/zoos - returns all zoos with their phone numbers and animals
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos()
    {
        List<Zoo> myZoos = zooService.findAllZoos();
        return new ResponseEntity<>(myZoos, HttpStatus.OK);
    }


    //GET /zoos/zoo/{id} - returns all information related to a zoo based on its id
    @GetMapping(value = "/zoo/{zooid}", produces = {"application/json"})
    public ResponseEntity<?> getZooById(@PathVariable Long zooid)
    {
        Zoo z = zooService.findZooById(zooid);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }


    //web 30 version
    /*http://localhost:2019/zoos/zoos
    http://localhost:2019/zoos/zoo/5
    POST http://localhost:2019/zoos/zoo
    PUT http://localhost:2019/zoos/zoo/5
    PATCH http://localhost:2019/zoos/zoo/4
    DELETE http://localhost:2019/zoos/zoo/5*/

    //web 30 stretch
    /*http://localhost:2019/zoos/zoos
    http://localhost:2019/zoos/zoo/5
    POST http://localhost:2019/zoos/zoo
    PUT http://localhost:2019/zoos/zoo/5
    PATCH http://localhost:2019/zoos/zoo/4
    DELETE http://localhost:2019/zoos/zoo/4
    http://localhost:2019/zoos/zoo/namelike/zoo
    POST http://localhost:2019/zoos/zoo/3/animal/4/originated/0
    DELETE http://localhost:2019/zoos/zoo/1/animal/2*/

    //Web 31 Stretch
    /*POST http://localhost:2019/zoos/zoo
    PUT http://localhost:2019/zoos/zoo/5
    PATCH http://localhost:2019/zoos/zoo/4
    DELETE http://localhost:2019/zoos/zoo/5*/
}
