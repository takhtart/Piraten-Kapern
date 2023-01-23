# A1 - Piraten Karpen

  * Author: Tarnveer Takhtar
  * Email: <takhtart@mcmaster.ca>

## Build and Execution

  * To clean your working directory:
    * `mvn clean`
  * To compile the project:
    * `mvn compile`
  * To run the project in development mode:
    * `mvn -q exec:java` (here, `-q` tells maven to be _quiet_)
  * To package the project as a turn-key artefact:
    * `mvn package`
  * To run the packaged delivery:
    * `java -jar target/piraten-karpen-jar-with-dependencies.jar` 
  * To enable trace mode:
    * `Set <Root level="trace">` in log4j2.xml under `src/main/resources`

Remark: **We are assuming here you are using a _real_ shell (e.g., anything but PowerShell on Windows)**

## Feature Backlog

 * Status: 
   * Pending (P), Started (S), Blocked (B), Done (D)
 * Definition of Done (DoD):
   * < Standalone Feature Is Completed, Tested, And Implemented Within the Program >

### Backlog 

| MVP? | Id  | Feature  | Status  |  Started  | Delivered |
| :-:  |:-:  |---       | :-:     | :-:       | :-:       |
| x   | F01 | Roll a dice | D | 01/11/23 | 01/11/23 |
| x   | F02 | Roll eight dices  | D | 01/13/23 | 01/13/23 |
| x   | F03 | Simulate 42 games | D | 01/16/23 | 01/16/23 |
| x   | F04 | Score Points (Multiply # of Diamonds and Coins By 100) | D | 01/13/23 | 01/16/23 |
| x   | F05 | Player keeping random dice, Re-rolling until obtaining three skulls to end the turn | D | 01/13/23 | 01/16/23 |
| x   | F06 | Create 2 Players, Playing With The Same Strategy | D | 01/13/23 | 01/16/23 |
| x   | F07 | Print % Of Wins of Each Player | D | 01/16/23 |  01/16/23 |
| x   | F08 | Game Ends When A Player Reaches Or Exceeds 6000 Points | D | 01/16/23 | 01/16/23 |
| x   | F09 | Updated Scoring System To Support Combos | D | 01/20/23 | 01/22/23 |
| x   | F10 | New Player Strategy (Maximize Combos) | D | 01/22/23 | 01/23/23 |
| x   | F11 | Command Line - Choose What Strategy Players Use During The Game | D | 01/23/23 | 01/23/23 |
| ... | ... | ... |

