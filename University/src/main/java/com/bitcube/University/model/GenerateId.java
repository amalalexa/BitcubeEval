package com.bitcube.University.model;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Properties;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class GenerateId implements IdentifierGenerator, Configurable{
	
	private String prefix;
	
	@Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj){
		try {
			Class object =  Class.forName(obj.getClass().getSimpleName()+"Repository");
			Method findAllRecords = object.getDeclaredMethod("findAllRecords");
			Object allObjects= findAllRecords.invoke(object, null);

			/*Stream ids = session.createQuery(query).stream();

			int max = ids.map(value -> value.replace(prefix+"-",""))
						  .mapToInt(Integer::parseInt)
						  .max()
						  .orElse(0);
			*/
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return prefix + "-" + (0+ 1);
		
	}
	
	 @Override
	  public void configure(Type type, Properties properties, ServiceRegistry serviceRegistry){
	      prefix = properties.getProperty("prefix");
	  }

}
