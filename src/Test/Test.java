package Test;

import java.util.Date;

import com.RDV.beans.Employe;
import com.RDV.dao.EmployeDAO;
import com.ibm.icu.text.SimpleDateFormat;

public class Test {

    public static void main( String[] args ) {

        EmployeDAO employeDao = new EmployeDAO();

        SimpleDateFormat formater = null;

        Date aujourdhui = new Date();

        formater = new SimpleDateFormat( "dd-MM-yyyy" );
        System.out.println( formater.format( aujourdhui ) );

        Employe employe = new Employe();

        employe.setCin( "I737329" );
        employe.setNom( "Benaicha" );
        employe.setPrenom( "Mohamed Amine" );
        employe.setVille( "Quartier El Hana" );
        employe.setNumTele( "0655887766" );
        employe.setEmail( "amine@gmail.com" );
        employe.setPhotoProfile( "/photo" );
        employe.setDate_debut( formater.format( aujourdhui ) );

        employeDao.saveEmploye( employe );

        employe.setCin( "D908765" );
        employe.setNom( "Amiri" );
        employe.setPrenom( "Mohamed" );
        employe.setVille( "Ouarazate" );
        employe.setNumTele( "0655885766" );
        employe.setEmail( "mohamed@gmail.com" );
        employe.setPhotoProfile( "/photo" );
        employe.setDate_debut( formater.format( aujourdhui ) );

        employeDao.saveEmploye( employe );
    }

}
