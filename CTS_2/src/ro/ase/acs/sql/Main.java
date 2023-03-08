package ro.ase.acs.sql;

import ro.ase.acs.sql.classes.DataInserter;
import ro.ase.acs.sql.classes.DataReader;
import ro.ase.acs.sql.classes.TableCreator;
import ro.ase.acs.sql.interfaces.DataInserterI;
import ro.ase.acs.sql.interfaces.DataReaderI;
import ro.ase.acs.sql.interfaces.TableCreatorI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    private static final String  CONEXIUNE = "jdbc:sqlite:database.db";
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(CONEXIUNE);
            connection.setAutoCommit(false);

            TableCreatorI tableCreator = new TableCreator();
            tableCreator.createTable(connection);

            DataInserterI dataInserter = new DataInserter();
            dataInserter.insertData(connection);

            DataReaderI dataReader = new DataReader();
            dataReader.readData(connection);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}