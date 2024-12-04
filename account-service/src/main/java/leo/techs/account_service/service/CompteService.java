package leo.techs.account_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import leo.techs.account_service.model.Compte;
import leo.techs.account_service.repositoty.CompteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompteService {
    private CompteRepository compteRepository;

    public Compte createCompte(Compte compte) {
       return compteRepository.save(compte);
        
    }

    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    public void updateSolde(Compte compte) {
        Compte compteToUpdate = compteRepository.findById(compte.getId());
        compteToUpdate.setSolde(compte.getSolde());
        compteRepository.save(compteToUpdate);
    }

    public Compte getCompte(int id) {
        return compteRepository.findById(id);
    }

  
}
