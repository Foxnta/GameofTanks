import java.util.Scanner;
import java.util.Random;
public class Principal{
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Tanque[][] tanquesLista= new Tanque[2][2];
            int numDisparos=0;

            int numeroDeTanques= numeroAleatorio(1,3);
            
            for(int i=1;i<=numeroDeTanques;i++){
                System.out.println("Digite 1 para tanque Normal o 2 para Alien");
                int tipo = scan.nextInt();
                Tanque tanque = new Tanque(tipo);
                int fila=0;
                int columna=0;
                if(i==1){
                    fila=0;
                    columna=0;
                }
                else if(i==2){
                    fila=0;
                    columna=1;
                }
                else if(i==3){
                    fila=1;
                    columna=0;
                }
                else if(i==4){
                    fila=1;
                    columna=1;
                }
                tanquesLista[fila][columna]=tanque; 
            }
            mostrarVida(tanquesLista);
            
            while(true){

                System.out.println("1) Disparar 1 bala");
                System.out.println("2) Activar bomba atomica");
                System.out.println("3) Activar tanque mutante");
                System.out.println("4) Frase de la abuela");
                System.out.println("5) Conteo de disparos");
                System.out.println("6) Mostrar Cantidad de salud");
                int numero = scan.nextInt();
                
               
                if(numero==1){
                    System.out.println("Posicion para disparar (0.0/0.1/1.0/1.1): ");
                    Double PosDisparo = scan.nextDouble();
                    if(PosDisparo==0.0){
                        tanquesLista[0][0].quitarSangre();
                    }
                    else if(PosDisparo==0.1){
                        tanquesLista[0][1].quitarSangre();
                    }
                    else if(PosDisparo==1.0){
                        tanquesLista[1][0].quitarSangre();
                    }
                    else if(PosDisparo==1.1){
                        tanquesLista[1][1].quitarSangre();
                    }    
                    numDisparos++;            

                }
                else if(numero==2){
                    int numAl= numeroAleatorio(1,numeroDeTanques-1);
                    Double posBombaAtomica= 0.0;
                    if (numAl==1){
                        posBombaAtomica=0.0;
                    }
                    else if (numAl==2){
                        posBombaAtomica=0.1;
                    }
                    else if (numAl==3){
                        posBombaAtomica=1.0;
                    }
                    else if (numAl==4){
                        posBombaAtomica=1.1;
                    }
                    System.out.println("Has matado a la posicion "+ posBombaAtomica);

                    if(posBombaAtomica==0.0){
                        tanquesLista[0][0].eliminar();
                    }
                    else if(posBombaAtomica==0.1){
                        tanquesLista[0][1].eliminar();
                    }
                    else if(posBombaAtomica==1.0){
                        tanquesLista[1][0].eliminar();
                    }
                    else if(posBombaAtomica==1.1){
                        tanquesLista[1][1].eliminar();
                    }   
                   
                }
                else if(numero==3){
                    int menorVida=1000;
                    int f=0;
                    int c=0;
                    for(int i=0;i<=1;i++){
                        for(int j=0;j<=1;j++){
                            if(tanquesLista[i][j]!=null){
                                if(tanquesLista[i][j].getVida()!=0){
                                    if(tanquesLista[i][j].getVida()<menorVida){
                                        menorVida=tanquesLista[i][j].getVida();
                                        f=i;
                                        c=i;
                                    }
                                }
                            }   
                        }
                    }
                    tanquesLista[f][c].duplicarVida();
                }
                else if(numero==4){
                    System.out.println("La victoria esta reservada para aquellos que estan dispuestos a pagar su precio");
                }
                else if(numero==5){
                   System.out.println("numero de disparos realizados: "+numDisparos); 
                }

                else if(numero==6){
                    mostrarVida(tanquesLista); 
                }

                int tanquesSinVida=0;
                for(int i=0;i<=1;i++){
                    for(int j=0;j<=1;j++){
                        if(tanquesLista[i][j]!=null){
                            if(tanquesLista[i][j].getVida()==0){
                                tanquesSinVida++;
                            }
                        }
                    }
                }
                if(tanquesSinVida==numeroDeTanques){
                    break;
                }


            }
        }
 
    }

    public static int numeroAleatorio(int min, int max){

        Random random = new Random();
        int value = random.nextInt(max + min) + min;
        return value;
    }

    public static void mostrarVida(Tanque[][] tanquesLista){
        String A="     ";
        String B="     ";
        String C="     ";
        String D="     ";
        if(tanquesLista[0][0]!=null){
            A=tanquesLista[0][0].toString();
        }
        if(tanquesLista[0][1]!=null){
            B=tanquesLista[0][1].toString();
        }
        if(tanquesLista[1][0]!=null){
            C=tanquesLista[1][0].toString();
        }
        if(tanquesLista[1][1]!=null){
            D=tanquesLista[1][1].toString();
        }
        System.out.println("-------------");
        System.out.println("|"+A+"|"+B+"|");
        System.out.println("|"+C+"|"+D+"|");
        System.out.println("-------------");
    }
}