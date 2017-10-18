package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import model.Utilisateur;

public interface IDAO<T,Id> {
	public void creer(T o, DB db);
	public boolean supprimer (T o, DB db);
	public boolean modifier(Id id, String caractere_changement , String valeur, DB db);
	public T charger(Id id, DB db);
	public ArrayList<T> getAll();
	public ArrayList<T> getAll(DB db) throws SQLException;
}
