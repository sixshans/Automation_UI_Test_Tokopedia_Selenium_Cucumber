Feature: Search laptop MSI on Tokopedia

  Scenario: User can search laptop MSI and click product details
    Given User on Tokopedia website home page
    And User search Laptop MSI on search bar
    And User directed into list of laptop MSI
    When User click product
    Then User directed to product detail page