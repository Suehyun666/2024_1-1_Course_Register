import view.Vmainframe;

public class Main {
	
	//components 
	private Vmainframe Vmainframe;
	
	//constructors
	public Main() {
		this.Vmainframe =new Vmainframe();
		this.Vmainframe.setVisible(true);
	}
	
	//initialize
	public void initialize() {
		this.Vmainframe.initialize();
	}
	
	//methods 
	public static void main(String[] args) {
		Main main =new Main();
		main.initialize();		
	}
	
}