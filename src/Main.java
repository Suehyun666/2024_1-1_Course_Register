import View.LoginFrame;

public class Main {
    //attributes 

    //components 
    private LoginFrame loginframe;

    //constructors
    public Main() {
        this.loginframe = new LoginFrame();
        this.loginframe.setVisible(true);
    }

    //main
    public static void main(String[] args) {
        Main main = new Main();
        main.initialize();
        main.run();
    }

    //methods
    private void run() {
    }

    //initialize
    private void initialize() {
        this.loginframe.initialize();
    }

}
