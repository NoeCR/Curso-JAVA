

/**
 * Escriviu aquí una descripcìó de la classe Eventos
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class EventPost extends Post {

    private String eventname;  // an arbitrarily long, multi-line message

    /**
     * Constructor for objects of class MessagePost.
     * 
     * @param author    The username of the author of this post.
     * @param text      The text of this post.
     */
    public EventPost(String author, String text)
    {
        super(author);
        eventname = text;
    }

    /**
     * Return the text of this post.
     * 
     * @return The post's message text.
     */
    public String getEvent()
    {
        return eventname;
    }
    /**
     * Este metodo imprime el nombre del autor del post
     */
    public void printShortSummary(){
        System.out.println("Event post from " + getName());
    }  
}
    

