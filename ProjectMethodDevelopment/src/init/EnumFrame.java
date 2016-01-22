package init;

public enum EnumFrame {
	WELCOME(0),
	MENU(1),
	GAME(2),
	END(3);
	
	private int value;
	
	private EnumFrame(int value) {
        this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}

