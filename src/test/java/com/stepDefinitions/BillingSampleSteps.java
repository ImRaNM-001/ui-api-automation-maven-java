package com.stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;

public class BillingSampleSteps {

    private double billingAmount,               // using comma I've made all variables private and double @ 1shot
    taxAmount,
    finalAmount;

    @Given("^user is on billing page$")
    public void user_is_on_billing_page() {
        System.out.println("Printing=>> User landed on billing page");
//        System.out.println(10/0);                   // deliberately tried to fail the test
    }

    @When("^user enters billing amount \"([^\"]+)\"$")
    public void user_enters_billing_amount(String billingAmount) {
        this.billingAmount = Double.parseDouble(billingAmount);
    }

    @And("^user enters tax amount \"([^\"]+)\"$")       // also can be represented as (.*) for arbitary string
    public void user_enters_tax_amount(String taxAmount) {
        this.taxAmount = Double.parseDouble(taxAmount);
    }

    @And("^user clicks on calculate button$")
    public void user_clicks_on_calculate_button() {
        System.out.println("Printing=>> User clicked on calculate button");
    }

    @Then("^it gives the final amount \"([^\"]+)\"$")
    public void it_give_the_final_amount(String finalAmount){
        this.finalAmount = this.billingAmount + this.taxAmount;
        double expectedFinalAmount = Double.parseDouble(finalAmount);

        System.out.println("Printing=>> Expected final amount is: " + expectedFinalAmount);
        System.out.println("Printing=>> Actual final amount is: " + this.finalAmount);

        Assert.assertTrue(this.finalAmount == expectedFinalAmount);
    }

}
