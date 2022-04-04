package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField sosireMinTextField;
	private JTextField sosireMaxTextField;
	private JTextField ServireMintextField;
	private JTextField servireMaxTextField;
	private JLabel queuesLabel;
	private JTextField queuesTextField;
	private JLabel clientsLabel;
	private JTextField intervalTextField;
	private JLabel lblNewLabel;
	private JLabel timpLabel;
	private JLabel minimLabel;
	private JLabel maximLabel;
	private JLabel serviceTimeLabel;
	private JButton validareButton;
	private JButton startButton;
	private JLabel timeLabel;
	JTextField clientsTextField;
	JTextArea textArea;
	JScrollPane scroll;

	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 536);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		queuesLabel = new JLabel("Numar cozi:");
		queuesLabel.setBounds(43, 67, 88, 13);
		contentPane.add(queuesLabel);

		queuesTextField = new JTextField();
		queuesTextField.setBounds(147, 64, 96, 19);
		contentPane.add(queuesTextField);
		queuesTextField.setColumns(10);

		 clientsTextField = new JTextField();
		clientsTextField.setBounds(147, 103, 96, 19);
		contentPane.add(clientsTextField);
		clientsTextField.setColumns(10);

		clientsLabel = new JLabel("Numar Clienti");
		clientsLabel.setBounds(43, 106, 94, 13);
		contentPane.add(clientsLabel);

		intervalTextField = new JTextField();
		intervalTextField.setBounds(147, 145, 96, 19);
		contentPane.add(intervalTextField);
		intervalTextField.setColumns(10);

		lblNewLabel = new JLabel("Interval Simulare");
		lblNewLabel.setBounds(43, 148, 88, 13);
		contentPane.add(lblNewLabel);

		timpLabel = new JLabel("Timp sosire");
		timpLabel.setBounds(43, 218, 88, 13);
		contentPane.add(timpLabel);

		minimLabel = new JLabel("Minim");
		minimLabel.setBounds(169, 192, 43, 13);
		contentPane.add(minimLabel);

		sosireMinTextField = new JTextField();
		sosireMinTextField.setBounds(147, 215, 96, 19);
		contentPane.add(sosireMinTextField);
		sosireMinTextField.setColumns(10);

		maximLabel = new JLabel("Maxim");
		maximLabel.setBounds(319, 192, 67, 13);
		contentPane.add(maximLabel);

		sosireMaxTextField = new JTextField();
		sosireMaxTextField.setBounds(290, 215, 96, 19);
		contentPane.add(sosireMaxTextField);
		sosireMaxTextField.setColumns(10);


		 timeLabel = new JLabel("Timp");

		timeLabel.setBounds(487, 145, 96, 16);
		contentPane.add(timeLabel);

		serviceTimeLabel = new JLabel("Timp Servire");
		serviceTimeLabel.setBounds(39, 261, 92, 13);
		contentPane.add(serviceTimeLabel);

		ServireMintextField = new JTextField();
		ServireMintextField.setBounds(147, 258, 96, 19);
		contentPane.add(ServireMintextField);
		ServireMintextField.setColumns(10);

		servireMaxTextField = new JTextField();
		servireMaxTextField.setBounds(290, 261, 96, 19);
		contentPane.add(servireMaxTextField);
		servireMaxTextField.setColumns(10);


		textArea = new JTextArea();
		//textArea.setBounds(43, 310, 563, 162);
		//contentPane.add(textArea);
		 scroll = new JScrollPane (textArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setBounds(43, 310, 563, 162);
		contentPane.add(scroll);


		validareButton = new JButton("Validare");
		validareButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		validareButton.setBounds(333, 63, 85, 21);
		contentPane.add(validareButton);

		startButton = new JButton("Start");
		startButton.setEnabled(false);
		startButton.setBounds(465, 63, 96, 20);
		contentPane.add(startButton);
		setVisible(true);
	}
	public void validareListener (ActionListener actionListener)
	{
		this.validareButton.addActionListener(actionListener);
	}
	public void startListener (ActionListener actionListener)
	{
		this.startButton.addActionListener(actionListener);
	}

public String getQueues ()
{

	return this.queuesTextField.getText();
}

	public String getClients ()
	{

		return this.clientsTextField.getText();
	}

	public String getInterval ()
	{

		return this.intervalTextField.getText();
	}
	public String getMinTimpSosire()
	{

		return this.sosireMinTextField.getText();
	}

	public String getMaxTimpSosire()
	{

		 return this.sosireMaxTextField.getText();
	}
	public String getMinServire()
	{

		return this.ServireMintextField.getText();
	}


	public String getMaxServire()
	{

		return this.servireMaxTextField.getText();
	}

	public JButton getStartButton() {
		return startButton;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JLabel getTimpLabel() {
		return timpLabel;
	}

	public JLabel getTimeLabel() {
		return timeLabel;
	}

	public JScrollPane getScroll() {
		return scroll;
	}
}
