@All
Feature: Self-loneliness
#  As a lonely guy
#  who spent entire guy in loneliness
#  hopes to die in peace

  @Search
  Scenario Outline: Ways to treat loneliness based on my decisions
    Given I made wrong <decisions> in life
    When I am <suffering> a lot
    Then I have to <pray> and seek forgiveness

    Examples:
      | decisions    | suffering   | pray      |
      | school study | mental heat | knowledge |
      | gadha engg   | hair loss   | techie    |

