package java.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Manager<T> implements IManager<T>, Serializable {
	protected List<T> list;
	private String filePath;

	protected Manager(String filePath) {
		list = new ArrayList<>();
		this.filePath = filePath;
		loadList();
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public boolean remove(T item) {
		boolean removed = list.remove(item);
		saveList();
		return removed;
	}

	@Override
	public boolean add(T item) {
		boolean added = list.add(item);
		saveList();
		return added;
	}

	@Override
	public void display() {
		int counter = 0;
		for (T item : list) {
			counter++;
			System.out.println(counter + ". " + item);
		}
	}

	@Override
	public void loadList() {
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath)))
		{
			list = (List<T>) inputStream.readObject();

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found exception");
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println("Error when reading from file");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void saveList() {
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath)))
		{
			outputStream.writeObject(list);
			System.out.println("List saved!");

		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println("Error when writing to file");
			System.out.println(e.getMessage());
		}
	}
}
