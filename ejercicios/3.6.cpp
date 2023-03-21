#include <iostream>
#include<math.h>
using namespace std;

int main() {
    int	 cuadrado,cubo ;
	int number=-1;
		int number2=-1;
		cout<<"los numero del 0 a 10 elevados al cudrado son: "<<endl<<endl;
	while (number<10  ) {
		
		number= number+1;
	
		cuadrado=pow(number,2);
		
		cout<<"     - "<<number<<"^2 : "<< cuadrado<<endl<<endl;
	}
	cout<<"los numero del 0 a 10 elevados al cubo son: "<<endl<<endl;
		 while (number2<10) {
		
			number2= number2+1;
			cubo=pow(number2,3);
												
			cout<<"     - "<<number2<<"^3 : "<< cubo<<endl<<endl;
		}

}
