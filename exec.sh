./xsbt package
java -Xmx256M -Xms32M -cp "scala-lib/scala-library.jar:lib/cglib-nodep-2.2.jar:lib/h2-1.2.127.jar:lib/squeryl_2.9.1-0.9.5-SNAPSHOT.jar:target/scala-2.9.1/scalexec_2.9.1-1.0.jar"  MyApp


