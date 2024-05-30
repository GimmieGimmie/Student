package com.jdbclearning.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jdbclearning.entities.Patient;
import com.jdbclearning.entities.Student;
import com.jdbclearning.util.SQLConnector;

//Data Access Object
public class Dao{

    public int insertPatient(Patient patient) {
        int status = 0;

        try(Connection con = SQLConnector.createConnection()) {

            String sql = "INSERT INTO patients (name, concern, address, blood) VALUES (?,?,?,?);";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, patient.getName());
            stm.setString(2, patient.getConcern());
            stm.setString(3, patient.getAddress());
            stm.setString(4, patient.getBlood());

            status = stm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<Patient>();

        try(Connection con = SQLConnector.createConnection()){

            String sql = "SELECT * FROM patients";

            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultData = stmt.executeQuery();

            while(resultData.next()){

                Patient p = new Patient();
                p.setId(resultData.getInt(1));
                p.setName(resultData.getString(2));
                p.setConcern(resultData.getString(3));
                p.setAddress(resultData.getString(4));
                p.setBlood(resultData.getString(5));

                patients.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return patients;
    }

    public int updateStudent(int id, Patient updatedPatient) {

        int status = 0;

        try(Connection con = SQLConnector.createConnection()) {

            String sql = "UPDATE patients SET name =?, concern =?, address =?, blood =? WHERE id =?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, updatedPatient.getName());
            stm.setString(2, updatedPatient.getConcern());
            stm.setString(3, updatedPatient.getAddress());
            stm.setString(4, updatedPatient.getBlood());
            stm.setInt(5, id);

            status = stm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }

    public int deleteStudent(int id) {

        int status = 0;

        try(Connection con = SQLConnector.createConnection()) {

            String sql = "DELETE FROM patients WHERE id =?";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            status = stm.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return status;
    }
}
