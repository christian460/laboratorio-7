package hash;

public class Contenedor <T>{
	private int index;
	private T key;
	private T value;
	private Contenedor<T> sigContenedor;
	
	public Contenedor(int index,T key , T value) {
		this.index=index;
		this.key=key;
		this.value=value;
		this.sigContenedor=null;
	}
	public Contenedor(int index) {
		this.index=index;
		this.key=null;
		this.value=null;
	}
	public int getIndex() { return index; }
	public void setIndex(int index) { this.index = index; }
	public T getKey() { return key; }
	public void setKey(T key) { this.key = key; }
	public T getValue() { return value; }
	public void setValue(T value) { this.value = value; }
	public Contenedor<T> getSigContenedor() { return sigContenedor; }
	public void setSigContenedor(Contenedor<T> sigContenedor) { this.sigContenedor = sigContenedor; } 
		
	public String toString() {
		return key+" -> "+ value;
	}
}
