import Animal.*;
import Animal.PackAnimal.*;
import Animal.Pets.*;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        try (Counter counter = new Counter();
             Scanner scanner = new Scanner(System.in)) {

            List<Animal> animals = new ArrayList<>();
            boolean running = true;

            while (running) {
                System.out.println("1. Завести новое животное");
                System.out.println("2. Показать команды животного");
                System.out.println("3. Обучить животное новым командам");
                System.out.println("4. Вывести список всех животных");
                System.out.println("5. Выход");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.println("Выберите животное: 1. Собака 2. Кошка 3. Хомяк 4. Лошадь 5. Верблюд 6. Осел");
                        int animalChoice = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        System.out.println("Введите имя:");
                        String name = scanner.nextLine();
                        LocalDate birthDate = LocalDate.now();
                        List<String> commands = new ArrayList<>();

                        Animal animal = switch (animalChoice) {
                            case 1 -> new Dog(name, birthDate, commands);
                            case 2 -> new Cat(name, birthDate, commands);
                            case 3 -> new Hamster(name, birthDate, commands);
                            case 4 -> new Horse(name, birthDate, commands);
                            case 5 -> new Camel(name, birthDate, commands);
                            case 6 -> new Donkey(name, birthDate, commands);
                            default -> null;
                        };

                        if (animal != null) {
                            animals.add(animal);
                            counter.add();
                        } else {
                            System.out.println("Некорректный выбор.");
                        }
                    }
                    case 2 -> {
                        System.out.println("Введите имя животного, чтобы увидеть команды:");
                        String animalName = scanner.next();

                        Optional<Animal> foundAnimal = animals.stream()
                                .filter(a -> a.getName().equalsIgnoreCase(animalName))
                                .findFirst();

                        if (foundAnimal.isPresent()) {
                            System.out.println(foundAnimal.get().getCommands());
                        } else {
                            System.out.println("Животное не найдено.");
                        }
                    }
                    case 3 -> {
                        System.out.println("Введите имя животного, чтобы обучить:");
                        String nameToTrain = scanner.next();
                        System.out.println("Введите новую команду:");
                        String newCommand = scanner.next();

                        Optional<Animal> foundAnimal = animals.stream()
                                .filter(a -> a.getName().equalsIgnoreCase(nameToTrain))
                                .findFirst();

                        if (foundAnimal.isPresent()) {
                            foundAnimal.get().addCommand(newCommand);
                        } else {
                            System.out.println("Животное не найдено.");
                        }
                    }
                    case 4 -> {
                        if (animals.isEmpty()) {
                            System.out.println("Список животных пуст.");
                        } else {
                            System.out.println("Список всех животных:");
                            animals.forEach(a -> {
                                String className = a.getClass().getSimpleName();
                                System.out.printf("Класс: %s, Имя: %s, Дата рождения: %s%n",
                                        className, a.getName(), a.getInfo().split(",")[1].trim());
                            });
                        }
                    }
                    case 5 -> running = false;
                    default -> System.out.println("Некорректный выбор.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
