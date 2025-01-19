package Main;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class category extends JFrame {

    public category() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Assets/pagelogo.png")));
        try {
            // Create the frame with null layout (no layout manager)
            JFrame frame = new JFrame("Art Gallery");

            // Create the canvas (panel) to hold the label and background image
            JPanel canvas = new JPanel();
            canvas.setLayout(null); // No layout manager for absolute positioning
            canvas.setBounds(0, 0, 1000, 562); // Size of the canvas (same as the frame)

            // Set up the background image
            ImageIcon myPicture = new ImageIcon("D:/2NDJAVAPROGRAMS/ArtGallery/src/Assets/category.png");
            JLabel picLabel = new JLabel(myPicture);
            picLabel.setBounds(0, 0, 1000, 562); // Position the image label to cover the entire canvas
            
            // Create the JLabel for the text (acts as a button)
            JLabel paintingBtn = new JLabel("", JLabel.CENTER);
            paintingBtn.setBounds(80, 210, 180, 160); // Position the label in the center manually

            // Add a mouse listener to the button (JLabel)
            paintingBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // When clicked, close the current frame and open the ViewPainting class window
                    frame.dispose(); // Close the current frame
                    new ViewPainting(); // Open the ViewPainting class window
                }
            });
            
            // Create the JLabel for the text (acts as a button)
            JLabel sculptureBtn = new JLabel("", JLabel.CENTER);
            sculptureBtn.setBounds(300, 210, 190, 160); // Position the label in the center manually

            // Add a mouse listener to the button (JLabel)
            sculptureBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // When clicked, close the current frame and open the ViewPainting class window
                    frame.dispose(); // Close the current frame
                    new ViewSculpture(); // Open the ViewPainting class window
                }
            });
            
            // Create the JLabel for the text (acts as a button)
            JLabel fineartBtn = new JLabel("", JLabel.CENTER);
            fineartBtn.setBounds(510, 210, 190, 160); // Position the label in the center manually

            // Add a mouse listener to the button (JLabel)
            fineartBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // When clicked, close the current frame and open the ViewPainting class window
                    frame.dispose(); // Close the current frame
                    new ViewFineart(); // Open the ViewPainting class window
                }
            });
            
            // Create the JLabel for the text (acts as a button)
            JLabel digitalartBtn = new JLabel("", JLabel.CENTER);
            digitalartBtn.setBounds(730, 210, 190, 160); // Position the label in the center manually

            // Add a mouse listener to the button (JLabel)
            digitalartBtn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // When clicked, close the current frame and open the ViewPainting class window
                    frame.dispose(); // Close the current frame
                    new ViewDigitalart(); // Open the ViewPainting class window
                }
            });
            
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


            canvas.add(paintingBtn);
            canvas.add(sculptureBtn);
            canvas.add(fineartBtn);
            canvas.add(digitalartBtn);
            
            frame.add(picLabel); 
            frame.add(canvas);

            // Set up the frame properties
            frame.setLayout(null); // Absolute positioning for the frame
            frame.setSize(1000, 562); // Set the frame size
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true); // Set the frame visible
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}
