package hu.soldier.repository;

import hu.soldier.domain.Soldier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldierRepo extends JpaRepository<Soldier, Integer> {
}
