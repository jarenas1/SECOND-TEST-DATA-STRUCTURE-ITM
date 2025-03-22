package services;

import models.CreditoModel;
import models.UserModel;

import java.util.Scanner;
import java.util.Stack;

public class Metodos {

    public void menu(){
    Scanner scanner = new Scanner(System.in);
        boolean stopper = true;
        Stack<UserModel> users = new Stack<>();
        Stack<CreditoModel> creditos = new Stack<>();
        while (stopper){
            System.out.println("selecciones una opcion:");
            System.out.println("1. crear credito");
            System.out.println("2. actualizar credito");
            System.out.println("3. vender credito");
            System.out.println("4. eliminar credito");
            System.out.println("5. salir");

            int opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt){
                case 1:
                    System.out.println("Crear credito:");
                    creditos = createCredito(creditos, scanner);
                    break;
                case 2:
                    System.out.println("Actualizar credito:");
                    creditos = updateCredito(creditos, scanner);
                    break;
                case 3:
                    System.out.println("Vender credito:");
                    users = asignCredito(users,creditos,scanner);
                    break;
                case 4:
                    System.out.println("Eliminar credito:");
                    users = deleteCredito(users, scanner);
                    break;
                case 5:
                    System.out.println("Saliendo ....");
                    stopper = false;
                    break;
                default:
                    System.out.println("INGRESE UNA OPCION EXISTENTE");
            }
    }
    }

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

    Stack<CreditoModel> createCredito(Stack<CreditoModel> creditoModels, Scanner sc){
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
        boolean estado = false;


        for (CreditoModel credito : creditoModels) {
            if (credito.getTipo().equals(tipo)) {
                estado = true;
                System.out.println("Ingrese el nuevo tipo de credito");
                String newTipo = sc.nextLine();

                System.out.println("Ingrese la nueva descripcion del credito");
                String newDescripcion = sc.nextLine();

                credito.setDescripcion(newDescripcion);
                credito.setTipo(newTipo);

                break;
            }
        }
        if (estado) {
            System.out.println("Credito actualizado");
        } else {
            System.out.println("Credito no encontrado");
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
        boolean creditoExiste = false;

        for(UserModel userIterator:users){
            if (userIterator.getCedula().equals(cedula)){
                for(CreditoModel creditoIterator:userIterator.getCreditos()){
                    if (creditoIterator.getTipo().equals(tipoCredito)){
                        userIterator.getCreditos().remove(creditoIterator);
                        creditoExiste = true;
                        break;

                    }
                }
                userExiste = true;
                break;
            }
        }
        if (!userExiste){
            System.out.println("Usuario no encontrado");
        }
        if (!creditoExiste && userExiste){
            System.out.println("El usuario no tiene asociado el credito");
        }
        return users;
    }
}
