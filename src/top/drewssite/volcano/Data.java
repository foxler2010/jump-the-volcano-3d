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
	
}
