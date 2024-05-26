package stepDefinition;

import Common.ConfigLoader;
import DriverUtils.SharedDriver;
import io.cucumber.java.en.Given;
import pageLayer.HomePageLayer;

public class GivenStepDefinition {
    HomePageLayer homePageLayer;

    public GivenStepDefinition(SharedDriver dr,
                               HomePageLayer p) {
        this.homePageLayer = p;
    }

    @Given("User visit home page")
    public void user_visit_home_page() {
        homePageLayer.gotoUrl();
        System.out.println("CONFIG UNDERWRITING: "+ ConfigLoader.config.getString("underwriting_link"));
    }

}