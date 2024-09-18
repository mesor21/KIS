package example.Interceptors;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class ProfileInterceptor {
    @AroundInvoke
    public Object profile(InvocationContext ic) throws Exception {
        long initTime = System.nanoTime();
        try {
            return ic.proceed();
        } finally {
            long diffTime = System.nanoTime() - initTime;
            System.out.println(ic.getMethod() + " took " + diffTime + " nanoseconds");
        }
    }

}
