package com.todo.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.*;
import com.todo.dao.TodoItem;
import com.todo.dao.TodoList;

public class TodoUtil {

	public static void createItem(TodoList list) {

		String title, desc, category, due_date;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[��Ͽ� �߰�]\n" + "������? > ");

		title = sc.nextLine().trim();
		if (list.isDuplicate(title)) {
			System.out.printf("�ߺ��� ������ �ֽ��ϴ�");
			return;
		}
		
		System.out.println("ī�װ���? > ");
		category = sc.nextLine().trim();
		
		System.out.println("������? > ");
		desc = sc.nextLine().trim();
		
		System.out.println("�������ڴ�?");
		due_date = sc.nextLine().trim();
		
		TodoItem t = new TodoItem(title, desc, category, due_date);
		list.addItem(t);
		System.out.println("��Ͽ� �߰��Ǿ����ϴ�.");
	}

	public static void deleteItem(TodoList l) {

		Scanner sc = new Scanner(System.in);
		/*System.out.println("\n" + "������ �׸��� ������ �Է��ϼ��� > ");

		String title = sc.next();

		for (TodoItem item : l.getList()) {
			if (title.equals(item.getTitle())) {
				l.deleteItem(item);
				System.out.println("��Ͽ��� �����Ǿ����ϴ�.");
				break;
			}
		}*/
		System.out.println("\n" + "������ �׸��� ��ȣ�� �Է��ϼ��� > ");
		
		int num = sc.nextInt();
		if (num > l.getSize()||num<0) {
			System.out.println("�������� �ʴ� ��ȣ�Դϴ�...");
			return;
		}
		l.deleteItemByNumber(num);
		System.out.println("��Ͽ��� �����Ǿ����ϴ�.");
		
	}

	public static void updateItem(TodoList l) {

		Scanner sc = new Scanner(System.in);

		/*System.out.println("\n" + "������ �׸��� ������ �Է��ϼ��� > ");
		String title = sc.next().trim();
		if (!l.isDuplicate(title)) {
			System.out.println("�������� �ʴ� �����Դϴ�...");
			return;
		}*/
		System.out.println("\n" + "������ �׸��� ��ȣ�� �Է��ϼ��� > ");
		int num = sc.nextInt();
		if (num > l.getSize()||num<0) {
			System.out.println("�������� �ʴ� ��ȣ�Դϴ�...");
			return;
		}
		sc.nextLine();
		System.out.println("�� ������ �Է��ϼ��� > ");
		String new_title = sc.nextLine().trim();
		if (l.isDuplicate(new_title)) {
			System.out.println("�̹� �ִ� �����Դϴ�.");
			return;
		}
		
		
		System.out.println("�� ī�װ��� �Է��ϼ��� > ");
		String new_category = sc.nextLine().trim();
		
		System.out.println("�� ������ �Է��ϼ��� > ");
		String new_description = sc.nextLine().trim();
		
		System.out.println("�� �������ڸ� �Է��ϼ��� > ");
		String new_duedate = sc.nextLine().trim();
		
		/*for (TodoItem item : l.getList()) {
			if (item.getTitle().equals(title)) {
				l.deleteItem(item);
				TodoItem t = new TodoItem(new_title, new_description, new_category, new_duedate);
				l.addItem(t);
				System.out.println("�׸��� �����Ǿ����ϴ�.");
			}
		}*/
		l.deleteItemByNumber(num);
		TodoItem t = new TodoItem(new_title, new_description, new_category, new_duedate);
		l.addItem(t);
		System.out.println("�׸��� �����Ǿ����ϴ�.");

	}

	public static void listAll(TodoList l) {
		System.out.println("[��ü���, �� " + l.getSize()+"��]");
		int i = 1;
		for (TodoItem item : l.getList()) {
			
			System.out.print(i+". ");
			System.out.println(item.toString());
			i++;
		}
	}
	
	public static void find(TodoList l, String find) {
		for(TodoItem item : l.getList()) {
			if(item.getTitle().contains(find)||item.getDesc().contains(find)) {
				System.out.println((l.getIndexOf(item)+1)+". "+item.toString());
			}
		}
	}

	public static void saveList(TodoList l, String filename) {
		try {
			Writer w = new FileWriter(filename);
			for (TodoItem item : l.getList()) {
				w.write(item.toSaveString());
			}
			w.close();

			System.out.println("��� ���� �Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void loadList(TodoList l, String filename) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));

			String oneline;
			
			while ((oneline = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(oneline, "##");
				String category = st.nextToken();
				String title = st.nextToken();
				String desc = st.nextToken();
				String due_date = st.nextToken();
				String date = st.nextToken();
				TodoItem t = new TodoItem(title, desc, category, due_date, date);
				l.addItem(t);
			}
			br.close();
			System.out.println("\n��� �ҷ����� �Ϸ�");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
