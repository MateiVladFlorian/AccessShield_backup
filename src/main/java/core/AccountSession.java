/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author vlad
 */
public class AccountSession {
    static int id;
    static String username;
    static String BuildingName;
    static boolean isAuthenticated = false;
    
    public static void setAccountId(int val) {
        id = val;
    }
    
    public static int getAccountId() {
        return id;
    }
    
    public static String getBuildingName() {
        return BuildingName;
    }
    
    public static void setBuildingName(String buildingName) {
        BuildingName = buildingName;
    }
    
    public static void setUsername(String fullName) {
        username = fullName;
    }
    
    public static String getUsername() {
        return username;
    }
    
    public static void Authenticate(boolean val) {
        isAuthenticated = val;
    }
    
    public static boolean IsAuthenticated() {
        return isAuthenticated;
    }
}
