package vn.edu.vnuk.record.mvc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import vn.edu.vnuk.record.mvc.jdbc.ConnectionFactory;
import vn.edu.vnuk.record.mvc.model.Contact;

public class ContactDao {
	
    private Connection connection;

    public ContactDao(){
        this.connection = new ConnectionFactory().getConnection();
    }


    //  CREATE
    public void create(Contact contact) throws SQLException{

        String sqlQuery = "insert into contacts (name, email, address, date_of_birth) "
                        +	"values (?, ?, ?, ?)";

        PreparedStatement statement;

        try {
                statement = connection.prepareStatement(sqlQuery);

                //	Replacing "?" through values
                statement.setString(1, contact.getName());
                statement.setString(2, contact.getEmail());
                statement.setString(3, contact.getAddress());
                statement.setDate(4, new Date(contact.getDateOfBirth().getTimeInMillis()));

                // 	Executing statement
                statement.execute();

                System.out.println("New record in DB !");

        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                System.out.println("Done !");
        }

    }
    
    
    //  READ (List of Contacts)
    @SuppressWarnings("finally")
    public List<Contact> read() throws SQLException {

        String sqlQuery = "select * from contacts";
        PreparedStatement statement;
        List<Contact> contacts = new ArrayList<Contact>();

        try {

            statement = connection.prepareStatement(sqlQuery);

            // 	Executing statement
            ResultSet results = statement.executeQuery();

            while(results.next()){

                Contact contact = new Contact();
                contact.setId(results.getLong("id"));
                contact.setName(results.getString("name"));
                contact.setEmail(results.getString("email"));
                contact.setAddress(results.getString("address"));

                Calendar date = Calendar.getInstance();
                date.setTime(results.getDate("date_of_birth"));
                contact.setDateOfBirth(date);

                contacts.add(contact);

            }

            results.close();
            statement.close();


        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                return contacts;
        }


    }


    //  READ (Single Contact)
    @SuppressWarnings("finally")
    public Contact read(Long id) throws SQLException{

        String sqlQuery = "select * from contacts where id=?";

        PreparedStatement statement;
        Contact contact = new Contact();

        try {
            statement = connection.prepareStatement(sqlQuery);

            //	Replacing "?" through values
            statement.setLong(1, id);

            // 	Executing statement
            ResultSet results = statement.executeQuery();

            if(results.next()){

                contact.setId(results.getLong("id"));
                contact.setName(results.getString("name"));
                contact.setEmail(results.getString("email"));
                contact.setAddress(results.getString("address"));

                Calendar date = Calendar.getInstance();
                date.setTime(results.getDate("date_of_birth"));
                contact.setDateOfBirth(date);

            }

            statement.close();

        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        } finally {
                return contact;
        }

    }


    //  UPDATE
    public void update(Contact contact) throws SQLException {
        String sqlQuery = "update contacts set name=?, email=?," 
                            + "address=?, date_of_birth=? where id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getEmail());
            statement.setString(3, contact.getAddress());
            statement.setDate(4, new Date(contact.getDateOfBirth().getTimeInMillis()));
            statement.setLong(5, contact.getId());
            statement.execute();
            statement.close();
            
            System.out.println("Contact successfully modified.");
        } 

        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    
    
    //  DELETE
    public void delete(Contact contact) throws SQLException {
        String sqlQuery = "delete from contacts where id=?";

        try {
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setLong(1, contact.getId());
            statement.execute();
            statement.close();
            
            System.out.println("Contact successfully deleted.");

        } 

        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}