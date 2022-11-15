package Tools;



import Entities.Consultation;
import Entities.Medicament;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel {
    private String[] colonnes;
    private Object[][] lignes;

    @Override
    public String getColumnName(int column) {
        return colonnes[column];
    }

    @Override
    public int getRowCount() {
        return lignes.length;
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lignes[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object value, int row, int column) {
        lignes[row][column] = value;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return column == 3 ;
    }

    public void LoadDatasConsultation (ArrayList<Consultation>lesConsultations)
    {
        colonnes = new String[]{"Numero","date","Nom du patient","Nom du medecin","Montant"};
        lignes = new Object[lesConsultations.size()][5];
        int i =0;
        for (Consultation cons : lesConsultations)
        {
            lignes[i][0] = cons.getNumero();
            lignes[i][1] = cons.getDate();
            lignes[i][2] = cons.getNomPatient();
            lignes[i][3] = cons.getNomMedecin();
            //lignes[i][4] = cons.getMontant();
            i++;
        }
        //Mettre à jour le JTable
        fireTableChanged(null);
    }
    public void LoadDatasMedicaments (ArrayList<Medicament> lesMedicaments)
    {
        colonnes = new String[]{"Numero","Nom","prix"};
        lignes = new Object[lesMedicaments.size()][3];
        int i =0;
        for (Medicament medoc : lesMedicaments)
        {
            lignes[i][0] = medoc.getNumero();
            lignes[i][1] = medoc.getNom();
            lignes[i][2] = medoc.getPrix();
            i++;
        }
        //Mettre à jour le JTable
        fireTableChanged(null);
    }
    public void LoadDatasAllMedoc(ArrayList<Medicament> lesMedocs)
    {
        colonnes = new String[]{"Numero","Nom","prix","quantite"};
        lignes = new Object[lesMedocs.size()][4];
        int i =0;
        for (Medicament med : lesMedocs)
        {
            lignes[i][0] = med.getNumero();
            lignes[i][1] = med.getNom();
            lignes[i][2] = med.getPrix();
            lignes[i][3] = med.getQuantite();
            i++;
        }
        //Mettre à jour le JTable
        fireTableChanged(null);
    }
}
