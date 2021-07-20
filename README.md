# Jump The Volcano
A simple Java text adventure all about jumping over a volcano.

# History
Well, for starters, it wasn't me who came up with the idea for this.
I'll spare you the details, but it's been a long running thing in my family to play this game in conversation.
There is a "game master" who is the 'speaker' for the game and decides what items the player gets,
and there is the player who chooses what to do each turn.
The game master is like the randomizer in the code.
They get to choose all the items the player gets and what options they have each turn.

Now, some time ago I was talking to my brother about this game, and we thought that it would be amazing if this game was 'digitalized'. Me learning Java at the time, I thought it would be a good challenge to create this game from scratch using 
zero libraries (for portability). And that's how this project came to be.

# How to play
1. You need Java SE 1.8 installed because I haven't gotten around to building a binary of this game for all platforms.
Compile the source and put it somewhere you want to keep it. It does not require any sort of installation on your system, just needs to be put somewhere where you can run it.

2. You run the Main.class file you just compiled and (if you want) give it a parameter detailing what level you would like to 
start at. You will have prompts for both these values in-game, and they should override the parameters in almost all cases. The only time this doesn't happen is if there is an error receiving the amount specified. Then it defaults to the parameter.

3. Navigate giving yourself inventory items. I still haven't come up with a good way to give yourself inventory items as there will be a lot of those and they will all be organized by index number so right now there's no good way to do that unless you want to edit the code and give yourself items at the beggining of each and every game.

--SIDE NOTE--
A normal game usually starts with you having absolutely nothing. These parameters are just for if you want to resume an old game (yeah im lazy and didn't implement a 'saving' feature yet). I would reccomend leaving them at 0 so you start with 0 money and level 0 (now please don't come running to me if you lost your 'save' and can't get it back. This is not a long-term game. It can be played in the moment and you will still have fun. I don't care about your save, I really only made this feature to help with testing.)
--END SIDE NOTE--

4. Finally start playing. The game starts as soon as you hit enter on the command. The rules are self-explanatory. You get options every turn and based on what you choose certain things happen. There is a lot of randomization involved so every game is different.

5. That's it. Have fun playing Jump The Volcano!

# Troubleshooting

First off, I can't give a lot of support if you are on Windows. I use Linux, and you should too, but I can live with it if you decide to continue using Windows for now. That being said, if you have problems that seem to pertain to the OS, you're goign to have to debug them yourself. Feel free to make a patch to fix it and please send it to me so I can make a pr of it. Just knough that I won't do anything about your problem.

Also, on Mac, I cannot give a ton of support, but I might ahve some suggestions to help. But that's only because Mac is based off of Unix, and I like Unix. I really don't know much else about it so don't expect much from me. Like with Windows, feel free to make a patch and send it me, just don't expect any official compatibility updates from me.

Now, if it is not an OS problem, be sure you ran the command correctly. My setup for Eclipse IDE gives me a folder structure of this: /root-of-project/bin/top/drewssite/volcano/Main.class.
I navigate to the /bin/ folder in the CLI and run the command "java top.drewssite.volcano.Main <starting level>". This is the correct Java way of running a class file, so if you aren't sure if you are running it the right way, just mimic what I described above.
  
This is a very new project and I have not yet gotten any support requests and so cannot make an FAQ. One will be added later once I get requests for support.
