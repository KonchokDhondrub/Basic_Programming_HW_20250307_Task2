class Programmer {
    private String name;
    private String status;

    public Programmer(String name, String status) {
        this.name = name;
        this.status = status;
    }

    public String doWork(String taskMsg) throws ProgrammerBusyException, ProgrammerUnavailableNowException {
        switch (status) {
            case "доступен":
                return taskMsg.toUpperCase();
            case "занят":
                throw new ProgrammerBusyException("Программист занят другой задачей");
            case "не доступен":
                throw new ProgrammerUnavailableNowException("Программист не доступен");
            default:
                throw new IllegalStateException("Некорректный статус программиста");
        }
    }
}