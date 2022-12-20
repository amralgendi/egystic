//
//  Screen.java
//  EGYSTIC
//
//  Created by Mohamed Salah on 5/9/2022.
//

package project.screens;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

abstract public class DataCreationScreen extends Screen {
    private Class classType;
    public DataCreationScreen(String title, String header, Class classType) {
        super(title, header);
        this.classType = classType;
    }
    abstract void dataInputted(Object object);

    @Override
    final public void start() {
        super.start();
        this.startFetchingClass();
    }
    public void setClassType (Class classType) {
        this.classType = classType;
    }
    public void startFetchingClass() {
        Object newObj;
        try {
            newObj = classType.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Field[] fields = newObj.getClass().getDeclaredFields();

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println("Please Enter "+ newObj.getClass().getSimpleName() + " " + field.getName() + ": ");
            Scanner input = new Scanner(System.in);
            String inputString = input.next();
            field.setAccessible(true);
            try {
                field.set(newObj, inputString);
            } catch (IllegalAccessException e) {
                System.out.println(e.getMessage());
                throw new RuntimeException(e);
            }
        }

        dataInputted(newObj);
    }
}
