import java.util.ArrayList;

/**
 * This class stores information about a post in a social network. 
 * The main part of the post consists of a photo and a caption. 
 * Other data, such as author and time, are also stored.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class AudioPost extends Post
{
    private String audioname;  // the name of the image file
    private double duration;   // a one line image caption
    /**
     * Constructor for objects of class PhotoPost.
     * 
     * @param author    The username of the author of this post.
     * @param filename  The filename of the image in this post.
     * @param caption   A caption for the image.
     */
    public AudioPost(String author, String audioname, int duration)
    {
        super(author);
        this.audioname = audioname;
        this.duration = duration;
       
    }
    /**
     * Return the file name of the image in this post.
     * 
     * @return The post's image file name.
     */
    public String getAudioFile()
    {
        return audioname;
    }

    /**
     * Return the caption of the image of this post.
     * 
     * @return The image's caption.
     */
    public double getDuration()
    {
        return duration;
    }



    /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
        System.out.println(getUsername());
        System.out.println("  [" + audioname + "]");
        System.out.println("  " + duration);
        System.out.print(timeString(getTimeStamp()));
        
        if(getLikes() > 0) {
            System.out.println("  -  " + getLikes() + " people like this.");
        }
        else {
            System.out.println();
        }
        
        if(getComments().isEmpty()) {
            System.out.println("   No comments.");
        }
        else {
            System.out.println("   " + getComments().size() + " comment(s). Click here to view.");
        }
    }
}
