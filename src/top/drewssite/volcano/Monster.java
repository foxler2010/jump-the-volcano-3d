package top.drewssite.volcano;

//unfriendly animal.. pretty much exactly the same as pet
class Monster extends Animal {

	Monster(String name, int strength) {
		//same as animal, but set type to itemType.MONSTER instead
		super(name, itemType.MONSTER, strength);
		
		//no extras to add :)
	}
	
	//would've made the target a Pet, but because of the abstract inheritance (i think that's what it is called)
	//it has to be an Animal... so a monster can attack a monster if it wants
	void attack(Animal target) {
		//fighting mechanics are hard.. i'll do it later
	}

}
