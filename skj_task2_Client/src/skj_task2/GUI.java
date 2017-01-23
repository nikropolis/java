package skj_task2;

import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class GUI {

	private Shell shell;
	private Text field_name;
	private Text field_port;
	public Text field_msg;
	private Text field_ip;
	public Text display;
	public List list;
	public Button btn_action;
	public Button btn_send;
	private Label lbl_name;
	private Label lbl_port;
	///////////////////////////////////////
	public boolean btn_action_bool;
	private int selected_list_ind;
	private String name;
	private String ip;
	private int port;
	///////////////////////////////////////
	private Handler handler;

	public GUI(Handler handler) {
		this.handler = handler;
		btn_action_bool = false;
		selected_list_ind = -1;
	}

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	// public static void main(String[] args) {
	// GUI window = new GUI(new Handler());
	// window.open();
	// }

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		shell.setSize(496, 428);
		shell.setText("SWT Application");
		shell.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("see you soon.");
				// handler.listener.close();
				System.exit(0);
			}
		});

		field_name = new Text(shell, SWT.BORDER);
		field_name.setBounds(51, 10, 76, 21);

		field_port = new Text(shell, SWT.BORDER);
		field_port.setBounds(283, 10, 76, 21);

		lbl_name = new Label(shell, SWT.NONE);
		lbl_name.setBounds(10, 10, 36, 15);
		lbl_name.setText("alias:");

		lbl_port = new Label(shell, SWT.NONE);
		lbl_port.setBounds(241, 10, 36, 15);
		lbl_port.setText("port:");

		btn_action = new Button(shell, SWT.NONE);
		btn_action.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String n_name = "";
				String n_ip = "";
				int n_port = 0;
				boolean n_bool = true;

				n_ip = field_ip.getText();
				n_name = field_name.getText();
				try {
					n_port = Integer.parseInt(field_port.getText());
				} catch (NumberFormatException e1) {
					System.out.println(e1);
					JOptionPane.showMessageDialog(null, e1);
					n_bool = false;
					if (port > 0)
						field_port.setText(Integer.toString(port));
					else
						field_port.setText("");
				}
				if (n_bool)
					if (n_name.length() > 0 && n_ip.length() > 0 && n_port > 0) {
						if (!btn_action_bool) {
							name = n_name;
							port = n_port;
							ip = n_ip;

							 handler.listener = new UDPListener(port,
							 handler);
							 handler.listener.start();

							Persona me = new Persona();
							me.ip = ip;
							me.port = port;
							me.alias = name;
							me.publicKey = handler.rsa.publicKey;

							Pack pack = new Pack();
							pack.alias = name;
							pack.type = 'c'; // connection
							pack.obj = me;

							UDPSender sender = new UDPSender(handler.server.ip, handler.server.port);
							sender.send(pack);
							System.out.println("-connection...");
							btn_action.setEnabled(false);
							
							
						} else if (name != n_name || port != n_port) {
							if (port != n_port) {
								port = n_port;
								if (handler.listener.isActive()) {
									handler.listener.close();
									handler.listener.start();
								}
								handler.listener = new UDPListener(port, handler);
								handler.listener.start();
							}

							Persona me = new Persona();
							me.ip = ip;
							me.port = port;
							me.alias = n_name;
							me.publicKey = handler.rsa.publicKey;

							Pack pack = new Pack();
							pack.alias = name;
							pack.type = 'r'; // refresh
							pack.obj = me;

							if (name != n_name)
								name = n_name;

							UDPSender sender = new UDPSender(handler.server.ip, handler.server.port);
							sender.send(pack);
							System.out.println("-refreshing...");
						}
					}
			}// end widgetSelected()
		});// end addSelectionListener()
		btn_action.setBounds(378, 8, 92, 25);
		btn_action.setText("connect");

		list = new List(shell, SWT.BORDER | SWT.V_SCROLL);
		list.setBounds(10, 50, 92, 197);
		list.setEnabled(false);
		list.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent event) {
				int[] selectedItems = list.getSelectionIndices();
				selected_list_ind = selectedItems[0];

				String outString = "";
				for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
					outString += selectedItems[loopIndex] + "";
				System.out.println("Selected alias index[" + outString + "]");
			}

			public void widgetDefaultSelected(SelectionEvent event) {
				int[] selectedItems = list.getSelectionIndices();
				selected_list_ind = selectedItems[0];

				String outString = "";
				for (int loopIndex = 0; loopIndex < selectedItems.length; loopIndex++)
					outString += selectedItems[loopIndex] + "";
				System.out.println("Selected Items index: " + outString);
			}
		});
		field_msg = new Text(shell, SWT.BORDER);
		field_msg.setBounds(10, 305, 460, 43);
		field_msg.setEnabled(false);

		btn_send = new Button(shell, SWT.NONE);
		btn_send.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// SEND BTN
				String text = field_msg.getText();
				if(text.length()>75)
					text = text.substring(0, 75) + '\n' + text.substring(76);
				field_msg.setText("");
				
				if (selected_list_ind >= 0 && text.length() > 0) {
					Persona dude = handler.list.get(selected_list_ind);
					String dude_name = dude.alias;
					add_to_display(">to-"+ dude_name +">>\t" + text + "\n");

					Pack pack = new Pack();
					pack.type = 'm';
					pack.alias = name;
					pack.msg = handler.rsa.encrypt(text, dude.publicKey);

					UDPSender sender = new UDPSender(dude.ip, dude.port);
					sender.send(pack);
					System.out.println("-sending msg...");
				}
			}
		});
		btn_send.setBounds(378, 354, 92, 25);
		btn_send.setText("SEND");
		btn_send.setEnabled(false);

		display = new Text(shell, SWT.BORDER | SWT.READ_ONLY | SWT.V_SCROLL);
		display.setBounds(108, 50, 362, 240);
		display.setEnabled(false);

		field_ip = new Text(shell, SWT.BORDER);
		field_ip.setBounds(159, 10, 76, 21);

		Label lblIp = new Label(shell, SWT.NONE);
		lblIp.setBounds(134, 10, 19, 15);
		lblIp.setText("ip:");

		field_ip.setText("localhost");
		field_port.setText("" + 9999);
		field_name.setText("pointer");
	}

	public void enter() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				btn_action_bool = true;
				field_ip.setEnabled(false);
				display.setEnabled(true);
				list.setEnabled(true);
				btn_send.setEnabled(true);
				field_msg.setEnabled(true);
				btn_action.setEnabled(true);
				btn_action.setText("refresh");
			}
		});
	}

	public void add_to_display(String text) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				display.insert(text);
			}
		});
	}
	public void btn_action_on(){
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				btn_action.setEnabled(true);
			}
		});
	}
	
	public void refresh_list() {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				list.removeAll();
				for (int i = 0; i < handler.list.size(); i++)
					list.add(handler.list.get(i).alias);
				selected_list_ind = -1;
			}
		});
	}

}
