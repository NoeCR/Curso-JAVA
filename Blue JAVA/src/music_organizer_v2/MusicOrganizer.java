package music_organizer_v2;

import java.util.ArrayList;

/**
 * A class to hold details of audio files.
 * This version can play the files.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class MusicOrganizer
{
    // An ArrayList for storing the file names of music files.
    private ArrayList<String> files;
    // A player for the music files.
    private MusicPlayer player;
        
    /**
     * Create a MusicOrganizer
     */
    public MusicOrganizer()
    {
        files = new ArrayList<>();
        player = new MusicPlayer();
    }
    
    /**
     * Add a file to the collection.
     * @param filename The file to be added.
     */
    public void addFile(String filename)
    {
        files.add(filename);
    }
    
    /**
     * Return the number of files in the collection.
     * @return The number of files in the collection.
     */
    public int getNumberOfFiles()
    {
        return files.size();
    }
    
    /**
     * List a file from the collection.
     * @param index The index of the file to be listed.
     */
    public void listFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            String filename = files.get(index);
            System.out.println(filename);
        }
    }
    
    /**
     * Remove a file from the collection.
     * @param index The index of the file to be removed.
     */
    public void removeFile(int index)
    {
        if(index >= 0 && index < files.size()) {
            files.remove(index);
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        String filename = files.get(index);
        player.startPlaying(filename);
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }
    public void listAllFiles(){
     for(String file : files){
            System.out.println(file.toString());
        }
    }
    public void listMatching(String match){
        boolean encontrado = false;
        String canciones="";
        for(String file : files){
            if(file.toLowerCase().contains(match.toLowerCase())){
                encontrado = true;
                canciones +=  file + ",";
            }
        }
        if(encontrado){
            System.out.println(canciones);
        }else{
             System.out.println("No Matches");   
        }
    }
    public void playMatching(String match){
       
        if(getMatching(match)!=null){
            for(String file : getMatching(match)){
                if(file.toLowerCase().contains(match.toLowerCase())){
                    System.out.println(file);
                    player.playSample(file);
                }
            }
        }else{
            System.out.println("No encontrado");
        }
    }
    public ArrayList<String> getMatching(String match){
        ArrayList<String> canciones = new ArrayList<>();
        for(String file : files){
            if(file.toLowerCase().contains(match.toLowerCase())){
                canciones.add(file);     
            }
        }
        return canciones;
    }
    public int findFirst(String searchString){
        int cont = files.size();
        int i = 0;
        boolean encontrado = false;
        while(cont >= 0 && !encontrado){
            if(files.get(i).contains(searchString)){
                encontrado = true;
            }
            cont--;
            i++;
        }
        if(encontrado){
            return i;
        }else{
            return cont;
        }
    }
}
