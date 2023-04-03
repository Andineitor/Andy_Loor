
//funcion desarrollada para obtener datos por el usuario
void agendarcita() {
    string x;
    do {
        cout << "\t\t\t\tINGRESE EL NUMERO DE CEDULA DEL PACIENTE:  ";
        cin >> info.id;
        cin.ignore(80, '\n');
        cout << "\t\t\t\tINGRESA EL NOMBRE COMPLETO DEL PACIENTE:  ";
        getline(cin, info.nom);
        cout << "\t\t\t\tINGRESA LA EDAD DEL PACIENTE:  ";
        cin >> info.edad;
        cout << "\t\t\t\tINGRESA EL PESO DEL PACIENTE:  ";
        cin >> info.peso;
        cout << "\t\t\t\tINGRESA LA ESTATURA DEL PACIENTE:  ";
        cin >> info.estatura;
        cin.ignore(50, '\n');
        cout << "\t\t\t\tINGRESA  EL TIPO DE SANGRE DEL PACIENTE:  ";
        getline(cin, info.sangre);
        cout << "\t\t\t\tINGRESA  EL TELEFONO DEL PACIENTE:  ";
        cin >> info.cel;
        cin.ignore(50, '\n');
        cout << "\t\t\t\tINGRESA EL CORREO ELECTRONICO DEL PACIENTE:  ";
        getline(cin, info.correo);
        cin.sync();
        system("cls");
        color(hConsole, 10);
        cout << "\t\t-----------------------------------------------------------------" << endl;
        cout << "\t\t| CEDULA \t\t|" << setw(20) << left << info.id << "       \t\t|" << endl;
        cout << "\t\t| NOMBRE \t\t|" << setw(15) << left << info.nom << "         \t\t|" << endl;
        cout << "\t\t| TELEFONO \t\t|" << setw(15) << left << info.cel << "        \t\t|" << endl;
        cout << "\t\t| CORREO ELECTRONICO\t|" << setw(15) << left << info.correo << "         \t\t|" << endl;
        cout << "\t\t| EDAD \t\t\t|" << setw(15) << left << info.edad << "         \t\t|" << endl;
        cout << "\t\t| PESO \t\t\t|" << setw(15) << left << info.peso << "         \t\t|" << endl;
        cout << "\t\t| ESTATURA \t\t|" << setw(15) << left << info.estatura << "         \t\t|" << endl;
        cout << "\t\t| TIPO DE SANGRE \t|" << setw(15) << left << info.sangre << "         \t\t|" << endl;
        cout << "\t\t-----------------------------------------------------------------";
        color(hConsole, 7);
        cout << endl << endl << "\t\t\t\t LOS DATOS SON CORRECTOS? (Si/No/Salir): ";
        cin >> x;
        system("cls");
        if (list.contador == MAX)
        {
            color(hConsole, 4);
            cout << "\t\t\t\t\t--------------------------------" << endl;
            cout << "\t\t\t\t\t|MAXIMO DE PERSONAS REGISTRADAS |" << endl;
            cout << "\t\t\t\t\t--------------------------------" << endl << endl;
            color(hConsole, 7);
        }
        else {
            if (x == "si" || x == "Si" || x == "SI" || x == "sI")
            {
                system("cls");
                bool comprobar = false;
                for (int i = 0; i < list.contador; i++) {
                    if ((info.nom == list.datoslista[i].nom)) {
                        comprobar = true;
                    }
                }
                if (comprobar == true) {
                    color(hConsole, 4);
                    cout << "\t\t\t\t\t\t-------------------" << endl;
                    cout << "\t\t\t\t\t\t|PACIENTE REPETIDO|" << endl;
                    cout << "\t\t\t\t\t\t-------------------" << endl << endl;
                    color(hConsole, 7);
                }
                else {
                    color(hConsole, 10);
                    cout << "\t\t\t\t\t\t-------------------------------" << endl;
                    cout << "\t\t\t\t\t\t|DATOS GUARDADOS CORRECTAMENTE|" << endl;
                    cout << "\t\t\t\t\t\t-------------------------------" << endl << endl;
                    list.datoslista[list.contador] = info;
                    list.contador++;
                    color(hConsole, 7);
                }
            }
            else {
                if (x == "No" || x == "nO" || x == "NO" || x == "no") {
                    system("cls");
                    color(hConsole, 4);
                    cout << "\t\t\t\t\t------------------------" << endl;
                    cout << "\t\t\t\t\t|VUELVE AGENDAR LA CITA|" << endl;
                    cout << "\t\t\t\t\t------------------------" << endl << endl;
                    color(hConsole, 7);
                }
            }
        }

    } while (x == "no" || x == "No" || x == "NO" || x == "nO");
}


