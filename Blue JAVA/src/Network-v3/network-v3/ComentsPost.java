import java.util.ArrayList;

/**
 * Escriviu aquí una descripcìó de la classe FeedBack
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class ComentsPost extends Post{

    // Variables d'instància. Canvieu l'exemple d'aquí sota pels vostres exemples
    private int likes;
    private ArrayList<String> comments;

    /**
     * Mètode constructor per a objectes de la classe FeedBack
     */
    public ComentsPost(String author){
        super(author);
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
     * Add a comment to this post.
     * 
     * @param text  The new comment to add.
     */
    public void addComment(String text)
    {
        comments.add(text);
    }
    
         /**
     * Display the details of this post.
     * 
     * (Currently: Print to the text terminal. This is simulating display 
     * in a web browser for now.)
     */
    public void display()
    {
        super.display();        
        if(likes > 0) {
            System.out.println("  -  " + likes + " people like this.");            
        }
        else {
            System.out.println();
        }
        
        if(comments.isEmpty()) {
            System.out.println("   No comments.");            
        }
        else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");            
        }        
    }
}
