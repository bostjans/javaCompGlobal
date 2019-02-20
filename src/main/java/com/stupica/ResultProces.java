package com.stupica;


public class ResultProces {

    public int      iResult = ConstGlobal.RETURN_OK;

    public boolean  bIsDone = false;

    public String        sText = null;
    public StringBuilder sMsg = null;


    public ResultProces() {
        init();
    }


    public void init() {
        sMsg = new StringBuilder();
    }
}
