package Models;

import java.util.*;

public class School {
    private static List<Person> members;

    public School() {
        this.members = new ArrayList<>();
    }

    public static void addMember(Person person) {
        members.add(person);
    }

    public static List<Person> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("School Members:\n");
        for (Person member : members) {
            result.append(member.toString()).append("\n");
        }
        return result.toString();
    }
}
