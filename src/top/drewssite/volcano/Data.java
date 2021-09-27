package top.drewssite.volcano;
import java.util.*;

//initializes almost everything in the game
//only a few exceptions (mostly in the beginning of the main method)
class Data {
	
	//let's start with some junk
	static Junk oldCanOfBeans = new Junk("Old Can of Beans", .05);
	
	static Junk dirtySodaBottle = new Junk("Dirty Soda Bottle", .05);
	
	public static Junk moldySock = new Junk("Moldy Sock", .05);
	
	public static Junk brokenMagnet = new Junk("Broken Magnet", .10);
	
	//will be switched to type 'Food' once the type is implemented
	public static Junk freshBudLight = new Junk("Fresh Bud Light", 10.0);
	
	public static Junk veryDietSoda = new Junk("Very Diet Soda", 5.0);
	
	//monsters!
	public static Monster weed = new Monster("The Weed That Keeps Popping Up In Your Garden", 1);
	
	public static Monster slime = new Monster("Slime", 3);
	
	public static Monster jupiterThePlanet = new Monster("Jupiter, the planet", 1000);
	
	public static Monster zeus = new Monster("Zeus, God of Lightning", 9999);
	
	public static Monster lightbulb = new Monster("Lightbulb", 1);
	
	public static Monster sharpGlass = new Monster("Sharp Glass", 2);
	
	//pets!
	public static Pet dog = new Pet("Dog", 10);
	
	public static Pet cat = new Pet("Cat", 10);
	
	public static Pet axolotl = new Pet("Axolotl", 20);
	
	public static Pet rhino = new Pet("Rhino", 150);
	
	public static Pet neilArmstrong = new Pet("Neil Armstrong", 30);
	
	//list of items you may find in a dumpster
	public ArrayList<Item> insideDumpster = new ArrayList<Item>();
	
	//insideDumpster.add(oldCanOfBeans);
	
}