//funcion desarrollada para vargar los datos ingresados por el usuario
void cargar(tDatos& lista, bool& ok) {
    tHospital hospital;
    ifstream archivo;
    char aux;
    lista.contador = 0;
    archivo.open("pascientes.txt");
    if (!archivo.is_open()) {
        ok = false;
    }
    else {
        ok = true;
        getline(archivo, hospital.nom);
        while ((hospital.nom != "XXX") && (lista.contador < MAX)) {
            archivo >> hospital.id;
            archivo >> hospital.edad;
            archivo >> hospital.peso;
            archivo >> hospital.estatura;
            archivo >> hospital.sangre;
            archivo >> hospital.cel;
            archivo >> hospital.correo;
            archivo.get(aux);
            lista.datoslista[lista.contador] = hospital;
            lista.contador++;
            getline(archivo, hospital.nom);
        }
        archivo.close();
    }
}

//funcion desarrollada para mostrar ingresados datos por el usuario
void mostrarpasientes(tDatos list, int contador) {
    system("cls");
    color(hConsole, 14);
    cout << "\t\t"<<"-------------------------------------------------------------------------------------------------------------------------------------------" << endl;
    cout << "\t\t|"<<setw(15) << left << "CEDULA" << setw(25) << left << "|NOMBRE" << setw(21) << left << "|EDAD" << setw(11) << left << "|PESO" << setw(14) << left << "|ESTATURA" << setw(15) << left << "|T. SANGRE" << setw(20) << left << "|N. CELULAR" << setw(25) << left << "|CORREO" << endl;
    cout << "\t\t" << "-------------------------------------------------------------------------------------------------------------------------------------------" << endl;
    for (int i = 0; i < list.contador; i++) {
    	color(hConsole, 7);
    	cout << "\t\t|";
        color(hConsole, 2);
		cout<<setw(15) << left << list.datoslista[i].id;
    	color(hConsole, 7);
		cout << "|" <<setw(24) << left << list.datoslista[i].nom <<"|"<<setw(20) << left  << list.datoslista[i].edad <<"|"<< setw(10) << left  << list.datoslista[i].peso <<"|" <<setw(13) << left << list.datoslista[i].estatura <<"|";
		color(hConsole, 4);
		cout<< setw(14) << left << list.datoslista[i].sangre;
		color(hConsole, 7);
		cout<<"|"<< setw(19) << left << list.datoslista[i].cel << "|"<<setw(25) << left << list.datoslista[i].correo << "|" << endl;
    }
}

//funcion desarrollada para guardar datos por el usuario
void guardar(const tDatos& list) {
    ofstream archivo;
    archivo.open("pascientes.txt");
    for (int i = 0; i < list.contador; i++) {
        archivo << list.datoslista[i].nom << endl;
        archivo << list.datoslista[i].id << endl;
        archivo << list.datoslista[i].edad << endl;
        archivo << list.datoslista[i].peso << endl;
        archivo << list.datoslista[i].estatura << endl;
        archivo << list.datoslista[i].sangre << endl;
        archivo << list.datoslista[i].cel << endl;
        archivo << list.datoslista[i].correo << endl;
    }
    archivo << "XXX" << endl;
    archivo.close();
}



