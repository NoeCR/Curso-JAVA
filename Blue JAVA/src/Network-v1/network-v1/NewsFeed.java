import java.util.ArrayList;

/**
 * The NewsFeed class stores news posts for the news feed in a social network 
 * application.
 * 
 * Display of the posts is currently simulated by printing the details to the
 * terminal. (Later, this should display in a browser.)
 * 
 * This version does not save the data to disk, and it does not provide any
 * search or ordering functions.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 0.1
 */
public class NewsFeed
{
    private ArrayList<Post> post;
    /**
     * Construct an empty news feed.
     */
    public NewsFeed()
    {
        post = new ArrayList<>();
    }

    /**
     * Add a text post to the news feed.
     * 
     * @param text  The text post to be added.
     */
    public void addMessagePost(MessagePost message)
    {
        post.add(message);
    }

    /**
     * Add a photo post to the news feed.
     * 
     * @param photo  The photo post to be added.
     */
    public void addPhotoPost(PhotoPost photo)
    {
        post.add(photo);
    }

     /**
     * Add a photo post to the news feed.
     * 
     * @param photo  The photo post to be added.
     */
    public void addAudioPost(AudioPost audio)
    {
       post.add(audio);
    }
    /**
     * Show the news feed. Currently: print the news feed details to the
     * terminal. (To do: replace this later with display in web browser.)
     */
    public void show()
    {
        for(Post message : post){
            message.toString()  .display();
            System.out.println(); 
        }
        // display all text posts
        for(MessagePost message : messages) {
            message.display();
            System.out.println();   // empty line between posts
        }

        // display all photos
        for(PhotoPost photo : photos) {
            photo.display();
            System.out.println();   // empty line between posts
        }
        // display all audios
         for(AudioPost audio : audios) {
            audio.display();
            System.out.println();   // empty line between posts
        }
    }
}
