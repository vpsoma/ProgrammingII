import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class OptionMenu extends JFrame implements ActionListener {
	// name the options of main menu
	private JMenuItem item1 = new JMenuItem("1.Set the cost of sold items");
	private JMenuItem item2 = new JMenuItem("2.Buy product's stock");
	private JMenuItem item3 = new JMenuItem("3.Add customer's purchase");
	private JMenuItem item4 = new JMenuItem("4.Make an offer");
	private JMenuItem item5 = new JMenuItem("5.Calculate known data");
	private JMenuItem item6 = new JMenuItem("6.Insert a csv file");
	JMenu menu1;
	int quantOfProduct, quant2, quant3, quant4, quant5, quant6, quant7, quant8, quant9;
	String nameOfProuct;
	ProductFactory objectOfProductFactory = new ProductFactory();

	// constructor
	public OptionMenu() {
		// menu
		JFrame F = new JFrame("Menu");
		JMenuBar menubar = new JMenuBar();
		menu1 = new JMenu("Select option!");
		menubar.add(menu1);

		// add action listener
		item1.addActionListener(this);
		item2.addActionListener(this);
		item3.addActionListener(this);
		item4.addActionListener(this);
		item5.addActionListener(this);
		item6.addActionListener(this);

		// add items to menu
		menu1.add(item1);
		menu1.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		menu1.add(item5);
		menu1.add(item6);

		// set size,location and make visible
		F.setJMenuBar(menubar);
		F.pack();
		F.setLocationRelativeTo(null);
		F.setSize(550, 500);
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/image.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(450, 300, 13, 35);
		F.getContentPane().add(label);
		F.setVisible(true);

		// create the submenu of customer's purchase option
		JFrame F2 = new JFrame("Click a product");
		F2.setLocationRelativeTo(null);
		F2.setSize(500, 500);
		JPanel panel2 = new JPanel();
		F2.add(panel2);
		F2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create and add the buttons
		ImageIcon Product1 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\hat1.png");
		ImageIcon Product2 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\Careers.png");
		ImageIcon Product3 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\t-shirt.png");
		ImageIcon Product4 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\Bow_tie.png");
		ImageIcon Product5 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\hat2.png");
		ImageIcon Product6 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\dress.png");
		ImageIcon Product7 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\m_jacket.png");
		ImageIcon Product8 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\heels.png");
		ImageIcon Product9 = new ImageIcon("C:\\Users\\nmpoura\\eclipse-workspace\\Java_Prog2\\image\\earings.png");
		JButton b5 = new JButton("Product1", Product1); // change names
		JButton b6 = new JButton("Product2", Product2);
		JButton b7 = new JButton("Product3", Product3);
		JButton b8 = new JButton("Product4", Product4);
		JButton b9 = new JButton("Product5", Product5);
		JButton b10 = new JButton("Product6", Product6);
		JButton b11 = new JButton("Product7", Product7);
		JButton b12 = new JButton("Product8", Product8);
		JButton b13 = new JButton("Product9", Product9);
		setLayout(new FlowLayout());
		add(b5);
		add(b6);
		panel2.add(b5);
		panel2.add(b6);
		panel2.add(b7);
		panel2.add(b8);
		panel2.add(b9);
		panel2.add(b10);
		panel2.add(b11);
		panel2.add(b12);
		panel2.add(b13);
		b5.setBounds(250, 250, 120, 35);
		b5.addActionListener(this);

		// add ActionListeners to the product buttons b5-b13
		// handles actions for option3
		// when you click on a product a window appears to insert quantity 
		b5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				{
					quantOfProduct = Integer.parseInt(JOptionPane.showInputDialog("Please insert quantity"));
				}
			}

		});
		b7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					quantOfProduct = Integer.parseInt(JOptionPane.showInputDialog("Please insert quantity"));
				}
			}

		});
		b8.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					quantOfProduct = Integer.parseInt(JOptionPane.showInputDialog("Please insert quantity"));
				}
			}

		});
		b9.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					quantOfProduct = Integer.parseInt(JOptionPane.showInputDialog("Please insert quantity"));
				}
			}

		});
		b10.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					quantOfProduct = Integer.parseInt(JOptionPane.showInputDialog("Please insert quantity"));
				}
			}

		});
		b11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					quantOfProduct = Integer.parseInt(JOptionPane.showInputDialog("Please insert quantity"));
				}
			}

		});
		b12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					quantOfProduct = Integer.parseInt(JOptionPane.showInputDialog("Please insert quantity"));
				}
			}

		});
		b13.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					quantOfProduct = Integer.parseInt(JOptionPane.showInputDialog("Please insert quantity"));
				}
			}

		});

		// add ActionListener for the new frame F2 for clicking the product
		// when you press option 3 a new frame appears
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
					F2.setVisible(true);

				}
			}
		});

		// create the frame for calculation's option
		JFrame F3 = new JFrame("Calculation of data");
		F3.setLocationRelativeTo(null);
		F3.setSize(500, 500);
		JPanel panel3 = new JPanel();
		F3.add(panel3);
		F3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// add ActionListener for the new frame F3 for calculation of data
		// when you press option 5 a new frame appears
		item5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
					F3.setVisible(true);
				}
			}
		});

		// create and add the buttons and add them to F3 Frame
		JButton button1 = new JButton("best customers");
		JButton button2 = new JButton("total cost");
		JButton button3 = new JButton("total sells");
		JButton button4 = new JButton("Show all the stock");
		panel3.add(button1);
		panel3.add(button2);
		panel3.add(button3);
		panel3.add(button4);
		button1.setBounds(250, 250, 120, 35);

		// add ActionListeners to the buttons
		// when you click an option a window appears saying 'hi'
		// here we want to call the methods for calculating the data in every option 
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					JOptionPane.showMessageDialog(null, "hi");
				}
			}

		});
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					JOptionPane.showMessageDialog(null, "hi");
				}
			}

		});
		button3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					JOptionPane.showMessageDialog(null, "hi");
				}
			}

		});
		button4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				{
					objectOfProductFactory.showAllProdutcs();
				}
			}

		});

		// add ActionListener for the new frame F2
		// when you press option 3 a new frame appears 
		item3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				{
					F2.setVisible(true);
				}
			}
		});

	}

	boolean continueLoop1 = true;
	boolean continueLoop2 = true;
	boolean continueLoop3 = true;
	boolean continueLoop4 = true;
	boolean continueLoop5 = true;
	boolean continueLoop6 = true;
	boolean continueLoop7 = true;
	boolean continueLoop8 = true;
	boolean continueLoop9 = true;
	String name, code;
	int quantity, day, month, year;
	double price, cost;

	// Handles actions based in option
	public void actionPerformed(ActionEvent event) throws NullPointerException {
		if (event.getSource() == item1) {
			do {
				try {
					cost = Double.parseDouble(JOptionPane.showInputDialog("Please insert the cost: "));
					ProductFactory.setCostSold(cost);
					continueLoop1 = false;
				} catch (NullPointerException e) {
					System.exit(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Sorry...invalid input was insert! Please try again.");
				}
			} while (continueLoop1);
		} else if (event.getSource() == item2) {
			do {
				try {
					name = JOptionPane.showInputDialog("Please insert the name ");
					continueLoop2 = false;
				} catch (NullPointerException e) {
					System.exit(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Sorry...invalid name was insert! Please try again.");
				}
			} while (continueLoop2);
			do {
				try {
					code = JOptionPane.showInputDialog("Please insert the code ");
					continueLoop3 = false;
				} catch (NullPointerException e) {
					System.exit(0);
				}
			} while (continueLoop3);

			do {
				try {
					quantity = Integer.parseInt(JOptionPane.showInputDialog("Please insert the quantity "));
					continueLoop4 = false;
				} catch (NullPointerException e) {
					System.exit(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Sorry...invalid quantity was insert! Please try again.");
				}
			} while (continueLoop4);

			do {
				try {
					day = Integer.parseInt(JOptionPane.showInputDialog("Please insert the day "));
					continueLoop5 = false;
				} catch (NullPointerException e) {
					System.exit(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Sorry...invalid day was insert! Please try again.");
				}
			} while (continueLoop5);

			do {
				try {
					month = Integer.parseInt(JOptionPane.showInputDialog("Please insert the month "));
					continueLoop6 = false;
				} catch (NullPointerException e) {
					System.exit(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Sorry...invalid month insert! Please try again.");
				}
			} while (continueLoop6);
			do {
				try {
					year = Integer.parseInt(JOptionPane.showInputDialog("Please insert the year"));
					continueLoop7 = false;
				} catch (NullPointerException e) {
					System.exit(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Sorry...invalid year was insert! Please try again.");
				}
			} while (continueLoop7);
			do {
				try {
					price = Double.parseDouble(JOptionPane.showInputDialog("Please insert the price "));
					continueLoop8 = false;
				} catch (NullPointerException e) {
					System.exit(0);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Sorry...invalid price was insert! Please try again.");
				}
			} while (continueLoop8);

			objectOfProductFactory.purchaseOfStock(name, code, quantity, day, month, year, price);
			JOptionPane.showMessageDialog(null, "Thank you!!");

		} else if (event.getSource() == item4) {

		}
	}

	public static void main(String[] args) {
		new OptionMenu();
	}
}