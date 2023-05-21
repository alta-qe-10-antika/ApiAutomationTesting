Feature: Get Single User Not Found
  @Tugas
 Scenario Outline: Get single user with invalid parameter id
   Given Get single user with invalid parameter id <id>
   When Send get single user
   Then Response code should be 404 Not Found
   Examples:
     | id    |
     | 50000 |
     | 10000 |

