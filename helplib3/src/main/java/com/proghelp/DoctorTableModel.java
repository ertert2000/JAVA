package com.proghelp;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DoctorTableModel extends AbstractTableModel {
    private List<Doctor> doctors = new ArrayList<>();
    private String[] columnNames = {"Врач", "Время", "specialization"};//, "pacient"};

    public DoctorTableModel(List<Doctor> doctors)
    {
        this.doctors = doctors;
    }

    @Override
    public int getRowCount()
    {
        return doctors.size();
    }

    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Doctor doctor = doctors.get(rowIndex);
        switch (columnIndex) 
        {
            case 0: return doctor.getName();
            case 1: return doctor.getWorkSchedule();
            case 2: return doctor.getSpecialization();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    public void addRow(Doctor doctor)
    {
        doctors.add(doctor);
        fireTableRowsInserted(doctors.size()-1, doctors.size()-1);
    }

    public void removeRow(int rowIndex)
    {
        if(rowIndex >= 0 && rowIndex < doctors.size())
        {
            doctors.remove(rowIndex);
            fireTableRowsDeleted(rowIndex, rowIndex);
        }
    }

    public void setRowCount() {
        doctors.clear();
        fireTableDataChanged();
    }
}
