

import java.sql.PreparedStatement;
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

    //################ GET APPRENANT BY ID #################

    public static Apprenant getApprenantById( int id) throws SQLException {
        String req = "SELECT * FROM apprenant WHERE idapprenant = " + id;
        ResultSet res = AccesBD.executerQuery(req);
        
        Apprenant apprenant = new Apprenant();
        
        res.next();
        apprenant.setId(res.getInt("idapprenant"));
        apprenant.setNom(res.getString("nom"));
        apprenant.setPrenom(res.getString("prenom"));

        return apprenant;
    }

    //############## INSERT APPRENANT #############
    public static void insertApprenant (Apprenant apprenant) throws SQLException {
        
        String sql = "INSERT INTO apprenant (idapprenant, nom, prenom, dateNaissance, email, region_idregion) value (?,?,?,?,?,?) ";
        PreparedStatement PS = AccesBD.getConnection().prepareStatement(sql);
        PS.setInt(1, apprenant.getId());
        PS.setString(2, apprenant.getNom());
        PS.setString(3, apprenant.getPrenom());
        PS.setDate(4, apprenant.getDateNaissance());
        PS.setString(5, apprenant.getEmail());
        PS.setInt(6, apprenant.getRegion_id().getId());
        PS.executeUpdate();
    }

    //############## ADD ACTIVITER ###############

     //  insert into activites_has_apprenant (activite_id, apprenant_id) VALUES (008, 16);

    public static void addActiviter (int idAct, int idApp) throws SQLException {
        
        String sql = "INSERT INTO activites_has_apprenant (activite_id, apprenant_id) VALUES (?, ?)";
        PreparedStatement PS = AccesBD.getConnection().prepareStatement(sql);

        PS.setInt(1, idAct);
        PS.setInt(2, idApp);
        PS.executeUpdate();

    }

    // ################# NOBODY DO ########################

    public static ArrayList<Activites> getActNull() throws SQLException {
        ArrayList<Activites> actList = new ArrayList<>();

        String req = 
            "select * from activites left join activites_has_apprenant on activites.idactivites = activites_has_apprenant.activite_id where activites_has_apprenant.activite_id is NULL";
        ResultSet res = AccesBD.executerQuery(req);
        
        while (res.next()) {
            Activites activite = new Activites();

            activite.setId(res.getInt("idactivites"));
            activite.setNomActivites(res.getString("nomActivites"));

            actList.add(activite);
        }

        return actList;
    }

    // ################### Update App via nom ##########################
    public static void updateApp ( String nom, int id ) throws SQLException {
		String req = "UPDATE apprenant SET prenom = ?  WHERE idapprenant = ? ";
		PreparedStatement PS = AccesBD.getConnection().prepareStatement(req);
		
		PS.setString(1, nom);
		PS.setInt(2, id);
		
		PS.executeUpdate();
	}

    
    // ############### GET ALL APPRENANT WITH ID REGION ###############
    public static ArrayList<Apprenant> getApprenantsWidthRegion(int id) throws SQLException {
        ArrayList<Apprenant> apprenants = new ArrayList<>();
        String req =  "select * from apprenant join region on region.idregion = apprenant.region_idregion where region.idregion =" + id;
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

    // ############## Search apprenant with name and see activites ##############
    public static ArrayList<Activites> searchAppprenantWithName(String name) throws SQLException {
        String req = "SELECT DISTINCT * FROM apprenant join activites_has_apprenant on apprenant.idapprenant = activites_has_apprenant.apprenant_id join activites on activites_has_apprenant.activite_id = activites.idactivites where apprenant.nom = \"" + name +  "\"";
        ResultSet res = AccesBD.executerQuery(req);

        ArrayList<Activites> activites = new ArrayList<>();
        while (res.next()) {
            Activites act = new Activites();
            act.setId(res.getInt("idactivites"));
            act.setNomActivites(res.getString("nomActivites"));
            act.setApprenant(getApprenantById(res.getInt("apprenant.idapprenant")));
            activites.add(act);
        }
        
        return activites;
    }

    // ############ GET ALL APPRENANT DO ACTIVITES #################

    public static ArrayList<Activites> getAllAppDoActivites(String act) throws SQLException {
        String req = "select * from activites join activites_has_apprenant on activites.idactivites = activites_has_apprenant.activite_id join apprenant on activites_has_apprenant.apprenant_id = apprenant.idapprenant where activites.nomActivites = \"" + act +  "\"";
        ResultSet res = AccesBD.executerQuery(req);

        ArrayList<Activites> activites = new ArrayList<>();
        while (res.next()) {
            Activites activite = new Activites();
            activite.setId(res.getInt("idactivites"));
            activite.setNomActivites(res.getString("nomActivites"));
            activite.setApprenant(getApprenantById(res.getInt("apprenant.idapprenant")));
            activites.add(activite);
        }
        
        return activites;
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

     // ############## GET ACTIVITES BY ID ##############
    public static Activites getActiviteById ( int id) throws SQLException {
        String req = "SELECT * FROM activites WHERE idactivites = " + id;
        ResultSet res = AccesBD.executerQuery(req);

        Activites activtes = new Activites();
        res.next();
        activtes.setId(res.getInt("idactivites"));
        activtes.setNomActivites(res.getString("nomActivites"));

        return activtes;
    }

}
