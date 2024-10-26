package Animal.PackAnimal;

import Animal.Animal;
import java.time.LocalDate;
import java.util.List;

public class PackAnimal extends Animal {
    public PackAnimal(String name, LocalDate birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }

    @Override
    public void performCommand(String command) {
        if (getCommands().contains(command)) {
            System.out.println(getInfo() + " is carrying out a pack animal command: " + command);
        } else {
            System.out.println(getInfo() + " doesn't know the pack animal command: " + command);
        }
    }
}