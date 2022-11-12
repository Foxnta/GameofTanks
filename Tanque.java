public class Tanque {
    public int vida; 
    public int tipo;

    public Tanque(int tipo) {
        this.tipo = tipo;
        if(tipo==1){
            this.vida=10;
        }
        else{
            this.vida=20;
        }
    }
    public int getVida() {
        return vida;
    }
    public void quitarSangre(){
        this.vida=this.vida-5;
    }
    public void eliminar(){
        this.vida=0;
    }
    public void duplicarVida(){
        this.vida=this.vida*2;
    }

    @Override
    public String toString() {
        String nlista="";
        if(tipo==1){
            nlista="BN-";
        }
        else {
            nlista="BA-";
        }

        return nlista+vida;
    }
    
    


}
