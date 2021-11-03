public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

    //    for (Apprenant apprenant : Requetes.getAllApprenants()) {
    //         System.out.println(apprenant.afficher());
    //     } 
        //System.out.println(Requetes.getRegionById(1));
    for (Apprenant apprenant : Requetes.getApprenantsWidthRegion(1)) {
        System.out.println(apprenant.afficherRegion());
    }
    }
}
