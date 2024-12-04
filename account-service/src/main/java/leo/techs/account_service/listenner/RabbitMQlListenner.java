package leo.techs.account_service.listenner;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import leo.techs.account_service.model.Compte;
import leo.techs.account_service.model.User;
import leo.techs.account_service.service.CompteService;
@Component
public class RabbitMQlListenner {
    private final ObjectMapper objectMapper ;
    private CompteService compteService;


    public RabbitMQlListenner(ObjectMapper objectMapper , CompteService compteService) {
        this.objectMapper = objectMapper;
        this.compteService = compteService;
    }

    @RabbitListener(queues = "notification.send")
    public void listen(String message) {
        
       try {
           User user = objectMapper.readValue(message, User.class);
              //print l'id de l'utilisateur
              System.out.println("id: " + user.getId());
                //print le nom de l'utilisateur

                System.out.println("Nom: " + user.getNom());
                //print le prenom de l'utilisateur

                System.out.println("Prenom: "+user.getPrenom());
                //print l'email de l'utilisateur

                System.out.println("Emmail: "+user.getEmail());
                //print le telephone de l'utilisateur
                System.out.println("Telephone: "+user.getTelephone());

                //print le mot de passe de l'utilisateur
                System.out.println("Password :"+user.getPassword());
                
                //je veux créer un compte pour l'utilisateur

            Compte compte = new Compte();
            compte.setSolde(0);
            compte.setUserId(user.getId());
            //recuprer la date courante sous le format yyyyMMddHHmmss

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
            String date = simpleDateFormat.format(new Date());

            //afficher la date courante
            System.out.println("Date : "+date);

            //créer le numero de compte sous le format date-id

            

            

            compte.setNumeroCompte(date+"-"+user.getId());
            compteService.createCompte(compte);


            //afficher le compte crée

            System.out.println("Compte crée : "+compte.getNumeroCompte());

            //envoyer une notification dans la queue compte.created pour dire que le compte est crée
           
    



            
                

       } catch (Exception e) {
           e.printStackTrace();

       }
       
    }
}
