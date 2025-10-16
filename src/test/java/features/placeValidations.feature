Feature: Validating Place API
  @AddPlace
  Scenario Outline: Verify place is successfully added using AddPlaceApi
    Given Add Place Payload with "<name>" "<language>" and "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify the place_id created maps to "<name>" using "GetPlaceAPI"
Examples:
    |name    |language    | address        |
    | AHouse | English    | 2nd cross road |
    | BHouse | Konkani    | 3rd cross road |
    | CHouse | Kannada    | 4th cross road |

@DeletePlace
  Scenario: Verify if Delete place functionality is working fine.
    Given Delete Place Payload
    When user calls "DeletePlaceAPI" with "POST" http request
    Then the API call is success with status code 200
    And "status" in response body is "OK"