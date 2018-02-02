import java.util.ArrayList;
import java.util.Iterator;
/**
 * Escriviu aquí una descripcìó de la classe Post
 * 
 * @author Noé Cruz Rodríguez
 * @version (02/02/2018_rev.001.17.19)
 */
public class Post {
    private String username;  // username of the post's author
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;
    public Post(String author){
        username = author;        
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<>();
    }
    /**
     * Record one more 'Like' indication from a user.
     */
    public void like()
    {
        likes++;
    }
    
    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike()
    {
        if (likes > 0) {
            likes--;
        }
    }
    /**
     * Metodo para devolver los likes 
     */
    public int getLikes(){
        return likes;
    }
    /**
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    public void addComment(String text)
    {
        comments.add(text);
    }
    /**
     * Este metodo devuelve una coleccion con todos los comentarios
     */
    public ArrayList<String> getComments(){
        return comments;
    }
    /**
     * Return the time of creation of this post.
     * 
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp()
    {
        return timestamp;
    }
    /**
     * Este metodo devuelve el nombre de usuario 
     */
    public String getUsername(){
        return username;
    }
    /**
     * Create a string describing a time point in the past in terms 
     * relative to current time, such as "30 seconds ago" or "7 minutes ago".
     * Currently, only seconds and minutes are used for the string.
     * 
     * @param time  The time value to convert (in system milliseconds)
     * @return      A relative time string for the given time
     */
    
    public String timeString(long time)
    {
        long current = System.currentTimeMillis();
        long pastMillis = current - time;      // time passed in milliseconds
        long seconds = pastMillis/1000;
        long minutes = seconds/60;
        if(minutes > 0) {
            return minutes + " minutes ago";
        }
        else {
            return seconds + " seconds ago";
        }
    }
}
