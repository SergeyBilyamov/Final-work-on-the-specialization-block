package Animal.PackAnimal;

import java.time.LocalDate;
import java.util.List;

public class Donkey extends PackAnimal {
    public Donkey(String name, LocalDate birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
}