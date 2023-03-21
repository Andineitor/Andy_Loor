#include <iostream>
using namespace std;
//INCLUIMOS LAS LIBRERIAS
#include "medicoss.cpp"
#include "citas.cpp"
#include "pascientes.cpp"
int main() {
    int opmenugeneral;
    do {//ENTRAMOS AL PROGRAMA EN GENERAL
        opmenugeneral = menucitas_medi_pac();//INVOCAMOS OPCION DE CITAS PACIENTES O MEDICOS
        system("cls");
        switch (opmenugeneral) {
        case 1:
        {//INGRESAMOS AL MENU DE CITAS
            bool exito;
            cargar(lista, exito);//CARGAR DATOS DEL ARCHIVO
            if (!exito) {//EN CASO DE NO CARGAR
                cout << "No se ha podido cargar la lista" << endl;
            }
            else {//EN CASO DE CARGAR
                int opcitas;
                do {
                    opcitas = menugeneralcitas();//MENU PARA SOLICITAR QUE HACER
                    switch (opcitas) {
                    case 1:
                    {
                        system("cls");
                        agendarcita(lista, datos);//AGENDAR CITA
                        break;
                    }
                    case 2:
                    {
                        int modificar;//MODIFICAR CITAS YA PROGRAMADAS
                        do {
                            int pos;
                            pos = datoelim(lista);//BUSCAR LA POSICION A ELIMINAR O MODIFICAR, SOLICITANDO EL NUMERO DE CEDULA 
                            if (pos < 0) {//EN CASO DE POS =-1 ES PORQUE LA CITA NO EXISTE
                                color(hConsole, 4);
                                system("cls");
                                cout << "\n\n\n\n\n\n\n\n";
                                cout << "\t\t\t\t\t\t\t\t\t------------------------------------------------------" << endl;
                                cout << "\t\t\t\t\t\t\t\t\t|                LA CITA NO EXISTE                   |" << endl;
                                cout << "\t\t\t\t\t\t\t\t\t------------------------------------------------------";
                                modificar = 0;
                                color(hConsole, 7);
                            }
                            else {//EN CASO DE EXISTIR LA CITA
                                modificar = menumodificar();//SOLOCITAR QUE HACER EN EL MENU DE MODIFICAR
                                switch (modificar) {
                                case 1://ELIMINA RAPIDAMENTE LA POSICION PASADA
                                {
                                    elimina(lista, lista.contador, pos);
                                    modificar = 0;
                                    break;
                                }
                                case 2://MODIFICA LA FECHA DE LA POSICON PASADA
                                {
                                    modificarfecha(lista, datos, pos);
                                    modificar = 0;
                                    break;
                                }
                                case 3://MODIFICA LA HORA DE LA POSICION PASADA
                                {
                                    modificarhora(lista, datos, pos);
                                    modificar = 0;
                                }
                                }
                            }

                        } while (modificar != 0);//VALIDAR PARA SALIR 
                        break;
                    }
                    case 3://MOSTRAR LAS CITAS REGISTRADAS SIEMPRE EN ORDEN POR: -->HORA,DIA,MES,AÑO
                    {
                        system("cls");
                        ordenarcitas(lista);
                        mostrarpasientes(lista, lista.contador);
                        break;
                    }
                    case 4://CONSUALR CITA YA REGISTRADA
                    {
                        system("cls");
                        int xcitas;
                        xcitas = regresardatosconsulta();

                        consultar(lista, xcitas);
                        break;
                    }
                    case 5://MOSTRAR LAS CITAS POR ESPECIALIDAD
                    {
                        especilidad(lista, pedirespecialidad()/*BUSCAR LAS CITAS QUE TENGAN ESTA ESPECIALIDAD*/);
                        break;
                    }
                    case 6:
                    {//MOSTRAR LAS CITAS POR FECHA
                        mostrarfecha(lista);
                        break;
                    }
                    }
                } while (opcitas != 0);
                guardar(lista);//GUARDA LOS DATOS DE LAS CITAS
            }
            break;
        }
        case 2:
        {

            bool exito2;
            cargarcita(list, exito2);
            if (!exito2) {//EN CASO DE NO CARGAR ARCHIVO
                color(hConsole, 4);
                cout << "No se ha podido cargar la lista" << endl;
                color(hConsole, 7);
            }
            else {//EN CASO DE CARGAR EL ARCHIVO
                int oppacientes;
                do {
                    cout << endl << endl;
                    oppacientes = menugeneralpacientes();//SOLICITAR QUE HACER EN MENU DE PACIENTES
                    switch (oppacientes) {
                    case 1://MOSTRAR TODOS LOS PACIENTES YA REGISTRADOS
                    {
                        system("cls");
                        ordenarBurburjapaciente(list, info);//ORDENAR EN ORDEN ALFABETICO
                        mostrarpasientes(list, list.contador);//MOSTRAR PACIENTES
                        break;
                    }
                    case 2://AGENDAR PACIENTES
                    {
                        system("cls");
                        agendarpaciente(list, info);
                        break;
                    }
                    case 3://MODIFICAR PACIENTE
                    {

                        int pos;
                        pos = datoelim(list);//BUSCAR POSICION DE PACIENTE POR MEDIO DE LA CEDULA
                        system("cls");
                        if (pos < 0) {//EN CASO DE NO EXISTIR EL PACIENTE
                            color(hConsole, 4);
                            cout << "\n\n\n\n\n";
                            cout << "\t\t\t\t\t\t\t\t\t\t    ---------------------------------" << endl;
                            cout << "\t\t\t\t\t\t\t\t\t\t    |EL PACIENTE NO ESTA REGISTRADO |" << endl;
                            cout << "\t\t\t\t\t\t\t\t\t\t    ---------------------------------";
                            color(hConsole, 7);
                        }
                        else {//DE SI EXITIR
                            int pasc;
                            do {
                                pasc = menumodificarpaciente();//PREGURNAS SI ELIMINAR O QUE MODIFICAR
                                switch (pasc) {
                                case 1:
                                {//ELIMINA EL PACIENTE
                                    elimina(list, list.contador, pos);
                                    pasc = 0;
                                    break;
                                }
                                case 2://MODIFICA EL NOMBRE
                                {
                                    modificarnombre(list, pos);
                                    break;
                                }
                                case 3://MODIFICA LA EDAD
                                {
                                    modificaredad(list, pos);
                                    break;
                                }
                                case 4://MODIFICA EL PESO
                                {
                                    modificarpeso(list, pos);
                                    break;
                                }
                                case 5://MODIFICA LA ESTATURA
                                {
                                    modificarestatura(list, pos);
                                    break;
                                }
                                case 6://MODIFICA EL TIPO DE SANGRE
                                {
                                    modificarsangre(list, pos);
                                    break;
                                }
                                case 7://MODIFICA EL CELULAR
                                {
                                    modificarcel(list, pos);
                                    break;
                                }
                                case 8://MODIFICA EL CORREO
                                {
                                    modificarcorreo(list, pos);
                                }
                                }
                            } while (pasc != 0);//SALIMOS DEL MENU DE MODIFICAR
                        }
                        break;
                    }
                    case 4:
                    {
                        int f;
                        f = buscarpaciente();//PIDE EL NUMERO DE CEDULA DEL PACIENTE  BUSCAR
                        consultarpaciente(list, f);//BUSCA EL PACIENTE
                        break;
                    }
                    }
                } while (oppacientes != 0);
                guardar(list);//GUARDA LOS DATOS DE LA LISTA DE PACIENTES
            }
            break;
        }
        case 3:
        {
            bool exito3;
            cargarmedico(lista1, exito3);//CARGAR 
            //si no se ha podido cargar la lista nos mostrara el sigueinte mensaje
            if (!exito3) {
                cout << "No se ha podido cargar la lista" << endl;
            }
            //caso contrario se presentara el menu que contendra las opciones que puede usar el ususario par el registro de los medicos
            else {
                //declaramos la variable op que sera la opcion que ingresara el usuario
                int opmedicos;
                //usamos el do para que le menu se presente de forma repetitiva despues de la ejecucion de una opcion que contenga el programa
                do {
                    cout << endl << endl;
                    opmedicos = menugeneralmedicos();
                    //nos ayudara a entrar uno por uno a las funciones de los subprogramas
                    switch (opmedicos) {
                        //con el numero 1 accedemos al agendamiento de un medico nuevo
                    case 1:
                    {
                        system("cls");
                        agendarmedico(lista1, datos1);
                        break;
                    }
                    //con el numero 2 mostraremos en pantalla los medicos registrados en el sistema
                    case 2:
                    {
                        system("cls");
                        ordenarBurburjaaMedicos(lista1, datos1);
                        ordenarBurburjaaMedicos2(lista1, datos1);
                        mostrarmedico(lista1, lista1.contador);
                        break;
                    }
                    // la opcion numero 3 permitira verificar la informacion de un usuario especifico por medio del numero de cedula
                    case 3:
                    {
                        system("cls");
                        int xmedicos;
                        xmedicos = buscarmedico();
                        consultarmedico(lista1, xmedicos);
                        break;
                    }
                    //la opcion numero 5 nos permitira eliminar o modificar algun medico que se haya registrado en el sistema, mediante su numero de cedula para verificar su identidad
                    case 4:
                    {
                        int pos;
                        pos = datoelim(lista1);
                        if (pos < 0) {
                            system("cls");
                            color(hConsole, 4);
                            cout << "\n\n\n\n\n";
                            cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
                            cout << "\t\t\t\t\t\t\t\t\t\t|        MEDICO NO ENCONTRADO         |" << endl;
                            cout << "\t\t\t\t\t\t\t\t\t\t---------------------------------------" << endl;
                            color(hConsole, 15);
                        }
                        else {
                            system("cls");
                            int modmedi;
                            do {
                                modmedi = menumodificarmedico();//pedir que eliminar o modificar del medico
                                switch (modmedi) {
                                case 1://elimacion del medico rapidamente
                                {
                                    elimina(lista1, lista1.contador, pos);
                                    modmedi = 0;
                                    break;
                                }
                                case 2://modificar el nombre
                                {
                                    modificarnombremedico(lista1, pos);
                                    break;
                                }
                                case 3://modificar la especialidad
                                {
                                    modificarespecialidad(lista1, pos);
                                    break;
                                }
                                case 4://modificar la edad
                                {
                                    modificaredadmedico(lista1, pos);
                                    break;
                                }
                                case 5://modificar el celular
                                {
                                    modificarcelularmedico(lista1, pos);
                                    break;
                                }
                                case 6://modificar el correo
                                {
                                    modificarcorreomedico(lista1, pos);
                                    break;
                                }
                                }
                            } while (modmedi != 0);

                        }
                        break;
                    }
                    }
                    //finalmente el programa se ejecutara solo hasta que el usuario ingrese el numero  en el menu principal
                } while (opmedicos != 0);
                guardar(lista1);//se guardan los datos de la lista
            }
            break;
        }
        }

    } while (opmenugeneral != 0);
    return 0;
}