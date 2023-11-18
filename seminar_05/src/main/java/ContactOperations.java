import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ContactOperations {
    List<Contact> data = new ArrayList<>();

    public void addContact(Contact Contact) {
        data.add(Contact);
    }

    public boolean editPhone(String name, String phone) {
        Optional<Contact> Contact = data.stream()
                .filter(n -> n.getName().contains(name))
                .findFirst();
        if (Contact.isPresent()) {
            Contact.get().setPhone(phone);
            return true;
        }
        return false;
    }


    public boolean editName(String name, String phone) {
        return data.stream()
                .filter(Contact -> Contact.getPhone().contains(phone))
                .peek(Contact -> Contact.setName(name))
                .findAny()
                .isPresent();
    }


    public boolean delContact(String name) {
        return data.removeIf(Contact -> Contact.getName().equals(name));
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Contact Contact : data) {
            result.append(Contact.getName()).append(": ").append(Contact.getPhone()).append("\n");
        }
        return result.toString();
    }
}