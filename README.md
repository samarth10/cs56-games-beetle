cs56-games-beetle
=================
A dice rolling game that you can play against a computer or another person.
The idea is to piece together a body by rolling the correct number.
There are three animals to choose from.

Beetle:
1=body
2=head
3=legs
4=eyes
5=antenna
6=tail

Ant:
1=thorax
2=head
3=legs
4=eyes
5=antenna
6=abdeomen

Person:
1=body
2=head
3=legs
4=eyes
5=mouth
6=arms

The idea is that you need a body(or thorax) first and foremost. Then you can the rest of the required body parts. In order to add eyes and antenna(mouth) you first need a head. Rolling a number that corresponds with a body part that you already have does nothing for your animal and it is the next players turn.

The gui allows the user to click "roll" and a random number between 1-6 is generated and it will add the correct parts to the animal. Then it will automatically do the same for the second player. The system will notify the user of the piece that have been added and whether or not they won or lost.

1. Run.java calls the startGUI class
2. The startGUI class allows the user to select which animal they would like to play with
3. The selected animalGUI class is then launched
4. The user is prompted to select "Single Player" or "Two Players"
5. The user(s) then enter their name(s)
6. The animalGUI class contains counters to update the GUI as rolls are called from the respected Player class.

HOW TO RUN

   ant run


![](http://i.imgur.com/5zEJUCJ.png)