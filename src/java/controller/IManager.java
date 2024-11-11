package java.controller;

import java.util.List;

public interface IManager<T> {

	boolean remove(T obj);

	boolean add(T obj);

	void display();

	void saveList();

	void loadList();
}
