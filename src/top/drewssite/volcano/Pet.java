package top.drewssite.volcano;

//friendly animal
public class Pet extends Animal {

	public Pet(String name, int strength) {
		//same as animal, but set type to itemType.PET instead
		super(name, itemType.PET, strength);
		
		//no extras to add :)
	}
	
	//would've made the target a Monster, but because of the abstract inheritance (i think that's what it is called)
	//it has to be an Animal... so a pet can attack a pet if it wants
	public void attack(Animal target) {
		//fighting mechanics are hard.. i'll do it later
	}

}
