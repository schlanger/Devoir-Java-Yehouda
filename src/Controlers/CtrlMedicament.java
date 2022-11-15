package Controlers;

import Entities.Consultation;
import Entities.Medicament;
import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlMedicament
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlMedicament() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<Medicament> GetAllMedicamentsByIdConsultations(int idConsultation) throws SQLException {
        ArrayList<Medicament> mesMedicaments = new ArrayList<>();
        ps = cnx.prepareStatement("select idMedoc,nomMedoc,prixMedoc from medicament,consultation,prescrire where medicament.idMedoc = prescrire.numMedoc And prescrire.numConsult = consultation.idConsult And consultation.idConsult=?");
        ps.setInt(1,idConsultation);
        rs = ps.executeQuery();
        while (rs.next())
        {
            Medicament medoc = new Medicament(rs.getInt(1),rs.getString(2),rs.getDouble(3));
            mesMedicaments.add(medoc);
        }
        return mesMedicaments;
    }
    public ArrayList<Medicament> getAllMedicaments() throws SQLException {
        ArrayList<Medicament> mesMedocs = new ArrayList<>();
        ps = cnx.prepareStatement("SELECT idMedoc,nomMedoc,prixMedoc from medicament");
        rs = ps.executeQuery();
        while(rs.next())
        {
            Medicament med = new Medicament(rs.getInt(1),rs.getString(2),rs.getDouble(3));
        }

        return mesMedocs;
    }
}
