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

  Scenario: Insert new employee
    When insert employe
      | John |
      | Snow |
    Then employe id should be a positif non zero number

  Scenario: Update employee
    When update employe by id
      |   17 |
      | Snow |
      | John |
    Then employe first name and last name should be inversed

  Scenario: Delete employee
    When delete employe by id 22
    Then employe with specifyed id should be deleted
