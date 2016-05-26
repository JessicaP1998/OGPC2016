Jessica Peterson & Sasha Leamy

For our project the plan is to build a controller that can communicate with a computer game, which we plan to enter in OGPC. Our biggest problem will be trying to get the communication between the circuitry and the video game. As for the nature of the game, we are not completely sure since we do not know the topic for this year yet. The game will be programmed in Java and we plan on emailing David Anuta, who graduated last year but also made a game using a physical device, in order to get some information as to how he went about making the dancing game. Since we do not know about the topic for OGPC yet we will be working on menus, options and learning about what to use to build the circuitry and how to communicate between it and the computer.

How to Install and Set-Up RXTX in Eclipse
The first thing that you need to do is find out how many bits your computer is. If it is 32 bit go to http://rxtx.qbang.org/wiki/index.php/Download. If it is 64 bit go to http://fizzed.com/oss/rxtx-for-java. Once you download it, extract the file. Inside of the newly extracted file there should be RXTXcomm.jar, rxtxParallel.dll, and rxtxSerial.dll. These should all go into various folders in your java folder which should be located. The RXTXcomm.jar should go into the Windows(C:), programfiles java into the lib ext folder. The rxtxParallel.dll and rxtxSerial.dll should go into the bin folder in java.
Adding the RXTX libraries into your eclipse project can be done by first adding a lib folder in your project. Copy RXTXcomm, rxtxParallel, and rxtxSerial all into that new folder. Next right click on you project folder and then go down to build path > configure build path. Once there click on add Jars and then add RXTXcomm.jar. click ok. Then expand RXTXcomm.jar, and click on native library location and then on edit. Edit the location to be you lib folder in the project. Check and make sure that the project compiles and communicates with a device.
 
The Controller
The controller will be a simple design with a directional pad on the left hand side. In the bottom center of the controller there will be the menu button. On the right side of the controller there will be a select button and a switch character button. They will be positioned diagonally from each other, but close to the center. A class will be used to enable communication to the game itself. The controller is soldered together, and resistors connect every button to the positive. Wires will connect them to pins on the controller. It is incased in a 3-D printed case.
 
We also plan on working on the Abstract Algebra app but we are not sure what is going to be happening with that.
 
9/11/15 Supplies needed for the controller:
-          1 adafruit metro mini board
-          6 buttons
-          Coated wire
-          Case (hopefully 3-D printed)
-          
Game mechanics
Puzzle Story based Game
The two main characters will remain the same: a mother and a child. The player will be able to move around the world by using the directional pad. The critical switch character piece will be used to switch between the mother and the child. When the user switches characters, the look of the world will change. The mother’s world will be darker, and supposedly more realistic. The child, on the other hand, will see the world more like and imaginary kingdom. Each perspective will hold the key to different puzzles throughout the course of the game. Additionally in the game the user will face critical moral choices that will change the way that the child or the mother views the world. Additionally some of the people will die right after being helped or ignored. This will come into play later because unbeknownst to the player at the beginning, the mother is dying of cancer caused by exposure to radiation during the war. In the end when the mother dies, the people who they helped, and died will reappear to welcome the mother and comfort the child.
Plot and crucial moments in the game:
1.       The game opens with a scene that shows the nuclear war that caused the devastation. It also shows the death of the father and brother of the child. It ends with the mother comforting the child.
2.       The game play now starts with an older version of the mother and child. They are in an abandoned city. Here there might be a brief tutorial to show how to switch between characters. There is then the sound of an explosion forcing the mother and child to find a way to enter an abandoned building.
3.       Upon entering the building the player is confronted with the first of the moral decisions. There is a mutant on the edge of death that asks for someone to grab his teddy bear. The mother is scared and revolted, but the child sees things differently.
4.       The player choses to help or not help the mutant, and that decision will impact how they get out. Upon exiting the mother and child must run from falling shrapnel.
5.       The game will continue in this manner with six people that you can help. Three of which die and show up in the end.

 We are also planning on using the game to compete in project Mythos, but how that will impact the story and design of the game is unknown.
 
10/27/2015
Sasha is learning libGDX and Jessica is working on the Arduino input to java.

11/9/15
Sasha:
Working on the menu and the ability to switch between sprites. Also working on the art and design to be used.

Jessica:
Working on creating an eclipse application for communicating between an Arduino and eclipse. Also we designed and updated the storyline of the game.

11/30/2015
Sasha:
I created the ability to move around and switch between characters, which also switches the background. Now I am	working on creating a main menu for the game. The two characters also move at different speeds.
 
Jessica:
I was able to get an arduino uno to give input to the computer, which will allow us to build the controller for the 	game. 
 
12/7/15
Sasha:
Working on combining the code for the menu, movement, and switching characters into one java application.

Jessica:
Working on eliminating the errors from the Arduino and java communication.

1/15/16
Sasha:
Creating separate classes for the movement of the mother and child.

Jessica:
Working on designing the circuit for the controller and having a list of all of the supplies that we need. Additionally creating a compatible class for receiving input from the Arduino.

18/2/2016

Sasha: I have created seperate classes for movement and have figured out how to select within a set area and have that change 
the background. The next step is to draw and combine the code with Jessica.

Jessica: I have finished the controller design and the class to communicate the controller. Also I have started on the CAD design for the controller case and the settings menu. We will be combining the code and reaching the final steps of the basic mechanics.

3/3/2016

Sasha:
Has successfully combined the game code with Jessica's controller code, and has created an instructions code in the menu.

Jessica:
I have worked on combining the code with Sasha, and have began to solder the controller.

3/17/2016

Sasha:
Has worked on updating and cleaning up the code in the engine to allow for seemless communication.

Jessica:
Has worked on soldering the controller and finishing up any 3D design for the controller.

4/4/2016

Sasha:
Has been working on the artwork and coordinating with the music department on the music.

Jessica: 
Has been working on finalizing the CAD drawing for the controller, and updating the arduino code. I will be finishing up the soldering, and making the sequence where the character is running away from the debris.

4/18/2016

Sasha: 
Has been working on getting the necessary art done for OGPC.

Jessica:
Has been trying to finish up the 3-D model and working out the kinks in the arduino code.

4/25/2016

Sasha:
Has worked on putting bounds on the screen and inputting the walking animations.

Jessica:
Has worked on getting libGDX to work on the computers. 

5/10/2016

Sasha:
Has been trying to finish drawing and and adding the art to the game.

Jessica:
Has been working on adding a falling debris class to the game.

5/24/2016

Sasha:
Has been finishing the art, and finishing it up before the end of the year.

Jessica:
Has been updating the documentation, and ironing out any kinks in RXTX.
