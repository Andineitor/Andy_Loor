#include <iostream>
using namespace std;

int main() {
  double med1, med2, med3;
  cout<<endl<<"    Introduzca solo medidas diferentes de 0    "<<endl<<endl;
  cout<<"Ingrese primer medida: "<<endl;
  cin>>med1;
  cout<<"Ingrese segunda medida: "<<endl;
  cin>>med2;
  cout<<"Ingrese tercer medida: "<<endl;
  cin>>med3;
  if(med1==0 || med2==0 || med3==0){
  	cout<<"ERROR, solo pude ingresar numeros diferentes de 0";
  }else if (med1+med2>med3 && med2+med3>med1 && med3+med1>med2){
  cout<<"las medidad ingresadas, reprecentan las medidas para un triangulo";
  }else{
  	cout<<"las medidad ingresadas, No reprecentan las medidas para un triangulo";
  }
}
