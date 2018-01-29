Feature: To test the fibonacci sequence

  Scenario: To test the fibonacci sequence for the first 10 numbers
   Given the user in the homepage
   Then the user should be displayed with the fibonacci sequence for first ten numbers

  Scenario Outline: To Test the fibonacci value for the number
    Given the user set the <index> for fibonacci in the url
    Then the user should be displayed with the appropriate fibonacci <value>
    Examples:
      |index  |value        |
      |   5   |  5          |
      |   0   |  0          |
      |  25   |75025        |
      |  29   |514229       |   //failure test due to error in application
      |  50   |12586269025  |   //failure test due to error in application
      |  -3   |  2          |

  Scenario Outline: To Test range the fibonacci values
   Given the user set the <startIndex> and <finishIndex> as a range for fibonacci
   Then the user should be displayed with the appropriate range of fibonacci values
   |<range> |
   |<range1>|
   |<range2>|
   |<range3>|
   Examples:
   |startIndex|finishIndex |range |range1   |range2    |range3   |
   |15         | 25        | 610  | 4181    |17711     |46368    |
   |25         | 30        |75025 |121393   |196418    |514229   |     //failure test due to error in application



