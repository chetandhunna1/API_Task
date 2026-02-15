
Feature: Sample API validation

  Scenario: Validate GET user API
    Given user hits GET api
    Then status code should be 200
    #Then Validate response body
    Then Validate the response body contains name as "Sachi Rautroy"
    And Validate alternate_names contains "Yugashrashta Sachi Routray"

