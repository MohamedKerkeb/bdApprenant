public class App {
    public static void main(String[] args) throws Exception {
        // System.out.println("Hello, World!");

       for (Apprenant apprenant : Requetes.getAllApprenants()) {
            System.out.println(apprenant);
        } 
        //System.out.println(Requetes.getRegionById(1));
    }
}
