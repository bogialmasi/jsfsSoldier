package hu.soldier.services;

import hu.soldier.domain.Soldier;
import hu.soldier.repository.SoldierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SoldierService {

    private SoldierRepo repo;

    @Autowired
    public void setRepository(SoldierRepo repo) {
        this.repo = repo;
    }

    public List<Soldier> getSoldiers() {
        return repo.findAll();
    }



    public Soldier addSoldier(Soldier s) {
        return repo.save(s);
    }


    public Soldier getSoldier(int id) {
        Optional<Soldier> oS = repo.findById(id);
        if (oS.isPresent()) {
            return oS.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Soldier updateSoldier(int id, int badges){
        Optional<Soldier> oS = repo.findById(id);
        if (oS.isPresent()){
            Soldier s = oS.get();
            s.setBadges(badges);
            return repo.save(s);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Soldier replaceSoldier(int id, Soldier s) {
        Optional<Soldier> oS = repo.findById(id);
        if (oS.isPresent()){
            s.setId(id);
            return repo.save(s);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public void deleteSoldier(int id) {
        Optional<Soldier> oS = repo.findById(id);
        if (oS.isPresent()){
            repo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}

