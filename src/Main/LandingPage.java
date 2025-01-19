package Main;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LandingPage extends JFrame {

    public LandingPage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Assets/pagelogo.png")));
        try {
            // Create the frame with null layout (no layout manager)
            JFrame frame = new JFrame("Art Gallery");
            frame.setLayout(null); // Absolute positioning for the frame

            // Create the canvas (panel) to hold the label and background image
            JPanel canvas = new JPanel();
            canvas.setLayout(null); // No layout manager for absolute positioning
            canvas.setBounds(0, 0, 1000, 562); // Size of the canvas (same as the frame)

            // Set up the background image
            BufferedImage myPicture = ImageIO.read(new File("D:/2NDJAVAPROGRAMS/ArtGallery/src/Assets/landing.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            // Set the size and position of the background image label using setBounds
            picLabel.setBounds(0, 0, 1000, 562); // Position the image label to cover the entire canvas

            // Create the JLabel for the text (acts as a button)
            JLabel btn = new JLabel("", JLabel.CENTER);
            btn.setBounds(350, 250, 300, 50); // Position the label in the center manually

            // Add a mouse listener to the button (JLabel)
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // When clicked, close the current frame and open the View class window
                    frame.dispose(); // Close the current frame
                    new category(); // Open the View class window
                }
            });
            
            JLabel btnContact = new JLabel("b");
            btnContact.setBounds(860, 70, 50, 50); // Position on the right
            btnContact.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new contact();
                    frame.dispose(); //go back to previous page
                    dispose();
                }
            });
            canvas.add(btnContact);

            // Add the background image label to the frame
            frame.add(picLabel);

            // Add the canvas (panel) to the frame, containing the btn label
            frame.add(canvas);

            // Add the button label to the canvas (panel) to make it clickable and visible
            canvas.add(btn);

            // Set up the frame properties
            frame.setSize(1000, 562); // Set the frame size
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setVisible(true); // Set the frame visible
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }

    public static void main(String[] args) {   
        new LandingPage();
    }
}
