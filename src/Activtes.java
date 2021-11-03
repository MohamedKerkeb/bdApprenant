public class Activtes {
    private int id;
    private String nomActivites;
    public Activtes(int id, String nomActivites) {
        this.id = id;
        this.nomActivites = nomActivites;
    }
    public Activtes() {
        // TODO
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
    @Override
    public String toString() {
        return "Activtes [id=" + id + ", nomActivites=" + nomActivites + "]";
    }
    
    
}

