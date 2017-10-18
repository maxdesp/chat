package dao;

public interface IDAO<T,Id> {
	public void creer(T o, DB db);
	public boolean supprimer (T o, DB db);
	public boolean modifier(Id id, String caractere_changement , String valeur, DB db);
	public T charger(Id id, DB db);
}