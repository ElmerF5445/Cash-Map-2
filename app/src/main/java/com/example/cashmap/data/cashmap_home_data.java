package com.example.cashmap.data;

public class cashmap_home_data {
    private String ATM_Location;
    private String ATM_Status;
    private int ATM_Status_Dot;
    public cashmap_home_data(String ATM_Location, String ATM_Status, int ATM_Status_Dot){
        this.ATM_Location = ATM_Location;
        this.ATM_Status = ATM_Status;
        this.ATM_Status_Dot = ATM_Status_Dot;
    }

    public String getATM_Location(){
        return ATM_Location;
    }

    public String getATM_Status(){
        return ATM_Status;
    }
    public int getATM_Status_Dot(){
        return ATM_Status_Dot;
    }
}
