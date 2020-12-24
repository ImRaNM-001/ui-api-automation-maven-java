package com.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class RegistrationDataTblSteps{

    @Given("^user is on registration page$")
    public void user_is_on_registration_page(){
        System.out.println("Printing=>> user navigated to registration page");
    }

    @When("^user enters following user details$")
    public void user_enters_following_user_details(DataTable dataTable){
        System.out.println("\n====================\n");

        // using List Collection
        List<List<String> > userList = dataTable.asLists(String.class);    // String.class although not mandatory to
        // write is nothing but value in the List

        // iterate this List
        for(List<String> elem : userList) System.out.println(elem);         // this prints each value in the DataTable
    }


    // When statement for 2nd scenario only
    @When("^user enters following user details with columns$")
    public void user_enters_following_user_details_with_columns(DataTable dataTable){
        System.out.println("\n====================\n");

        // using List and Map Collection
        List<Map<String, String> > userList = dataTable.asMaps(String.class, String.class);    // 1st String.class is
        // map key while 2nd one is map value

        System.out.println(userList);               // prints entire table
        System.out.println("\n====================\n");

        System.out.println(userList.get(0) );       // prints 1st row only
        System.out.println("\n====================\n");

        System.out.println(userList.get(0).get("firstName") );       // prints firstName of 1st row only
        System.out.println("\n====================\n");

        for(Map<String, String> elem : userList){
            System.out.println(elem.get("firstName") );
            System.out.println(elem.get("lastName") );
            System.out.println(elem.get("emailId") );
            System.out.println(elem.get("phoneNumber") );
            System.out.println(elem.get("city") );
            System.out.println("\n====================\n");
        }
    }

    @Then("^user registration should be successful$")             // if ^ $ not used then also works fine
    public void user_registration_should_be_successful(){
        System.out.println("\n====================\n");
        System.out.println("Printing=>> registration is successful for this user");
    }
}
