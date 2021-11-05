public class Activites {
    private int id;
    private String nomActivites;
    private Apprenant apprenant;
    public Activites(int id, String nomActivites, Apprenant apprenant) {
        this.id = id;
        this.nomActivites = nomActivites;
        this.apprenant = apprenant;
    }
    public Activites() {
        // TODO
    }

    public Activites(int id, String nomActivites) {
        this(id, nomActivites, null);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomActivites() {
        return nomActivites;
    }
    public void setNomActivites(String nomActivites) {
        this.nomActivites = nomActivites;
    }
    
    public Apprenant getApprenant() {
        return apprenant;
    }
    public void setApprenant(Apprenant apprenant) {
        this.apprenant = apprenant;
    }
    @Override
    public String toString() {
        return " Activités :" + nomActivites ;
    }
        //"Activites [apprenant=" + apprenant + ", id=" + id + ", nomActivites=" + nomActivites + "]";
    

    public String Afficher() {
        return "Nom : " + apprenant.getNom() + ", Prénom: " + apprenant.getPrenom()  ;
    }
    
    
}

