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

public class ViewSculpture extends JFrame {
    
    private ArtCollection artCollection;
    private JLabel lblImage;
    private JLabel lblArtist, lblTitle, lblDescription;
    private int imgLoop = 0; // Track the current image index
    private ImageIcon[] images; // Store the loaded images
    
    public ViewSculpture() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Assets/pagelogo.png")));
        artCollection = new ArtCollection();
        artCollection.loadSculptures(); // Load sculpture images
        images = artCollection.getSculptures();
        initializeUI();
    }
    
    private void initializeUI() {
        try {
            // Create the frame with null layout
            JFrame frame = new JFrame("Art Gallery");
            frame.setLayout(null); // Absolute positioning for the frame

            // Create the canvas (panel) to hold the label and background image
            JPanel canvas = new JPanel();
            canvas.setLayout(null); //absolute positioning
            canvas.setBounds(0, 0, 1000, 562); // Size of the canvas (same as the frame)

            // Set up the background image
            BufferedImage myPicture = ImageIO.read(new File("D:/2NDJAVAPROGRAMS/ArtGallery/src/Assets/view.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));

            // Set the size and position of the background image label using setBounds
            picLabel.setBounds(0, 0, 1000, 562); // Position the image label to cover the entire canvas

            // Add the background image label to the frame
            frame.add(picLabel);

            // Add the canvas (panel) to the frame, containing the lblImage
            frame.add(canvas);

            // Create the JLabel to display the images
            lblImage = new JLabel();
            lblImage.setBounds(200, 90, 600, 270);
            lblImage.setIcon(this.images[imgLoop]); // Set the first image initially
            lblImage.setHorizontalTextPosition(JLabel.CENTER);
            lblImage.setHorizontalAlignment(JLabel.CENTER);

            canvas.add(lblImage); // Add the image label to the canvas
            
            // Create the labels for artist name, title, and description
            lblArtist = new JLabel("", JLabel.CENTER);
            lblArtist.setHorizontalTextPosition(JLabel.CENTER);
            lblArtist.setBounds(390, 370, 220, 30); // Adjust position below image
            canvas.add(lblArtist);

            lblTitle = new JLabel("", JLabel.CENTER);
            lblTitle.setHorizontalTextPosition(JLabel.CENTER);
            lblTitle.setBounds(390, 400, 220, 30); // Adjust position below artist name
            canvas.add(lblTitle);

            lblDescription = new JLabel("", JLabel.CENTER);
            lblDescription.setHorizontalTextPosition(JLabel.CENTER);
            lblDescription.setBounds(240, 430, 520, 60); // Adjust position below title
            canvas.add(lblDescription);

            // Create the left button for previous image
            JLabel btnLeft = new JLabel("<");
            btnLeft.setBounds(140, 200, 50, 60); // Position on the left
            btnLeft.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showPreviousImage(); // Show previous image when clicked
                }
            });
            canvas.add(btnLeft); // Add the left button to the canvas

            // Create the right button for next image
            JLabel btnRight = new JLabel(">");
            btnRight.setBounds(800, 200, 50, 60); // Position on the right
            btnRight.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    showNextImage(); // Show next image when clicked
                }
            });
            canvas.add(btnRight); // Add the right button to the canvas
            
            // Create the right button for next image
            JLabel btnBack = new JLabel("b");
            btnBack.setBounds(60, 54, 70, 30); // Position on the right
            btnBack.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    new category();
                    frame.dispose(); //go back to previous page
                    dispose();
                }
            });
            canvas.add(btnBack); // Add the right button to the canvas

            // Set up the frame properties
            frame.setSize(1000, 562); // Set the frame size
            frame.setLocationRelativeTo(null); // Center the frame on the screen
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        
    }
        // Function to show the next image
    private void showNextImage() {
        imgLoop = (imgLoop + 1) % images.length; // Increment the index and loop
        lblImage.setIcon(images[imgLoop]); // Update the image on the label
        showImageDetails(); // Update details for the new image
    }

    // Function to show the previous image
    private void showPreviousImage() {
        imgLoop = (imgLoop - 1 + images.length) % images.length; // Decrement and loop
        lblImage.setIcon(images[imgLoop]); // Update the image on the label
        showImageDetails(); // Update details for the new image
    }
    
    // Function to update the details (artist, title, description) for the current image
    private void showImageDetails() {
        String[] details = artCollection.getSculptureDetails(imgLoop);
        lblArtist.setText(details[0]);
        lblTitle.setText(details[1]);
        lblDescription.setText("<html><font size=\"4\"><span style=\"font-family:Tahoma\">" + details[2] + "</font></span></html>"); // Wrap description in HTML for line breaks
    }
}
