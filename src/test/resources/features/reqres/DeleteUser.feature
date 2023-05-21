Feature: Delete User With exceed parameter id
  @Tugas
  Scenario Outline: Delete user with exceed parameter id
  Given Delete user with exceed id <id>
  When Send delete Exceed user
  Then Status code should be 204 No Content
  Examples:
    | id   |
    | 2000 |
    | 3000 |
    | 5000 |