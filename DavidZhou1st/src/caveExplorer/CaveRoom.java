package caveExplorer;

public class CaveRoom {

	private String description;//tells what the room looks like
	private String directions;//tells what you can do
	private String contents;//a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organized by direction, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRoutes;
	private CaveRoom[] borderingRooms;
	private Door[] doors;
	
	public String getDescription() {
		return description+"\n"+directions;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}
	public void enter() {
		contents = "X";
	}
	public void leave() {
		contents = defaultContents;
	}
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction),this,door);
	}
	public static int oppositeDirection(int direction) {
		return (direction+2)%4;
	}
	public void addRoom(int direction, CaveRoom cave, Door door) {
		borderingRooms[direction]=cave;
		doors[direction]=door;
		setDirections();
	}

	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is  "contents" becomes an 'x' when you are
		//inside this room, when you leave, it goes back to defaultContents
		
		//note: by default, arrays will populate with 'null' meaning there are no connections
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
		
	}
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w', 'a', 's', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		String dirs = "wdsa";
		goToRoom(dirs.indexOf(input));
	}

	private boolean isValid(String input) {
		String validEntries = "wdsa";
		return validEntries.indexOf(input) > -1&& input.length() ==1;
	}


	private void goToRoom(int direction) {
		if(borderingRooms[direction]!=null&&doors[direction]!=null){
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}
	
	public static void setUpCaves() {
		//ALL OF THESE CODE CAN BE CHANGED
		//1. Decide how big your caves should be
		CaveExplorer.caves= new CaveRoom[5][5];
		//2. Populate with caves and a default description: hint when starting, use coordinates (helps debugging)
		for (int row=0;row<CaveExplorer.caves.length;row++) {
			//PLEASE PAY ATTENTION TO THE DIFFERENCE:
			for(int col=0;col<CaveExplorer.caves[0].length;col++) {
				//create a "default" cave
				CaveExplorer.caves[row][col] = new CaveRoom("This cave has coords ("+row+","+col+")");
			}
		}
		//3. Replace default rooms with custom rooms
		//we will do later
		
		//4. Set your starting room:
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		//5. Set up doors
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
	}

	public static String toDirection(int dir) {
		String[] arr = {"the North", "the East", "the South", "the West"};
		return arr[dir];
	}
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for(int i = 0;i<doors.length;i++) {
			if (doors[i]!=null) {
				doorFound = true;
				directions += "\n There is a "+doors[i].getDescription()+" to "+toDirection(i)+ "."+doors[i].getDetails();
			}
	}
		if (!doorFound) {
			directions += "There is no way out. You are trapped in here.";
		}
}
}
