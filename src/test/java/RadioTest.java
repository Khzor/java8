import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class RadioTest {

    @Test
    void setCurrentStationToFour() {
        Radio radio = new Radio();

        int expected = radio.getCurrentStation() + 4;
        radio.setCurrentStation(4);
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void doNotSetCurrentStationIfMoreThanMax() {
        Radio radio = new Radio();

        int expected = radio.getCurrentStation();
        radio.setCurrentStation(27);
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void doNotSetCurrentStationIfLessThanMin() {
        Radio radio = new Radio();

        int expected = radio.getCurrentStation();
        radio.setCurrentStation(-52);
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void nextStationTwice() {
        Radio radio = new Radio();

        int expected = radio.getCurrentStation() + 2;
        radio.nextStation();
        radio.nextStation();
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void nextStationFromMaxStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);
        int expected = radio.getMinStation();
        radio.nextStation();
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void previousStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);
        int expected = radio.getCurrentStation() - 1;
        radio.previousStation();
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void previousStationFromMinStation() {
        Radio radio = new Radio();

        int expected = radio.getMaxStation();
        radio.previousStation();
        int actual = radio.getCurrentStation();

        assertEquals(expected, actual);
    }

    @Test
    void increaseVolume() {
        Radio radio = new Radio();

        int expected = radio.getCurrentVolume() + 1;
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void decreaseVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(5);
        int expected = radio.getCurrentVolume() - 1;
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void doNotDecreaseFromMinVolume() {
        Radio radio = new Radio();

        int expected = radio.getCurrentVolume();
        radio.decreaseVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }

    @Test
    void doNotIncreaseFromMaxVolume() {
        Radio radio = new Radio();

        radio.setCurrentVolume(radio.getMaxVolume());
        int expected = radio.getCurrentVolume();
        radio.increaseVolume();
        int actual = radio.getCurrentVolume();

        assertEquals(expected, actual);
    }
}
