package Animal;

import java.time.LocalDate;
import java.util.List;

public abstract class Animal {
    private String name;
    private LocalDate birthDate;
    private List<String> commands;

    public Animal(String name, LocalDate birthDate, List<String> commands) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = commands;
    }

    public abstract void performCommand(String command);

    public String getInfo() {
        return String.format("Name: %s, Birth Date: %s", name, birthDate.toString());
    }

    public List<String> getCommands() {
        return commands;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public String getName() {
        return name;
    }
}