/*
Bienvenidos a todos a mi blog. Os presento el juego del ahorcado. Con este juego, podreis jugar con
vuestro amigo a ver si adivina vuestra palabra. Vosotros debereis introducir vuestar palabra a
adivinar, y vuestro adversario, debera introducir la letra que quiere a medida que van pasando los
turnos. �Guay, verdad? Espero que lo disfruteis mucho
*/
 
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{ 
system("color 0A");
    char frase[60],rep[100],temporal[100];
    char pal;
    int longitud,i,j,inicial,acertado=0,temp=0,oportunidades=9;
    int repetido=0,gano=0;
    printf("  **  JUEGO DEL AHORCADO  **\n\n");
    printf("  Introduzca la palabra a adivinar: ");
    gets(frase);
    system("cls");
    longitud = 0;
    inicial = 0;
    j = 0;
    rep[0] = ' ';
    rep[1] = '\0';
    do
    {
        system("cls");
        temp=0;
        if(inicial == 0)
        {
            for(i=0;i<strlen(frase);i++)
            {
                if(frase[i] == ' ')
                {
                    temporal[i] = ' ';
                    longitud++;
                }
                else
                {
                    temporal[i] = '_';
                    longitud++;
                }
            }
        }
        inicial = 1;
        temporal[longitud] = '\0';
        for(i=0;i<strlen(rep);i++)
        {
            if(rep[i] == pal)
            {
                repetido = 1;
                break;
            }
            else
           {
               repetido = 0;
           }
        }
        if(repetido == 0)
        {
            for(i=0;i<strlen(frase);i++)
            {
                if(frase[i] == pal)
                {
                    temporal[i] = pal;
                    acertado++;
                    temp=1;
                }
            }
        }
        if(repetido == 0)
        {
            if(temp == 0)
            {
                oportunidades = oportunidades - 1;
            }
        }
        else
        {
            printf("  Ya se ha introducido este caracter");
            printf("\n\n");
        }
        printf("\n");
        for(i=0;i<strlen(temporal);i++)
        {
            printf(" %c ",temporal[i]);
        }
        printf("\n");
        if(strcmp(frase,temporal) == 0)
        {
            gano = 1;
            break;
        }
        printf("\n  Letras Acertadas: %d",acertado);
        printf("\n  Oportunidades Restantes: %d",oportunidades);
        printf("\n");
        rep[j] = pal;
        j++;
        if (oportunidades==0)
        {
           break;
        }
        printf("  Introduzca una letra:");
        scanf("\n%c",&pal);
    }
    while(oportunidades != 0);
    if(gano)
    {
        printf("\n\n  Enhorabuena, has ganado.");
    }
    else
    {
        printf("\n\n  Has perdido.");
    }
    printf("\n\n");
    system("PAUSE");
    return 0;
}
