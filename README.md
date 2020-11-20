# CSE201_Pear

This GitHub repository is an in-progress application Repository showing a filterable and sortable library of applications based on different criteria - built fully in Java. Users can create accounts and login to them, view discussion boards on mobile and desktop applications, post comments, and compare through different platforms. Different filters and views can be used to aggregate different application information.

## Developer Documentation

After cloning the repository, running the ANT build script should automatically clean, compile and build the JAR file for the program. If you do not want to clone it, you can download it as a ZIP file, import it into your IDE, and run the build script. This will clean, compile, and overall correctly build the project. 

- Cleaning the file directory fixes any classpath issues
- A new directory structure is added for future testing and for packaging all of the software resources pre-compilation
- Compilation and packaging of the corresponding JAR files is followed therafter

```xml
	<target name="clean">
		<delete dir="bin" />
		<delete dir="dist" />
		<delete dir="test" />
		<echo message="${ant.project.name}: Directory structure cleaned" />
	</target>
	
	 <target name="init" depends="clean">
	 	<echo message="${ant.project.name}: ${ant.file}"/>
	 	<mkdir dir="bin/main" />
	 	<mkdir dir="dist" />
	 	<mkdir dir="test" />
	 	<echo message="${ant.project.name}: Directory structure added" />
	  </target>
		
	  <target name="compile" depends="init" description="Compile Java code">
	    <javac srcdir="src/main" destdir="bin" includeantruntime="false" />
		  //JUnit compilation can be added here or in another target
	  	<echo message="${ant.project.name}: Compilation completed"/>
	  </target>
```

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
    
    \\Application List load - varies between iterations
    
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
