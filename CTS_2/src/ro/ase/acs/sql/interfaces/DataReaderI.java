package ro.ase.acs.sql.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataReaderI {
    void readData(Connection connection) throws SQLException;
}

