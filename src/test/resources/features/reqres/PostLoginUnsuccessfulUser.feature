Feature: Post Login Unsuccessful with body json
  @Tugas
  Scenario: Post Login Unsuccessful with body json
    Given Post Login Unsuccessful with body json
    When Send Post Login Unsuccessful
    Then Status code should be 400 Missing Password
