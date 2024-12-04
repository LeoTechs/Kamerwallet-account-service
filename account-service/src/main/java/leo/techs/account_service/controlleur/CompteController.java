package leo.techs.account_service.controlleur;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leo.techs.account_service.model.Compte;
import leo.techs.account_service.service.CompteService;
import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@AllArgsConstructor
@RestController
@RequestMapping(path="api/comptes")
public class CompteController {

    private CompteService compteService;

    @PostMapping
    public void createCompte(@RequestBody Compte compte){
        compteService.createCompte(compte);
    }

    //afficher la liste des comptes

    @RequestMapping
    public List<Compte> getComptes(){
        return compteService.getComptes();
    }

    //modifier le solde d'un compte en passant en parametre le compte l'id du compte et le nouveau solde

    @PostMapping("/updateSolde")
    public void updateSolde(@RequestBody Compte compte){
        compteService.updateSolde(compte);
    }

    //afficher un compte en passant en parametre l'id du compte

    @GetMapping("/{id}")
    public Compte getCompte(@PathVariable int id){
        return compteService.getCompte(id);
    }






}
