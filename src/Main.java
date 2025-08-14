import view.LoginFrame;

public class Main {
	//components 
	private LoginFrame loginframe;
	
	//constructors
	public Main() {
		this.loginframe=new LoginFrame();
		this.loginframe.setVisible(true);
	}
	
	//main
	public static void main(String[] args) {
		Main main =new Main();
		main.initialize();
	}
	
	//initialize
	private void initialize() {
		this.loginframe.initialize();
	}

}
