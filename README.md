# CSE201_Pear

This GitHub repository is an in-progress application Repository showing a filterable and sortable library of applications based on different criteria - built fully in Java. Users can create accounts and login to them, view discussion boards on mobile and desktop applications, post comments, and compare through different platforms. Different filters and views can be used to aggregate different application information.

## Developer Documentation

After cloning the repository, running the ANT build script should automatically clean, compile and build the JAR file for the program. 

- Cleaning the file directory fixes any classpath issues
- A new directory structure is added for future testing and for packaging all of the software resources pre-compilation
- Compilation and packaging of the corresponding JAR files is followed therafter

To add dependencies with ANT:

```xml
<target name="package" depends="compile" description="Generates the JAR file">                                                
    <jar destfile="dist/CSE201_Pear.jar" basedir="bin"/>
    //Future dependencies using JAR files added here
    <echo message="${ant.project.name}: JAR file generated"/>
</target>
```
To conduct tests, adding JUnit to your corresponding classpath allows for testing. A test directory is created to store tester classes. Adding a JUnit JAR file as a dependency inside the package target would allow for JUnit tests to be run. Otherwise, you can just add it to you current classpath in your IDE.

## User Documentation

Users can currently run the main driver (PearWindow, which is shown below and should be run), which creates a separate instance of the running software that can then be used to view applications, filter, sort, and use several other functionalities. 

```java
public static void main(String[] args) {
		Store pear = new Store();
    
    \\Application load
    
    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new PearWindow(pear, pear.appList);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}
```
