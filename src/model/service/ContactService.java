package model.service;

import model.contact.Contact;
import model.contact.Phone;
import model.contact.User;
import java.util.ArrayList;

public interface ContactService <T extends User, E extends Phone>  {

	public boolean isCorrect(T user, ArrayList<E> phones);
	public Contact createContact(T user, ArrayList<E> phones);

}
