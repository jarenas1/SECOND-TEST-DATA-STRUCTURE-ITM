package services;

import models.CreditoModel;
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
            System.out.println("Creando usuario ...");
        }
        return userModelStack;
    }

    Stack<CreditoModel> creditoModels(Stack<CreditoModel> creditoModels, Scanner sc){
        System.out.println("Ingrese el tipo del credito");
        String tipo = sc.nextLine();
        System.out.println("Ingrese la descripcion del credito");
        String descripcion = sc.nextLine();

        //verificar que el credito no este registrado
        boolean status = false;

        for(CreditoModel creditoModel : creditoModels) {
            if (creditoModel.getTipo().equals(tipo)) {
                status = true;
                System.out.println("El credito ya esta creado");
                break;
            }
        }
        if (!status){
            CreditoModel creditoModel = new CreditoModel(tipo, descripcion);
            creditoModels.add(creditoModel);
            System.out.println("Creando credito ....");
        }
        return creditoModels;
    }

    Stack<CreditoModel> updateCredito(Stack<CreditoModel> creditoModels, Scanner sc) {
        System.out.println("Ingrese el tipo de credito");
        String tipo = sc.nextLine();

        //verificar que el credito no este registrado
        boolean status = false;


        for (CreditoModel credito : creditoModels) {
            if (credito.getTipo().equals(tipo)) {
                status = true;
                System.out.println("Ingrese el nuevo tipo de credito");
                String newTipo = sc.nextLine();

                System.out.println("Ingrese la nueva descripcion del credito");
                String newDescripcion = sc.nextLine();

                credito.setDescripcion(newDescripcion);
                credito.setTipo(newTipo);

                break;
            }
            if (status) {
                System.out.println("Credito actualizado");
            } else {
                System.out.println("Credito no encontrado");
            }
        }
        return creditoModels;
    }

    public Stack<UserModel> asignCredito(Stack<UserModel> users, Stack<CreditoModel> creditoModels, Scanner sc){
        System.out.println("Ingrese la cedula del usuario");
        String cedula = sc.nextLine();
        System.out.println("Ingrese el credito que desea tomar");
        String tipoCredito = sc.nextLine();

        boolean userExiste = false;
        boolean creditoExiste = false;

        for(UserModel userIterator:users){
            if (userIterator.getCedula().equals(cedula)){
                userExiste = true;
                break;
            }
        }
        if (!userExiste){
            System.out.println("Usuario no encontrado, registrese:");
            users = crearUsuario(users, sc);
            userExiste=true;
        }

        //verificar credito existe
        for(CreditoModel creditoIterator: creditoModels){
            if (creditoIterator.getTipo().equals(tipoCredito)){
                creditoIterator.setTomados(creditoIterator.getTomados()+1);
                creditoExiste = true;

                for(UserModel userIterator:users){
                    if (userIterator.getCedula().equals(cedula)){
                        userIterator.getCreditos().add(creditoIterator);
                        break;
                    }
                }
                System.out.println("Credito tomado");
                break;
            }
        }
        if (!creditoExiste){
            System.out.println("El credito no se encuentra en el portafolio del banco");
        }
        return users;
    }
    public Stack<UserModel> deleteCredito(Stack<UserModel> users, Scanner sc){
        System.out.println("Ingrese la cedula del usuario");
        String cedula = sc.nextLine();
        System.out.println("Ingrese el credito que desea eliminar");
        String tipoCredito = sc.nextLine();

        boolean userExiste = false;

        for(UserModel userIterator:users){
            if (userIterator.getCedula().equals(cedula)){
                for(CreditoModel creditoIterator:userIterator.getCreditos()){
                    if (creditoIterator.getTipo().equals(tipoCredito)){
                        userIterator.getCreditos().remove(creditoIterator);
                        break;
                    }
                }
                userExiste = true;
                break;
            }
        }
    }
}
