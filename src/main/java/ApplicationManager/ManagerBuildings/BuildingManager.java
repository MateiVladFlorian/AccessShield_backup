/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ApplicationManager.ManagerBuildings;

import ApplicationManager.Builds;

/**
 *
 * @author vlad
 */
public class BuildingManager {
    public static Builds panelWindowCopy;
    
    public static void setWindow(Builds panelWindow) {
        panelWindowCopy = panelWindow;
    }
    
    public static Builds GetWindow() {
        return panelWindowCopy;
    }
}
