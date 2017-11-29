package classNotes;

public class Pokemon {
	int level;
	int hp;
	String name;
	boolean poisoned;
	public Pokemon(String name, int level) {
		this.level=level;
		this.name=name;
		this.hp = 100;
		this.poisoned = false;
	}
	public void iChooseYou() {
		System.out.println(name);
		System.out.println(name);
	}
	int getHp() {
		return hp;
	}
	String getName() {
		return name;
	}
	void setHP(int newHP) {
		hp = newHP;
	}
	void setPoisoned(boolean b) {
		poisoned = b;
	}
	void lapse() {
		if(poisoned = true) {
			hp = hp-15;
		}
	}
	 public static void main(String[] args) {
		 Pokemon squirtle = new Pokemon("Squirtle",26);
		 Pokemon bulbasaur = new Pokemon("Bulbasaur",26);
		 squirtle.iChooseYou();
		 bulbasaur.iChooseYou();
		 System.out.println("Squirtle is preparing to attack with water blast");
		 squirtle.attack(bulbasaur, new Attack() {
		 
		 public void attack(Pokemon target) {
		 int hp = target.getHp();
		 target.setHP(hp/2);
		 }
		 });
		 System.out.println("Bulbasaur is preparing to attack with poison.");
		 bulbasaur.attack(squirtle, new Attack() {
		 
		 public void attack(Pokemon target) {
		 target.setPoisoned(true);
		 }
		 });
		 squirtle.lapse();
		 bulbasaur.lapse();
		 printScore(squirtle, bulbasaur);
		 System.out.println("Squirtle is attacking again");
		 squirtle.attack(bulbasaur, new Attack() {
			
			@Override
			public void attack(Pokemon target) {
				int oldHP = target.getHp();
				target.setHP(oldHP-1);
			}
		});
		 squirtle.levelUp(new Effect() {
			
			@Override
			public void happens(Pokemon target) {
				int curHp = target.getHp();
				
			}
		});
		 printScore(squirtle, bulbasaur);
		 }
	 private static void printScore(Pokemon p1, Pokemon p2) {
		System.out.println(p1.getName()+", HP = "+p1.getHp());
		System.out.println(p2.getName()+", HP = "+p2.getHp());
		
	}
	public void attack(Pokemon target, Attack attack){
		 if(Math.random() < .9){
		 attack.attack(target);
		 System.out.println("The attack hit");
		 }else{
		 System.out.println("The attack missed");
		 }
		 }
	public void levelUp(Pokemon target ,Effect e) {
		this.level++;
		e.happens(target);
	}
}
