import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
 
public class JPanelDemo extends JFrame
	{
	static boolean nameStatus = false;
	private static final long serialVersionUID = 1L;
 
	public static void JFrame()
		{
		final JFrame frame = new JFrame("JFrame Name");
		frame.setSize(400, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); //Sets JPanel to center of screen 
		
		JButton button = new JButton("Enter");
		final TextField txtfield = new TextField(20);
		final JLabel words = new JLabel("Enter your name");
		
		final JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		frame.add(panel);
		panel.add(words);
		panel.add(txtfield);
		panel.add(button);
		button.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent arg0) 
				{
				System.out.println("Welcome " + txtfield.getText() + " to the blcakjack casino");
				nameStatus = true;
				}
			});
		
		frame.setVisible(true);
		}
	}