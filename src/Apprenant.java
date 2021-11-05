import java.sql.Date;

public class Apprenant {
    private int id;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String email;
    private Region region_id;
    private Activites activites;

    public Apprenant(int id, String nom, String prenom, Date dateNaissance, String email, Region region_id, Activites activites) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.region_id = region_id;
        this.activites = activites;
    }
    
    public Apprenant() {
        // TODO
    }

    public Apprenant(int id, String nom, String prenom, Date dateNaissance, String email, Region region_id) {
        this(id, nom, prenom, dateNaissance, email, region_id, null);
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
    public Date getDateNaissance() {
        return dateNaissance;
    }
    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Region getRegion_id() {
        return region_id;
    }
    public void setRegion_id(Region region_id) {
        this.region_id = region_id;
    }
    
    public Activites getActivites() {
        return activites;
    }

    public void setActivites(Activites activites) {
        this.activites = activites;
    }

    
    
    @Override
    public String toString() {
        return "Apprenant [activtes=" + activites + ", dateNaissance=" + dateNaissance + ", email=" + email + ", id="
                + id + ", nom=" + nom + ", prenom=" + prenom + ", region_id=" + region_id + "]";
    }

    public String afficher() {
        return "Nom, prénom: " + nom  + ", " + prenom ;
    }

    public String afficherRegion() {
        return "Nom, prénom : " + nom + ", " + prenom + " de " + region_id.getNomRegion();
    }
}