//funcion desarrollada para eliminar datos por el usuario
void elimina(tDatos& list, int& contador, int pos)
{
    for (int i = pos; i < contador; i++) {
        list.datoslista[i] = list.datoslista[i + 1];
    }
    color(hConsole, 10);
    system("cls");
    cout << "\n\n\n\n\n\n\n\n";
    cout << "\t\t\t\t\t\t\t\t\t------------------------------------------------------" << endl;
    cout << "\t\t\t\t\t\t\t\t\t|           PACIENTE ELIMINADO CORRECTAMENTE             |" << endl;
    cout << "\t\t\t\t\t\t\t\t\t------------------------------------------------------";
	color(hConsole, 7);
	list.contador--;
}
//funcion desarrollada para obtener un resultado que permitirra que la funcion anterio elimine datos
int datoelim(tDatos list) {
    system("cls");
    int buscar;
    int pos;
    color(hConsole, 4);
            cout << "\t\t\t\t\t------------------" << endl;
            cout << "\t\t\t\t\t|BUSCAR PACIENTE |" << endl;
            cout << "\t\t\t\t\t------------------" << endl << endl;
    color(hConsole, 7);
    cout <<endl<<endl<<endl<<endl<< "\t\t\t\t\t\t\t INGRESE EL NUMERO DE CEDULA DEL PASCIENTE:  ";
    cin >> buscar;
    bool a = false;
    for (int i = 0; i < list.contador; i++) {
        if (list.datoslista[i].id == buscar) {
            return i;
            a = true;
        }
    }
    if (a == false) {
        return -1;
    }
}


//funcion desarrollada para consultar datos por el usuario
void consultar(const tDatos& lista, int buscar) {
    bool a = false;
    system("cls");
    cout << "\n\n\n\n\n\n ";
    for (int i = 0; i < lista.contador; i++) {
        if (lista.datoslista[i].id == buscar) {
        	color(hConsole, 14);
            cout << "\t\t"<<"-------------------------------------------------------------------------------------------------------------------------------------------" << endl;
    cout << "\t\t|"<<setw(15) << left << "CEDULA" << setw(25) << left << "|NOMBRE" << setw(21) << left << "|EDAD" << setw(11) << left << "|PESO" << setw(14) << left << "|ESTATURA" << setw(15) << left << "|T. SANGRE" << setw(20) << left << "|N. CELULAR" << setw(25) << left << "|CORREO" << endl;
    cout << "\t\t" << "-------------------------------------------------------------------------------------------------------------------------------------------" << endl;
    	color(hConsole, 7);
    	cout << "\t\t|";
        color(hConsole, 2);
		cout<<setw(15) << left << list.datoslista[i].id;
    	color(hConsole, 7);
		cout << "|" <<setw(24) << left << list.datoslista[i].nom <<"|"<<setw(20) << left  << list.datoslista[i].edad <<"|"<< setw(10) << left  << list.datoslista[i].peso <<"|" <<setw(13) << left << list.datoslista[i].estatura <<"|";
		color(hConsole, 4);
		cout<< setw(14) << left << list.datoslista[i].sangre;
		color(hConsole, 7);
		cout<<"|"<< setw(19) << left << list.datoslista[i].cel << "|"<<setw(25) << left << list.datoslista[i].correo << "|" << endl;
			a = true;
}
    }
    if (a == false) {
        color(hConsole, 4);
        string op;
        cout << "\t\t\t\t\t\t\t\t\t\t--------------------------" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t|EL PASCIENTE NO AGENDADO|" << endl;
        cout << "\t\t\t\t\t\t\t\t\t\t--------------------------" << endl << endl;
        color(hConsole, 7);
        cout << "\t\t\t\t\t\t\t DESEAS AGENDAR UNA CITA? (Si/No): ";
        cin >> op;
        system("cls");
        if (op == "si" || op == "Si" || op == "SI" || op == "sI") {
            agendarcita();
        }
    }
}


//funcion desarrollada para ordenar datos por el usuario
void ordenarBurburjaa(tDatos& lista, tHospital& stock) {
    int i = 0;
    bool inter = true;
    tHospital temp;
    if (lista.contador == 0) {
        cout << endl << "ERROR! No existen productos en el registro" << endl << endl;
    }
    else {
        while ((i < lista.contador - 1) && inter) {
            inter = false;
            for (int j = lista.contador - 1; j > i; j--) {
                if (lista.datoslista[j].nom < lista.datoslista[j - 1].nom) {
                    temp = lista.datoslista[j];
                    lista.datoslista[j] = lista.datoslista[j - 1];
                    lista.datoslista[j - 1] = temp;
                    inter = true;
                }
            }
            if (inter) {
                i++;
            }
        }
    }
}
//funcion booleana que retornara un resultado para que la funcion anterior ordene los datos
bool operator<(tHospital opIzq, tHospital opDer) {
    return (opIzq.nom < opDer.nom);
}
