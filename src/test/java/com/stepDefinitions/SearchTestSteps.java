package com.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchTestSteps {

    @Given("^I made wrong (.*) in life$")
    public void m1Decisions(String decisions) {
        System.out.println("Printing=>> 1st");
    }

    @When("^I am (.*) a lot$")
    public void m2Suffer(String suffering) {
        System.out.println("Printing=>> 2nd");
    }

    @Then("^I have to (.*) and seek forgiveness$")
    public void m3Pray(String pray){
        System.out.println("Printing=>> 3rd");
    }


//    @And("^Be thankful to <what> I have$")
//    public void hh(){
//        System.out.println("4th");
//    }

    
}
