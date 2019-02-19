package fr.him.CassandraExamples;


import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;

/**
 * CRUD with cassandra.
 * Don't forget to start cassandra server before running this app.
 */
public class App 
{
    public static void main( String[] args )
    {
    	//Query
        String query = "CREATE KEYSPACE tp WITH replication "
           + "= {'class':'SimpleStrategy', 'replication_factor':1};";
                      
        //creating Cluster object
        Cluster cluster = Cluster.builder().addContactPoint("127.0.0.1").build();
        
        //Creating Session object
        Session session = cluster.connect();
       
        //Executing the query
        session.execute(query);
       
        //using the KeySpace
        session.execute("USE tp");
        System.out.println("Keyspace created"); 
        
        query = "CREATE TABLE emp(emp_id int PRIMARY KEY, "
                + "emp_name text, "
                + "emp_city text, "
                + "emp_sal varint, "
                + "emp_phone varint );";
        
        session.execute(query);
        System.out.println("Table created");
        
        query = "CREATE INDEX name ON emp (emp_name);";
        //Executing the query
        session.execute(query);
        System.out.println("Index created");
        
        //queries
        String query1 = "INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone)"  
  		
           + " VALUES(1,'john', 'paris', 9848022338);" ;
                               
        String query2 = "INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone, emp_sal)"
        
           + " VALUES(2,'robin', 'london', 9848022339, 40000);" ;
                               
        String query3 = "INSERT INTO emp (emp_id, emp_name, emp_city, emp_phone, emp_sal)"
         
           + " VALUES(3,'julien', 'madrid', 9848022330, 45000);" ;
        
        //Executing the query
        session.execute(query1);
          
        session.execute(query2);
          
        session.execute(query3);
          
        System.out.println("Data created");
        
        query = " UPDATE emp SET emp_city='Delhi',emp_sal=50000  WHERE emp_id=2;";
        //Executing the query
        session.execute(query);
        System.out.println("Data updated");
        
        //queries
        query = "SELECT * FROM emp";
        //Getting the ResultSet
        ResultSet result = session.execute(query);
        System.out.println(result.all());
        
        query = "DELETE FROM emp WHERE emp_id=3;";
        //Executing the query
        session.execute(query);
        System.out.println("Data deleted");
        
        //queries
        query = "SELECT * FROM emp";
        //Getting the ResultSet
        result = session.execute(query);
        System.out.println(result.all());
        
        /** CASSANDRA COLLECTIONS **/
        
        //Queries - cassandra list collection
        String listQuery = "CREATE TABLE data(name text PRIMARY KEY, email list<text>);";
        session.execute(listQuery);
        listQuery = "INSERT INTO data(name, email) VALUES ('sam', ['abc@gmail.com','cba@yahoo.com']);";
        session.execute(listQuery);
        listQuery = "UPDATE data SET email = email +['xyz@outlook.com'] where name = 'sam';";
        session.execute(listQuery);
        System.out.println("Cassandra list queries executed");
        
        //queries
        query = "SELECT * FROM data";
        //Getting the ResultSet
        result = session.execute(query);
        System.out.println(result.all());
        
        
        //Queries - cassandra set collection
        String setQuery = "CREATE TABLE data2(name text PRIMARY KEY, phone set<varint>);";
        session.execute(setQuery);
        setQuery = "INSERT INTO data2(name, phone)VALUES ('rock', {9848022338,9848022339});";
        session.execute(setQuery);
        setQuery = "UPDATE data2 SET phone = phone + {9848022330} where name = 'rock';";
        session.execute(setQuery);
        System.out.println("Cassandra set queries executed");
        
        //queries
        query = "SELECT * FROM data2";
        //Getting the ResultSet
        result = session.execute(query);
        System.out.println(result.all());
        
        //Queries - cassandra map collection
        String mapQuery = "CREATE TABLE data3(name text PRIMARY KEY,  address map<text, text>);";
        session.execute(mapQuery);
        mapQuery = "INSERT INTO data3(name, address) VALUES ('robin', {'home' : 'nyc' , 'office' : 'miami' } );";
        session.execute(mapQuery);
        mapQuery = "UPDATE data3 SET address = address+{'office':'mumbai'} where name = 'robin';";
        session.execute(mapQuery);
        System.out.println("Cassandra map queries executed");
        
        //queries
        query = "SELECT * FROM data3";
        //Getting the ResultSet
        result = session.execute(query);
        System.out.println(result.all());

    }
}
