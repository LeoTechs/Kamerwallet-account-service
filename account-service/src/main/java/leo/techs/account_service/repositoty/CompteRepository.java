package leo.techs.account_service.repositoty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import leo.techs.account_service.model.Compte;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Integer> {
    Compte findById(int id);


}
