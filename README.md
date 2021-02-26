# Barter 

### Online Commerce

Barter is an online commerce, or as we know it 
eCommerce solution tailored to small and mid sized 
businesses.

Feel free to fork and run on your own to check it
out.

## Run
* clone repo
* cd into Sequence
* run project    
    `mvn jetty:run -Dspring.profiles.active=Dev`
    
The project is completely open source. 
You just can't make money from it.

DFW7S282

	<bean depends-on="dataSource" class="org.springframework.beans.factory.config.MethodInvokingBean">
		<property name="targetClass" value="org.hsqldb.util.DatabaseManagerSwing" />
		<property name="targetMethod" value="main" />
		<property name="arguments">
			<list>
				<value>--url</value>
				<value>jdbc:h2:mem:dataSource</value>
				<value>--user</value>
				<value>sa</value>
				<value>--password</value>
				<value></value>
			</list>
		</property>
	</bean>