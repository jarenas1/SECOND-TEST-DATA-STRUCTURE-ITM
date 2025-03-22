package services;

import models.UserModel;

import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicBoolean;

public class metodos {

    Stack<UserModel> crearUsuario(Stack<UserModel> userModelStack, Scanner sc){
        System.out.println("Ingrese la ceula del usuario");
        String cedula = sc.nextLine();
        System.out.println("Ingrese el nombre completo del usuario");
        String nombre = sc.nextLine();

        //verificar que la cedula no esté ya registrada
        boolean status = false;

        for(UserModel userModel : userModelStack) {
            if (userModel.getCedula().equals(cedula)) {
                status = true;
                System.out.println("El usuario con la cedula dada ya esta registrado");
                break;
            }
        }
        if (!status){
            UserModel userModel = new UserModel(cedula, nombre);
            userModelStack.add(userModel);
        }
        return userModelStack;
    }
}
