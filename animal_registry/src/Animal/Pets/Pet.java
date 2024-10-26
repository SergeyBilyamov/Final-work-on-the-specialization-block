package Animal.Pets;

import Animal.Animal;
import java.time.LocalDate;
import java.util.List;

public class Pet extends Animal {
    public Pet(String name, LocalDate birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    public void performCommand(String command) {
        if (getCommands().contains(command)) {
            System.out.println(getInfo() + " performs command: " + command);
        } else {
            System.out.println(getInfo() + " doesn't know the command: " + command);
        }
    }
}