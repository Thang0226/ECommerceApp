package java.controller.abstracts;

public interface IManager<T> {

	boolean remove(T obj);

	boolean add(T obj);

	void display();

	void saveList();

	void loadList();
}
