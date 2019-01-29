Feature:
  Verify different operations using Rest-assured

  Scenario Outline: Post Method
    Given I perform a POST operation
    When  I post a new <Name> , <Physics> <Maths> and <Chemistry>

    Examples:
      | Name    |  Physics   |  Maths   | Chemistry  |
      | "Sam"   |   "23"     |  "4"     |    "5"     |
      | "Bonga" |   "87"     |  "90"    |    "80"    |

  Scenario Outline: GET method
    Given I perform GET operation
    When I perform GET for the post number <id>
    Then Response code should be "200"

    Examples:
      | id  |
      |  1  |
      |  2  |



  Scenario: UPDATE Method
    Given I perform a Update operation
    When I change name

  Scenario Outline: Delete Method
    Given I perform Delete operation
    When  I delete <id>
    Examples:
      |  id  |
      |  "1" |
      |  "2" |

