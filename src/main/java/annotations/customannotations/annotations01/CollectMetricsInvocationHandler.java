package annotations.customannotations.annotations01;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;

public class CollectMetricsInvocationHandler   implements InvocationHandler{

	private Object proxied;

	public CollectMetricsInvocationHandler(Object proxied) {
		this.proxied = proxied; 
	} 
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object methodReturnValue= null;
		Method m = proxied.getClass().getMethod(method.getName(), method.getParameterTypes());
		if (m.isAnnotationPresent(CollectMetrics.class)) {
			long start =0 , end =0;
			start = System.currentTimeMillis();
			methodReturnValue = method.invoke(proxied, args);
			end= System.currentTimeMillis();
			System.out.println(MessageFormat.format("{0} method took {1}ms",method.getName() , (end-start)));  
		} 
		else {
			methodReturnValue = method.invoke(proxied, args);
		}		
		return methodReturnValue ;
	}
	
	
	
	public static Object getNewProxy(Object proxied, Class<?> interfaze) {
		Object proxy = Proxy.newProxyInstance(
				CollectMetricsInvocationHandler.class.getClassLoader(),
				new Class[] {interfaze}, 
				new CollectMetricsInvocationHandler(proxied));
		return proxy;
	}

}
