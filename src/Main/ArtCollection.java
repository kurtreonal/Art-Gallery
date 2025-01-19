package Main;

import javax.swing.ImageIcon;

public class ArtCollection {

    public ImageIcon painting1, painting2;
    public ImageIcon sculpture1, sculpture2;
    public ImageIcon fineArt1, fineArt2;
    public ImageIcon digitalArt1, digitalArt2, digitalArt3;
    
    // Painting details
    public String painting1Artist = "Bernardo Lira";
    public String painting1Title = "Calle Azcarraga Manila, Philippines";
    public String painting1Description = "The Americans gave it a single name, Calle Azcarraga, in 1910, while in 1961, it was renamed to honor Senator Claro Mayo Recto.";

    public String painting2Artist = "Juan Luna";
    public String painting2Title = "Spoliarium";
    public String painting2Description = "Depicts the aftermath of a gladiatorial contest in the Roman Colosseum.";

    //Sculpture Details
    public String sculpture1Artist = "David Lubotsky";
    public String sculpture1Title = "Equilibrium Sculpture ";
    public String sculpture1Description = " Equilibrium is a marble sculpture with a bold and distinctive symmetry that appears as if it were a timeless, sacred object.";
    
    public String sculpture2Artist = "Bettina Silverio";
    public String sculpture2Title = "Underneath the Waves";
    public String sculpture2Description = "Our summers were often spent by the ocean, and this piece reminds me of the sights, sensations and the feelings aroused while frolicking underneath the waves in the open sea.";
    
    
    //Fine Arts Details
    public String fineart1Artist = "Rosario Sanchez";
    public String fineart1Title = "The Lilies of our Lives Painting";
    public String fineart1Description = "The works of Alechinsky inspired this painting. I added gold foil and old photos to create interesting textures and contrast. I hope the viewers can feel the excitement, beauty and serenity of this work.";

    public String fineart2Artist = "Rosario Sanchez";
    public String fineart2Title = "Solemn Silence Painting";
    public String fineart2Description = "When ideas and feelings are combined, they become vehicles of happiness for others. In this work geometric shapes, dots, photo of a tribal man suggest calmness.";

    //Digital Arts Details
    public String digitalart1Artist = "あるふぁひじり";
    public String digitalart1Title = "Concept Highway";
    public String digitalart1Description = "";

    public String digitalart2Artist = "あるふぁひじり";
    public String digitalart2Title = "Concept Glaciers";
    public String digitalart2Description = "";

    
// Method to load painting images
    public void loadPaintings() {
        try {
            painting1 = new ImageIcon(getClass().getResource("/Assets/painting1.jpg"));
            painting2 = new ImageIcon(getClass().getResource("/Assets/spoliarium.jpg"));
        } catch (Exception e) {
            System.out.println("Error loading paintings: " + e.getMessage());
        }
    }

    // Method to load sculpture images
    public void loadSculptures() {
        try {
            sculpture1 = new ImageIcon(getClass().getResource("/Assets/sculpture1.jpg"));
            sculpture2 = new ImageIcon(getClass().getResource("/Assets/sculpture2.jpg"));
        } catch (Exception e) {
            System.out.println("Error loading sculptures: " + e.getMessage());
        }
    }

    // Method to load fine art images
    public void loadFineArt() {
        try {
            fineArt1 = new ImageIcon(getClass().getResource("/Assets/fineart1.jpg"));
            fineArt2 = new ImageIcon(getClass().getResource("/Assets/fineart2.jpg"));
        } catch (Exception e) {
            System.out.println("Error loading fine art: " + e.getMessage());
        }
    }

    // Method to load digital art images
    public void loadDigitalArt() {
        try {
            digitalArt1 = new ImageIcon(getClass().getResource("/Assets/digital1.jpg"));
            digitalArt2 = new ImageIcon(getClass().getResource("/Assets/digital2.jpg"));
        } catch (Exception e) {
            System.out.println("Error loading digital art: " + e.getMessage());
        }
    }

    // Methods to get images of each type
    public ImageIcon[] getPaintings() {
        return new ImageIcon[]{painting1, painting2};
    }
    public String[] getPaintingDetails(int index) {
        // Return artist, title, and description based on index
        if (index == 0) {
            return new String[]{painting1Artist, painting1Title, painting1Description};
        } else {
            return new String[]{painting2Artist, painting2Title, painting2Description};
        }
    }

    public ImageIcon[] getSculptures() {
        return new ImageIcon[]{sculpture1, sculpture2};
    }
    public String[] getSculptureDetails(int index) {
        // Return artist, title, and description based on index
        if (index == 0) {
            return new String[]{sculpture1Artist, sculpture1Title, sculpture1Description};
        } else {
            return new String[]{sculpture2Artist, sculpture2Title, sculpture2Description};
        }
    }

    public ImageIcon[] getFineArt() {
        return new ImageIcon[]{fineArt1, fineArt2};
    }
    public String[] getFineArtDetails(int index) {
        // Return artist, title, and description based on index
        if (index == 0) {
            return new String[]{fineart1Artist,fineart1Title, fineart1Description};
        } else {
            return new String[]{fineart2Artist, fineart2Title, fineart2Description};
        }
    }

    public ImageIcon[] getDigitalArt() {
        return new ImageIcon[]{digitalArt1, digitalArt2};
    }
    public String[] getDigitalArtDetails(int index) {
        // Return artist, title, and description based on index
        if (index == 0) {
            return new String[]{digitalart1Artist, digitalart1Title, digitalart1Description};
        } else {
            return new String[]{digitalart2Artist, digitalart2Title, digitalart2Description};
        }
    }
}
