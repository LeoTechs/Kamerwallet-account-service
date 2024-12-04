package leo.techs.account_service.model;

public class User {

    private int id;
    private String nom;
    private String prenom; 
    private String Email;
    private String password;
    private String telephone;

    public User() {
    }

    public User(int id, String nom, String prenom, String email, String password, String telephone) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        Email = email;
        this.password = password;
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    

    

    
}
