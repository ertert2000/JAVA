package com.proghelp;

public class Doctor {
    private String name;
    private String specialization;
    private String workSchedule;

    public Doctor(String name, String specialization, String workSchedule) 
    {
        this.name = name;
        this.specialization = specialization;
        this.workSchedule = workSchedule;
    }

    public String getName() 
    {
        return name;
    }

    public String getSpecialization() 
    {
        return specialization;
    }

    public String getWorkSchedule() 
    {
        return workSchedule;
    }
}
