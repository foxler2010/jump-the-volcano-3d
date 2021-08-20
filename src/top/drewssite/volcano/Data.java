package top.drewssite.volcano;

//contains the initializations for all items. (except player)
//also initializes some useful lists of items
class Data {
	
	//let's start with some junk
	Junk oldCanOfBeans = new Junk("Old Can of Beans", .05);
	
	Junk dirtySodaBottle = new Junk("Dirty Soda Bottle", .05);
	
	Junk moldySock = new Junk("Moldy Sock", .05);
	
	Junk brokenMagnet = new Junk("Broken Magnet", .10);
	
	//will be switched to type 'Food' once the type is implemented
	Junk freshBudLight = new Junk("Fresh Bud Light", 10.0);
	
	Junk veryDietSoda = new Junk("Very Diet Soda", 5.0);
	
	//monsters!
	Monster weed = new Monster("The Weed That Keeps Popping Up In Your Garden", 1);
	
	Monster slime = new Monster("Slime", 3);
	
	Monster jupiterThePlanet = new Monster("Jupiter, the planet", 1000);
	
	Monster zeus = new Monster("Zeus, God of Lightning", 9999);
	
	Monster lightbulb = new Monster("Lightbulb", 1);
	
	Monster sharpGlass = new Monster("Sharp Glass", 2);
	
	//pets!
	Pet dog = new Pet("Dog", 10);
	
	Pet cat = new Pet("Cat", 10);
	
	Pet axolotl = new Pet("Axolotl", 20);
	
	Pet rhino = new Pet("Rhino", 150);
	
	Pet neilArmstrong = new Pet("Neil Armstrong", 30);
	
}
