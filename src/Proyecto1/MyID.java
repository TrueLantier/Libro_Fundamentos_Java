package Proyecto1;

public interface MyID {
    int getUserID();

    static int getUniversalID() {
        return 0;
    }

    default int getAdminID() {
        return 1;
    }
}
