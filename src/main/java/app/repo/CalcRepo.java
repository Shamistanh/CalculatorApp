package app.repo;

import app.entity.Calculation;
import app.entity.XUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface CalcRepo extends JpaRepository<Calculation, Integer> {

    List<Calculation> findAllByUsername(String username);

}
