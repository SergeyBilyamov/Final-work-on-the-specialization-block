package Animal.PackAnimal;

import java.time.LocalDate;
import java.util.List;

public class Camel extends PackAnimal {
    public Camel(String name, LocalDate birthDate, List<String> commands) {
        super(name, birthDate, commands);
    }
}