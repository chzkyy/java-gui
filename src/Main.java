import javax.swing.JFrame;

public class Main extends JFrame {

	public Main() {
		setSize(400, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new RegForm());
		setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}
}
