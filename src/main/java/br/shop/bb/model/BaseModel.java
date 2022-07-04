package br.shop.bb.model;




import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
public abstract class BaseModel<ID> {


    public void setId(ID id) {

        try {
            Class clazz = this.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(br.shop.bb.annotations.ID.class)) {
                    String fieldName = field.getName();
                    String methodName = "set" + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1);
                    Method method = clazz.getDeclaredMethod(methodName, id.getClass());
                    //method.setAccessible(true);
                    method.invoke(this, id);
                    break;
                }
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}