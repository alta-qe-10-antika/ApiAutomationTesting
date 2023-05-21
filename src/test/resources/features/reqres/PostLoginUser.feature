Feature: Post Login User
  @Tugas
  Scenario: Post Login User with valid body json
    Given Post Login User with valid body json
    When Send Post Login User
    Then Status code should be 200 OK
    And Validate Post Login User JSON Schema