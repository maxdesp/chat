package dao;

public interface IDAO<T,Id> {
	public void creer(T o);
	public boolean supprimer (T o);
	public boolean modifier(Id id, String caractere_changement , String valeur);
	public T charger(Id id);
}
