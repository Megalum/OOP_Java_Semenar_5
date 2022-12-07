package controller;

import model.contact.Contact;
import model.contact.Phone;
import model.contact.User;
import model.phonebook.Phonebook;
import model.service.ContactServiceImpl;
import model.service.PhonebookService;
import utils.ReadFromConsole;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
	public static void buttonClick() {
		String message = new ReadFromConsole().getMessage();
		ArrayList<Contact> listContacts = new ArrayList<>();
		listContacts.add(addContact(message));
		listContacts.add(addContact("Ford;Mrow;123456;954321;654285;123512"));
		listContacts.add(addContact("Kel/Raf/956421/365214/854652/975648"));
		listContacts.add(addContact("Gor Vil 362525 365495 352162"));
		Phonebook phonebook = new PhonebookService().createPhonebook("Phonebook", listContacts);
		System.out.println(phonebook);
	}

	private static Contact addContact(String message){
		String separator = splitLine(message);
		List<String> line = new ArrayList<>(Arrays.asList(message.split(separator)));
		User user = new User(line.get(0), line.get(1));
		ArrayList<Phone> phones = new ArrayList<>();
		for (int i = 2; i< line.size(); i++){
			phones.add(new Phone(line.get(i)));
		}
		Contact contact =  new ContactServiceImpl().createContact(user, phones);
		return contact;
	}

	private static String splitLine(String message){
		String f = "";
		for (char s: message.toCharArray()) {
			if(!Character.isLetter(s)){
				f = s + "";
				break;
			}
		}
		return f;
	}
}
