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

public class contact extends JFrame {

    public contact() {
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
            BufferedImage myPicture = ImageIO.read(new File("D:/2NDJAVAPROGRAMS/ArtGallery/src/Assets/contact.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            // Set the size and position of the background image label using setBounds
            picLabel.setBounds(0, 0, 1000, 562); // Position the image label to cover the entire canvas
            
            JLabel btnBack = new JLabel("b");
            btnBack.setBounds(60, 54, 70, 30); // Position on the right
            btnBack.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new LandingPage();
                    frame.dispose(); //go back to previous page
                    dispose();
                }
            });
            canvas.add(btnBack); // Add the right button to the canvas

            // Add the background image label to the frame
            frame.add(picLabel);

            // Add the canvas (panel) to the frame, containing the btn label
            frame.add(canvas);

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
}
