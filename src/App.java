import java.sql.Date;

public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

    //    for (Apprenant apprenant : Requetes.getAllApprenants()) {
    //         System.out.println(apprenant.afficher());
    //     } 
    // System.out.println(Requetes.getRegionById(2));
    // for (Apprenant apprenant : Requetes.getApprenantsWidthRegion(1)) {
    //     System.out.println(apprenant.afficherRegion());
    // }
    // System.out.println(Requetes.searchAppprenantWithName("géraldine"));
    //System.out.println(Requetes.getActiviteById(3));
    // System.out.println(Requetes.getAllAppDoActivites("Rien faire"));
    // for (Activites activite : Requetes.getAllAppDoActivites("Programmer en java")) {
    //     System.out.println(activite.getNomActivites());
    //     System.out.println(activite.Afficher());
    // }
    // Requetes.insertApprenant(new Apprenant(18, "Mohamed", "Milkka", Date.valueOf("1979-02-28"), "mohamed@gmail.com", Requetes.getRegionById(1)));
    // Requetes.addActiviter(9, 18);
        for (Activites activites : Requetes.getActNull()) {
            System.out.println(activites);
        }
    }
}
