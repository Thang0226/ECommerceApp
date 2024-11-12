package java_source.controller.abstracts;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Manager<T> implements IManager<T> {
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
		return list.remove(item);
	}

	@Override
	public boolean add(T item) {
		return list.add(item);
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
	public void loadList() {    // Binary file by default
		try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filePath)))
		{
			list = (List<T>) inputStream.readObject();
			System.out.println("List loaded.");

		} catch (ClassNotFoundException e) {
			System.out.println("Class not found exception");
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println("Error when reading from file");
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void saveList() {    // Binary file by default
		try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filePath)))
		{
			outputStream.writeObject(list);
			System.out.println("List saved.");

		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println("Error when writing to file");
			System.out.println(e.getMessage());
		}
	}
}
