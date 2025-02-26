package pl.jkuznik.computer.hardware.components.drive;

class ReadWriteSpeed {
    int readSpeed;
    int writeSpeed;

    public ReadWriteSpeed(int readSpeed, int writeSpeed) {
        this.readSpeed = readSpeed;
        this.writeSpeed = writeSpeed;
    }

    public int getReadSpeed() {
        return readSpeed;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }
}

