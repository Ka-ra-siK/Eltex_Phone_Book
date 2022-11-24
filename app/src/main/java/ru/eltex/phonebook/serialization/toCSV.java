package ru.eltex.phonebook.serialization;

import java.io.IOException;
import java.util.List;

import ru.eltex.phonebook.User;

public interface toCSV {
    public void CSVFileWriter(List<User> userList) throws IOException;
}
