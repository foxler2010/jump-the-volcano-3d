# Jump The Volcano
A simple Java text adventure all about jumping over a volcano.

# History
Oh, by the way, it wasn't me who came up with the idea for this.
It's been a long running thing in my family to play this game in conversation.
There is a "game master" who is the 'speaker' for the game and decides what items the player gets,
and there is the player who chooses what to do each turn.
The game master is like the randomizer in the code.
They get to choose all the items the player gets and what options they have each turn.
Now, when I was talking a few days ago about this game,
I thought of coding it on my computer as a text adventure. And that's how this project came to be.

# How to play
1. You need Java SE 1.8 installed because I haven't gotten around to building a system-binary of this game.

2. You run the main.class file you just compiled and give it some parameters. The first is the DEFAULT starting level and the second is the DEFAULT amount of money you will have.
You will have prompts for both these values in-game, and they should override the parameters in almost all cases. The only time this doesn't happen is if there is an error receiving the amount specified. Then it defaults to the parameter.

3. Navigate giving yourself inventory items. I still haven't come up with a good way to give yourself inventory items as there will be a lot of those and they will all be organized by index number so right now there's no good way to do that unless you want to edit the code and give yourself items at the beggining of each and every game.

--SIDE NOTE--
A normal game usually starts with you having absolutely nothing. These parameters are just for if you want to resume an old game (yeah im lazy and didn't implement a 'saving' feature yet). I would reccomend leaving them at 0 so you start with 0 money and level 0 (now please don't come running to me if you lost your 'save' and can't get it back. This is not a long-term game. It can be played in the moment and you will still have fun. I don't care about your save, I really only made this feature to help with testing.)
--END SIDE NOTE--

4. Finally start playing. The game starts as soon as you hit enter on the "java main <parameters>" command. The rules are self-explanatory. You get options every turn and based on what you choose certain things happen. There is a lot of randomization involved so every game is different.

5. That's it. Have fun playing Jump The Volcano!
