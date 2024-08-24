package Framework;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public abstract class MainFrame{
	private JFrame frame;
	private ToolBar toolbar;
	private GraphPanel panel;
	private JScrollPane scrollPane;
	private ShopBar shopPanel;
	private JMenuBar menu;
	private JMenu File,Edit,View,YourShop;
	private JMenuItem ShowComponents, Save, Load, Shop, Shoplist, New, Undo; 

	
	public abstract void saveButton();
	public abstract void loadButton();
	public abstract void shopButton();
	public abstract void showShopButton();
	public abstract void showCompButton();
	public abstract void newButton();
	public abstract void undoButton();
	
	/*
	 * The constructor which creates the template model.
	 */
	public MainFrame(Graph graph){
		frame = new JFrame("Project X");
		toolbar = new ToolBar(graph);
		panel = new GraphPanel(toolbar,graph);
		scrollPane = new JScrollPane(panel);
		shopPanel = new ShopBar();
		
		menu = new JMenuBar();

		File = new JMenu("File");
		Edit = new JMenu("Edit");
		View = new JMenu("View");
		YourShop = new JMenu("Shop");
	
		ShowComponents = new JMenuItem("Show Components");
		Save = new JMenuItem("Save");
		Load = new JMenuItem("Load File");
		Shop = new JMenuItem("Add all to shopping list");
		Shoplist = new JMenuItem("Show shopping list");
		New = new JMenuItem("New");
		Undo = new JMenuItem("Undo");
		
		File.add(New);
		File.add(Save);
		File.add(Load);
		Edit.add(Undo);
		View.add(ShowComponents);
		YourShop.add(Shop);
		YourShop.add(Shoplist);
		menu.add(File);
		menu.add(Edit);
		menu.add(View);
		menu.add(YourShop);
		
		
		//Buttons for JMenuItems.
		ShowComponents.setMnemonic(KeyEvent.VK_V);
		ShowComponents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		ShowComponents.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCompButton();
			}
		});
		
		
		New.setMnemonic(KeyEvent.VK_N);
		New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		New.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				newButton();
			}
		});
		
		
		Save.setMnemonic(KeyEvent.VK_S);
		Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		Save.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				saveButton();
			}
		});
		
		
		Load.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
			loadButton();
			}
		});
		
		
		Shop.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				shopButton();
			}
		});
		
	
		Shoplist.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				showShopButton();
			}
		});
		
		Undo.setMnemonic(KeyEvent.VK_Z);
		Undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		Undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				undoButton();
			}
		});
		
		
		shopPanel.setVisible(false);
		frame.add(shopPanel, BorderLayout.WEST);
		frame.add(toolbar, BorderLayout.EAST);
		frame.add(menu, BorderLayout.NORTH);
		frame.add(scrollPane, BorderLayout.CENTER);
		frame.setSize(1200,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	/**
	 * Gets the toolbar.
	 * @return the toolbar.
	 */
	public ToolBar getToolbar() {
		return toolbar;
	}
	/**
	 * Gets the GraphPanel.
	 * @return the GraphPanel.
	 */
	public GraphPanel getPanel()
	{
		return panel;
	}
	
	/**
	 * Gets the ShopBar.
	 * @return the ShopBar panel.
	 */
	public ShopBar getShop() {
		return shopPanel;
	}
}
