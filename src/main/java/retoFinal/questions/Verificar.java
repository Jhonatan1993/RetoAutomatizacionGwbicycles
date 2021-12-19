package retoFinal.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import retoFinal.userinterface.PaginaLocalizadora;

public class Verificar implements Question {

    public static Verificar resultado() {return new Verificar();}

    @Override
    public Object answeredBy(Actor actor) {

        String texto = Text.of(PaginaLocalizadora.RESPUESTA).viewedBy(actor).asString();
        String[] s = texto.split(" ");
        String output ="";

        for (String word : s){
            String temp="";
            for (int i=0; i<word.length(); i++){
                if (i==0){
                    temp+=(word.charAt(i)+"").toUpperCase();
                }else {
                    temp+=(word.charAt(i)+"").toLowerCase();
                }
            }
            output+=temp+" ";
        }
        System.out.println(output);

        return output.trim();
    }
}
