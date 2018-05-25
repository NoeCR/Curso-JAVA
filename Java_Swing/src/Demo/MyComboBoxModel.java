package Demo;

import javax.swing.DefaultComboBoxModel;
/**
 * 
 * @author victor
 * Esta clase funciona siempre igual. Sólo hay que cambiar el tipo de objeto
 * Cuando pinta los elementos en la lista lo hace llamando al método toString() del objeto, 
 * que se sobreescribe (ver Libro.java)
 */
class MyComboBoxModel extends DefaultComboBoxModel<Libro> {
    public MyComboBoxModel(Libro[] items) {
        super(items);
    }
 
    @Override
    public Libro getSelectedItem() {
    	Libro libro = (Libro) super.getSelectedItem();
 
        // do something with this job before returning...
 
        return libro;
    }
}