#Jan 11, 2022

Cloned Repository
Updated README.md (name email)
Created and Updated Logbook

#Jan 13, 2022

Updated Backlog in README.md Based On Business Logic Described In Step 2 Of The Instructions
Updated Definition Of Done (DOD) within README.md 
Finished 1 Dice Roll Feature (F01)
Begin F02 - Roll 8 Dice
Implemented 8 Dice Roll as its own function which rolls 8 dice and adds each roll to an array list, returning the ArrayList back to main on completion

Begin F06 - Create Player Pkg
Player Pkg Completed 
Added score variable
Moved Main Roll Implementation of Roll From PiratenKarpen.java to Player.java
Added Get Score, Skulls, And Roll Functions in Player.java
Began ReRoll Implementation in Player.Java

#Jan 16, 2023

Finished ReRoll Implementation (Tested And Working) - Full Turn Can Now Be Simulated
Implemented 2 Players Within PiratenKarpen.java
Removed Unnecessary Imports From PiratenKarpen.java and formatted output
Set Score, Skull and CurrentRoll Variables To Private so they cannot be modified outside the Player Package, Minor Formatting To End Turn Statement (Player.java)
Begin Implemetation of Game Winning Trigger (Game ends with one of the players scores 6000 or more points)
Fixed Score Resetting In Player.Java When Game Runs
Implemented Win Counter Variables For Both Plyaers
Simulated 1 Game
Simulated 42 Games

#Jan 18, 2023
Implemented Percentage Of Wins
Implemented a continuation condition in the event both players tie reaching 6000 points each (also added a debug statement that prints amount of ties)

#Jan 19, 2023
Moved Game elements to seperate Game.java file
Added Comments, Privatized variables in Game.java

#Jan 20, 2023
Added log4j to dependancies
Removed tracker variables from main class (now directly pulled from game class)
Created Strategy Class
Moved Random Strategy to Strategy.java
Sort Dice Array Alphabetically

#Jan 22,2023
Finished Calculating Score taking into account for Combos
Fixed Check Combo Bug
Created Strategy Where Combos Are Maximized (While Adding A Bit Of Prioritization for Diamond And Gold)
Updated Scoring To Support Full Chest Rule
Updated MaxCombos Strategy To Consider Rerolling If The Availible Dice to Roll Is Odd
Updated MaxCombos Strategy To Prioritize Full Chest First

#Jan 23, 2023
Finished MaxCombos Strategy
Added Strategy Setter Function In Player Class (Default Strategy Is Random Unless SetStrat Function Is Called)
Added Command Line Arguments
Made All String Comparisons to use .equals() rather than ==
Updated Scoring System To Give 0 Points If 3 Skulls Are Rolled
Updated Logic Of Currently Implemented Strategies to Accomodate The Risk Of Rolling 3 Skulls

#Jan 25, 2023
Simplified The Args check Function in PiratenKarpen.java
Set Default Strategy Of Both Players To "combo" in PiratenKarpen.java

#Jan 28,2023
Updated ReadMe (New Business Logic Based Features)
Created Cards Class
Cards Class Generated Deck (29 nop and 3 unique Sea Battle Cards (2 of each card in Deck))
Draw Card Function Draws Card From Top Of Deck And Puts The Card At The Bottom Once Used (Manipulates Array)
Print Deck Getter Function Added For Debug Purposes
Scoring System Updated To Give Sea Battle Bonus If Player Wins Sea Battle And Rolls the Minimum Amount of Sabers Needed as Indicated By The Card.
Added Monkey Business Card to Deck in Cards.Java
Updated Check Combo Function To Take An Additional Parameter Of Card so That has Access to Player's Card Value 
If Monkey Business Card Is in Play Sets Value Indicating Monkeys to Be Monkeys + Parrots And Sets Parrots To 0 (For Easy Score Calc and Combo Check)
Switched Display of Player Roll Decision To Trace instead of System.println So It Can Be Called Upon For Debugging Needs
Monkey Business Card Fully Implemented
Added Dice Rolled Tracker Value (Will Indicate To User The Amount Of Individual Dice The Player Rolled Before It Reached it's Final Roll) - The Program Will No Longer Display Each Individual Roll As Its Now A Part Of logger.Trace, Only Intial And Final Roll Will Be Displayed
Updated Output Of Program To Provide Clean And Meaningful Turn Information
log4j2.xml set to off by default, set to "trace" in log4j2.xml to disable logger messages within program.
