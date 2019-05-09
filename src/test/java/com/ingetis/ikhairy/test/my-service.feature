Feature: Features of my dao implementation

  Background: 
    Given my employe dao class exists

  Scenario: Get employe count from my db
    When get employe count
    Then employe count should be positif number
    
  Scenario: Get employes list
    When get all employes
    Then employes should be list of size zero or plus
  
  Scenario: Get employe by id
    When get employe with id 1
    Then employe should be only one or null
