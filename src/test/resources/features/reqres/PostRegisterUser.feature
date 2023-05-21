Feature: Post Register User
  @Tugas
  Scenario: Post Register User with valid json
    Given Post Register User with valid json
    When Send Post Register User
    Then Status code should be 200 OK
    And Validate Post User JSON Schema