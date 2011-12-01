import org.squeryl.PrimitiveTypeMode._
import org.squeryl.annotations.Column
import org.squeryl._
import org.squeryl.adapters.H2Adapter
import java.sql.DriverManager

case class Person(val id : Long, var name : String)

object Library extends Schema {
  val persons = table[Person]
}

object MyApp {
  def main(args : Array[String]) = { 
    println("executing MyApp from Java Command Line ?")

    Class.forName("org.h2.Driver");
    SessionFactory.concreteFactory = Some(()=>
        Session.create(DriverManager.getConnection("jdbc:h2:mem:dbname;DB_CLOSE_DELAY=-1", "sa", ""),
          new H2Adapter))
    
    transaction {    
      Library.create
      val johndoe = Library.persons.insert(new Person(id = 1, name="John Doe"))    
      def who = Library.persons.where(a => a.name === "John Doe").single    
      println(who.toString)
    }
  }
}
