package com.stupica;


import static com.stupica.ConstGlobal.DEFINE_STR_ERROR;
import static com.stupica.ConstGlobal.DEFINE_STR_OK;


public class ResultProces {

    public final String     sStatusOk = DEFINE_STR_OK;
    public final String     sStatusErr = DEFINE_STR_ERROR;
    public final String     sStatusWarn = "WARNING";
    public final String     sStatusNA = "NotAvailable";

    public int      iResult;

    public boolean  bIsDone;

    public String        sText;
    public String        sStatus;
    public StringBuilder sMsg;


    public ResultProces() {
        init();
    }


    public void init() {
        iResult = ConstGlobal.RETURN_OK;
        sText = null;
        sStatus = sStatusNA;
        bIsDone = false;
        sMsg = new StringBuilder();
    }
}
