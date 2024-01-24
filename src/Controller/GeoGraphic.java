/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Controller;

import VIew.UserInterface;

/**
 *
 * @author ninza
 */

public class GeoGraphic {

    public static void main(String[] args) {
        ManageEastAsiaCountries controller = new ManageEastAsiaCountries();
        UserInterface user = new UserInterface(controller);

        user.run();
    }
}