package com.example.appgrado;

public class ModelClass {

    String  InitialQuestion;
//    int Imagen;
    String  ResponseA;
    String  ResponseB;
    String  ResponseC;
    String  ResponseD;
    String  ResponseANS; //Respuesta

    public ModelClass(){

    }

    public ModelClass(String initialQuestion,  String responseA, String responseB, String responseC, String responseD, String responseANS) {
        InitialQuestion = initialQuestion;
//        Imagen = imagen;
        this.ResponseA = responseA;
        this.ResponseB = responseB;
        this.ResponseC = responseC;
        this.ResponseD = responseD;
        this.ResponseANS = responseANS;
    }



    public String getInitialQuestion() {
        return InitialQuestion;
    }

    public void setInitialQuestion(String initialQuestion) {
        InitialQuestion = initialQuestion;
    }

//    public int getImagen() {
//        return Imagen;
//    }
//
//    public void setImagen(int imagen) {
//        Imagen = imagen;
//    }

    public String getResponseA() {
        return ResponseA;
    }

    public void setResponseA(String responseA) {
        this.ResponseA = responseA;
    }

    public String getResponseB() {
        return ResponseB;
    }

    public void setResponseB(String responseB) {
        this.ResponseB = responseB;
    }

    public String getResponseC() {
        return ResponseC;
    }

    public void setResponseC(String responseC) {
        this.ResponseC = responseC;
    }

    public String getResponseD() {
        return ResponseD;
    }

    public void setResponseD(String responseD) {
        this.ResponseD = responseD;
    }

    public String getResponseANS() {
        return ResponseANS;
    }

    public void setResponseANS(String responseANS) {
        this.ResponseANS = responseANS;
    }
}
