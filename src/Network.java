import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;
import java.awt.Font;


public class Network extends JFrame {

	private JPanel contentPane;
	private JTextField textSSID;
	private JTextField textPassword;
	private JLabel lblLog;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Network frame = new Network();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Network() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("InternalFrame.border"));		
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 70, 60, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 31, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblWifiMaker = new JLabel("WiFi Maker");
		lblWifiMaker.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		GridBagConstraints gbc_lblWifiMaker = new GridBagConstraints();
		gbc_lblWifiMaker.fill = GridBagConstraints.VERTICAL;
		gbc_lblWifiMaker.gridwidth = 6;
		gbc_lblWifiMaker.insets = new Insets(0, 0, 5, 0);
		gbc_lblWifiMaker.gridx = 0;
		gbc_lblWifiMaker.gridy = 0;
		contentPane.add(lblWifiMaker, gbc_lblWifiMaker);
		
		JLabel lblWifiSsid = new JLabel("WiFi SSID");
		lblWifiSsid.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		GridBagConstraints gbc_lblWifiSsid = new GridBagConstraints();
		gbc_lblWifiSsid.insets = new Insets(0, 0, 5, 5);
		gbc_lblWifiSsid.gridx = 1;
		gbc_lblWifiSsid.gridy = 2;
		contentPane.add(lblWifiSsid, gbc_lblWifiSsid);
		
		textSSID = new JTextField();
		textSSID.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textSSID.setText("HaarwegFi");
		GridBagConstraints gbc_textSSID = new GridBagConstraints();
		gbc_textSSID.insets = new Insets(0, 0, 5, 5);
		gbc_textSSID.gridx = 2;
		gbc_textSSID.gridy = 2;
		contentPane.add(textSSID, gbc_textSSID);
		textSSID.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					handleCreate();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.fill = GridBagConstraints.VERTICAL;
		gbc_btnCreate.gridheight = 2;
		gbc_btnCreate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreate.gridx = 3;
		gbc_btnCreate.gridy = 2;
		contentPane.add(btnCreate, gbc_btnCreate);		
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		textPassword = new JTextField();
		textPassword.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		textPassword.setText("bb123456");
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.insets = new Insets(0, 0, 5, 5);
		gbc_textPassword.gridx = 2;
		gbc_textPassword.gridy = 3;
		contentPane.add(textPassword, gbc_textPassword);
		textPassword.setColumns(10);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleStop();
			}
		});
		
		GridBagConstraints gbc_btnStop = new GridBagConstraints();
		gbc_btnStop.insets = new Insets(0, 0, 5, 5);
		gbc_btnStop.gridx = 1;
		gbc_btnStop.gridy = 5;
		contentPane.add(btnStop, gbc_btnStop);
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				handleStart();
			}
		});
		
		JButton btnEnable = new JButton("Enable");
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					handleEnable();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnEnable = new GridBagConstraints();
		gbc_btnEnable.insets = new Insets(0, 0, 5, 5);
		gbc_btnEnable.gridx = 2;
		gbc_btnEnable.gridy = 5;
		contentPane.add(btnEnable, gbc_btnEnable);
		
		GridBagConstraints gbc_btnStart = new GridBagConstraints();
		gbc_btnStart.insets = new Insets(0, 0, 5, 5);
		gbc_btnStart.gridx = 3;
		gbc_btnStart.gridy = 5;
		contentPane.add(btnStart, gbc_btnStart);		
		
		lblLog = new JLabel(" Log!");
		lblLog.setFont(new Font("Trebuchet MS", Font.PLAIN, 11));
		GridBagConstraints gbc_lblLog = new GridBagConstraints();
		//setSize(300, 300);
		//setPreferedSize(190, 30);
		//setMaximumSize(190, 30);
		gbc_lblLog.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblLog.gridwidth = 3;
		gbc_lblLog.insets = new Insets(0, 0, 5, 5);
		gbc_lblLog.gridx = 1;
		gbc_lblLog.gridy = 6;
		contentPane.add(lblLog, gbc_lblLog);
		Border border =BorderFactory.createLineBorder(Color.BLACK, 1);
		lblLog.setBorder(border);
		
		JLabel lblWifiMakerV = new JLabel("WiFi Maker v0.9");
		lblWifiMakerV.setEnabled(false);
		lblWifiMakerV.setFont(new Font("Calibri Light", Font.BOLD, 11));
		GridBagConstraints gbc_lblWifiMakerV = new GridBagConstraints();
		gbc_lblWifiMakerV.gridwidth = 6;
		gbc_lblWifiMakerV.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblWifiMakerV.gridx = 0;
		gbc_lblWifiMakerV.gridy = 8;
		contentPane.add(lblWifiMakerV, gbc_lblWifiMakerV);
	}	

	protected void handleEnable() throws IOException {
	// OPTION 1
		List<String> powershCommand = new ArrayList<String>();
		powershCommand.add("powershell.exe $m = New-Object -ComObject HNetCfg.HNetShare");
		powershCommand.add("$c = $m.EnumEveryConnection |? { $m.NetConnectionProps.Invoke($_).Name -eq \"Ethernet\" }");
		powershCommand.add("$config = $m.INetSharingConfigurationForINetConnection.Invoke($c)");
		powershCommand.add("$config.EnableSharing(0)");
		ProcessBuilder pb = new ProcessBuilder(powershCommand);
		pb.redirectErrorStream(true);
		Process process=pb.start();
		//Present the output of the process to log label
		BufferedReader inStreamReader = new BufferedReader(
		    new InputStreamReader(process.getErrorStream()));		
		String line=null;		
		while((line=inStreamReader.readLine()) != null){
		    System.out.println(line);
		   //lblLog.setText(String.valueOf(inStreamReader));		    
        }
		
	//OPTION 2
		/*String powerShCommand = "powershell.exe  /VirtualWiFi/Resources/ethernetShare.ps1 ";
		Process powerShellProcess = Runtime.getRuntime().exec(powerShCommand);
		powerShellProcess.getOutputStream().close();
		String line;
		System.out.println("Output:");
		BufferedReader stdout = new BufferedReader(new InputStreamReader(
		powerShellProcess.getInputStream()));
		while ((line = stdout.readLine()) != null) {
		  System.out.println(line);
		  }
		stdout.close();
		System.out.println("Error:");
		BufferedReader stderr = new BufferedReader(new InputStreamReader(
		   powerShellProcess.getErrorStream()));
		while ((line = stderr.readLine()) != null) {
		  System.out.println(line);
		 }
		stderr.close();
		System.out.println("Done");*/
		
		//OPTION 3
				/*String powerShCommand [] = {"powershell.exe  /VirtualWiFi/Resources/ethernetShare.ps1 ", 
						"$c = $m.EnumEveryConnection |? { $m.NetConnectionProps.Invoke($_).Name -eq \"Ethernet\" }", 
						"$config = $m.INetSharingConfigurationForINetConnection.Invoke($c)", 
						"$config.EnableSharing(0)"};
							
				Process powerShellProcess = Runtime.getRuntime().exec(powerShCommand);
				powerShellProcess.getOutputStream().close();
				String line;
				System.out.println("Output:");
				BufferedReader stdout = new BufferedReader(new InputStreamReader(
				powerShellProcess.getInputStream()));
				while ((line = stdout.readLine()) != null) {
				  System.out.println(line);
				  }
				stdout.close();
				System.out.println("Error:");
				BufferedReader stderr = new BufferedReader(new InputStreamReader(
				   powerShellProcess.getErrorStream()));
				while ((line = stderr.readLine()) != null) {
				  System.out.println(line);
				 }
				stderr.close();
				System.out.println("Done");*/
	}

	protected void handleCreate() throws IOException {
		
		String SSID = textSSID.getText();
		String password = textPassword.getText();
				
		List<String> commandList=new ArrayList<String>();
		commandList.add("cmd");
		commandList.add("/C");
		commandList.add(String.format("netsh wlan set hostednetwork mode=allow ssid=%s key=%s", SSID, password));		
		
		ProcessBuilder pb = new ProcessBuilder(commandList);
		pb.redirectErrorStream(true);
		Process process=pb.start();
		//Present the output of the process to log label
		BufferedReader inStreamReader = new BufferedReader(
		    new InputStreamReader(process.getInputStream()));		
		String line=null;		
		while((line=inStreamReader.readLine()) != null){
		    System.out.println(line);
		   //lblLog.setText(String.valueOf(inStreamReader));		    
        }
	}

	protected void handleStop() {
		try{  
			Process p=Runtime.getRuntime().exec("netsh wlan stop hostednetwork"); 
			p.waitFor(); 
			BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
			String line=reader.readLine();
			String log = line; 			
			while(line!=null){
				System.out.println(line);
				line=reader.readLine();	
				lblLog.setText(String.valueOf(log));
			}
		}
		catch(IOException e1) {}
		catch(InterruptedException e2) {}		
	}

	protected void handleStart() {
		try{  
			Process p=Runtime.getRuntime().exec("netsh wlan start hostednetwork"); 
			p.waitFor(); 
			BufferedReader reader=new BufferedReader(new InputStreamReader(p.getInputStream())); 
			String line=reader.readLine();
			String log = line; 
			while(line!=null){
				System.out.println(line);
				line=reader.readLine();
				lblLog.setText(String.valueOf(log));
				System.out.println(log);
			}
		}
		catch(IOException e1) {}
		catch(InterruptedException e2) {}
	}	
}
