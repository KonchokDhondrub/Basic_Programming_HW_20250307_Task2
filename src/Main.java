public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Jack");
        programmer.setUnavailable();

        try {
            String result = programmer.doWork("Написать код");
            System.out.println("Результат: " + result);
        } catch (ProgrammerBusyException | ProgrammerUnavailableNowException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ProgrammerBusyException extends Exception {
    public ProgrammerBusyException(String message) {
        super(message);
    }
}

class ProgrammerUnavailableNowException extends Exception {
    public ProgrammerUnavailableNowException(String message) {
        super(message);
    }
}
