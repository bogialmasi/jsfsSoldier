package hu.soldier.controllers;

import hu.soldier.domain.Soldier;
import hu.soldier.services.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/soldiers")
public class SoldierController {

    private SoldierService service;

    @Autowired
    public void setService(SoldierService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Soldier> getSoldiers(){
        return service.getSoldiers();
    }

    @GetMapping("/{id}")
    public Soldier getSoldier(@PathVariable("id") int id){
        return service.getSoldier(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Soldier addSoldier(@RequestBody Soldier s){
        return service.addSoldier(s);
    }

    @PatchMapping("/{id}/{badges}")
    public Soldier updateSoldier(@PathVariable("id") int id, @PathVariable("badges") int badges){
        return service.updateSoldier(id, badges);
    }

    @PutMapping("/{id}")
    public Soldier replaceSoldier(@PathVariable("id)") int id, @RequestBody Soldier s){
        return service.replaceSoldier(id, s);
    }

    @DeleteMapping("/{id}")
    public void deleteSoldier(@PathVariable("id") int id){
        service.deleteSoldier(id);
    }
}
