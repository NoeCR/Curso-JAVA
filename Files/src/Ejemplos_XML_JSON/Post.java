package Ejemplos_XML_JSON;
import java.io.Serializable;

public class Post implements Serializable {
	private static final long serialVersionUID = 1L;
	private String texto;
	private String from;
	private String to;
	private String asunto;
	
	public Post(String texto, String from, String to, String asunto) {
		this.texto = texto;
		this.from = from;
		this.to = to;
		this.asunto = asunto;
	}
	
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	
}
