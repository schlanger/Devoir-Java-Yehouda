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

public class CtrlConsultation
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlConsultation() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Consultation> GetAllConsultations() throws SQLException {
        ArrayList<Consultation> mesConsultations = new ArrayList<>();
        ps = cnx.prepareStatement("select idConsult,dateConsult,patient.nomPatient,Medecin.nomMedecin from consultation,patient,medecin where consultation.numPatient = patient.idPatient And consultation.numMedecin = Medecin.idMedecin");
        rs = ps.executeQuery();
        while (rs.next())
        {
            Consultation cons = new Consultation(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
            mesConsultations.add(cons);
        }
        return mesConsultations;
    }
    public int getLastNumberOfConsultation()
    {

        return 0;
    }
    public void InsertConsultation(int idConsult, String dateConsultation, int numPatient,int numMedecin)
    {

    }
}
