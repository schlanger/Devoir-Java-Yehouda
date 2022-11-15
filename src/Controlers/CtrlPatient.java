package Controlers;

import Entities.Consultation;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlPatient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlPatient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllPatients() throws SQLException {
        ArrayList<String> lesPatients = new ArrayList<>();
        String nomPatient = "";
        ps = cnx.prepareStatement("SELECT nomPatient from patient");
        rs = ps.executeQuery();
        while (rs.next())
        {
            rs.getString(1);
            lesPatients.add(nomPatient);
        }
        ps.close();

        return lesPatients;
    }
    public int getIdPatientByName(String nomPat)
    {

        return 0;
    }
}
