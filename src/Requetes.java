import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Requetes {


    // ########## GET ALL APPRENANTS ###############
    public static ArrayList<Apprenant> getAllApprenants() throws SQLException {
        // System.out.println("All Apprenants");
        ArrayList<Apprenant> apprenants = new ArrayList<>();
        String req = "SELECT * FROM apprenant";
        ResultSet res = AccesBD.executerQuery(req);

        while (res.next()) {
            Apprenant apprenant = new Apprenant();
            apprenant.setId(res.getInt("idapprenant"));
            apprenant.setNom(res.getString("nom"));
            apprenant.setPrenom(res.getString("prenom"));
            apprenant.setDateNaissance(res.getDate("dateNaissance"));
            apprenant.setEmail(res.getString("email"));
            apprenant.setRegion_id(getRegionById(res.getInt("region_idregion")));
            apprenants.add(apprenant);
        }

        return apprenants;
    }


    // ############## GET REGION BY ID ##############
    public static Region getRegionById( int id ) throws SQLException {
        String req = "SELECT * FROM region WHERE idregion = " + id;
        ResultSet res = AccesBD.executerQuery(req);

        Region region = new Region();
        res.next();
        region.setId(res.getInt("idregion"));
        region.setNomRegion(res.getString("nomRegion"));
        

        return region;
    }
}
