Feature: Put update user with valid json and invalid id
  @Tugas
  Scenario Outline:Put update user with valid json and invalid id
    Given Put update user with valid json and invalid id <id>
    When Send put update user invalid id
    Then Status code should be 200 OK
    Examples:
      | id   |
      | 4000 |
      | 5000 |
      | 6000 |