public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Jack");
        programmer.setUnavailable();

        try {
            String result = programmer.doWork("Написать код");
            System.out.println("Результат: " + result);
        } catch (ProgrammerBusyException e) {
            System.out.println(e.getMessage());
        } catch (ProgrammerUnavailableNowException e) {
            System.out.println(e.getMessage());
        }
    }
}

class ProgrammerBusyException extends RuntimeException {
    public ProgrammerBusyException(String message) {
        super(message);
    }
}

class ProgrammerUnavailableNowException extends RuntimeException {
    public ProgrammerUnavailableNowException(String message) {
        super(message);
    }
}
