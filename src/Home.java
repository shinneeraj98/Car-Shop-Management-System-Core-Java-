import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import javax.swing.JLabel;



public class Home extends JFrame {
	JDesktopPane desktopPane = new JDesktopPane();
	private JPanel contentPane;
	private int w,h;
	private BufferedImage image;
	private static String arg;
	
	
	public Home() {
		
		
		pic mainPanel= new pic("e:/cars.jpg");
		mainPanel.setBounds(0,0,847,455);
		desktopPane.add(mainPanel);
		mainPanel.setLayout(new BorderLayout(0, 0));
		desktopPane.invalidate();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 873, 525);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnCars = new JMenu("Cars");
		menuBar.add(mnCars);
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			Add a=new Add();
			
			a.setVisible(true);
		desktopPane.add(a);
		
	
			}
		});
		mnCars.add(mntmAdd);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Search s=new Search();
				desktopPane.add(s);
				s.setVisible(true);
				
			}
		});
		mnCars.add(mntmSearch);
		
		JMenu mnCustomer = new JMenu("Customer");
		menuBar.add(mnCustomer);
		
		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		mntmAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Addc ad=new Addc();
				desktopPane.add(ad);
				ad.setVisible(true);
				
			}
		});
		mnCustomer.add(mntmAdd_1);
		
		JMenuItem mntmService = new JMenuItem("Service");
		mntmService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				serv ssv=new serv();
				desktopPane.add(ssv);
				ssv.setVisible(true);
				
			}
		});
		mnCustomer.add(mntmService);
		
		JMenuItem mntmShowAllService = new JMenuItem("Show all Service");
		mntmShowAllService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				allsev all=new allsev();
				desktopPane.add(all);
				all.setVisible(true);
			}
		});
		mnCustomer.add(mntmShowAllService);
		JMenu mnPurchases = new JMenu("Purchases");
	    menuBar.add(mnPurchases);
		
		JMenuItem mntmListAllPurchase = new JMenuItem("List all Purchase ");
		mntmListAllPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				purc all=new purc();
				desktopPane.add(all);
				all.setVisible(true);
				
			}
		});
		mnPurchases.add(mntmListAllPurchase);
		
		JMenuItem mntmSearchPurchase = new JMenuItem("Search Purchase ");
		mntmSearchPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				seapur all=new seapur();
				desktopPane.add(all);
				all.setVisible(true);
			}
		});
		mnPurchases.add(mntmSearchPurchase);
		
		JMenu mnParts = new JMenu("Parts");
		menuBar.add(mnParts);
		
		JMenuItem mntmOrderPart = new JMenuItem("Order Part");
		mntmOrderPart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				parts all=new parts();
				desktopPane.add(all);
				all.setVisible(true);
				
			}
		});
		mnParts.add(mntmOrderPart);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	 
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);
		
		JLabel l = new JLabel("");
		l.setBounds(355, 220, 232, 151);	
	}
}
