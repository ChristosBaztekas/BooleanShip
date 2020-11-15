package Lesson11ClassProgramms;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SecondWindow extends JFrame implements ActionListener
{
	static JButton b1 = new JButton("Εντάξει");
	static JButton b2 = new JButton("Ακύρωση");
	static JTextField f1 = new JTextField();
	static JLabel l1 = new JLabel("Δείτε παραπάνω πληροφορίες.");
	static JTextField f2 = new JTextField();
	static JLabel l2 = new JLabel("Εισαγωγή οργανισμού.");

	// Only for the panel example
	JPanel p = new JPanel();
	JButton pb1 = new JButton();
	
	public SecondWindow()
	{
		super("Title");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400,180);
		//setLayout(new FlowLayout());
		setLayout(new GridLayout(4,2));
		add(l1);
		add(f1);
		add(l2);
		add(f2);
		add(b1);
		b1.addActionListener(this);
		add(b2);
		b2.addActionListener(this);

		// Example panel to combine layouts (only for demonstration)
		add(p);
		p.setLayout(new GridLayout(2,2));
		p.add(pb1);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}