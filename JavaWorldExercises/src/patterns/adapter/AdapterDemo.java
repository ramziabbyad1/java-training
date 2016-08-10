package patterns.adapter;

public class AdapterDemo {
	
	private interface Action {
		int act();
	}
	
	static int doActionX() {return 0;}
	static int doActionY() {return 1;}
	static int doActionZ() {return 2;}
	
	static Action[] actions = new Action[]{
			new Action(){public int act() {return doActionX();}},
			new Action(){public int act() {return doActionY();}},
			new Action(){public int act() {return doActionZ();}}
	};

	public static void main(String[] args) {
		for(Action action: actions) {
			System.out.println(action.act());
		}
	}

}
