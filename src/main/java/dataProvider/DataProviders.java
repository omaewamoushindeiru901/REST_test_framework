package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name="authorNames")
    public static Object[][]validNames(){
        return new Object[][]{
                {"Cordia"},
                {"Broderick"},
                {"Alb"},
                {"Kelli"},
                {"Kam"},
                {"Josiah"}
        };

    }

    @DataProvider(name="genreNames")
    public static Object[][]validGenreNames(){
        return new Object[][]{
                {"Legend"},
                {"Adv"},
                {"ext"},
                {"oab"}
        };

    }

}
