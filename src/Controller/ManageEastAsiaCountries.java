/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author ninza
 */
public class ManageEastAsiaCountries {
    private List<EastAsiaCountries> countriesList;

    public ManageEastAsiaCountries() {
        countriesList = new ArrayList<>();
    }

    public void addcountry(EastAsiaCountries country) throws Exception {
        if (country.getTotalArea() <= 0) {
            throw new Exception("Total area must be greater than 0.");
        }

        countriesList.add(country);
    }

    public EastAsiaCountries getCountry() throws Exception {
        if (countriesList.isEmpty()) {
            throw new Exception("No information available. Add countries first.");
        }

        return countriesList.get(countriesList.size() - 1);
    }

    public EastAsiaCountries[] searchbyName(String name) throws Exception {
        List<EastAsiaCountries> result = new ArrayList<>();

        for (EastAsiaCountries country : countriesList) {
            if (country.getCountryName().equalsIgnoreCase(name)) {
                result.add(country);
            }
        }

        if (result.isEmpty()) {
            throw new Exception("Country not found.");
        }

        return result.toArray(new EastAsiaCountries[0]);
    }

    public EastAsiaCountries[] sortbyOrder() throws Exception {
        if (countriesList.isEmpty()) {
            throw new Exception("No information available. Add countries first.");
        }

        Collections.sort(countriesList, Comparator.comparing(EastAsiaCountries::getCountryName));

        return countriesList.toArray(new EastAsiaCountries[0]);
    }
}

