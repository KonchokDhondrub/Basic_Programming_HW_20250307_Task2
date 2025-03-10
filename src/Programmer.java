class Programmer {
    private final String name;
    private ProgrammerStatus status;

    public Programmer(String name) {
        this.name = name;
        status = ProgrammerStatus.AVAILABLE;
    }

    public void setAvailable(){
        status = ProgrammerStatus.AVAILABLE;
    }
    public void setUnavailable(){
        status = ProgrammerStatus.UNAVAILABLE;
    }
    public void getBusy(){
        status = ProgrammerStatus.BUSY;
    }

    public String getName() {
        return name;
    }
    public ProgrammerStatus getStatus() {
        return status;
    }

    public String doWork(String taskMsg) throws ProgrammerBusyException, ProgrammerUnavailableNowException {
        switch (status) {
            case AVAILABLE:
                return status.getMsg() + taskMsg.toUpperCase();
            case UNAVAILABLE:
                throw new ProgrammerBusyException(status.getMsg() + "Программист занят другой задачей");
            case BUSY:
                throw new ProgrammerUnavailableNowException(status.getMsg() + "Программист не доступен");
            default:
                throw new IllegalStateException("Некорректный статус программиста");
        }
    }
}

enum ProgrammerStatus {
    AVAILABLE {
        @Override
        public String getMsg() {
            return "Доступен\n";
        }
    },
    UNAVAILABLE {
        @Override
        public String getMsg() {
            return "Не доступен\n";
        }
    },
    BUSY {
        @Override
        public String getMsg() {
            return "Занят\n";
        }
    };

    public abstract String getMsg();
}